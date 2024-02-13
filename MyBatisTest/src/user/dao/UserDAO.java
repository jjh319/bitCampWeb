package user.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import user.bean.UserDTO;

public class UserDAO {
	private SqlSessionFactory sqlSessionFactory;
	

	private static UserDAO userDAO = new UserDAO(); // 종료할때까지 계속 살아있음

    public static UserDAO getInstance() {
        return userDAO;   // UserDAO타입이 return된다
    } // getInstance
	
    public UserDAO() {
    	
    	try {
//			Reader reader = Resources.getResourceAsReader("MyBatis-config.xml");
//			
//			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    		
    		String resource = "MyBatis-config.xml";
    		InputStream inputStream = Resources.getResourceAsStream(resource);
    		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    		
		} catch (IOException e) {
			
			e.printStackTrace();
		} // try-catch
    	
    } // Constructor
    

	public void write(UserDTO userDTO) { // 저장
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("userSQL.write", userDTO);
		sqlSession.commit();
		sqlSession.close();
		
	} // write
	
	
	public List<UserDTO> getUserList() { // 출력
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<UserDTO> list = sqlSession.selectList("userSQL.getUserList");
		
		return list;
		
	} // getUserList
	
	
	public void updateUser(UserDTO userDTO) { // 수정
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("userSQL.updateUser",userDTO);
		sqlSession.commit();
		sqlSession.close();
		
	} // updateUser
	
	
	public void deleteUser(String id) { // 삭제
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("userSQL.deleteUser", id);
		sqlSession.commit();
		sqlSession.close();
		
	} // deleteUser
    
    
} // end class
