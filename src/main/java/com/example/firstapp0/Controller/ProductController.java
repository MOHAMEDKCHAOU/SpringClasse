package com.example.firstapp0.Controller;
import com.example.firstapp0.Entity.Product;
import com.example.firstapp0.Entity.Provider;
import com.example.firstapp0.Service.ProductService;
import com.example.firstapp0.Service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProviderService providerService;


    // 1. Display the form to add a new product
    @GetMapping("/addProduct")
    public String addProduct(Model model) {
        Product product = new Product();
        List<Provider> providers = providerService.getAllProviders();
        model.addAttribute("ProductForm", product);
        model.addAttribute("listeProvider", providers);
        return "new_product";
    }

    // 2. Save product
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("ProductForm") Product product) {
        productService.createProduct(product);
        return "redirect:/all";
    }

    // 3. Get all products
    @GetMapping("/all")
    public String getAllProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "product_list";  // product_list.html to show the list of products
    }

    // 4. Get product details by ID
    @GetMapping("/product/{id}")
    public String getProductById(@PathVariable int id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "product_detail";  // Display details in product_detail.html
    }

    // 5. Delete a product by ID
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);  // Call service to delete the product
        return "redirect:/all";  // Redirect to the list after deletion
    }

    // 6. Display form to update a product
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable int id, Model model) {
        Product product = productService.getProductById(id);  // Load the product to edit
        model.addAttribute("product", product);
        return "update_product";  // update_product.html to modify the product
    }

    // 7. Update product
    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable int id, @ModelAttribute("product") Product product) {
        productService.updateProduct(id, product);  // Update product in the service layer
        return "redirect:/all";  // Redirect to the list after update
    }
}
