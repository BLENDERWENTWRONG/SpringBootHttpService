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
@Table(name = "T_Famille")
public class Famille implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id_Famille;
	@Column(name = "Lib_Famille", length = 30)
	private String Lib_Famille;
	@JsonIgnore
	@OneToMany(mappedBy="fam")
	private List<Produit_Pharm> pr;
	public Long getId_Famille() {
		return Id_Famille;
	}
	public void setId_Famille(Long Id_Famille) {
		this.Id_Famille = Id_Famille;
	}
	public String getLib_Famille() {
		return Lib_Famille;
	}
	public void setLib_Famille(String Lib_Famille) {
		this.Lib_Famille = Lib_Famille;
	}
	public List<Produit_Pharm> getProduit_Pharm() {
		return pr;
	}
	public void setProduit_Pharm(List<Produit_Pharm> pr) {
		this.pr = pr;
	}
	public Famille(Long Id_Famille, String Lib_Famille) {
		super();
		this.Id_Famille = Id_Famille;
		this.Lib_Famille = Lib_Famille;
	}
	public Famille() {
		super();
	}
	
}
