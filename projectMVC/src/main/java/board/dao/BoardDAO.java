package board.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.bean.BoardDTO;

public class BoardDAO {
	private SqlSessionFactory sqlSessionFactory = null;
	private static BoardDAO boardDAO = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return boardDAO;
	}
	
	public BoardDAO() {
		
		try {
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int insertBoard(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();	//생성
		int su = sqlSession.insert("boardSQL.insertBoard", map);
		sqlSession.commit();
		sqlSession.close();
		return su;
	}
	
	public List<BoardDTO> boardList(Map<String,Integer> map){
		SqlSession sqlSession = sqlSessionFactory.openSession();	//생성
		List<BoardDTO> list = sqlSession.selectList("boardSQL.boardList", map);
		sqlSession.close();
		return list;
	}
	
	public int getTotalA() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int totalA = sqlSession.selectOne("boardSQL.getTotalA");
		sqlSession.close();
		return totalA;
	}

	public BoardDTO getBoard(int seq) {
		SqlSession sqlSession = sqlSessionFactory.openSession();	//생성
		BoardDTO boardDTO = sqlSession.selectOne("boardSQL.getBoard", seq);
		sqlSession.close();	// 커밋할 필요는 없음
		return boardDTO;
	}

	
	
	public void boardReply(Map<String, String> map) {
		/*
		 * SqlSession sqlSession = sqlSessionFactory.openSession(); //생성 int su =
		 * sqlSession.update("boardSQL.boardReply", map); sqlSession.commit();
		 * sqlSession.close(); return su;
		 */
	    /*<!-- 원글 -->*/
  		BoardDTO boardDTO = this.getBoard(Integer.parseInt(map.get("pseq")));
  		SqlSession sqlSession = sqlSessionFactory.openSession();
  		
  		/*<!-- step(글순서)update -->*/
  		sqlSession.update("boardSQL.boardReplyStep",boardDTO);
  		
  		/*<!-- insert -->*/
  		//Map안에는 id, name, email, subject, content 가지고 았다. ref, lev, step을 추가.
  		map.put("ref", boardDTO.getRef() + "");//답글 ref = 원글 ref
  		map.put("lev", boardDTO.getLev() + 1 + "");//답글 lev = 원글 lev + 1
  		map.put("step", boardDTO.getStep() + 1 + "");//답글 step = 원글 step + 1
  		
  		sqlSession.update("boardSQL.boardReply",map);
		/* <!-- reply(답글수) --> */
  		sqlSession.update("boardSQL.boardReplyReply", Integer.parseInt(map.get("pseq")));
  		
  		sqlSession.commit();
		sqlSession.close();
		
	}
	public int  boardUpdate(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();	//생성
		int su = sqlSession.update("boardSQL.updateBoard", map);
		sqlSession.commit();
		sqlSession.close();
		return su;
	}
	

	public void boardDelete(int seq) {
  		SqlSession sqlSession = sqlSessionFactory.openSession();
  		sqlSession.delete("boardSQL.boardDelete", seq);
  		sqlSession.commit();
		sqlSession.close();
		
	}
	

}
