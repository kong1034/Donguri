package com.donguri.sign;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginC")
public class LoginC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// logout function
		  // logout function
        if ("1".equals(request.getParameter("logout"))) {
            DAOSign.logout(request, response); 
            // Redirect to login page
            response.sendRedirect(request.getContextPath() + "/HC");
            return; 
        }
        
        // If not logging out, continue with normal operation
        request.setAttribute("contentPage", "/jsp/sign/login.jsp");
        request.getRequestDispatcher("/jsp/sign/sign.jsp").forward(request, response);
    }
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		DAOSign.login(request);
		
		String loginChk = (String)request.getAttribute("result");
		
		
		if (loginChk.equals("login")) {
		
			String jwtToken = (String) request.getAttribute("jwtToken");
			Cookie jwtCookie = new Cookie("jwtToken", jwtToken);
			response.addCookie(jwtCookie);
			
			// login status time limit
			jwtCookie.setMaxAge(3600);
			response.sendRedirect("HC?result=login");
		}else {
			request.setAttribute("contentPage", "/jsp/sign/login.jsp");
			System.out.println("Can't Login");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}

	
}
