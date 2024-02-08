package guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class GuestbookDAO {

	private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    private String driver = "oracle.jdbc.driver.OracleDriver";
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private String username = "c##java";
    private String password = "1234";

    private static GuestbookDAO guestbookDAO = new GuestbookDAO(); // 종료할때까지 계속 살아있음

    public static GuestbookDAO getInstance() {
        return guestbookDAO;   // MemberDAO타입이 return된다
    } // getInstance

    public GuestbookDAO() {
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
    
    
    
    
	
} // end class
