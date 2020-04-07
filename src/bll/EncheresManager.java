package bll;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import fr.eni.suivirepas.BusinessException;
import fr.eni.suivirepas.bo.Aliments;
import fr.eni.suivirepas.bo.Repas;
import fr.eni.suivirepas.dal.RepasDAO;
import fr.eni.suivirepas.dal.AlimentsDAO;
import fr.eni.suivirepas.dal.DAOFactory;

/**
 * 
 * @author Administrator
 *
 * Cette classe permet d'effectuer les traitements attendus sur la classe Repas
 */
public class EncheresManager {
	
	private UtilisateurDAO repasDAO;
	private ArticleDAO alimentsDAO;
	
	/**
	 * Le constructeur permet d'initialiser la variable membre repasDAO pour 
	 * permettre une communication avec la base de données. 
	 */
	public EncheresManager() {
		this.repasDAO=DAOFactory.getRepasDAO();
		this.alimentsDAO=DAOFactory.getAlimentsDAO();
	}
	/**
	 * @param description
	 * @param note
	 * @return un objet Repas en cas de succcès
	 * @throws BusinessException 
	 */
	public Categorie ajouterRepas(Date dateRepas, Time heureRepas) throws BusinessException
	{
		BusinessException exception = new BusinessException();
		
		Categorie repas = new Categorie(dateRepas, heureRepas);
		
		this.validerHeure(repas,exception);
		this.validerDate(repas,exception);

		if(!exception.hasErreurs())
		{
			this.repasDAO.insert(repas);
		}
		
		if(exception.hasErreurs())
		{
			throw exception;
		}
		return repas;
	}
	
	/**
	 * @param description
	 * @param note
	 * @return un objet Repas en cas de succcès 
	 * @throws BusinessException 
	 */
	public Utilisateur ajouterAliment(String nom, int leRepas) throws BusinessException
	{
		BusinessException exception = new BusinessException();
		
		Utilisateur aliments = new Utilisateur(nom, leRepas);
		
		if(!exception.hasErreurs())
		{
			this.alimentsDAO.insert(aliments);
		}
		
		if(exception.hasErreurs())
		{
			throw exception;
		}
		return aliments;
	}
	
	/**
	 * Cette méthode permet de vérifier les règles à respecter sur la variable membre note.
	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet businessException.
	 * @param repas
	 * @param businessException 
	 */
	private void validerHeure(Categorie repas, BusinessException businessException)
	{
		if(repas.getHeureRepas() == null)
		{
			businessException.ajouterErreur(CodesResultatBLL.REGLE_HEURE_REPAS_ERREUR);
		}
	}
		
	/**
	 * Cette méthode permet de vérifier les règles à respecter sur la variable membre description.
	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet businessException.
	 * @param repas
	 * @param businessException
	 */
	private void validerDate(Categorie repas, BusinessException businessException) 
	{
		if(repas.getDateRepas()==null)
		{
			businessException.ajouterErreur(CodesResultatBLL.REGLE_DATE_REPAS_ERREUR);
		}
	}
	
	public ArrayList<Categorie> getLesRepas() throws BusinessException{
		return this.repasDAO.selectAll();
	}
}
