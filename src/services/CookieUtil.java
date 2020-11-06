package services;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static constants.AuthConstant.AUTH_COOKIE;
import static constants.AuthConstant.AUTH_VALUE;

public class CookieUtil {
	private final static String CHARACTER_ENCODING = "UTF-8";
	private final static int MAX_AGE_IN_SECONDS = 120;

	public static void addCookieToResponse(HttpServletResponse response, String navn, String verdi) {
		try {
			Cookie cookie = new Cookie(navn, URLEncoder.encode(verdi, CHARACTER_ENCODING));
			cookie.setMaxAge(MAX_AGE_IN_SECONDS);
			response.addCookie(cookie);
		} catch (UnsupportedEncodingException e) {
			// Should never happen
			e.printStackTrace();
		}
	}

	public static String getCookieFromRequest(HttpServletRequest request, String navn) throws Exception {
			String verdi = Arrays.stream(request.getCookies())
					.filter(c -> c.getName().equals(navn))
					.map(Cookie::getValue)
					.findFirst()
					.orElse("");

			return URLDecoder.decode(verdi, CHARACTER_ENCODING);
	}
	
	public static void setCookie(HttpServletResponse response) {
		CookieUtil.addCookieToResponse(response, AUTH_COOKIE, AUTH_VALUE);
	}
	
	public static boolean hasValidAuthCookie(HttpServletRequest request) throws Exception {
		String cookieValue = getCookieFromRequest(request, AUTH_COOKIE);
		return cookieValue.equals(AUTH_VALUE);
	}

}
