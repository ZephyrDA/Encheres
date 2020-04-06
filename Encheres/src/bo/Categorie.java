package bo;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.sql.Date;


public class Categorie implements Serializable {

	private static final long serialVersionUID = 1L;
	private int identifiant;
	private Date dateRepas;
	private Time heureRepas;
	private ArrayList<Utilisateur> lesAliments;
	
	public int getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	public Date getDateRepas() {
		return this.dateRepas;
	}
	
	public void setDateRepas(Date dateRepas) {
		this.dateRepas = dateRepas;
	}
	
	public Time getHeureRepas() {
		return this.heureRepas;
	}
	
	public void setHeureRepas(Time heureRepas) {
		this.heureRepas = heureRepas;
	}
	
	public ArrayList<Utilisateur> getLesAliments() {
		return lesAliments;
	}
	public void setLesAliments(ArrayList<Utilisateur> lesAliments) {
		this.lesAliments = lesAliments;
	}
	public Categorie() {
		super();
		this.lesAliments = new ArrayList<Utilisateur>();
	}
	public Categorie(Date dateRepas, Time heureRepas) {
		this();
		this.dateRepas = dateRepas;
		this.heureRepas = heureRepas;
	}
	public Categorie(int identifiant, Date dateRepas, Time heureRepas) {
		this(dateRepas,heureRepas);
		this.identifiant = identifiant;
	}
	@Override
	public String toString() {
		return "Repas [identifiant=" + identifiant + ", dateRepas=" + dateRepas.toString() + ", heureRepas=" + heureRepas.toString() + "]";
	}
	
	
}
