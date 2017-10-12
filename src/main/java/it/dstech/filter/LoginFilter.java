package it.dstech.filter;

import java.io.IOException;
import java.util.Date;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import it.dstech.models.User;


@WebFilter("/contact/*")
public class LoginFilter implements Filter{

	private static Logger logger = Logger.getLogger(LoginFilter.class.getName());
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpResp = (HttpServletResponse) response;
		User user = (User) httpReq.getSession().getAttribute("user");
		if (user == null) {
		String url = httpReq.getRequestURL().toString();
		logger.info("url: " + url);
		// Get the IP address of client machine.   String ipAddress = request.getRemoteAddr();
		String ipAddress= request.getRemoteAddr();
		// Log the IP address and current timestamp. System.out.println("IP "+ ipAddress + ", Time "+ new Date().toString());
		logger.info("FILTERED: -> ip " + ipAddress + ", Time " + new Date().toString());
		httpResp.sendRedirect("../user/login");
		} else {
			// Pass request back down the filter chain chain.doFilter(request,response);
			chain.doFilter(request, response);
		}
		
		
	}

	@Override
	public void destroy() {
//		logger.info("Filter destroyed");
	}
}
