package com.donguri.sign;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/verify_email")
public class EmailVerifyC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD:src/main/java/com/donguri/sign/EmailVerifyC.java
		System.out.println("verify called");
		SignDAO.emailVerify(request);
		
	
	
=======
		request.setCharacterEncoding("utf-8");
		DAOFind.findPw(request, response);
>>>>>>> 021c94beb9c2f614a696280a1772a9c7cfe7c307:src/main/java/com/donguri/find/FindPwC.java
	}

}
