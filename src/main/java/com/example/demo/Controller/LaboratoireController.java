package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.LaboratoireService;
import com.example.demo.entities.Laboratoire;



@RestController
@RequestMapping("/laboratoires")
public class LaboratoireController {

		@Autowired
		public LaboratoireService lab;

		//lister les laboratoires
		@GetMapping("/getAllLabo")
		public List<Laboratoire> getAllLabo(){
			return lab.findAllLabo();		
		}
		
		//add un laboratoire
				@PostMapping("/ajouterLabo")
				public String ajouterLabo( @RequestBody Laboratoire labo){
					lab.AddLaboratoire(labo);
					return "labo ajouté";
				}
	
				@DeleteMapping("/sup/{id}")
				public void supprimerLabo(@PathVariable int id){
					lab.DeleteLaboratoire(id);
				}
				@PutMapping("/modif/{id}")
				public Laboratoire modifierLabo(@PathVariable int id,@RequestBody Laboratoire labo){
					Laboratoire l=lab.updateLaboratoire(id,labo);
					return l;
				}	

	
}