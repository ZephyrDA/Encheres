package dal.dao;


import bo.Categorie;
import be.BusinessException;


public interface CategorieDAO {
	/**
	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet businessException.
	 * @param avis
	 * @throws BusinessException
	 */
	public void insert(Categorie categorie) throws BusinessException;
	
	public void update(Categorie categorie) throws BusinessException;
	
	public void selectById(int id) throws BusinessException;
	
	public void selectAll() throws BusinessException;
	
	public void delete(int id) throws BusinessException;
}
