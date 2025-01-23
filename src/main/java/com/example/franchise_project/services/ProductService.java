package com.example.franchise_project.services;

import com.example.franchise_project.models.BranchModel;
import com.example.franchise_project.models.ProductModel;
import com.example.franchise_project.repositories.BranchRepository;
import com.example.franchise_project.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ProductService  {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BranchRepository branchRepository;

    BranchModel branch;
    ProductModel product;

    public ProductModel saveProduct(ProductModel product) {
        return productRepository.save(product);
    }

    public List<ProductModel> getAll() {
        return productRepository.findAll();
    }

    @Transactional
    public void deleteProduct(Long sucursalId, Long productoId) {
        // Verifica si la sucursal existe
        branch = branchRepository.findById(sucursalId)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));

        // Verifica si el producto pertenece a la sucursal
        product = productRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        if (!product.getBranch().equals(branch)) {
            throw new RuntimeException("Este producto no pertenece a la sucursal especificada");
        }

        // Elimina el producto
        productRepository.delete(product);
    }

    @Transactional
    public List<ProductModel> getStockProduct(Long franchiseId) {
        List<BranchModel> branches = branchRepository.findByFranchiseId(franchiseId);

        if (branches.isEmpty()) {
            // Si no se encuentran sucursales para el franchiseId, lanzamos una excepción
            throw new RuntimeException("No se encontraron sucursales para la franchiseId especificada");
        }

        // Aquí guardamos los productos de todas las sucursales
        List<ProductModel> allProducts = new ArrayList<>();

        // Iteramos sobre todas las sucursales encontradas y buscamos los productos
        for (BranchModel branch : branches) {
            List<ProductModel> products = productRepository.findBySucursalId(branch.getIdBranch());
            allProducts.addAll(products);  // Añadimos los productos de cada sucursal
        }

        // Si no se encontraron productos, lanzamos una excepción
        if (allProducts.isEmpty()) {
            throw new RuntimeException("No se encontraron productos para la franchiseId especificada");
        }

        return allProducts;
    }

    public ProductModel updateName(Long productId, String newName) {
        // Buscar el producto
        ProductModel product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // Actualizar el stock
        product.setName(newName);

        // Guardar el producto actualizado
        return productRepository.save(product);
    }

    public ProductModel updateStock(Long productId, Integer newStock) {
        // Buscar el producto
        ProductModel product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // Actualizar el stock
        product.setStock(newStock);

        // Guardar el producto actualizado
        return productRepository.save(product);
    }


}
