package servlets;

import static constants.UrlMappings.URL_REGISTRATION;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.ParticipantDAO;
import models.Participant;
import services.FormatPhoneNumber;

@WebServlet("/Participants")
public class DeltakerListeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private ParticipantDAO participantDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Participant> participants = participantDAO.getParticipants();

		request.setAttribute("participants", participants);

		String username = request.getParameter("username");

		HttpSession sesjon = request.getSession(false);
		

		if (sesjon == null || (sesjon.getAttribute("phoneNumber") == null) && (username == null)) {
			response.sendRedirect(URL_REGISTRATION);
		} else {

			if (sesjon.getAttribute("firstName") != null) {

				request.setAttribute("phoneNumber", FormatPhoneNumber.formatPhoneNumber((String)sesjon.getAttribute("phoneNumber")));

			} else {
				String loginUsername = FormatPhoneNumber.formatPhoneNumber(username); 
				request.setAttribute("phoneNumber", loginUsername);

			}

			request.getRequestDispatcher("WEB-INF/DeltagerListe.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
