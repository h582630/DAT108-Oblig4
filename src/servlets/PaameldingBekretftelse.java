package servlets;

import static constants.UrlMappings.URL_REGISTRATION; 
import static constants.UrlMappings.URL_LOGIN;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.FormatPhoneNumber;


@WebServlet("/Confirmed-Registration")
public class PaameldingBekretftelse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		 HttpSession sesjon = request.getSession(false);
		 
		  if (sesjon == null || sesjon.getAttribute("phoneNumber") == null) {
	            response.sendRedirect(URL_LOGIN);
		  } else {
	
			  String phoneNumber = FormatPhoneNumber.formatPhoneNumber(sesjon.getAttribute("phoneNumber").toString()); 
			  
			  request.setAttribute("firstName", sesjon.getAttribute("firstName"));
			  request.setAttribute("lastName", sesjon.getAttribute("lastName"));
			  request.setAttribute("phoneNumber", phoneNumber);
			  request.setAttribute("sex", sesjon.getAttribute("sex"));
			  request.getRequestDispatcher("WEB-INF/PaameldingsBekreftelse.jsp").forward(request, response);
		  }
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
