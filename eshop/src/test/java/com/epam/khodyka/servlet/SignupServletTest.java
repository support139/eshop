package com.epam.khodyka.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.epam.khodyka.bean.Captcha;
import com.epam.khodyka.bean.SignupFormBean;
import com.epam.khodyka.captcha.CaptchaService;
import com.epam.khodyka.captcha.impl.SessionCapthaImpl;
import com.epam.khodyka.db.UserRepository;
import com.epam.khodyka.db.impl.LocalUserRepository;
import com.epam.khodyka.service.UserService;
import com.epam.khodyka.service.impl.UserServiceImpl;
import com.epam.khodyka.validator.SignupFormValidator;
import com.epam.khodyka.validator.Validator;

public class SignupServletTest {

	private static HttpServletRequest request;
	private static HttpServletResponse response;
	private static HttpSession session;

	private static CaptchaService captchaService;
	private static UserService userService;
	private static UserRepository userRepository;

	private static Validator<SignupFormBean> validator;

	private static SignupServlet servlet;

	@BeforeClass
	public static void setup() throws ServletException {
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		session = Mockito.mock(HttpSession.class);

		userRepository = new LocalUserRepository();
		captchaService = new SessionCapthaImpl(5);
		userService = new UserServiceImpl(userRepository);
		validator = new SignupFormValidator();

		ServletContext context = Mockito.mock(ServletContext.class);
		ServletConfig config = Mockito.mock(ServletConfig.class);

		Mockito.when(config.getServletContext()).thenReturn(context);
		Mockito.when(context.getAttribute("UserService")).thenReturn(
				userService);
		Mockito.when(context.getAttribute("CaptchaService")).thenReturn(
				captchaService);
		Mockito.when(context.getAttribute("SignupFormValidator")).thenReturn(
				validator);
		Mockito.when(request.getSession()).thenReturn(session);

		servlet = new SignupServlet();
		servlet.init(config);
	}

	@Test
	public void shouldRedirectToSignupPageWhenRegistrationHasBeenSuccess()
			throws ServletException, IOException {
		Captcha captcha = new Captcha(1, "Token", new Date().getTime());
		Mockito.when(request.getParameter("login")).thenReturn("Statham20");
		Mockito.when(request.getParameter("password")).thenReturn("Radeon960");
		Mockito.when(request.getParameter("name")).thenReturn("Andrew");
		Mockito.when(request.getParameter("surname")).thenReturn("Khodyka");
		Mockito.when(request.getParameter("email")).thenReturn(
				"support139@mail.ru");
		Mockito.when(request.getSession().getAttribute("captcha")).thenReturn(
				captcha);
		Mockito.when(request.getParameter("captchaValue")).thenReturn("Token");

		servlet.doPost(request, response);

		Mockito.verify(response).sendRedirect(Mockito.eq("Signup"));
	}

	@Test
	public void shouldRedirectToSignupPageWhenFormIsNotValid()
			throws ServletException, IOException {
		Captcha captcha = new Captcha(1, "Token", new Date().getTime());
		Mockito.when(request.getParameter("login")).thenReturn("Statham20");
		Mockito.when(request.getParameter("password")).thenReturn("Radeon960");
		Mockito.when(request.getParameter("name")).thenReturn("Andrew");
		Mockito.when(request.getParameter("surname")).thenReturn("Khodyka");
		Mockito.when(request.getParameter("email")).thenReturn("support139");
		Mockito.when(request.getSession().getAttribute("captcha")).thenReturn(
				captcha);
		Mockito.when(request.getParameter("captchaValue")).thenReturn("Token");

		servlet.doPost(request, response);

		Mockito.verify(response).sendRedirect(Mockito.eq("Signup"));
	}

	@Test
	public void shouldRedirectToSignupPageWhenCaptchaIsNotValid()
			throws ServletException, IOException {
		Captcha captcha = new Captcha(1, "Token", new Date().getTime());
		Mockito.when(request.getParameter("login")).thenReturn("Statham20");
		Mockito.when(request.getParameter("password")).thenReturn("Radeon960");
		Mockito.when(request.getParameter("name")).thenReturn("Andrew");
		Mockito.when(request.getParameter("surname")).thenReturn("Khodyka");
		Mockito.when(request.getParameter("email")).thenReturn("support139");
		Mockito.when(request.getSession().getAttribute("captcha")).thenReturn(
				captcha);
		Mockito.when(request.getParameter("captchaValue")).thenReturn("Tokenn");

		servlet.doPost(request, response);

		Mockito.verify(response).sendRedirect(Mockito.eq("Signup"));

	}

}
