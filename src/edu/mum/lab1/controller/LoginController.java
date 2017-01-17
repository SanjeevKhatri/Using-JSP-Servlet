package edu.mum.lab1.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.mum.lab1.service.LoginService;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		

		LoginService loginService = new LoginService();
		Boolean result = loginService.loginVerification(username, password);

		if (result) {
			request.getSession().setAttribute("user_name", username);
			response.sendRedirect("welcome.jsp");
		} else {
			request.setAttribute("errormsg", "Username and/or Password is incorrect.");
			RequestDispatcher view = getServletContext().getRequestDispatcher("/login.jsp");
			view.forward(request, response);
		}
	}

}
