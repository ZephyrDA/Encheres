package bo;

import java.io.Serializable;


/**
 * Classe Categorie
 * @author Elian
 *
 */
public class Categorie implements Serializable {


	private static final long serialVersionUID = 1L;
	private int no_categorie;
	private String libelle;
	
	/**
	 * Constructeur de la classe Categorie
	 */
	public Categorie() {
		super();
	}
	
	/**
	 * Constructeur de la classe Categorie
	 * @param no_categorie
	 * @param libelle
	 */
	public Categorie(int no_categorie, String libelle) {
		super();
		this.no_categorie = no_categorie;
		this.libelle = libelle;
	}
	public int getNo_categorie() {
		return no_categorie;
	}
	public void setNo_categorie(int no_categorie) {
		this.no_categorie = no_categorie;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	@Override
	public String toString() {
		return "Categorie [no_categorie=" + no_categorie + ", libelle=" + libelle + "]";
	}
	
}
