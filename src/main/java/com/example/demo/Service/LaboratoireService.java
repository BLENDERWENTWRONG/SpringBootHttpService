package com.example.demo.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.LaboratoireRepository;
import com.example.demo.entities.Laboratoire;

import java.util.List;

@Service
public class LaboratoireService{
	@Autowired
	private LaboratoireRepository laboratoireRepository;
	@Transactional
	public List<Laboratoire>findAllLabo(){
		return laboratoireRepository.findAll();
	}
	
	@Transactional
	public void AddLaboratoire(Laboratoire labo) {
		
		laboratoireRepository.save(labo);

	}
	
	@Transactional
	public void DeleteLaboratoire(long id) {
			
			laboratoireRepository.deleteById(id);
		}
	@Transactional
	public Laboratoire updateLaboratoire(long id,Laboratoire labo) {
		Laboratoire l=laboratoireRepository.findById(id).orElse(null);
		l.setLib_labo(labo.getLib_labo());
		return laboratoireRepository.save(l);
		}
	

}
