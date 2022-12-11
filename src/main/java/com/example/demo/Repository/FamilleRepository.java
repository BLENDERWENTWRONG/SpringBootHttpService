package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Famille;

public interface FamilleRepository extends JpaRepository<Famille,Long>{

}
