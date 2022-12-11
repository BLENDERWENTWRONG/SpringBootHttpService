package com.example.demo.Service;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.FactureRepository;
import com.example.demo.entities.Facture;
import java.util.List;

@Service
public class FactureService{
	@Autowired
	private FactureRepository FactureRepository;
	@Transactional
	public List<Facture>findAllFact(){
		return FactureRepository.findAll();
		
	}
	
	@Transactional
	public void AddFacture(Facture fact) {
		
		FactureRepository.save(fact);

	}
	
	@Transactional
	public void DeleteFacture(long id) {
			
			FactureRepository.deleteById(id);
		}
	@Transactional
	public Facture updateFacture(long id,Facture fact) {
		Facture f=FactureRepository.findById(id).orElse(null);
		f.setDate(fact.getDate());
		f.setTotal_HT(fact.getTotal_HT());
		f.setTotal_TVA(fact.getTotal_TVA());
		f.setTotal_TTC(fact.getTotal_TTC());
		f.setFournisseur(fact.getFournisseur());
		return FactureRepository.save(f);
		}
}
	