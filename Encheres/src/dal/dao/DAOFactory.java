package dal.dao;

import fr.eni.suivirepas.dal.RepasDAO;

public abstract class DAOFactory {
	
	public static UtilisateurDAO getRepasDAO()
	{
		return new UtilisateurDAOJdbcImpl();
	}
	
	public static ArticleDAO getAlimentsDAO()
	{
		return new ArticleDAOJdbcImpl();
	}
}
