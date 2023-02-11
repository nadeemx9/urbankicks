package com.urbankicks.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.urbankicks.entities.User;
import com.urbankicks.service.UserService;


@Controller
public class MyController {

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String index(Model model)
    {
        model.addAttribute("title", "UrbanKicks - First Choice");

        return "index";
    }
    @GetMapping("/cart")
    public String cart(Model model, Principal principal)
    {
        model.addAttribute("title", "Cart");


        System.out.println(principal.getName());
        return "cart";
    }

    @GetMapping("/checkout")
    public String checkout(Model model)
    {
        model.addAttribute("title", "Checkout");
        
        return "checkout";
    }
    @GetMapping("/contact")
    public String contact(Model model)
    {
        model.addAttribute("title", "Contact");

        return "contact";
    }
    @GetMapping("/detail")
    public String detail(Model model)
    {
        model.addAttribute("title", "Detail");

        return "detail";
    }
    @GetMapping("/shop")
    public String shop(Model model)
    {
        model.addAttribute("title", "Shop");

        return "shop";
    }
    
    @GetMapping("/signup")
    public String signup(Model model)
    {
        model.addAttribute("title", "SignUp");
        model.addAttribute("user", new User());

        return "signup";
    }

    @PostMapping("/signupSubmit")
    public String signupSubmit(@ModelAttribute User user)
    {
        user.setPassword(userService.encode(user.getPassword()));
        userService.save(user);
        return "signup";
    }

    @RequestMapping("/add-product")
    public String addProduct()
    {
        return "add-product";
    }
}
