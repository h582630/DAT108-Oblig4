package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.text.StringEscapeUtils;

import static constants.UrlMappings.URL_PARTICIPANTS;
import static constants.UrlMappings.URL_LOGIN;
import database.ParticipantDAO;
import models.Participant;
import services.FormatPhoneNumber;
import services.PassordService;

import validation.ParticipantValidator;

@WebServlet("/Login")
public class LoggInnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private ParticipantDAO participantDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		String loginError = "";
		if (request.getParameter("invalidUsernameOrPass") != null) {
			loginError = "Feil brukernavn eller passord";
		}

		request.setAttribute("loginError", loginError);
		

		request.getRequestDispatcher("WEB-INF/Innlogging.jsp").forward(request, response);
		
		String username = request.getParameter("mobil"); 
		
		request.setAttribute("phoneNumber", username);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String password = StringEscapeUtils.escapeHtml3(request.getParameter("passord"));
		String username = StringEscapeUtils.escapeHtml3(request.getParameter("mobil"));
		String invalid = "";
		String password_hash = "";
		String password_salt = "";

		if (!(ParticipantValidator.phoneNumberValidator(username))) {
			invalid = "?invalidUsernameOrPass";
			response.sendRedirect(URL_LOGIN + invalid);
		} else {

			String newUsername = "'" + username + "'";
			Participant participant = participantDAO.getPassword(newUsername);

			password_hash = participant.getPassword_hash();
			password_salt = participant.getPassword_salt();

			if (!PassordService.validerMedSalt(password, password_salt, password_hash)) {
				invalid = "?invalidUsernameOrPass";
				response.sendRedirect(URL_LOGIN + invalid);
			} else {

				response.sendRedirect(URL_PARTICIPANTS + "?username=" + username);
			}

		}

	}

}
