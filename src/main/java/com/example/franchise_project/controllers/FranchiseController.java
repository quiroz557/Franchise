package com.example.franchise_project.controllers;

import com.example.franchise_project.models.FranchiseModel;

import com.example.franchise_project.models.ProductModel;
import com.example.franchise_project.services.FranchiseService;
import com.example.franchise_project.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/franchise")
public class FranchiseController {
    @Autowired
    private FranchiseService franchiseService;

    @Autowired
    private ProductService productService;

    @PostMapping()
    public FranchiseModel saveFranchise(@RequestBody FranchiseModel franchiseModel) {
        return franchiseService.saveFranchise(franchiseModel);
    }

    @GetMapping("/getAll")
    public List<FranchiseModel> getAllFranchises() {
        return franchiseService.getAllFranchises();
    }

    @GetMapping("/{franchiseId}/max-stock-products")
    public List<ProductModel> getMaxStockProducts(@PathVariable Long franchiseId) {
        return productService.getStockProduct(franchiseId);
    }

    @PutMapping("/{id}/name")
    public FranchiseModel updateName(@PathVariable Long id, @RequestParam String name) {
        return franchiseService.updateName(id,name);
    }
}