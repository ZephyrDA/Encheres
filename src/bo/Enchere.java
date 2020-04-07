package bo;

import java.io.Serializable;
import java.sql.Date;

/**
 * Classe Enchere
 * @author Elian
 *
 */
public class Enchere implements Serializable {

	private static final long serialVersionUID = 1L;
	private Date dateEnchere;
	private int montantEnchere;
	private Utilisateur utilisateur;
	
	/**
	 * Constructeur de la classe Encheres
	 */
	public Enchere() {
		super();
	}
	
	/**
	 * Constructeur de la classe Encheres
	 * @param dateEnchere
	 * @param montantEnchere
	 * @param utilisateur
	 */
	public Enchere(Date dateEnchere, int montantEnchere, Utilisateur utilisateur) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.utilisateur = utilisateur;
	}

	public Date getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(Date dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public int getMontantEnchere() {
		return montantEnchere;
	}

	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}



	@Override
	public String toString() {
		return "Enchere [dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere + ", utilisateur="
				+ utilisateur + "]";
	}
	
	
	
}
