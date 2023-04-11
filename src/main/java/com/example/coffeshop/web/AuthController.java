package com.example.coffeshop.web;

import com.example.coffeshop.model.entity.dtos.LoginDTO;
import com.example.coffeshop.model.entity.dtos.UserRegistrationDTO;
import com.example.coffeshop.services.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    //TODO 4. правим модели за страниците ...
    @ModelAttribute("registrationDTO")
    public UserRegistrationDTO initRegistrationDTO() {
        return new UserRegistrationDTO();
    }

    @ModelAttribute("loginDTO")
    public LoginDTO initLoginDTO() {
        return new LoginDTO();
    }


    // TODO 1. регистрация
    @GetMapping("/register")
    public String register() {
        //секюрити
        if (this.authService.isLoggedIn()) {
            return "redirect:/home";
        }

        return "redirect:/register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegistrationDTO registrationDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (this.authService.isLoggedIn()) {
            return "redirect:/home";
        }

        if (bindingResult.hasErrors() || !this.authService.register(registrationDTO)) {
            redirectAttributes.addFlashAttribute("registrationDTO", registrationDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.registrationDTO", bindingResult);

            return "redirect:/register";
        }

        return "redirect:/login";
    }


    @GetMapping("/login")
    public String login() {
        if (this.authService.isLoggedIn()) {
            return "redirect:/home";
        }
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid LoginDTO loginDTO,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {
        if (this.authService.isLoggedIn()) {
            return "redirect:/home";
        }
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("loginDTO", loginDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.loginDTO", bindingResult);

            return "redirect:/login";
        }
//TODO 5. показваме ако има грешка в логина като правим boolean login  в сървиса
        // ако не го правим слагаме горе в if authService както в регистер ...
        if (!this.authService.login(loginDTO)) {
            redirectAttributes.addFlashAttribute("loginDTO", loginDTO);
            redirectAttributes.addFlashAttribute("badCredentials", true);

            return "redirect:/login";
        }

        return "redirect:/home";


    }
    @GetMapping("/logout")
    public String logout(){
        this.authService.logout();
        return "redirect:/";

    }

}
