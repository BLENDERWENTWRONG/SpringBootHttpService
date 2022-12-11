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

import com.example.demo.Service.UtilisateurService;
import com.example.demo.entities.Utilisateur;



@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

		@Autowired
		public UtilisateurService util;

		//lister les utilisateurs
		@GetMapping("/getAllUtil")
		public List<Utilisateur> getAllUtil(){
			return util.findAllUtil();		
		}
		
		
		//add un utilisateur
		
		@PostMapping("/ajouterUtilisateur")
		public String ajouterUtilisateur( @RequestBody Utilisateur utili){
			util.AddUtilisateur(utili);
			return "Utilisateur ajouté";
		}

		@DeleteMapping("/sup/{id}")
		public void supprimerUtilisateur(@PathVariable int id){
			util.DeleteUtilisateur(id);
			
		}
		@PutMapping("/modif/{id}")
		public Utilisateur modifierUtilisateur(@PathVariable int id,@RequestBody Utilisateur  utili){
			Utilisateur u=util.updateUtilisateur(id,utili);
			return u;
		}	

}
