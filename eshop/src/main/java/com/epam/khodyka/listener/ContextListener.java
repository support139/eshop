package com.epam.khodyka.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.epam.khodyka.bean.SignupFormBean;
import com.epam.khodyka.captcha.CaptchaFactory;
import com.epam.khodyka.captcha.CaptchaService;
import com.epam.khodyka.db.impl.LocalUserRepository;
import com.epam.khodyka.service.UserService;
import com.epam.khodyka.service.impl.UserServiceImpl;
import com.epam.khodyka.validator.SignupFormValidator;
import com.epam.khodyka.validator.Validator;

/**
 * Application Lifecycle Listener implementation class ContextListener
 *
 */
@WebListener
public class ContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent event) {

		LocalUserRepository userRepository = new LocalUserRepository();
		UserService userService = new UserServiceImpl(userRepository);
		event.getServletContext().setAttribute("UserService", userService);

		String captchaMode = event.getServletContext().getInitParameter(
				"captchaMode");
		int captchaExpiryTime = Integer.parseInt(event.getServletContext()
				.getInitParameter("captchaExpiryTime"));
		CaptchaService captchaService = CaptchaFactory.getInstance(
				captchaExpiryTime).getCaptchaService(captchaMode);
		event.getServletContext().setAttribute("CaptchaService", captchaService);
	
		Validator<SignupFormBean> validator = new SignupFormValidator();
		event.getServletContext().setAttribute("SignupFormValidator", validator);
	}

	public void contextDestroyed(ServletContextEvent event) {
		
	}

}
