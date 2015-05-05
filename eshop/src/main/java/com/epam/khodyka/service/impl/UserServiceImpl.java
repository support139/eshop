package com.epam.khodyka.service.impl;

import com.epam.khodyka.bean.LoginForm;
import com.epam.khodyka.bean.SignupForm;
import com.epam.khodyka.db.repository.UserRepository;
import com.epam.khodyka.db.entiry.User;
import com.epam.khodyka.db.exception.UserAlreadyExistException;
import com.epam.khodyka.service.UserService;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isUserExists(String login){
        return userRepository.get(login) != null;
    }

    @Override
    public void createUser(SignupForm formBean) throws UserAlreadyExistException {
        if (isUserExists(formBean.getLogin().getValue())) {
            throw new UserAlreadyExistException();
        }
        User user = new User();
        user.setLogin(formBean.getLogin().getValue());
        user.setPassword(formBean.getPassword().getValue());
        user.setName(formBean.getName().getValue());
        user.setSurname(formBean.getSurname().getValue());
        user.setEmail(formBean.getEmail().getValue());
        user.setAvatar(formBean.getLogin().getValue());
        userRepository.add(user);
    }

    @Override
    public User login(LoginForm loginForm) {
        String login = loginForm.getLogin().getValue();
        if (!isUserExists(login)) {
            return null;
        }
        User user = userRepository.get(login);
        if(!user.getPassword().equals(loginForm.getPassword().getValue())){
            return null;
        }
        return user;
    }


}
