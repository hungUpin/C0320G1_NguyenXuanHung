package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    @GetMapping("/convert")
    public String showConvertPage(){
        return "currency";
    }
    @PostMapping("/convert")
    public String convert(@RequestParam("rate") int rate, @RequestParam("usd") int usd, Model model){
        int vnd = usd*rate;
        model.addAttribute("vnd",vnd);
        return "result";
    }
}
