package com.example.demo.Service;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.FournisseurRepository;
import com.example.demo.entities.Fournisseur;
import java.util.List;

@Service
public class FournisseurService{
	@Autowired
	private FournisseurRepository FournisseurRepository;
	@Transactional
	public List<Fournisseur>findAllFou(){
		return FournisseurRepository.findAll();
		
	}
	
	@Transactional
	public void AddFournisseur(Fournisseur fou) {
		
		FournisseurRepository.save(fou);

	}
	
	@Transactional
	public void DeleteFournisseur(long id) {
			
		FournisseurRepository.deleteById(id);
		}
	@Transactional
	public Fournisseur updateFournisseur(long id,Fournisseur fou) {
		Fournisseur f=FournisseurRepository.findById(id).orElse(null);
		f.setNom_fournisseur(fou.getNom_fournisseur());
		f.setAdresse_fournisseur(fou.getAdresse_fournisseur());
		f.setEmail_fournisseur(fou.getEmail_fournisseur());
		f.setAdresse_fournisseur(fou.getAdresse_fournisseur());
		f.setTel_fournisseur(fou.getTel_fournisseur());
		f.setUtilisateur(fou.getUtilisateur());
		return FournisseurRepository.save(f);
		}
}
	