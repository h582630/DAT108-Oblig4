package servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.ParticipantDAO;
import models.Participant;


@WebServlet("/Participants")
public class DeltakerListe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private ParticipantDAO participantDAO;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		 List<Participant> participants = participantDAO.getParticipants(); 
		 
		 request.setAttribute("participants", participants);
		 request.getRequestDispatcher("WEB-INF/DeltagerListe.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
	

}
