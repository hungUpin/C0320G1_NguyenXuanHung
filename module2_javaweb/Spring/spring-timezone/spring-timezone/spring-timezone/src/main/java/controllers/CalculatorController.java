package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {
    @GetMapping("/calculator")
    public ModelAndView calculate(@RequestParam(value = "firstNum",required = false) Double firstNum,@RequestParam(value = "secondNum",required = false) Double secondNum,
    @RequestParam(value = "button",required = false) String choose){
        if(choose==null||firstNum==null||secondNum==null){
            return new ModelAndView("calculator");
        }
        double result=0;
        switch (choose){
            case "Addition(+)":
                result = firstNum+secondNum;
                break;
            case "Subtraction(-)":
                result = firstNum-secondNum;
                break;
            case "Multiplication(X)":
                result = firstNum*secondNum;
                break;
            case "Division(/)":
                result = firstNum/secondNum;
                break;
        }
        return new ModelAndView("calculator","result",result);
    }
}
