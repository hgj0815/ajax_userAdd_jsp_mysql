package user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


@WebServlet("/UserRegisterCheckServlet")
public class UserRegisterCheckServlet  extends HttpServlet {
	private static final  long  serialVersionUID =1L;
	
	private final Logger logger = Logger.getLogger(UserRegisterCheckServlet .class);


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException{
		
		logger.info ("[INFO]  UserRegisterCheckServlet.");
		//response.setContentType("UTF-8");
		request.setCharacterEncoding("UTF-8");
		//화면에서 전달받은 userID 취득
		String userID= request.getParameter("userID");
		//쓰기  유저DAO실행한 값을 response함 여기서 ""은 함수 결과가 0 또는 1이기에 문자를 형식으로 만들기 위해서 넣어줌
		response.getWriter().write(new UserDAO().registerCheck(userID)+"");
		logger.info(response);
		}
}
