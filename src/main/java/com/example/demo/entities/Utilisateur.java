package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "T_Utilisateur")
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_util;
	@Column(name = "Nom_util", length = 30)
	private String Nom_util;
	@Column(name = "Prenom_util", length = 30)
	private String Prenom_util;
	@Column(name = "Addresse_util", length = 30)
	private String Addresse_util;
	@Column(name = "Email_util", length = 30)
	private String Email_util;
	@Column(name = "CodePostal_util")
	private int CodePostal_util;
	@Column(name = "DateNaissance_util", length = 30)
	private Date DateNaissance_util;
	@JsonIgnore
	@OneToMany(mappedBy="util")
	private List<Fournisseur> fou;
	
	@ManyToMany(mappedBy = "util", fetch = FetchType.LAZY)
    private Set<Produit_Pharm>  pr = new HashSet<>();
	
	public Long getid_util() {
		return id_util;
	}
	public void setid_util(Long id_util) {
		this.id_util = id_util;
	}
	public String getNom_util() {
		return Nom_util;
	}
	public void setNom_util(String Nom_util) {
		this.Nom_util = Nom_util;
	}
	public String getPrenom_util() {
		return Prenom_util;
	}
	public void setPrenom_util(String  Prenom_util) {
		this. Prenom_util =  Prenom_util;
	}
	
	public String getAddresse_util() {
		return Addresse_util;
	}
	public void setAddresse_util(String  Addresse_util) {
		this.Addresse_util =  Addresse_util;
	}
	public String getEmail_util() {
		return Email_util;
	}
	public void setEmail_util(String  Email_util) {
		this.Email_util =  Email_util;
	}
	
	public int getCodePostal_util() {
		return CodePostal_util;
	}
	public void setCodePostal_util(int  CodePostal_util) {
		this.CodePostal_util =  CodePostal_util;
	}
	public Date getDateNaissance_util() {
		return DateNaissance_util;
	}
	public void setDateNaissance_util(Date  DateNaissance_util) {
		this.DateNaissance_util =  DateNaissance_util;
	}
	public List<Fournisseur> getFournisseur() {
		return fou;
	}
	public void setFournisseur(List<Fournisseur> fou) {
		this.fou = fou;
	}
	public Utilisateur(Long id_util, String Nom_util, String Prenom_util,String Addresse_util,String Email_util, 	int CodePostal_util,Date DateNaissance_util) {
		super();
		this.id_util = id_util;
		this.Nom_util = Nom_util;
		this.Prenom_util = Prenom_util;
		this.Addresse_util = Addresse_util;
		this.Email_util = Email_util;
		this.CodePostal_util = CodePostal_util;
		this.DateNaissance_util = DateNaissance_util;
	}
	public Utilisateur() {
		super();
	}
	
}
