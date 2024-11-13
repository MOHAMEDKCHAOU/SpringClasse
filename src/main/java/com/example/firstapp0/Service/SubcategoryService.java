package com.example.firstapp0.Service;

import com.example.firstapp0.Entity.Subcategory;
import com.example.firstapp0.Repository.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubcategoryService {

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    public List<Subcategory> getAllSubcategories() {
        return subcategoryRepository.findAll();
    }

    public Subcategory getSubcategoryById(int id) {
        return subcategoryRepository.findById(id).orElse(null);
    }

    public Subcategory createSubcategory(Subcategory subcategory) {
        return subcategoryRepository.save(subcategory);
    }

    public Subcategory updateSubcategory(int id, Subcategory subcategory) {
        subcategory.setId(id);
        return subcategoryRepository.save(subcategory);
    }

    public void deleteSubcategory(int id) {
        subcategoryRepository.deleteById(id);
    }
}
