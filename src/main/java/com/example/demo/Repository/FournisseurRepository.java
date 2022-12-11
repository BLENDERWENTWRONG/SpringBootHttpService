package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Fournisseur;

public interface FournisseurRepository extends JpaRepository<Fournisseur,Long>{

}
