package member.dao;

import java.sql.*;

import member.bean.MemberDTO;

public class MemberDAO {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    private String driver = "oracle.jdbc.driver.OracleDriver";
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private String username = "c##java";
    private String password = "1234";

    private static MemberDAO memberDAO = new MemberDAO(); // 종료할때까지 계속 살아있음

    public static MemberDAO getInstance() {
        return memberDAO;   // MemberDAO타입이 return된다
    }

    public MemberDAO() {
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
    }
//id 중복체크
    public boolean isExistID(String id) {
        boolean exist = false;
        String sql = "SELECT * FROM MEMBER WHERE ID=?";

        getConnection();
        try {
            pstmt = conn.prepareStatement(sql);//생성
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();//실행

            if (rs.next()) exist = true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return exist;
    }
    
    public boolean insert(MemberDTO memberDTO) {
        String sql = "insert into member values(?,?,?,?,?,?,?,?,?,?,?,?,sysdate)";

        getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memberDTO.getName());
            pstmt.setString(2, memberDTO.getId());
            pstmt.setString(3, memberDTO.getPwd());
            pstmt.setString(4, memberDTO.getGender());
            pstmt.setString(5, memberDTO.getEmail1());
            pstmt.setString(6, memberDTO.getEmail2());
            pstmt.setString(7, memberDTO.getTel1());
            pstmt.setString(8, memberDTO.getTel2());
            pstmt.setString(9, memberDTO.getTel3());
            pstmt.setString(10, memberDTO.getZipcode());
            pstmt.setString(11, memberDTO.getAddr1());
            pstmt.setString(12, memberDTO.getAddr2());

            pstmt.executeUpdate();  //실행 - 개수 리턴
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public MemberDTO login(String id, String pwd){
        MemberDTO memberDTO = null;
        String sql = "select * from member where id=? and pwd=?";

        getConnection();

        try{
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,id);
            pstmt.setString(2,pwd);

            rs = pstmt.executeQuery();    //실행

            if(rs.next()){
                memberDTO = new MemberDTO(); //rs값 존재하면 new 실행

                memberDTO.setName(rs.getString("name"));
                memberDTO.setId(rs.getString("id"));
                memberDTO.setPwd(rs.getString("pwd"));
                memberDTO.setGender(rs.getString("gender"));
                memberDTO.setEmail1(rs.getString("email1"));
                memberDTO.setEmail2(rs.getString("email2"));
                memberDTO.setTel1(rs.getString("tel1"));
                memberDTO.setTel2(rs.getString("tel2"));
                memberDTO.setTel3(rs.getString("tel3"));
                memberDTO.setZipcode(rs.getString("zipcode"));
                memberDTO.setAddr1(rs.getString("addr1"));
                memberDTO.setAddr2(rs.getString("addr2"));
                
                return memberDTO;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return memberDTO;
    } // login
    
    
    


    
} // end class
