package user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;




public class UserRegisterServlet  extends HttpServlet {
	private static final  long  serialVersionUID =1L;
	
	private final Logger logger = Logger.getLogger(UserDAO .class);


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException{
		
		logger.info ("[INFO]  Hello doPost.");
		//response.setContentType("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String userID= request.getParameter("userID");
		String userPassword1=request.getParameter("userPassword1");
		String userPassword2=request.getParameter("userPassword2");
		String userName=request.getParameter("userName");
		String userAge=request.getParameter("userAge");
		String userGender=request.getParameter("userGender");
		String userEmail=request.getParameter("userEmail");
		
		
		logger.info ("userID: "+userID);
		logger.info ("userPassword1: "+userPassword1);
		logger.info ("userPassword2: "+userPassword2);
		logger.info ("userName: "+userName);
		logger.info ("userAge: "+userAge);
		logger.info ("userGender: "+userGender);
		logger.info ("userEmail: "+userEmail);

		if (
				userID ==null || userID.equals("")|| 
				userPassword1 ==null || userPassword1.equals("")|| 
				userPassword2 ==null || userPassword2.equals("")|| 
				userName ==null || userName.equals("")|| 
				userAge ==null || userAge.equals("")|| 
				userGender ==null || userGender.equals("")|| 
				userEmail ==null || userEmail.equals("")
				)	{  
			request.getSession().setAttribute("messageType", "오류 메세지");
			request.getSession().setAttribute("messageContent", "모든 내용을 입력하세요.");
			
			logger.info ("[INFO]  Hello doPost.모든 내용을 입력하세요..");
			
			response.sendRedirect("index.jsp");
			return;
		}
		if ( ! userPassword1.equals(userPassword2)	)	{  
			logger.info ("[INFO]  Hello doPost.비밀번호가 서로 일치하지 않습니다.");
			request.getSession().setAttribute("messageType", "오류 메세지");
			request.getSession().setAttribute("messageContent", "비밀번호가 서로 일치하지 않습니다.");
			response.sendRedirect("index.jsp");
			return;
		}
		logger.info ("[INFO] UserDAO() 시작");
		int result = new UserDAO().register(userID,userPassword1,userName,userAge,userGender,userEmail	);
		
       if(result ==1	) {
    		logger.info ("[INFO]  Hello doPost.성공 메세지");
    	   request.getSession().setAttribute("messageType", "성공 메세지");
			request.getSession().setAttribute("messageContent", "회원가입에 성공하였습니다.");
			response.sendRedirect("index.jsp");
			return;
       }else {
    		logger.info ("[INFO]  Hello doPost.오류 메세지");
    	   request.getSession().setAttribute("messageType", "오류 메세지");
			request.getSession().setAttribute("messageContent", "이미 존재하는 회원입니다.");
			response.sendRedirect("index.jsp");
			return;
       }
	}
}
