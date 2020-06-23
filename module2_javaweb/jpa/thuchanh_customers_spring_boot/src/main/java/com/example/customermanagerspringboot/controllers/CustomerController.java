package com.example.customermanagerspringboot.controllers;

import com.example.customermanagerspringboot.models.Customer;
import com.example.customermanagerspringboot.models.Province;
import com.example.customermanagerspringboot.repositories.ProvinceRepository;
import com.example.customermanagerspringboot.services.CustomerService;
import com.example.customermanagerspringboot.services.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    ProvinceService provinceService;

    @ModelAttribute("provinces")
    public List<Province> provinces() {
        return provinceService.findAllProvince();
    }

    @GetMapping("")
    public ModelAndView getHomePage(@PageableDefault(value = 2) Pageable pageable, @RequestParam(value = "s", required = false) String s) {
        Page<Customer> customers;

        //if(s != null){
         //   customers=customerService.findAllCustomerByFirstName(s,pageable);
     //   }else {
            customers = customerService.findAll(pageable);
       // }
        return new ModelAndView("index", "customers", customers);
    }

    @GetMapping("/create-customer")
    public ModelAndView showCreatePage() {
        return new ModelAndView("create", "customer", new Customer());
    }

    @PostMapping("/create-customer")
    public String createCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customer.setId((long) (Math.random() * 10000));
        customerService.saveCustomer(customer);
        redirectAttributes.addFlashAttribute("message", "Add customer completed!!!");
        return "redirect:/";
    }

    @GetMapping("/customer/edit/{id}")
    public ModelAndView getEditPage(@PathVariable("id") Long id) {
//        ModelAndView modelAndView = new ModelAndView("edit");
//        Customer customer = customerService.findCustomerById(id);
//        Province province = provinceService.findByIdProvince(customer.getProvince().getId());
//        modelAndView.addObject("customer",customer);
//        modelAndView.addObject("province",province);
        return new ModelAndView("edit", "customer", customerService.findCustomerById(id));
    }

    @PostMapping("/customer/edit")
    public String editCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.saveCustomer(customer);
        redirectAttributes.addFlashAttribute("message", "Edit customer completed!!!");
        return "redirect:/";
    }

    @GetMapping("/customer/delete/{id}")
    public ModelAndView getDeletePage(@PathVariable("id") Long id) {
        return new ModelAndView("delete", "customer", customerService.findCustomerById(id));
    }

    @PostMapping("/customer/delete")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.removeCustomer(customer.getId());
        redirectAttributes.addFlashAttribute("message", "Delete completed!!!");
        return "redirect:/";
    }

    @GetMapping("/view-province/{id}")
    public ModelAndView getListProvinceView(@PathVariable Long id) {
        Province province = provinceService.findByIdProvince(id);
        List<Customer> customers = customerService.findAllCustomerByProvince(province);
        ModelAndView modelAndView = new ModelAndView("/province/view");
        modelAndView.addObject("province", province);
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
}
