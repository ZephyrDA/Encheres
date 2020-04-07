package dal.dao;

import dal.ConnectionProvider;
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
	private static final String SELECTALL="SELECT * ARTICLES_VENDUS;";
	private static final String UPDATE="UPDATE ARTICLES_VENDUS SET  nom_article=?, description=?, date_debut_encheres=?,"
			+ " date_fin_encheres=?, prix_initial=?, prix_vente=?,  no_utilisateur=?, no_categorie=? WHERE no_article=? ";
	private static final String DELETE="DELETE FROM ARTICLES_VENDUS WHERE no_article=?;";
	private static final String SELECTBYID ="SELECT * FROM ARTICLES_VENDUS WHERE no_article=?";
	
	@Override
	public void insert(Article article) throws BusinessException {
		if(article==null)
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, article.getNom_article());
			pstmt.setString(2, article.getDescription());
			pstmt.setDate(3,  article.getDate_debut_encheres());
			pstmt.setDate(4,  article.getDate_fin_encheres());
			pstmt.setInt(5,  article.getPrix_initial());
			pstmt.setInt(6,  article.getPrix_vente());
			pstmt.setInt(7,  article.getVendeur().getNoUtilisateur());
			pstmt.setInt(8,  article.getCategorie().getNo_categorie());

			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next())
			{
				article.setNo_article(rs.getInt(1));
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
	public void update(Article article) throws BusinessException {
		if(article==null)
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.UPDATE_OBJET_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, article.getNom_article());
			pstmt.setString(2, article.getDescription());
			pstmt.setDate(3,  article.getDate_debut_encheres());
			pstmt.setDate(4,  article.getDate_fin_encheres());
			pstmt.setInt(5,  article.getPrix_initial());
			pstmt.setInt(6,  article.getPrix_vente());
			pstmt.setInt(7,  article.getVendeur().getNoUtilisateur());
			pstmt.setInt(8,  article.getCategorie().getNo_categorie());
			pstmt.setInt(9, article.getNo_article());


			pstmt.executeUpdate();			
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
	public void delete(int id) throws BusinessException {
		if(id==0)
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.DELETE_ID_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(DELETE, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, id);

			pstmt.executeUpdate();			
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
	public Article selectById(int id) throws BusinessException {
		if(article==null)
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.UPDATE_OBJET_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, article.getNo_article());
			pstmt.setString(2, article.getNom_article());
			pstmt.setString(3, article.getDescription());
			pstmt.setDate(4,  article.getDate_debut_encheres());
			pstmt.setDate(5,  article.getDate_fin_encheres());
			pstmt.setInt(6,  article.getPrix_initial());
			pstmt.setInt(7,  article.getPrix_vente());
			pstmt.setInt(8,  article.getVendeur().getNoUtilisateur());
			pstmt.setInt(9,  article.getCategorie().getNo_categorie());

			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next())
			{
				article.setNo_article(rs.getInt(1));
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
	public List<Article> selectAll() throws BusinessException {
		if(article==null)
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.UPDATE_OBJET_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, article.getNo_article());
			pstmt.setString(2, article.getNom_article());
			pstmt.setString(3, article.getDescription());
			pstmt.setDate(4,  article.getDate_debut_encheres());
			pstmt.setDate(5,  article.getDate_fin_encheres());
			pstmt.setInt(6,  article.getPrix_initial());
			pstmt.setInt(7,  article.getPrix_vente());
			pstmt.setInt(8,  article.getVendeur().getNoUtilisateur());
			pstmt.setInt(9,  article.getCategorie().getNo_categorie());

			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next())
			{
				article.setNo_article(rs.getInt(1));
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
}