package com.example.franchise_project.services;

import com.example.franchise_project.models.BranchModel;
import com.example.franchise_project.models.FranchiseModel;
import com.example.franchise_project.models.ProductModel;
import com.example.franchise_project.repositories.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService {

    @Autowired
    private BranchRepository branchRepository;

    public List<BranchModel> getAllBranches() {
        return branchRepository.findAll();
    }

    public BranchModel updateName(Long productId, String newName) {
        // Buscar el producto
        BranchModel branch = branchRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // Actualizar el stock
        branch.setName(newName);

        // Guardar el producto actualizado
        return branchRepository.save(branch);
    }
}
