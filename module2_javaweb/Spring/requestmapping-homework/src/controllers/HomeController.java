package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    //1.1
    @RequestMapping(value = "/method0",method = RequestMethod.GET)
    public String method0(){
        return "method0";
    }
    //2.2
    @RequestMapping(value = {"/method1",  "/method1/one", "/method1/two"},method = RequestMethod.GET)
    public String method1(){
        return "method1";
    }
    //2.3
    @RequestMapping(value="/method3")

}
