package dal.dao;


import java.util.ArrayList;

import bo.Article;
import be.BusinessException;


public interface RetraitDAO {
	/**
	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet businessException.
	 * @param avis
	 * @throws BusinessException
	 */
	public void insert(Article article) throws BusinessException;
	
	public void update(int id) throws BusinessException;
	
	public void selectById(int id) throws BusinessException;
	
	public void selectAll(int id) throws BusinessException;
	
	public void delete(int id) throws BusinessException;
}
