package com.example.franchise_project.controllers;

import com.example.franchise_project.models.BranchModel;

import com.example.franchise_project.models.ProductModel;
import com.example.franchise_project.services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branch")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @GetMapping("/getAll")
    public List<BranchModel> getAllFranchises() {
        return branchService.getAllBranches();
    }

    @PutMapping("/{id}/name")
    public BranchModel updateName(@PathVariable Long id, @RequestParam String name) {
        return branchService.updateName(id,name);
    }
}
