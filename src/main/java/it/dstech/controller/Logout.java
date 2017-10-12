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

import it.dstech.dao.HibernateDao;

@WebServlet("/user/logout")
public class Logout extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(Logout.class.getName());

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
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		logger.info("I'm on doPost()");
		try {
			req.getSession().invalidate();
			resp.sendRedirect("../user/login");

		} catch (Exception e) {
			logger.severe(e.getMessage());
			resp.sendRedirect("logout?error");
		}

	}
}
