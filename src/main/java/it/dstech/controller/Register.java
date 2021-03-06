package it.dstech.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.models.User;


@WebServlet("/user/register")
public class Register extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(Register.class.getName());
	
	@Override
	public void init() throws ServletException {
//		logger.info("I'm on init()");
		super.init();

	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
//		logger.info("I'm on service()");
		super.service(arg0, arg1);
	}

	@Override
	public void destroy() {
//		logger.info("I'm on destroy()");
		super.destroy();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		logger.info("I'm on doGet()");
		req.getRequestDispatcher("../register.jsp").forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
		String username = req.getParameter("username");
//		logger.info("from jsp " + username);
		String password = req.getParameter("password");
//		logger.info("from jsp " + password);
		User user = new User(username, password);
		Login.userService.saveUser(user);
		resp.sendRedirect("login");
		} catch (Exception e) {
			logger.severe(e.getMessage());
			resp.sendRedirect("register?error");
		}
	}
}
