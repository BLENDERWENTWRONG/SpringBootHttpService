package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "T_Produit_Pharm")
public class Produit_Pharm implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_prd;
	@Column(name = "Lib_prd")
	private String Lib_prd;
	@Column(name = "Description_prd")
	private String Description_prd;
	@Column(name = "Prix_prd")
	private Double Prix_prd;
	@Column(name = "DateAjout_prd")
	private Date DateAjout_prd;
	@Column(name = "Prix_Livr")
	private Float Prix_Livr;
	
	@JsonIgnore
	@OneToMany(mappedBy="pr")
	private List<Commande_prd> cmd;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "Id_labo", referencedColumnName = "Id_labo")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Laboratoire labo;
	
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "Id_famille", referencedColumnName = "Id_famille")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Famille fam;
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "Produit_Facture",
            joinColumns = {
                    @JoinColumn(name = "id_prd", referencedColumnName = "id_prd",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "Id_Fact_Achat", referencedColumnName = "Id_Fact_Achat",
                            nullable = false, updatable = false)})
    private Set<Facture> fact = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "Produit_Fournisseur",
            joinColumns = {
                    @JoinColumn(name = "id_prd", referencedColumnName = "id_prd",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "id_fournisseur", referencedColumnName = "id_fournisseur",
                            nullable = false, updatable = false)})
    private Set<Fournisseur> fou = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "Produit_Utilisateur",
            joinColumns = {
                    @JoinColumn(name = "id_prd", referencedColumnName = "id_prd",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "id_util", referencedColumnName = "id_util",
                            nullable = false, updatable = false)})
    private Set<Utilisateur> util = new HashSet<>();



	public Long getId_prd() {
		return id_prd;
	}

	public void setId_prd(Long id_prd) {
		this.id_prd = id_prd;
	}

	public String getLib_prd() {
		return Lib_prd;
	}

	public void setLib_prd(String Lib_prd) {
		this.Lib_prd = Lib_prd;
	}

	public String getDescription_prd() {
		return Description_prd;
	}

	public void setDescription_prd(String Description_prd) {
		this.Description_prd = Description_prd;
	}

	public Double getPrix_prd() {
		return Prix_prd;
	}

	public void setPrix_prd(Double Prix_prd) {
		this.Prix_prd = Prix_prd;
	}

	public Date getDateAjout_prd() {
		return DateAjout_prd;
	}

	public void setDateAjout_prd(Date DateAjout_prd) {
		this.DateAjout_prd = DateAjout_prd;
	}

	public float getPrix_Livr() {
		return Prix_Livr;
	}

	public void setPrix_Livr(float Prix_Livr) {
		this.Prix_Livr = Prix_Livr;
	}

	public Famille getFamille() {
		return fam;
	}

	public void setFamille(Famille fam) {
		this.fam = fam;
	}
	
	public Laboratoire getLaboratoire() {
		return labo;
	}

	public void setLaboratoire(Laboratoire labo) {
		this.labo = labo;
	}

	public List<Commande_prd> getCommande_prd() {
		return cmd;
	}
	public void setCommande_prd(List<Commande_prd> cmd) {
		this.cmd = cmd;
	}
	public Produit_Pharm() {
		super();
	}
	
	
	

	public Produit_Pharm(Long id_prd, String Lib_prd, String Description_prd, Double Prix_prd, Date DateAjout_prd, float Prix_Livr,
			Laboratoire labo, Famille fam) {
		super();
		this.id_prd = id_prd;
		this.Lib_prd = Lib_prd;
		this.Description_prd = Description_prd;
		this.Prix_prd = Prix_prd;
		this.DateAjout_prd = DateAjout_prd;
		this.Prix_Livr = Prix_Livr;
		this.labo = labo;
		this.fam=fam;
	}
	
	
}
