package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SandwichController {
    @GetMapping("/sandwich")
    public ModelAndView save(@RequestParam(value = "condiment",required = false) String condiment) {
        if(condiment==null){
            return new ModelAndView("sandwich");
        }
        return new ModelAndView("sandwich","condiment",condiment);
    }
}
