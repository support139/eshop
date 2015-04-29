package com.epam.khodyka.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.khodyka.bean.SignupFormBean;
import com.epam.khodyka.captcha.CaptchaService;
import com.epam.khodyka.db.exception.UserAlreadyExistException;
import com.epam.khodyka.service.UserService;
import com.epam.khodyka.validator.SignupFormValidator;
import com.epam.khodyka.validator.Validator;

@WebServlet("/Signup")
public class SignupServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private CaptchaService captchaService;
	private UserService userService;
	private Validator<SignupFormBean> validator;

	@Override
	public void init() throws ServletException {
		super.init();
		this.captchaService = (CaptchaService) getServletContext()
				.getAttribute("CaptchaService");
		this.userService = (UserService) getServletContext().getAttribute(
				"UserService");
		this.validator = new SignupFormValidator();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.captchaService = (CaptchaService) config.getServletContext()
				.getAttribute("CaptchaService");
		this.userService = (UserService) config.getServletContext()
				.getAttribute("UserService");
		this.validator = (Validator<SignupFormBean>) config.getServletContext()
				.getAttribute("SignupFormValidator");
	}
	
	public void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int hiddenCaptchaId = new Random().nextInt();
		request.setAttribute("hiddenCaptchaId", hiddenCaptchaId);

		SignupFormBean formBean = (SignupFormBean) request.getSession()
				.getAttribute("formBean");
		request.setAttribute("formBean", formBean);
		request.getSession().removeAttribute("formBean");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		SignupFormBean formBean = new SignupFormBean();
		formBean.setLogin(request.getParameter("login"));
		formBean.setPassword(request.getParameter("password"));
		formBean.setName(request.getParameter("name"));
		formBean.setSurname(request.getParameter("surname"));
		formBean.setEmail(request.getParameter("email"));

		if (!validator.isValid(formBean)) {
			redirectToSignUpPage(request, response, formBean);
			return;
		}
		if (!captchaService.checkCaptcha(request)) {
			redirectToSignUpPage(request, response, formBean);
			return;
		}
		try {
			userService.createUser(formBean);
		} catch (UserAlreadyExistException e) {
			formBean.getLogin().setErrorMessage("User already exist");
			redirectToSignUpPage(request, response, formBean);
			return;
		}
		response.sendRedirect("Signup");

	}

	private void redirectToSignUpPage(HttpServletRequest request,
			HttpServletResponse response, SignupFormBean formBean)
			throws IOException {
		request.getSession().setAttribute("formBean", formBean);
		response.sendRedirect("Signup");
	}
}
