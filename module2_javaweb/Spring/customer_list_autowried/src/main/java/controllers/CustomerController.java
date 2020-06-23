package controllers;

import models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import repositories.CustomerRepository;
import repositories.Impl.CustomerRepositoryImpl;
import services.CustomerService;

import java.util.Random;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @GetMapping("/")
    public ModelAndView getHomePage(ModelMap model) {
        model.addAttribute("customer",customerService.getAllCustomer());
        return new ModelAndView("customer/index","customers",customerService.getAllCustomer());
    }
    @GetMapping("/customer/create")
    public ModelAndView getCreatePage(){
        return new ModelAndView("customer/create","customer", new Customer());
    }
    @PostMapping("/customer/save")
    public String addCustomer(@ModelAttribute("customer") Customer customer,
                                    RedirectAttributes redirectAttributes){
        customer.setId((int) (Math.random()*1000));
        customerService.addNewCustomer(customer);
        redirectAttributes.addFlashAttribute("message","Add customer completed!!!");
        return "redirect:/";
    }
    @GetMapping("/customer/edit/{id}")
    public ModelAndView getEditPage(@PathVariable("id") Integer id){
        return new ModelAndView("/customer/edit","customer",customerService.findCustomerById(id));
    }
    @PostMapping("/customer/edit")
    public String editStudent(@ModelAttribute("customer") Customer customer,
                              RedirectAttributes redirectAttributes){
        customerService.addNewCustomer(customer);
        redirectAttributes.addFlashAttribute("message","edit customer completed!!!");
        return "redirect:/";
    }
}
