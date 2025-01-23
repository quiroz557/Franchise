package com.example.franchise_project.repositories;

import com.example.franchise_project.models.BranchModel;
import com.example.franchise_project.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepository extends JpaRepository<BranchModel, Long> {
    @Query(value = "SELECT * FROM franchisedb.branch WHERE franchise_id = :franchiseId", nativeQuery = true)
    List<BranchModel> findByFranchiseId(@Param("franchiseId") Long franchiseId);
}
