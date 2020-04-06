package dal.dao;


import java.util.ArrayList;

import fr.eni.suivirepas.BusinessException;
import fr.eni.suivirepas.bo.Repas;

public interface UtilisateurDAO {
	/**
	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet businessException.
	 * @param avis
	 * @throws BusinessException
	 */
	public void insert(Categorie repas) throws BusinessException;
	
	public ArrayList<Categorie> selectAll() throws BusinessException;
}
