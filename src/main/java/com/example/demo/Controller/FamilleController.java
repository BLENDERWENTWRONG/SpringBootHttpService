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

import com.example.demo.Service.FamilleService;
import com.example.demo.entities.Famille;



@RestController
@RequestMapping("/familles")
public class FamilleController {

		@Autowired
		public FamilleService fam;

		//lister les familles
		@GetMapping("/ListerFamille")
		public List<Famille> ListerFamille(){
			return fam.findAllfam();		
		}
		
		//add une famille
				@PostMapping("/ajouterFam")
				public String ajouterFam( @RequestBody Famille fami ){
					fam.AddFamille(fami);
					return "famille ajoutée";
				}
	
				@DeleteMapping("/sup/{id}")
				public void supprimerFamille(@PathVariable int id){
					fam.DeleteFamille(id);
				}
				@PutMapping("/modif/{id}")
				public Famille modifierFamille(@PathVariable int id,@RequestBody Famille fami){
					Famille f=fam.updateFamille(id,fami);
					return f;
				}	

	
}