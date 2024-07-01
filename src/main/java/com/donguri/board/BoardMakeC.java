package com.donguri.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.donguri.sign.DAOSign;

import io.jsonwebtoken.Claims;



@WebServlet("/BoardMakeC")
public class BoardMakeC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		
		// Login_Chk & Get Session
		try {
            Claims claims = DAOSign.extractAndValidateToken(request);
			DAOSign.getUserSession(request, response);
			
			request.setAttribute("contentPage", "/jsp/board/board_make.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			// If User doesn't Login 
			response.sendRedirect("LoginC");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOBoard.DAOB.makeBoard(request);
		
		response.sendRedirect("BoardC");
		
	}

}
