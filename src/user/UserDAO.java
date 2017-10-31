package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

public class UserDAO {

	private Connection conn;
	private final Logger logger = Logger.getLogger(UserDAO .class);
	public  UserDAO(){
		try {
//			download  https://dev.mysql.com/downloads/connector/j/5.1.html zip파일로 다운로드
//			/Register/WebContent/WEB-INF/lib/mysql-connector-java-5.1.44-bin.jar
			String dbURL="jdbc:mysql://localhost:3306/studydb";
			String dbID="study";
			String dbPassword ="study";
			
			Class.forName("com.mysql.jdbc.Driver");
			logger.info(Class.forName("com.mysql.jdbc.Driver"));
			
			conn= DriverManager.getConnection(dbURL, dbID, dbPassword);
		
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception 
			logger.info("-1_com.mysql.jdbc.Driver");
		}
	}

		public int registerCheck( String userID) {
			PreparedStatement pstmt = null;
			ResultSet rs= null;
			String SQL = "select *  from user where userID=?";
			try {
				pstmt = conn.prepareStatement(SQL);
				pstmt.setNString(1, userID);
				rs = pstmt.executeQuery();
//				if(rs.next()) {
//			공백체크로 오류메세지 띄우기 위해서추가
             if(rs.next() || userID.equals("")) {
            	 logger.info("0");
					return 0; //이미 존재하는 회원
				}else {
					logger.info("1");
					return 1;// 가입가능한 회원 아이디
				}
             

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				try {
					if (rs != null) {rs.close();}
					if(pstmt != null) {pstmt.close();}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}

			return -1;

		}
		
		public int register( String userID, String  userPassword, String userName, String userAge, String userGender, String userEmail) {
			PreparedStatement pstmt = null;
			ResultSet rs= null;
			String SQL = "insert into user values( ?, ?, ?, ?, ?, ?)";
			try {
				pstmt = conn.prepareStatement(SQL);
				pstmt.setNString(1,userID);
				pstmt.setNString(2, userPassword);
				pstmt.setNString(3, userName);
				pstmt.setInt(4, Integer.parseInt(userAge));
				pstmt.setNString(5, userGender);
				pstmt.setNString(6, userEmail);
               
				return pstmt.executeUpdate();

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				try {
					if (rs != null) {rs.close();}
					if(pstmt != null) {pstmt.close();}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}

			return -1;

		}

}

