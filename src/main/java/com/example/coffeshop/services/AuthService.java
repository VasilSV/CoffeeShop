package com.example.coffeshop.services;

import com.example.coffeshop.model.entity.User;
import com.example.coffeshop.model.entity.dtos.LoginDTO;
import com.example.coffeshop.model.entity.dtos.UserRegistrationDTO;
import com.example.coffeshop.repository.UserRepository;
import com.example.coffeshop.session.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;

    private LoggedUser userSession;

    public AuthService(UserRepository userRepository, LoggedUser userSession) {
        this.userRepository = userRepository;
        this.userSession = userSession;
    }

    // todo 3. проверка паролата
    public boolean register(UserRegistrationDTO registrationDTO) {
        if (!registrationDTO.getPassword().equals(registrationDTO.getConfirmPassword())) {
            return false;
        }
        Optional<User> byEmail = this.userRepository.findByEmail(registrationDTO.getEmail());
        if (byEmail.isPresent()) {
            return false;
        }
        Optional<User> byUsername = this.userRepository.findByUserName(registrationDTO.getUserName());
        if (byUsername.isPresent()) {
            return false;
        }

        User user = new User();
        user.setUserName(registrationDTO.getUserName());
        user.setFirstName(registrationDTO.getFirstName());
        user.setLastName(registrationDTO.getLastName());
        user.setEmail(registrationDTO.getEmail());
        user.setPassword(registrationDTO.getPassword());

        this.userRepository.save(user);
        return true;
    }


    public boolean login(LoginDTO loginDTO) {
        Optional<User> user = this.userRepository
                .findByUserNameAndPassword(loginDTO.getUserName(), loginDTO.getPassword());

        if (user.isEmpty()) {
            return false;
        }
//6. правим Session с LoggedUser
        this.userSession.login(user.get());

        return true;
    }


    public boolean isLoggedIn() {
        return userSession.getId()>0;
    }
    public void logout() {
        this.userSession.logout();
    }

}
