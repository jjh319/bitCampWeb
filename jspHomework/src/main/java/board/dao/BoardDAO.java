package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import board.bean.BoardDTO;
import member.bean.MemberDTO;

public class BoardDAO {

	private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    private String driver = "oracle.jdbc.driver.OracleDriver";
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private String username = "c##java";
    private String password = "1234";

    private static BoardDAO boardDAO = new BoardDAO(); // 종료할때까지 계속 살아있음

    public static BoardDAO getInstance() {
        return boardDAO;   // MemberDAO타입이 return된다
    } // getInstance

    public BoardDAO() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    } // Constructor

    public void getConnection() {
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }   // Connection 생성(인터페이스라 new 안된다, implement도 불가(추상메소드가 너무많다)
    } // getConnection
	
    // 게시글 작성
    public void boardWrite(String id, String name, String email,String subject, String content) {
    	String sql;
    	
    	sql = "Insert INTO BOARD(seq,id,name,email,subject,content，ref) VALUES(SEQ_BOARD.nextval,?,?,?,?,?,?)";
    	
    	getConnection();
    	
    	try {
    		pstmt = conn.prepareStatement(sql);
    	
    		pstmt.setString(1,id);
    		pstmt.setString(2,name);
    		pstmt.setString(3, email);
    		pstmt.setString(4, subject);
    		pstmt.setString(5, content);
    		pstmt.setInt(6,1);
    		
    		pstmt.executeUpdate(); // 실행
    		
    		
    	}  catch(SQLException e) {
    		e.printStackTrace();
    	}  finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } // try-catch
            
        } // finally
    	
    } // boardWrite
    
    
    // 게시물 출력
    public ArrayList<BoardDTO> loadContents() {
        String sql = "SELECT * FROM board";
        
        ArrayList<BoardDTO> boardDTOList = new ArrayList<>();
        
        getConnection();
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            rs = pstmt.executeQuery();

                while(rs.next()) {
                	BoardDTO boardDTO = new BoardDTO();
                    boardDTO.setContent(rs.getString("content"));
                    boardDTO.setSubject(rs.getString("subject"));
                    boardDTO.setName(rs.getString("name"));
                    boardDTO.setEmail(rs.getString("email"));
                    boardDTO.setId(rs.getString("id"));
                    boardDTO.setSeq(rs.getInt("seq"));
                    boardDTO.setLogtime(rs.getString("logtime"));
                    boardDTOList.add(boardDTO);
                }
            } catch(SQLException e) {
            e.printStackTrace();
        }  finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } // try-catch
        } // finally
        
        return boardDTOList;
    } // loadContents
    
    
    
    
} // end class

