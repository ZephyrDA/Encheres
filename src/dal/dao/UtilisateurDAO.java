package dal.dao;


import java.util.ArrayList;

import bo.Utilisateur;
import be.BusinessException;

public interface UtilisateurDAO {
	/**
	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet businessException.
	 * @param avis
	 * @throws BusinessException
	 */
	public void insert(Utilisateur utilisateur) throws BusinessException;
	public void update(Utilisateur utilisateur) throws BusinessException;
	public void delete (int id) throws BusinessException;
	public Utilisateur selectById(int id) throws BusinessException;
	public ArrayList<Utilisateur> selectAll() throws BusinessException;
}
