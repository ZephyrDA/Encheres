package dal.dao;

import bo.Article;
import be.BusinessException;


import java.util.ArrayList;
import java.util.List;


public interface ArticleDAO {
	/**
	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet businessException.
	 * @param article
	 * @throws BusinessException
	 */
	public void insert(Article article) throws BusinessException;
	
	public void update(Article article) throws BusinessException;
	
	public void delete(int id) throws BusinessException;

	public Article selectById(int id) throws BusinessException;
	
	public  ArrayList<Article> selectAll() throws BusinessException;
}
