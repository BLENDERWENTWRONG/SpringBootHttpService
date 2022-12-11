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

import com.example.demo.Service.FactureService;
import com.example.demo.entities.Facture;


@RestController
@RequestMapping("/Factures")
public class FactureController {

		@Autowired
		public FactureService fact;

		//lister les factures
		@GetMapping("/getAllFact")
		public List<Facture> getAllFact(){
			return fact.findAllFact();		
		}
		
		//add une Facture
				@PostMapping("/ajouterFact")
				public String ajouterFact( @RequestBody Facture factu){
					fact.AddFacture(factu);
					return "Facture ajoutée";
				}
	
				@DeleteMapping("/sup/{id}")
				public void supprimerFact(@PathVariable int id){
					fact.DeleteFacture(id);
				}
				@PutMapping("/modif/{id}")
				public Facture modifierFact(@PathVariable int id,@RequestBody Facture factu){
					Facture f=fact.updateFacture(id,factu);
					return f;
				}	

	
}