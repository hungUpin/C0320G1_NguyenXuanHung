package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TranslateController {
    private static Map<String,String> dictionary;
    static {
        dictionary = new HashMap<>();
        dictionary.put("hello","xin chào");
        dictionary.put("Good morning","Chào buổi sáng");
        dictionary.put("Goodbye","tạm biệt");
    }
    @GetMapping("/translate")
    public String showTranslatePage(){
        return "dictionary";
    }
    @PostMapping("/translate")
    public ModelAndView result(@RequestParam("word") String word){
        String result = dictionary.get(word);
        return new ModelAndView("dictionary","result",result);
    }
}
