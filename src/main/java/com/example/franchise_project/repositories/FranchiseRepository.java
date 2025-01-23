package com.example.franchise_project.repositories;


import com.example.franchise_project.models.FranchiseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranchiseRepository extends JpaRepository<FranchiseModel, Long> {
}
