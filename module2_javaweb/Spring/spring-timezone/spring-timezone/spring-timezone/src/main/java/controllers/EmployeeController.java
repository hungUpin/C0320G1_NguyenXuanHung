package controllers;

import model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @GetMapping("/showform")
    public ModelAndView showForm(){
        System.out.println("hi");
        return new ModelAndView("employee/create","employee", new Employee());
    }
    @PostMapping("/addEmployee")
    public ModelAndView submit(@ModelAttribute("employee") Employee employee){
        ModelAndView modelAndView = new ModelAndView("employee/info");
        modelAndView.addObject("name",employee.getName());
        modelAndView.addObject("contactNumber",employee.getContactNumber());
        modelAndView.addObject("id",employee.getId());
        return modelAndView;
    }
}
