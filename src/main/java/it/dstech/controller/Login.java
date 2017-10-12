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
import javax.servlet.http.HttpSession;

import it.dstech.dao.HibernateDao;
import it.dstech.models.User;
import it.dstech.services.UserService;
import it.dstech.services.UserServiceImpl;

@WebServlet("/user/login")
public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(Login.class.getName());

	public static UserService userService = new UserServiceImpl();

	@Override
	public void init() throws ServletException {
//		logger.info("I'm on init()");
		HibernateDao.getSession();
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
		req.getRequestDispatcher("../login.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
//		logger.info("from jsp " + username);
		String password = req.getParameter("password");
//		logger.info("from jsp " + password);
		try {
			User user = userService.selectUserByUsernamePassword(username, password);
			if (user != null) {
				HttpSession session = req.getSession();
				session.setAttribute("user", user);
				logger.info(user + "saved on session");
				resp.sendRedirect("../contact/getList");
			} else {
				resp.sendRedirect("login?error");
			}
		} catch (Exception e) {
			logger.severe(e.getMessage());
			resp.sendRedirect("login?error");
		}

	}
}
