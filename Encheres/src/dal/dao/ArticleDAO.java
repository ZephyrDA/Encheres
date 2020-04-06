package dal.dao;


import java.util.ArrayList;

import fr.eni.suivirepas.BusinessException;
import fr.eni.suivirepas.bo.Aliments;
import fr.eni.suivirepas.bo.Repas;

public interface ArticleDAO {
	/**
	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet businessException.
	 * @param avis
	 * @throws BusinessException
	 */
	public void insert(Utilisateur aliment) throws BusinessException;
	
	public ArrayList<Utilisateur> selectByIdRepas(int id) throws BusinessException;
}
