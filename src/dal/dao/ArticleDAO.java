package dal.dao;

import bo.Article;
import be.BusinessException;


public interface ArticleDAO {
	/**
	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet businessException.
	 * @param avis
	 * @throws BusinessException
	 */
	public void insert(Article article) throws BusinessException;
	
	public void update(int id) throws BusinessException;
	
	public void delete(int id) throws BusinessException;
}
