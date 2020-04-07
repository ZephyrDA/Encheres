package dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.BusinessException;
import bo.Article;
import bo.Categorie;
import dal.CodesResultatDAL;

class CategorieDAOJdbcImpl implements ArticleDAO {

	private static final String INSERT="INSERT INTO ALIMENTS(nom, leRepas) VALUES(?,?) ;";
	private static final String SELECT="SELECT * FROM ALIMENTS WHERE leRepas = ? ;";
	@Override
	public void insert(Categorie categorie) throws BusinessException {
		if(categorie==null)
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, categorie.getNom());
			pstmt.setInt(2, categorie.getLeRepas());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next())
			{
				categorie.setIdentifiant(rs.getInt(1));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if(e.getMessage().contains("CK_AVIS_note"))
			{
				businessException.ajouterErreur(CodesResultatDAL.INSERT_ALIMENTS_ECHEC);
			}
			else
			{
				businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			}
			throw businessException;
		}	
	}

	
	private Categorie itemBuilder(ResultSet rs) throws BusinessException{
		Categorie al;
		try {
			if(rs != null) {
				al = new Categorie(rs.getInt("id_categorie"),rs.getString("nom"),rs.getInt("leRepas"));
			}else {
				al = new Categorie();
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.BUILDER_ALIMENTS_ECHEC);
				throw businessException;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.BUILDER_ALIMENTS_EXCEPTION);
			throw businessException;
		}

		return al;
	}


	@Override
	public void insert(Article article) throws BusinessException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(int id) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

}
