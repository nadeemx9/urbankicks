package com.urbankicks.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.urbankicks.entities.Product;
import com.urbankicks.entities.User;
import com.urbankicks.service.BrandService;
import com.urbankicks.service.CategoryService;
import com.urbankicks.service.ProductService;
import com.urbankicks.service.UserService;


@Controller
public class MyController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private CategoryService categoryService;


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
    public String addProduct(@ModelAttribute("product")Product product, Model model)
    {
        model.addAttribute("title", "UrbanKicks - Add Products");
        model.addAttribute("brands", brandService.findAllBrands());
        model.addAttribute("categories", categoryService.findAllCategories());

        return "add-product";
    }

    @RequestMapping("/login")
    public String login(@ModelAttribute("user")User user, Model model)
    {
        model.addAttribute("title", "UrbanKicks - Login");
        return "login";
    }
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response)
    {
        // LOGOUT PROCESS
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        return "redirect:index";
    }

    @PostMapping("/processAddProduct")
    public String processAddProduct(@ModelAttribute("product")Product product)
    {   
        System.out.println(product);
        return "add-product";
    }
}
