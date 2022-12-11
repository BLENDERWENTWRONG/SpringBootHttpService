package com.example.demo.Service;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.Produit_PharmRepository;
import com.example.demo.entities.Produit_Pharm;
import java.util.List;

@Service
public class Produit_PharmService{
	@Autowired
	private Produit_PharmRepository Produit_PharmRepository;
	@Transactional
	public List<Produit_Pharm>findAllProd(){
		return Produit_PharmRepository.findAll();
		
	}
	
	@Transactional
	public void AddProduit_Pharm(Produit_Pharm prod) {
		
		Produit_PharmRepository.save(prod);

	}
	
	@Transactional
	public void DeleteProduit_Pharm(long id) {
			
		Produit_PharmRepository.deleteById(id);
		}
	@Transactional
	public Produit_Pharm updateProduit_Pharm(long id,Produit_Pharm prod) {
		Produit_Pharm p=Produit_PharmRepository.findById(id).orElse(null);
		p.setLib_prd(prod.getLib_prd());
		p.setDescription_prd(prod.getDescription_prd());
		p.setPrix_prd(prod.getPrix_prd());
		p.setDateAjout_prd(prod.getDateAjout_prd());
		p.setPrix_Livr(prod.getPrix_Livr());
		p.setLaboratoire(prod.getLaboratoire());
		p.setFamille(prod.getFamille());
		
		return Produit_PharmRepository.save(p);
		}
}
	