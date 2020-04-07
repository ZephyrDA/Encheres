package bo;

import java.io.Serializable;
import java.sql.Date;

public class Enchere implements Serializable {

	private static final long serialVersionUID = 1L;
	private Date dateEnchere;
	private int montantEnchere;
	private Utilisateur acheteur;
	
	public Enchere() {
		super();
	}

	public Enchere(Date dateEnchere, int montantEnchere, Utilisateur acheteur) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.acheteur = acheteur;
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

	public Utilisateur getAcheteur() {
		return acheteur;
	}

	public void setUtilisateur(Utilisateur acheteur) {
		this.acheteur = acheteur;
	}



	@Override
	public String toString() {
		return "Enchere [dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere + ", utilisateur="
				+ acheteur + "]";
	}
	
	
	
}
