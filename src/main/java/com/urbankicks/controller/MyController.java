package com.urbankicks.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.urbankicks.config.UserDetailsImpl;
import com.urbankicks.entities.Brand;
import com.urbankicks.entities.Cart;
import com.urbankicks.entities.Category;
import com.urbankicks.entities.Orders;
import com.urbankicks.entities.Product;
import com.urbankicks.entities.User;
import com.urbankicks.service.BrandService;
import com.urbankicks.service.CartService;
import com.urbankicks.service.CategoryService;
import com.urbankicks.service.OrdersService;
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

    @Autowired
    OrdersService ordersService;

    @Autowired
    private CartService cartService;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("title", "UrbanKicks - First Choice");

        return "index";
    }

    @GetMapping("/cart")
    public String cart(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        int user_id = userDetails.getId();

        model.addAttribute("title", "Cart");

        Cart cart = cartService.getCartByUser(user_id);
        model.addAttribute("products", cart.getProducts());

        model.addAttribute("total", cartService.getTotal(cart.getProducts()));

        return "cart";
    }

    @GetMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute("title", "Checkout");

        return "checkout";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("title", "Contact");

        return "contact";
    }

    @GetMapping("/shop")
    public String shop(Model model, Product product) {
        model.addAttribute("title", "Shop");

        List<Product> products = productService.findAllProducts();

        model.addAttribute("products", products);

        return "shop";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("title", "SignUp");
        model.addAttribute("user", new User());

        return "signup";
    }

    // Cart will also created for the user who signed up
    @PostMapping("/signupSubmit")
    public String signupSubmit(@ModelAttribute User user) {
        user.setPassword(userService.encode(user.getPassword()));
        User savedUser = userService.save(user);

        Cart cart = new Cart();
        cart.setUser_id(savedUser);
        List<Product> products = new ArrayList<>();
        cart.setProducts(products);

        cartService.addCart(cart);

        return "signup";
    }

    @RequestMapping("/add-product")
    public String addProduct(Model model) {
        model.addAttribute("title", "UrbanKicks - Add Products");
        model.addAttribute("brands", brandService.findAllBrands());
        model.addAttribute("categories", categoryService.findAllCategories());
        model.addAttribute("product", new Product());

        return "add-product";
    }

    @RequestMapping("/login")
    public String login(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("title", "UrbanKicks - Login");
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        // LOGOUT PROCESS
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        return "redirect:index";
    }

    @PostMapping("/processAddProduct")
    public String processAddProduct(@RequestParam("prod_name") String prod_name,
            @RequestParam("description") String description,
            @RequestParam("category") String category,
            @RequestParam("brand") String brand,
            @RequestParam("size") String size,
            @RequestParam("gender") String gender,
            @RequestParam("quantity") String quantiy,
            @RequestParam("price") String price,
            @RequestParam("img1") MultipartFile img1,
            @RequestParam("img2") MultipartFile img2,
            @RequestParam("img3") MultipartFile img3) throws IOException {
        Product product = new Product();
        product.setProd_name(prod_name);
        product.setDescription(description);
        product.setBrand(new Brand(brand));
        product.setCategory(new Category(category));
        product.setSize(Integer.parseInt(size));
        product.setGender(gender);
        product.setQuantity(Integer.parseInt(quantiy));
        product.setPrice(Double.parseDouble(price));
        product.setImg1(Base64.getEncoder().encodeToString(img1.getBytes()));
        product.setImg2(Base64.getEncoder().encodeToString(img2.getBytes()));
        product.setImg3(Base64.getEncoder().encodeToString(img3.getBytes()));

        productService.addProduct(product); // Image will not insert directly through phpmyadmin

        return "redirect:/add-product";
    }

    @RequestMapping("/productDetail")
    public String productDetail(@RequestParam("id") int prod_id, Model model) throws IOException {
        Product product = productService.findById(prod_id);
        model.addAttribute("product", product);
        model.addAttribute("title", "Detail");

        return "detail";
    }

    @RequestMapping("/processAddToCart")
    public String processAddToCart(@RequestParam("prod_id") int prod_id, @RequestParam("size") String size,
            @RequestParam("quantity") String quantity, Model model,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        Product product = productService.findById(prod_id);
        product.setSize(Integer.parseInt(size));
        product.setQuantity(Integer.parseInt(quantity));

        try {
            Cart cart = cartService.getCartByUser(userDetails.getId());

            List<Product> products = cartService.getCartProductsByuser(userDetails.getId());
            products.add(product);
            cart.setProducts(products);

            cartService.addCart(cart);

        } catch (NullPointerException e) {
            return "redirect:/cart";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/login";
        }

        return "redirect:/cart";
    }

    @RequestMapping("/removeFromCart")
    public String removeFromCart(@RequestParam("prod_id") int prod_id,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        Cart cart = cartService.getCartByUser(userDetails.getId());
        List<Product> products = cartService.getCartProductsByuser(userDetails.getId());

        Product product = productService.findById(prod_id);

        products.remove(product);
        cart.setProducts(products);

        cartService.addCart(cart);

        return "redirect:/cart";
    }

    @RequestMapping("/processCheckout")
    public String processCheckout(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model) {
        User user = userDetails.getUser();

        model.addAttribute("user", user);

        // List<CartItem> cartItems = cartItemService.getCartItemsByUser(user.getUser_id());
        // model.addAttribute("cartItems", cartItems);

        // long subtotal = cartItemService.getSubtotal(cartItems);
        // model.addAttribute("subtotal", subtotal);

        Cart cart = cartService.getCartByUser(userDetails.getId());
        model.addAttribute("cartItems", cart.getProducts());

        model.addAttribute("total", cartService.getTotal(cart.getProducts()));

        return "checkout";
    }

    @RequestMapping("/processPlaceOrder")
    public String placeOrder(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model) {

        // List<CartItem> cartItems = cartItemService.getCartItemsByUser(user.getUser_id());
        // List<Product> products = new ArrayList<>();

        // for (CartItem cartItem : cartItems) {
        //     Product product = (Product) productService.findById(cartItem.getProduct().getProd_id());
        //     product.setQuantity(cartItem.getProduct().getQuantity());
        //     product.setSize(cartItem.getProduct().getSize());
        //     products.add(product);
        // }

        Cart cart = cartService.getCartByUser(userDetails.getId());

        double total = cartService.getTotal(cartService.getCartProductsByuser(userDetails.getId()));

        Orders orders = new Orders();
        orders.setUser(userDetails.getUser());
        orders.setProducts(cartService.getCartProductsByuser(userDetails.getId()));
        orders.setTotal(total);


        ordersService.placeOrder(orders);

        System.out.println("ORDER PLACED SUCCESSFULLY!");
        return "redirect:/index";
    }

}
