package com.example.franchise_project.repositories;

import com.example.franchise_project.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {
    @Query(value = "SELECT * FROM franchisedb.product WHERE branch_id = :sucursalId", nativeQuery = true)
    List<ProductModel> findBySucursalId(@Param("sucursalId") Long sucursalId);
}

