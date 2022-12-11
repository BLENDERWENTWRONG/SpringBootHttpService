package com.example.demo.Service;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.UtilisateurRepository;
import com.example.demo.entities.Utilisateur;
import java.util.List;

@Service
public class UtilisateurService{
	@Autowired
	private UtilisateurRepository UtilisateurRepository;
	@Transactional
	public List<Utilisateur>findAllUtil(){
		return UtilisateurRepository.findAll();
		
	}
	
	@Transactional
	public void AddUtilisateur(Utilisateur util) {
		
		UtilisateurRepository.save(util);

	}
	
	@Transactional
	public void DeleteUtilisateur(long id) {
			
			UtilisateurRepository.deleteById(id);
		}
	@Transactional
	public Utilisateur updateUtilisateur(long id,Utilisateur util) {
		Utilisateur u=UtilisateurRepository.findById(id).orElse(null);
		u.setNom_util(util.getNom_util());
		u.setPrenom_util(util.getPrenom_util());
		u.setAddresse_util(util.getAddresse_util());
		u.setEmail_util(util.getEmail_util());
		u.setCodePostal_util(util.getCodePostal_util());
		u.setDateNaissance_util(util.getDateNaissance_util());
		return UtilisateurRepository.save(u);
		}
}
	