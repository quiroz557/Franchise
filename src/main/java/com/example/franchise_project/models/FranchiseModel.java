package com.example.franchise_project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "franchise")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FranchiseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false,name = "franchise_id")
    private Long idFranchise;
    private String nombre;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "franchise",cascade = CascadeType.ALL)
    private List<BranchModel> listBranch;
}
