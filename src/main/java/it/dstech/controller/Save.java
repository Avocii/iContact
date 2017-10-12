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

import it.dstech.models.Contact;
import it.dstech.models.User;
import it.dstech.services.ContactService;
import it.dstech.services.ContactServiceImpl;

@WebServlet("/contact/save")
public class Save extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(Save.class.getName());

	public static ContactService contactService = new ContactServiceImpl();

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

		req.getRequestDispatcher("../save.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		User user = (User) req.getSession().getAttribute("user");
		if (user != null) {
//			logger.info(user + "from session");
			String nome = req.getParameter("nome");
			String cognome = req.getParameter("cognome");
			String tel = req.getParameter("tel");
			String email = req.getParameter("email");
			Contact contact = new Contact(nome, cognome, tel, email);
			contact.setUser(user);
			contactService.saveContact(contact);
			logger.info(contact + "saved on user");
			resp.sendRedirect("../contact/getList");
		}

	}
}
