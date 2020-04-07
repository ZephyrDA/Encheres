package dal.dao;

import be.BusinessException;
import bo.Article;
import dal.DALException;
import dal.CodesResultatDAL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utils.DBConnectPool;

class ArticleDAOJdbcImpl implements ArticleDAO {

	private static final String INSERT="INSERT INTO ARTICLES_VENDUS(no_article, nom_article, description,"
			+ " date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie)"
			+ " VALUES(?,?,?,?,?,?,?,?,?) ;";
	private static final String SELECT="SELECT * FROM ALIMENTS WHERE leRepas = ? ;";
	@Override
	public void insert(Article article) throws BusinessException {
		if(article==null)
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		
		try(Connection cnx = DBConnectPool.seConnecter())
		{
			PreparedStatement pstmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, article.getNo_article());
			pstmt.setString(2, article.getNom_article());
			pstmt.setString(3,  article.getDescription());
			pstmt.setString(3,  article.getDate_debut_encheres());
			pstmt.setString(3,  article.getDescription());
			pstmt.setString(3,  article.getDescription());
			pstmt.setString(3,  article.getDescription());
			pstmt.setString(3,  article.getDescription());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next())
			{
				aliment.setIdentifiant(rs.getInt(1));
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

	@Override
	public ArrayList<Utilisateur> selectByIdRepas(int id_repas) throws BusinessException{
		ArrayList<Utilisateur> listeAliments= new ArrayList<Utilisateur>();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT);
			pstmt.setInt(1, id_repas);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				Utilisateur a = itemBuilder(rs);
				listeAliments.add(a);					
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_ALIMENTS_ECHEC);			
			throw businessException;
		}	
		return listeAliments;
	}
	
	private Utilisateur itemBuilder(ResultSet rs) throws BusinessException{
		Utilisateur al;
		try {
			if(rs != null) {
				al = new Utilisateur(rs.getInt("id_aliment"),rs.getString("nom"),rs.getInt("leRepas"));
			}else {
				al = new Utilisateur();
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

}
