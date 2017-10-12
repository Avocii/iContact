package it.dstech.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.models.Contact;
import it.dstech.models.User;

@WebServlet("/contact/getList")
public class GetList extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(GetList.class.getName());

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
		User user = (User) req.getSession().getAttribute("user");
		if (user != null) {
			req.setAttribute("user", user);
			logger.info(user + "from session");
			List<Contact> listContatti = Save.contactService.getListContactByUser(user);
			logger.info(listContatti.toString());
			req.setAttribute("lista", listContatti);
		}
		req.getRequestDispatcher("../getList.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
