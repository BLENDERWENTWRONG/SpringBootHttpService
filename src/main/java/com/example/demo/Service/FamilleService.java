package com.example.demo.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.FamilleRepository;
import com.example.demo.entities.Famille;

import java.util.List;

@Service
public class FamilleService{
	@Autowired
	private FamilleRepository familleRepository;
	@Transactional
	public List<Famille>findAllfam(){
		return familleRepository.findAll();
	}
	
	@Transactional
	public void AddFamille(Famille fami) {
		
		familleRepository.save(fami);

	}
	
	@Transactional
	public void DeleteFamille(long id) {
			
			familleRepository.deleteById(id);
		}
	@Transactional
	public Famille updateFamille(long id,Famille fami) {
		Famille f=familleRepository.findById(id).orElse(null);
		f.setLib_Famille(fami.getLib_Famille());
		return familleRepository.save(f);
		}
	

}
