package board.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.bean.BoardDTO;
import member.bean.MemberDTO;

public class BoardDAO {
	
	private SqlSessionFactory sqlSessionFactory;
	

    private static BoardDAO boardDAO = new BoardDAO(); // 종료할때까지 계속 살아있음

    public static BoardDAO getInstance() {
        return boardDAO;   // MemberDAO타입이 return된다
    } // getInstance

    public BoardDAO() {
    	try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	
    } // Constructor


    public void boardWrite(Map<String, String> map) {
    	SqlSession sqlSession = sqlSessionFactory.openSession();
    	sqlSession.insert("boardSQL.boardWrite",map);
    	sqlSession.commit();
    	sqlSession.close();
    } // boardWrite
    
    
    public List<BoardDTO> boardList(int startNum, int endNum) {
    	Map<String, Integer> map = new HashMap();
    	map.put("startNum", startNum);
    	map.put("endNum", endNum);
    	
    	SqlSession sqlSession = sqlSessionFactory.openSession();
    	List<BoardDTO> list = sqlSession.selectList("boardSQL.boardList", map);
    	sqlSession.close();
    	
    	return list;
    } // boardList
    
    
    public List<BoardDTO> boardView(String seq) {
    	
    	Map<String, String> map = new HashMap<String, String>();
    	map.put("seq", seq);
    	
    	SqlSession sqlSession = sqlSessionFactory.openSession();
    	List<BoardDTO> list = sqlSession.selectList("boardSQL.boardView", map);
    	
    	sqlSession.close();
    	
    	return list;
    } // boardView
    
    
    public int getTotalA() {
		
    	SqlSession sqlSession = sqlSessionFactory.openSession();
    	
    	int totalA = sqlSession.selectOne("boardSQL.getTotalA");
    	sqlSession.close();
    	
    	return totalA;
    	
    } // getTotalA
    
    
    
    
} // end class

