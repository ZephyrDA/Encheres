package dal.dao;

import dal.ConnectionProvider;
import be.BusinessException;
import bo.Article;
import bo.Categorie;
import dal.DALException;
import dal.CodesResultatDAL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.DBConnectPool;

class ArticleDAOJdbcImpl implements ArticleDAO {

	private static final String INSERT="INSERT INTO ARTICLES_VENDUS(nom_article, description,"
			+ " date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie)"
			+ " VALUES(?,?,?,?,?,?,?,?,?) ;";
	private static final String SELECTALL="SELECT * ARTICLES_VENDUS;";
	private static final String UPDATE="UPDATE ARTICLES_VENDUS SET  nom_article=?, description=?, date_debut_encheres=?,"
			+ " date_fin_encheres=?, prix_initial=?, prix_vente=?,  no_utilisateur=?, no_categorie=? WHERE no_article=? ";
	private static final String DELETE="DELETE FROM ARTICLES_VENDUS WHERE no_article=?;";
	private static final String SELECTBYID ="SELECT * FROM ARTICLES_VENDUS WHERE no_article=?";
	
	private Article itemBuilder(ResultSet rs) throws BusinessException{
		Article al;
		try {
			if(rs != null) {
				UtilisateurDAOJdbcImpl UtilisateurDAOImpl= new UtilisateurDAOJdbcImpl();
				CategorieDAOJdbcImpl CategorieDAOImpl= new CategorieDAOJdbcImpl();
				EnchereDAOJdbcImpl EnchereDAOJdbc = new EnchereDAOJdbcImpl();
				al = new Article(rs.getInt("no_article"), rs.getString("nom_article"),rs.getString("description"), 
						rs.getDate("date_debut_encheres"),rs.getDate("date_fin_encheres"),rs.getInt("prix_initial"),
						rs.getInt("prix_vente"),CategorieDAOImpl.selectById(rs.getInt("no_categorie")),
						EnchereDAOJdbc.selectByNoArticle(rs.getInt("no_article")),
						UtilisateurDAOImpl.selectById(rs.getInt("no_utilisateur"))
						);
			}
			else {
				al = new Article();
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.BUILDER_ARTICLE_ECHEC);
				throw businessException;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.BUILDER_ARTICLE_EXCEPTION);
			throw businessException;
		}

		return al;
	}

	
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
			businessException.ajouterErreur(CodesResultatDAL.INSERT_ARTICLE_ECHEC);			
			throw businessException;
		}	
	}
	
	@Override
	public void update(Article article) throws BusinessException {
		if(article==null)
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.UPDATE_ARTICLE_NULL);
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
			businessException.ajouterErreur(CodesResultatDAL.INSERT_ARTICLE_ECHEC);
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
			businessException.ajouterErreur(CodesResultatDAL.INSERT_ARTICLE_ECHEC);			
			throw businessException;
		}	
	}
	
	@Override
	public Article selectById(int id) throws BusinessException {
		if(id==0)
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_ARTICLE_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECTBYID, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, id);			

			pstmt.executeQuery();
			ResultSet rs = pstmt.getGeneratedKeys();
			return itemBuilder(rs);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_ARTICLE_ECHEC);			
			throw businessException;
		}	
	}
	
	@Override
	public ArrayList<Article> selectAll() throws BusinessException {
				
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			ArrayList<Article> liste = new ArrayList<Article>();
			PreparedStatement pstmt = cnx.prepareStatement(SELECTALL, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			while(rs.next()) {
				liste.add(itemBuilder(rs));
			}
			return liste;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_ARTICLE_ECHEC);			
			throw businessException;
		}	
	}
}
