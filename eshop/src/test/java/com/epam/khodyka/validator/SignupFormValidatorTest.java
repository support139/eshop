package com.epam.khodyka.validator;

import com.epam.khodyka.bean.Input;
import com.epam.khodyka.bean.StringInput;
import com.epam.khodyka.validator.impl.SignupFormValidator;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertFalse;

/**
 * Created by Andrii_Khodyka on 4/29/2015.
 */
public class SignupFormValidatorTest {

    SignupFormValidator validator = new SignupFormValidator();

    @Test
    public void shouldBeFalseWhenLoginIsIncorrect() throws Exception {
        Input login = new StringInput("!2313!*&*@#");
        boolean result = validator.isLoginValid(login);
        assertFalse(result);
    }

    @Test
    public void shouldBeSuccessWhenLoginIsCorrect() throws Exception {
        Input login = new StringInput("Ghost36");
        boolean result = validator.isLoginValid(login);
        assertTrue(result);
    }

    @Test
    public void shouldBeFalseWhenPasswordIsIncorrect() throws Exception {
        Input password = new StringInput("!2313!*&*@#");
        boolean result = validator.isPasswordValid(password);
        assertFalse(result);
    }

    @Test
    public void shouldBeSuccessWhenPasswordIsCorrect() throws Exception {
        Input password = new StringInput("Radeon960");
        boolean result = validator.isPasswordValid(password);
        assertTrue(result);
    }

    @Test
    public void shouldBeFalseWhenNameIsIncorrect() throws Exception {
        Input name = new StringInput("*&*&*");
        boolean result = validator.isNameValid(name);
        assertFalse(result);
    }

    @Test
    public void shouldBeTrueWhenNameIsCorrect() throws Exception {
        Input name = new StringInput("Andrew");
        boolean result = validator.isNameValid(name);
        assertTrue(result);
    }

    @Test
    public void shouldBeFalseWhenSurnameIsIncorrect() throws Exception {
        Input surname = new StringInput("!@#$%^&");
        boolean result = validator.isSurnameValid(surname);
        assertFalse(result);
    }

    @Test
    public void shouldBeTrueWhenSurnameIsCorrect() throws Exception {
        Input surname = new StringInput("Khodyka");
        boolean result = validator.isSurnameValid(surname);
        assertTrue(result);
    }

    @Test
    public void shouldBeFalseWhenEmailIsIncorrect() throws Exception {
        Input email = new StringInput("support139");
        boolean result = validator.isEmailValid(email);
        assertFalse(result);
    }

    @Test
    public void shouldBeTrueWhenEmailIsCorrect() throws Exception {
        Input email = new StringInput("support139@mail.ru");
        boolean result = validator.isEmailValid(email);
        assertTrue(result);
    }
}