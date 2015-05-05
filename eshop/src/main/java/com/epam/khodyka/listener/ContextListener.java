package com.epam.khodyka.listener;

import com.epam.khodyka.bean.SignupForm;
import com.epam.khodyka.captcha.CaptchaFactory;
import com.epam.khodyka.captcha.CaptchaService;
import com.epam.khodyka.db.TransactionManager;
import com.epam.khodyka.db.repository.impl.MySqlUserRepository;
import com.epam.khodyka.service.AvatarService;
import com.epam.khodyka.service.UserService;
import com.epam.khodyka.service.impl.LocalAvatarService;
import com.epam.khodyka.service.impl.UserServiceImpl;
import com.epam.khodyka.validator.SignupFormValidator;
import com.epam.khodyka.validator.Validator;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.lang.reflect.Proxy;

/**
 * Application Lifecycle Listener implementation class ContextListener
 */
@WebListener
public class ContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {

        MySqlUserRepository userRepository = new MySqlUserRepository();
        UserServiceImpl userServiceImpl = new UserServiceImpl(userRepository);
        TransactionManager<UserService> userTransactionManager = new TransactionManager(userServiceImpl);
        UserService userService = createServiceProxy(userServiceImpl, userTransactionManager);

        AvatarService avatarService = new LocalAvatarService();

        String captchaMode = event.getServletContext().getInitParameter(
                "captchaMode");
        int captchaExpiryTime = Integer.parseInt(event.getServletContext()
                .getInitParameter("captchaExpiryTime"));
        CaptchaService captchaService = CaptchaFactory.getInstance(
                captchaExpiryTime).getCaptchaService(captchaMode);


        Validator<SignupForm> validator = new SignupFormValidator();

        event.getServletContext().setAttribute("AvatarService", avatarService);
        event.getServletContext().setAttribute("UserService", userService);
        event.getServletContext().setAttribute("CaptchaService", captchaService);
        event.getServletContext().setAttribute("SignupFormValidator", validator);
    }

    public void contextDestroyed(ServletContextEvent event) {

    }

    private <T> T createServiceProxy(T impl, TransactionManager manager) {
        return (T) Proxy.newProxyInstance(impl.getClass().getClassLoader(), impl.getClass().getInterfaces(), manager);
    }

}
