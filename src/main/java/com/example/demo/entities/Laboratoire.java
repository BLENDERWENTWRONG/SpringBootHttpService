package com.example.demo.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "T_Laboratoire")
public class Laboratoire implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id_labo;
	@Column(name = "Lib_labo", length = 30)
	private String Lib_labo;
	@JsonIgnore
	@OneToMany(mappedBy="labo")
	private List<Produit_Pharm> pr;
	public Long getId_Labo() {
		return Id_labo;
	}
	public void setId_Labo(Long Id_Labo) {
		this.Id_labo = Id_Labo;
	}
	public String getLib_labo() {
		return Lib_labo;
	}
	public void setLib_labo(String Lib_labo) {
		this.Lib_labo = Lib_labo;
	}
	/*public List<Produit_Pharm> getProduit_Pharm() {
		return pr;
	}
	public void setProduit_Pharm(List<Produit_Pharm> pr) {
		this.pr = pr;
	}*/
	public Laboratoire(Long Id_labo, String Lib_labo) {
		super();
		this.Id_labo = Id_labo;
		this.Lib_labo = Lib_labo;
	}
	public Laboratoire() {
		super();
	}
	
}
