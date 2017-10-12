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



@WebServlet("/contact/edit")
public class Edit extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(Edit.class.getName());
	
	private static Contact contact;

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
		String idContact = (String) req.getParameter("id");
//		logger.info("from jsp " + idContact);
		int id =Integer.parseInt(idContact);
		logger.info("id " + id);
		contact = Save.contactService.getContactById(id);
		req.setAttribute("contact", contact);
		req.getRequestDispatcher("../edit.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		logger.info("I'm on doPost()");
		try {
			String nome = req.getParameter("nome");
			String tel = req.getParameter("tel");
			String email = req.getParameter("email");
			contact.setName(nome);
			contact.setTel(tel);
			contact.setMail(email);
			Save.contactService.updateContact(contact);
			resp.sendRedirect("../contact/getList");

		} catch (Exception e) {
			logger.severe(e.getMessage());
			resp.sendRedirect("edit?error");
		}

	}

}
