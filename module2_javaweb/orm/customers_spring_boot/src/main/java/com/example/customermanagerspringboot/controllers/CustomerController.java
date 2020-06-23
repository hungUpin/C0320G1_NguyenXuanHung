package com.example.customermanagerspringboot.controllers;

import com.example.customermanagerspringboot.models.Customer;
import com.example.customermanagerspringboot.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @GetMapping("/")
    public ModelAndView getHomePage(){
        return new ModelAndView("index","customers",customerService.findAllCustomer());
    }
    @GetMapping("/create-customer")
    public ModelAndView showCreatePage(){
        return new ModelAndView("create","customer",new Customer());
    }
    @PostMapping("/create-customer")
    public String createCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes){
        customer.setId((long) (Math.random()*10000));
        customerService.saveCustomer(customer);
        redirectAttributes.addFlashAttribute("message","Add customer completed!!!");
        return "redirect:/";
    }
    @GetMapping("/customer/edit/{id}")
    public ModelAndView getEditPage(@PathVariable("id") Long id){
        return new ModelAndView("edit","customer",customerService.findCustomerById(id));
    }
    @PostMapping("/customer/edit")
    public String editCustomer(@ModelAttribute("customer") Customer customer,RedirectAttributes redirectAttributes){
        customerService.saveCustomer(customer);
        redirectAttributes.addFlashAttribute("message","Edit customer completed!!!");
        return "redirect:/";
    }
    @GetMapping("/customer/delete/{id}")
    public ModelAndView getDeletePage(@PathVariable("id") Long id){
        return new ModelAndView("delete","customer",customerService.findCustomerById(id));
    }
    @PostMapping("/customer/delete")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer,RedirectAttributes redirectAttributes){
        customerService.removeCustomer(customer.getId());
        redirectAttributes.addFlashAttribute("message","Delete completed!!!");
        return "redirect:/";
    }
}
