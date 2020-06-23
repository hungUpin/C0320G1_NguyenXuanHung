package com.example.login.controllers;

import com.example.login.models.Account;
import com.example.login.models.User;
import com.example.login.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@SessionAttributes("user")
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @ModelAttribute("user")
    public User setUpUserForm() {
        return new User();
    }

    @GetMapping("/login")
    public ModelAndView Index(@CookieValue(value = "setUser", defaultValue = "") String setUser) {
        Cookie cookie = new Cookie("setUser", setUser);
        Cookie cookie1=new Cookie("setUser",setUser);
        return new ModelAndView("login", "cookieValue", cookie);
    }

    @PostMapping("/dologin")
    public String doLogin(@ModelAttribute("user") User user, Model model, @CookieValue(value = "setUser", defaultValue = "") String setUser,
                          HttpServletResponse response, HttpServletRequest request) {
        if (user.getEmail().equals("admin@gmmail.com") && user.getPassword().equals("123456")) {
            if (user.getEmail() != null) {
                setUser = user.getEmail();
            }
            // create cookie and set it in response
            Cookie cookie = new Cookie("setUser", setUser);
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);
            Cookie[] cookies = request.getCookies();
            for (Cookie ck : cookies) {
                if (ck.getName().equals("setUser")) {
                    model.addAttribute("cookieValue", ck);
                    break;
                } else {
                    ck.setValue("");
                    model.addAttribute("cookieValue", ck);
                    break;
                }
            }
            model.addAttribute("message", "login success. Welcome!! ");
        } else {
            user.setEmail("");
            Cookie cookie = new Cookie("setUser", setUser);
            model.addAttribute("cookieValue", cookie);
            model.addAttribute("message", "Login failed. Try again.");
        }
        return "login";
    }

    @GetMapping("/add")
    public ModelAndView goAddAccountForm() {
        return new ModelAndView("add", "account", new Account());
    }

    @PostMapping("/add")
    public ModelAndView addAccount(@Valid @ModelAttribute Account account, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("add");
        }
        accountService.saveAccount(account);
        return new ModelAndView("result", "message", "Edit completed!!!");
    }
}
