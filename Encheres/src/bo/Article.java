package bo;

import java.io.Serializable;

public class Article implements Serializable {

	private static final long serialVersionUID = 2L;
	private int identifiant;
	private String nom;
	private int leRepas;
	
	public int getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	public String getNom() {
		return this.nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getLeRepas() {
		return this.leRepas;
	}
	
	public void setLeRepas(int leRepas) {
		this.leRepas = leRepas;
	}
	
	public Article() {
		super();
	}
	public Article(String nom, int leRepas) {
		this();
		this.nom = nom;
		this.leRepas = leRepas;
	}
	public Article(int identifiant, String nom, int leRepas) {
		this(nom,leRepas);
		this.identifiant = identifiant;
	}
	@Override
	public String toString() {
		return "Repas [identifiant=" + identifiant + ", nom=" + nom.toString() + ", leRepas=" + leRepas + "]";
	}
}
