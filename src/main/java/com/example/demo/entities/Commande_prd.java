package com.example.demo.entities;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "T_Commande")
public class Commande_prd {
	@Id
	private int QuantiteFourni;
	@Column(name = "DateFourni")
	private Date DateFourni;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_fournisseur", referencedColumnName = "id_fournisseur")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Fournisseur fou ;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_prd", referencedColumnName = "id_prd")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Produit_Pharm pr;
	
	public int getQuantiteFourni() {
		return QuantiteFourni;
	}

	public void setQuantiteFourni(int QuantiteFourni) {
		this.QuantiteFourni = QuantiteFourni;
	}
	
	public Date DateFourni() {
		return DateFourni;
	}

	public void setDateFourni(Date DateFourni) {
		this.DateFourni = DateFourni;
	}
	
	public Fournisseur getFounisseur() {
		return fou;
	}

	public void setFournisseur(Fournisseur fou) {
		this.fou = fou;
	}

	public Produit_Pharm getProduit_Pharm() {
		return pr;
	}

	public void setProduit_Pharm( Produit_Pharm pr) {
		this.pr = pr;
	}
	
	public Commande_prd() {
		super();
	}
	
	public Commande_prd(int QuantiteFourni, Date DateFourni, Fournisseur fou, Produit_Pharm pr) {
		super();
		this.QuantiteFourni=QuantiteFourni;
		this.DateFourni=DateFourni;
		this.fou=fou;
		this.pr=pr;
	}
}
