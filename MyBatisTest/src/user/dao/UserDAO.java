package user.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

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
    

	public void write(UserDTO userDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("userSQL.write", userDTO);
		sqlSession.commit();
		sqlSession.close();
		
	} // write
    
    
} // end class
