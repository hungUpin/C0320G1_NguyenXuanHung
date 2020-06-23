package com.codegym.productlist.controllers;

import com.codegym.productlist.models.Product;
import com.codegym.productlist.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public ModelAndView getHomePage(@RequestParam(value = "nameSearch",required = false) String nameSearch){
        if(nameSearch!=null){
            ModelAndView modelAndView = new ModelAndView("product/index");
            modelAndView.addObject("showBack","showBack");
            List<Product> productList = productService.findProductByName(nameSearch);
            modelAndView.addObject("products",productList);
            return modelAndView;
        }
        return new ModelAndView("product/index","products", productService.findAllProduct());
    }
    @GetMapping("/product/add")
    public ModelAndView getAddPage(){
        return new ModelAndView("product/add","product",new Product());
    }
    @PostMapping("/product/save")
    public String addNewProduct(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes){
        product.setId((int) (Math.random()*10000));
        productService.addNewProduct(product);
        redirectAttributes.addFlashAttribute("message","Add new product completed!!!");
        return "redirect:/";
    }
    @GetMapping("/product/delete/{id}")
    public ModelAndView getDeletePage(@PathVariable("id") Integer id){
        return new ModelAndView("product/delete","product",productService.findProductById(id));
    }
    @PostMapping("/product/delete")
    public String deleteProduct(@ModelAttribute("product") Product product,RedirectAttributes redirectAttributes){
        productService.deleteProductById(product.getId());
        redirectAttributes.addFlashAttribute("message","Product has been deleted!!!");
        return "redirect:/";
    }
    @GetMapping("product/edit/{id}")
    public ModelAndView getEditPage(@PathVariable("id") Integer id){
        return new ModelAndView("product/edit","product",productService.findProductById(id));
    }
    @PostMapping("product/edit")
    public String editProduct(@ModelAttribute("product") Product product,RedirectAttributes redirectAttributes){
        productService.addNewProduct(product);
        redirectAttributes.addFlashAttribute("message","Product has been updated!!!");
        return "redirect:/";
    }
}
