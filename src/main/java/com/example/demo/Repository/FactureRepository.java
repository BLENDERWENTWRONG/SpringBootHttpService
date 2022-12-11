package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Facture;

public interface FactureRepository extends JpaRepository<Facture,Long>{

}
