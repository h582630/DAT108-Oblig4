package servlets;

import java.io.IOException;
import java.util.List;

import org.apache.commons.text.StringEscapeUtils;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.ParticipantDAO;
import models.Participant;
import services.PassordService;
import validation.ParticipantValidator;
import validation.PasswordValidator;

import services.FormatPhoneNumber;

import static constants.UrlMappings.URL_REG_CONFIRMED;
import static constants.UrlMappings.URL_REGISTRATION;

@WebServlet("/Registration")
public class PaameldingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private ParticipantDAO participantDAO;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String loginFirstName = "";
		String loginLastName = "";
		String loginPassword = "";
		String loginPhone = "";
		String loginRepeatPass = "";
		String loginSex = "";

		if (request.getParameter("invalidPassword") != null) {
			loginPassword = "Ugyldig passord";
		}
		if (request.getParameter("invalidFirstName") != null) {
			loginFirstName = "Ugyldig fornavn";
		}
		if (request.getParameter("invalidLastName") != null) {
			loginLastName = "Ugyldig etternavn";
		}
		if (request.getParameter("invalidPhone") != null) {
			loginPhone = "Ugyldig telefonnummer";
		}
		if (request.getParameter("invalidRepeatPass") != null) {
			loginRepeatPass = "Passordene er ikke like";
		}
		if (request.getParameter("invalidSex") != null) {
			loginSex = "M� velge kjonn";
		}

		request.setAttribute("loginPassword", loginPassword);
		request.setAttribute("loginFirstName", loginFirstName);
		request.setAttribute("loginLastName", loginLastName);
		request.setAttribute("loginPhone", loginPhone);
		request.setAttribute("loginRepeatPass", loginRepeatPass);
		request.setAttribute("loginSex", loginSex);

		request.getRequestDispatcher("WEB-INF/Paamelding.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// N�r vi bruker ferdig bibliotek "escapeHTML3" s� vil den ikke la oss bruke ���
		// som f�rste bokstav i fornavn eller etternavn.

		String firstName = request.getParameter("fornavn");
		String lastName = request.getParameter("etternavn");
		String phoneNumber = StringEscapeUtils.escapeHtml3(request.getParameter("mobil"));
		String password = StringEscapeUtils.escapeHtml3(request.getParameter("passord"));
		String repeatPass = StringEscapeUtils.escapeHtml3(request.getParameter("passordRepetert"));
		String sex = StringEscapeUtils.escapeHtml3(request.getParameter("kjonn"));

		if (!(firstName.startsWith("�") || firstName.startsWith("�") || firstName.startsWith("�"))) {
			firstName = StringEscapeUtils.escapeHtml3(firstName);
		}
		if (!(lastName.startsWith("�") || lastName.startsWith("�") || lastName.startsWith("�"))) {
			lastName = StringEscapeUtils.escapeHtml3(lastName);
		}

		String invalid = "?";

		List<Participant> checkForPhonenumber = participantDAO.getParticipants();

		if (!ParticipantValidator.checkExistingPhone(checkForPhonenumber,
				FormatPhoneNumber.formatPhoneNumber(phoneNumber))) {

			response.sendRedirect(URL_REGISTRATION);
		} else {

			if (!PasswordValidator.passwordValidator(password)) {
				invalid += "&invalidPassword";
			}
			if (!ParticipantValidator.firstNameValidator(firstName)) {
				invalid += "&invalidFirstName";
			}
			if (!ParticipantValidator.lastNameValidator(lastName)) {
				invalid += "&invalidLastName";
			}
			if (!ParticipantValidator.phoneNumberValidator(phoneNumber)) {
				invalid += "&invalidPhone";
			}
			if (!password.equals(repeatPass) || (repeatPass == "")) {
				invalid += "&invalidRepeatPass";
			}
			if (sex == null) {
				invalid += "&invalidSex";
			}
			if (invalid != "?") {
				response.sendRedirect(URL_REGISTRATION + invalid);
			} else {

				HttpSession sesjon = request.getSession(false);
				if (sesjon != null) {
					sesjon.invalidate();
				}
				sesjon = request.getSession(true);
				sesjon.setMaxInactiveInterval(20);

				sesjon.setAttribute("firstName", firstName);
				sesjon.setAttribute("lastName", lastName);
				sesjon.setAttribute("phoneNumber", phoneNumber);
				sesjon.setAttribute("sex", sex);

				String password_salt = PassordService.genererTilfeldigSalt();

				String password_hash = PassordService.hashMedSalt(password, password_salt);

				Participant participant = new Participant(firstName, lastName, phoneNumber, password_hash, sex,
						password_salt);

				participantDAO.addParticipant(participant);
				response.sendRedirect(URL_REG_CONFIRMED);
			}

		}

	}
}
