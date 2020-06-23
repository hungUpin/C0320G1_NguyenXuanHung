package com.codegym.controllers;

import com.codegym.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.codegym.services.CustomerService;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @GetMapping("/")
    public ModelAndView getHomePage(){
        return new ModelAndView("index","customers",customerService.findAllCustomer());
    }
    @GetMapping("/customer/add")
    public ModelAndView addCustomer(){
        return new ModelAndView("add","customer", new Customer());
    }
    @PostMapping("/customer/save")
    public String addNewCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes){
        customer.setId((long) (Math.random()*10000));
        customerService.saveCustomer(customer);
        redirectAttributes.addFlashAttribute("message","Add customer completed!!!");
        return "redirect:/";
    }
}
