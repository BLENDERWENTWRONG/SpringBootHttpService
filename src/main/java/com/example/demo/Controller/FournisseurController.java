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

import com.example.demo.Service.FournisseurService;
import com.example.demo.entities.Fournisseur;



@RestController
@RequestMapping("/fournisseurs")
public class FournisseurController {

		@Autowired
		public FournisseurService fou;

		//lister les Fournisseur
		@GetMapping("/getAllFou")
		public List<Fournisseur> getAllFou(){
			return fou.findAllFou();		
		}
		
		//add un Fournisseur
				@PostMapping("/ajouterFou")
				public String ajouterFou( @RequestBody Fournisseur four){
					fou.AddFournisseur(four);
					return "Fournisseur ajouté";
				}
	
				@DeleteMapping("/sup/{id}")
				public void supprimerFou(@PathVariable int id){
					fou.DeleteFournisseur(id);
				}
				@PutMapping("/modif/{id}")
				public Fournisseur modifierFou(@PathVariable int id,@RequestBody Fournisseur four){
					Fournisseur f=fou.updateFournisseur(id,four);
					return f;
				}	

	
}