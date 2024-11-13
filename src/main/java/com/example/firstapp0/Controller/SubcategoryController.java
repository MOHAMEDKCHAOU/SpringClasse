package com.example.firstapp0.Controller;

import com.example.firstapp0.Entity.Subcategory;
import com.example.firstapp0.Service.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subcategories")
public class SubcategoryController {

    @Autowired
    private SubcategoryService subcategoryService;

    @GetMapping
    public List<Subcategory> getAllSubcategories() {
        return subcategoryService.getAllSubcategories();
    }

    @GetMapping("/{id}")
    public Subcategory getSubcategoryById(@PathVariable int id) {
        return subcategoryService.getSubcategoryById(id);
    }

    @PostMapping
    public Subcategory createSubcategory(@RequestBody Subcategory subcategory) {
        return subcategoryService.createSubcategory(subcategory);
    }

    @PutMapping("/{id}")
    public Subcategory updateSubcategory(@PathVariable int id, @RequestBody Subcategory subcategory) {
        return subcategoryService.updateSubcategory(id, subcategory);
    }

    @DeleteMapping("/{id}")
    public void deleteSubcategory(@PathVariable int id) {
        subcategoryService.deleteSubcategory(id);
    }
}
