package dal.dao;

import bo.Categorie;
import dal.dao.jdbc.ArticleDAOJdbcImpl;
import dal.dao.jdbc.CategorieDAOJdbcImpl;
import dal.dao.jdbc.EnchereDAOJdbcImpl;
import dal.dao.jdbc.RetraitDAOJdbcImpl;
import dal.dao.jdbc.UtilisateurDAOJdbcImpl;


public abstract class DAOFactory {
	
	public static UtilisateurDAO getUtilisateurDAO()
	{
		return new UtilisateurDAOJdbcImpl();
	}
	
	public static ArticleDAO getArticleDAO()
	{
		return new ArticleDAOJdbcImpl();
	}
	
	public static CategorieDAO getCategorieDAO()
	{
		return new CategorieDAOJdbcImpl();
	}
	
	public static EnchereDAO getEnchereDAO()
	{
		return new EnchereDAOJdbcImpl();
	}
	
	public static RetraitDAO getRetraitDAO()
	{
		return new RetraitDAOJdbcImpl();
	}
}
