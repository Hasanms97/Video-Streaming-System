package com.example.DTube.Controllers;

import com.example.DTube.Entities.user;
import com.example.DTube.Services.AuthenticationService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;


    @GetMapping("/")
    public String getSignIn(Model model) {
        model.addAttribute("account", new user());
        return "signIn";
    }

    @GetMapping("/sign-up")
    public String getSignUp(Model model) {
        model.addAttribute("account", new user());
        return "singUp";
    }

    @PostMapping("/signin")
    public String signInSubmitHandler(user user, HttpSession session) {
        com.example.DTube.Entities.user temp = authenticationService.checkUserCredentials(user);
        if(temp != null)
        {
            session.setAttribute("account",temp);
            return "redirect:/auth/home";
        }
        return "redirect:/auth/";
    }

    @PostMapping("/auth_sign-up")
    public String singUpSubmitHandler(user user, @RequestParam String confirmPassword, HttpSession session) {
        com.example.DTube.Entities.user temp = authenticationService.createUserCredentials(user,confirmPassword);
        if(temp == null)
        {
            session.setAttribute("account",temp);
            return "redirect:/auth/home";
        }
        return "redirect:/auth/";
    }
    @GetMapping("/signout")
    public String signOutHandler(HttpSession session)
    {
        authenticationService.removeSession();
        return "redirect:/auth/";
    }
    @GetMapping("/home")
    public String getHome(Model model,HttpSession session) {
        model.addAttribute("account", session.getAttribute("account"));
        return "homePage";
    }
}
