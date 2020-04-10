package dal.dao;


import java.util.ArrayList;
import java.util.List;

import bo.Article;
import bo.Enchere;
import be.BusinessException;


public interface EnchereDAO {
	/**
	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet businessException.
	 * @param avis
	 * @throws BusinessException
	 */
	public void insert(Enchere enchere,int idArticle) throws BusinessException;
	
	public void update(Enchere enchere, int idArticle) throws BusinessException;
	
	public Enchere selectById(int idArticle,int idUtilisateur) throws BusinessException;
	
	public ArrayList<Enchere> selectByNoArticle(int id) throws BusinessException;
	
	public ArrayList<Enchere> selectByNoUtilisateur(int id) throws BusinessException;
	
	public ArrayList<Enchere> selectAll() throws BusinessException;
	
	public void delete(int idArticle,int idUtil) throws BusinessException;
}
