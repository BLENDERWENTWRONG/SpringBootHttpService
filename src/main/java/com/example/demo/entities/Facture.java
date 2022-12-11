package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "T_Facture")
public class Facture implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id_Fact_Achat;
	@Column(name = "Date")
	private Date Date;
	@Column(name = "Total_HT")
	private Double Total_HT;
	@Column(name = "Total_TVA")
	private Double Total_TVA;
	@Column(name = "Total_TTC")
	private Double Total_TTC;
	


	
	
	
	 @ManyToMany(mappedBy = "fact", fetch = FetchType.LAZY)
	    private Set<Produit_Pharm>  pr = new HashSet<>();
	
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_fournisseur", referencedColumnName = "id_fournisseur")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Fournisseur fou;
	


	public Long getId_Fact_Achat() {
		return Id_Fact_Achat;
	}

	public void setId_Fact_Achat(Long Id_Fact_Achat) {
		this.Id_Fact_Achat = Id_Fact_Achat;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date Date) {
		this.Date = Date;
	}

	public Double getTotal_HT() {
		return Total_HT;
	}

	public void setTotal_HT(Double Total_HT) {
		this.Total_HT= Total_HT;
	}

	public Double getTotal_TVA() {
		return Total_TVA;
	}

	public void setTotal_TVA(Double Total_TVA) {
		this.Total_TVA = Total_TVA;
	}

	public Double getTotal_TTC() {
		return Total_TTC;
	}

	public void setTotal_TTC(Double Total_TTC) {
		this.Total_TTC = Total_TTC;
	}

	
	public Fournisseur getFournisseur() {
		return fou;
	}

	public void setFournisseur(Fournisseur fou) {
		this.fou = fou;
	}

	public Facture() {
		super();
	}
	
	
	

	public Facture(Long Id_Fact_Achat, Date Date, Double Total_HT, Double Total_TVA, Double Total_TTC,
			Fournisseur fou) {
		super();
		this.Id_Fact_Achat = Id_Fact_Achat;
		this.Date = Date;
		this.Total_HT = Total_HT;
		this.Total_TVA = Total_TVA;
		this.Total_TTC = Total_TTC;
		this.fou = fou;
		
	}
	
	
}
