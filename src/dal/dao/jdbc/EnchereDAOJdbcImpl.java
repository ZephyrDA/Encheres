package dal.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
 
import be.BusinessException;
import bo.Article;
import bo.Enchere;
import bo.Utilisateur;
import dal.CodesResultatDAL;
import dal.ConnectionProvider;
import dal.dao.DAOFactory;
import dal.dao.EnchereDAO;
import dal.dao.UtilisateurDAO;

class EnchereDAOJdbcImpl implements EnchereDAO {

	private static final String INSERT="INSERT INTO ENCHERE(no_utilisateur,no_article,date_enchere,montant_enchere) VALUES(?,?,?,?);";
	private static final String UPDATE="UPDATE ENCHERE SET date_enchere = ? , montant_enchere WHERE no_article = ? AND no_utilisateur = ?";
	private static final String DELETE="DELETE FROM ENCHERE WHERE no_article = ? AND no_utilisateur = ?";
	private static final String SELECTBYID="SELECT * FROM ENCHERE WHERE no_article = ? AND no_utilisateur = ? ;";
	private static final String SELECTALL="SELECT * FROM ENCHERE;";
	private static final String SELECTBYUTIL="SELECT * FROM ENCHERE WHERE no_utilisateur = ? ;";
	private static final String SELECTBYARTICLE="SELECT * FROM ENCHERE WHERE no_utilisateur = ? ;";
	
	@Override
	public void insert(Enchere enchere, int idArticle) throws BusinessException {
		if(enchere==null)
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(INSERT);
			pstmt.setInt(1, enchere.getUtilisateur().getNoUtilisateur());
			pstmt.setInt(2, idArticle);
			pstmt.setDate(3, enchere.getDateEnchere());
			pstmt.setInt(4, enchere.getMontantEnchere());
			pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();

			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			
			throw businessException;
		}	
	}

	
	@Override
	public void delete(int id) throws BusinessException {
		if(id<0)
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(DELETE);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			throw businessException;
		}	
	}


	@Override
	public void update(Enchere enchere,int idArticle) throws BusinessException {
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(DELETE);
			pstmt.setInt(1, enchere.getUtilisateur().getNoUtilisateur());
			pstmt.setInt(2, idArticle);
			pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			throw businessException;
		}
	}


	@Override
	public Enchere selectById(int idArticle, int idUtilisateur) throws BusinessException {
		Enchere c = null;
		try (Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(SELECTBYID);
			pstmt.setInt(1, idArticle);
			pstmt.setInt(1, idUtilisateur);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()){
				 c = itemBuilder(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			throw businessException;
		}	finally {
			if(c == null) {
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
				throw businessException;	
			}
		}
		return c;
	}


	@Override
	public ArrayList<Enchere> selectAll() throws BusinessException {
		ArrayList<Enchere> listeEnchere= new ArrayList<Enchere>();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECTALL);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
					Enchere a = itemBuilder(rs);	
					listeEnchere.add(a);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_REPAS_ECHEC);
			throw businessException;
		}	
		return listeEnchere;		
	}


	@Override
	public ArrayList<Enchere> selectByNoArticle(int id) throws BusinessException {
		Enchere c = null;
		ArrayList<Enchere> listeEnchere = new ArrayList<Enchere>();
		try (Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(SELECTBYARTICLE);
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
					Enchere a = itemBuilder(rs);	
					listeEnchere.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			throw businessException;	
		}
		return listeEnchere;

	}


	@Override
	public ArrayList<Enchere> selectByNoUtilisateur(int id) throws BusinessException {
		Enchere c = null;
		ArrayList<Enchere> listeEnchere= new ArrayList<Enchere>();
		try (Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(SELECTBYUTIL);
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
					Enchere a = itemBuilder(rs);	
					listeEnchere.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			throw businessException;
		}
		return listeEnchere;

	}

	private Enchere itemBuilder(ResultSet rs) throws BusinessException{
		Enchere al;
		Utilisateur util;
		UtilisateurDAO UtilDAO = DAOFactory.getUtilisateurDAO();
		try {
			if(rs != null) {
				util = UtilDAO.selectById(rs.getInt("no_utilisateur"));
				al = new Enchere(rs.getDate("date_enchere"),rs.getInt("montant_enchere"),util);
			}else {
				al = new Enchere();
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