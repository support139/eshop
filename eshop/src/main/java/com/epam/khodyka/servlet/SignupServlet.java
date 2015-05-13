package com.epam.khodyka.servlet;

import com.epam.khodyka.Path;
import com.epam.khodyka.bean.SignupForm;
import com.epam.khodyka.captcha.CaptchaService;
import com.epam.khodyka.db.Fields;
import com.epam.khodyka.db.exception.UserAlreadyExistException;
import com.epam.khodyka.requestextractor.Extractor;
import com.epam.khodyka.requestextractor.impl.SignupFormExtractor;
import com.epam.khodyka.service.PictureService;
import com.epam.khodyka.service.UserService;
import com.epam.khodyka.service.exception.UnsupportPictureFormatException;
import com.epam.khodyka.validator.impl.SignupFormValidator;
import com.epam.khodyka.validator.Validator;
import org.apache.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@MultipartConfig
@WebServlet("/Signup")
public class SignupServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(SignupServlet.class);
    private static final long serialVersionUID = 1L;

    private CaptchaService captchaService;
    private UserService userService;
    private PictureService pictureService;
    private Extractor<SignupForm> signupFormExtractor;
    private Validator<SignupForm> signupFormValidator;

    @Override
    public void init() throws ServletException {
        super.init();
        this.captchaService = (CaptchaService) getServletContext()
                .getAttribute("CaptchaService");
        this.userService = (UserService) getServletContext().getAttribute(
                "UserService");
        this.pictureService = (PictureService) getServletContext().getAttribute("PictureService");
        this.signupFormExtractor = new SignupFormExtractor();
        this.signupFormValidator = new SignupFormValidator();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.captchaService = (CaptchaService) config.getServletContext()
                .getAttribute("CaptchaService");
        this.userService = (UserService) config.getServletContext()
                .getAttribute("UserService");
        this.pictureService = (PictureService) config.getServletContext().getAttribute("PictureService");
        this.signupFormValidator = (Validator<SignupForm>) config.getServletContext()
                .getAttribute("SignupFormValidator");
    }

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        int hiddenCaptchaId = new Random().nextInt();
        request.setAttribute("hiddenCaptchaId", hiddenCaptchaId);

        SignupForm formBean = (SignupForm) request.getSession()
                .getAttribute("formBean");
        request.setAttribute("formBean", formBean);
        request.getSession().removeAttribute("formBean");
        request.getRequestDispatcher(Path.LOGIN_PAGE).forward(request, response);
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        SignupForm formBean = signupFormExtractor.extract(request);

        if (!signupFormValidator.isValid(formBean)) {
            LOG.warn("Form data is not valid. Redirect to sign up page");
            redirectToSignUpPage(request, response, formBean);
            return;
        }
        if (!captchaService.checkCaptcha(request)) {
            LOG.warn("Captcha is not valid. Redirect to sign up page");
            redirectToSignUpPage(request, response, formBean);
            return;
        }
        try {
            userService.createUser(formBean);
        } catch (UserAlreadyExistException e) {
            LOG.warn("User already exists. Redirect to sign up page", e);
            formBean.getLogin().setErrorMessage("User already exist");
            redirectToSignUpPage(request, response, formBean);
            return;
        }
        try {
            pictureService.saveAvatar(request);
        } catch (UnsupportPictureFormatException e) {
            LOG.warn("Unsupport picture format has been used", e);
            redirectToSignUpPage(request, response, formBean);
            return;
        }
        LOG.info("User has been created. Redirect to sign up page");
        response.sendRedirect(Path.SIGN_UP_SERVLET);
    }

    private void redirectToSignUpPage(HttpServletRequest request,
                                      HttpServletResponse response, SignupForm formBean)
            throws IOException {
        request.getSession().setAttribute("formBean", formBean);
        response.sendRedirect(Path.SIGN_UP_SERVLET);
    }
}
