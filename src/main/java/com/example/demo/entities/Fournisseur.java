package com.example.demo.entities;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "T_Fournisseur")
public class Fournisseur implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_fournisseur;
	@Column(name = "Nom_fournisseur")
	private String Nom_fournisseur;
	@Column(name = "Adresse_fournisseur")
	private String Adresse_fournisseur;
	@Column(name = "Email_fournisseur")
	private String Email_fournisseur;
	@Column(name = "Tel_fournisseur")
	private int Tel_fournisseur;
	
	
	@ManyToMany(mappedBy = "fou", fetch = FetchType.LAZY)
    private Set<Produit_Pharm>  pr = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy="fou")
	private List<Commande_prd> cmd;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_util", referencedColumnName = "id_util")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Utilisateur util;
	
	@JsonIgnore
	@OneToMany(mappedBy="fou")
	private List<Facture> fact;
	
	

	


	public Long getid_fournisseur() {
		return id_fournisseur;
	}

	public void setid_fournisseur(Long id_fournisseur) {
		this.id_fournisseur = id_fournisseur;
	}

	public String getNom_fournisseur() {
		return Nom_fournisseur;
	}

	public void setNom_fournisseur(String Nom_fournisseur) {
		this.Nom_fournisseur = Nom_fournisseur;
	}

	public String getAdresse_fournisseur() {
		return Adresse_fournisseur;
	}

	public void setAdresse_fournisseur(String Adresse_fournisseur) {
		this.Adresse_fournisseur = Adresse_fournisseur;
	}

	public String getEmail_fournisseur() {
		return Email_fournisseur;
	}

	public void setEmail_fournisseur(String Email_fournisseur) {
		this.Email_fournisseur = Email_fournisseur;
	}

	public int getTel_fournisseur() {
		return Tel_fournisseur;
	}

	public void setTel_fournisseur(int Tel_fournisseur) {
		this.Tel_fournisseur = Tel_fournisseur;
	}

	

	
	public List<Facture> getFacture() {
		return fact;
	}
	public void setFacture(List<Facture> fact) {
		this.fact = fact;
	}
	
	public Utilisateur getUtilisateur() {
		return util;
	}

	public void setUtilisateur(Utilisateur util) {
		this.util =util;
	}
	
	public List<Commande_prd> getCommande_prd() {
		return cmd;
	}
	public void setCommande_prd(List<Commande_prd> cmd) {
		this.cmd = cmd;
	}

	public Fournisseur() {
		super();
	}
	
	
	

	public Fournisseur(Long id_fournisseur, String Nom_fournisseur, String Adresse_fournisseur, String Email_fournisseur, int Tel_fournisseur,
			Facture fact, Utilisateur util) {
		super();
		this.id_fournisseur = id_fournisseur;
		this.Nom_fournisseur = Nom_fournisseur;
		this.Adresse_fournisseur = Adresse_fournisseur;
		this.Email_fournisseur= Email_fournisseur;
		this.Tel_fournisseur = Tel_fournisseur;
	    this.util =util;
	}
	
	
}

