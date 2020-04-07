package dal.dao;


import java.util.ArrayList;
import java.util.List;

import bo.Article;
import bo.Retrait;
import be.BusinessException;


public interface RetraitDAO {
	/**
	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet businessException.
	 * @param avis
	 * @throws BusinessException
	 */
	public void insert(Retrait retrait) throws BusinessException;
	
	public void update(Retrait retrait) throws BusinessException;
	
	public Retrait selectById(int id) throws BusinessException;
	
	public List<Retrait> selectAll() throws BusinessException;
	
	public void delete(int id) throws BusinessException;
}
