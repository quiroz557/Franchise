package com.example.franchise_project.services;

import com.example.franchise_project.models.BranchModel;
import com.example.franchise_project.models.FranchiseModel;
import com.example.franchise_project.repositories.FranchiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FranchiseService {

    @Autowired
    private FranchiseRepository franchiseRepository;

    public FranchiseModel saveFranchise(FranchiseModel franchiseModel) {
        return franchiseRepository.save(franchiseModel);
    }

    public List<FranchiseModel> getAllFranchises() {
        return franchiseRepository.findAll();
    }

    public FranchiseModel updateName(Long productId, String newName) {
        // Buscar el producto
        FranchiseModel franchise = franchiseRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // Actualizar el stock
        franchise.setNombre(newName);

        // Guardar el producto actualizado
        return franchiseRepository.save(franchise);
    }
}
