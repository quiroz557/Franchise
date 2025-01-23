package com.example.franchise_project.controllers;

import com.example.franchise_project.models.BranchModel;
import com.example.franchise_project.models.ProductModel;
import com.example.franchise_project.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping()
    public ProductModel saveProduct(@RequestBody ProductModel product) {
        return this.productService.saveProduct(product);
    }

    @GetMapping("/getAll")
    public List<ProductModel> getAll() {
        return this.productService.getAll();
    }

    @DeleteMapping("/delete/{productoId}/sucursales/{sucursalId}")
    public String deleteProduct(
            @PathVariable Long sucursalId,
            @PathVariable Long productoId) {

        // Llama al servicio para eliminar el producto
        this.productService.deleteProduct(sucursalId, productoId);

        return "Producto eliminado exitosamente";
    }

    @PutMapping("/{id}/stock")
    public ProductModel updateStock(@PathVariable Long id, @RequestParam Integer stock) {
        return productService.updateStock(id, stock);
    }

    @PutMapping("/{id}/name")
    public ProductModel updateName(@PathVariable Long id, @RequestParam String name) {
        return productService.updateName(id,name);
    }
}
