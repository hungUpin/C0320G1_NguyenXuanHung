package controllers;

import dao.UserDao;
import module.Login;
import module.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

@GetMapping("/home")
    public ModelAndView home(){
    ModelAndView modelAndView = new ModelAndView("home","login", new Login());
    return modelAndView;
}
@PostMapping("/login")
    public ModelAndView login(@ModelAttribute("login")Login login){
    User user = UserDao.checkLogin(login);
    if(user==null){
        return new ModelAndView("error");
    }else {
        return new ModelAndView("user","user",user);
    }
}
}
