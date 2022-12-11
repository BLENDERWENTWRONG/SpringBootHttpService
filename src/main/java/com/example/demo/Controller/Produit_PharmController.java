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

import com.example.demo.Service.Produit_PharmService;
import com.example.demo.entities.Produit_Pharm;



@RestController
@RequestMapping("/produits")
public class Produit_PharmController {

		@Autowired
		public Produit_PharmService prod;

		//lister les produits
		@GetMapping("/getAllProd")
		public List<Produit_Pharm> getAllProd(){
			return prod.findAllProd();		
		}
		
		
		//add un produit
		
		@PostMapping("/ajouterProduit")
		public String ajouterProduit( @RequestBody Produit_Pharm produ){
			prod.AddProduit_Pharm(produ);
			return "Produi ajouté";
		}

		@DeleteMapping("/sup/{id}")
		public void supprimerAddProduit_Pharm(@PathVariable int id){
			prod.DeleteProduit_Pharm(id);
			
		}
		@PutMapping("/modif/{id}")
		public Produit_Pharm modifierAddProduit_Pharm(@PathVariable int id,@RequestBody Produit_Pharm  produ){
			Produit_Pharm p=prod.updateProduit_Pharm(id,produ);
			return p;
		}	

}
