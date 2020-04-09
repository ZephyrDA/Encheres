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

public class EnchereDAOJdbcImpl implements EnchereDAO {

	private static final String INSERT="INSERT INTO ENCHERES(no_utilisateur,no_article,date_enchere,montant_enchere) VALUES(?,?,?,?);";
	private static final String UPDATE="UPDATE ENCHERES SET date_enchere = ? , montant_enchere WHERE no_article = ? AND no_utilisateur = ?";
	private static final String DELETE="DELETE FROM ENCHERES WHERE no_article = ? AND no_utilisateur = ?";
	private static final String SELECTBYID="SELECT * FROM ENCHERES WHERE no_article = ? AND no_utilisateur = ? ;";
	private static final String SELECTALL="SELECT * FROM ENCHERES;";
	private static final String SELECTBYUTIL="SELECT * FROM ENCHERES WHERE no_utilisateur = ? ;";
	private static final String SELECTBYARTICLE="SELECT * FROM ENCHERES WHERE no_utilisateur = ? ;";
	
	@Override
	public void insert(Enchere enchere, int idArticle) throws BusinessException {
		if(enchere==null)
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_ENCHERE_NULL);
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

			businessException.ajouterErreur(CodesResultatDAL.INSERT_ENCHERE_ECHEC);
			
			throw businessException;
		}	
	}

	
	@Override
	public void delete(int idArticle, int idUtil) throws BusinessException {
		if(idArticle<0 || idUtil < 0)
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.DELETE_ENCHERE_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(DELETE);
			pstmt.setInt(1, idArticle);
			pstmt.setInt(2, idUtil);
			pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.DELETE_ENCHERE_ECHEC);
			throw businessException;
		}	
	}


	@Override
	public void update(Enchere enchere,int idArticle) throws BusinessException {
		if(enchere == null || idArticle < 0) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.UPDATE_ENCHERE_NULL);
			throw businessException;
		}
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
			businessException.ajouterErreur(CodesResultatDAL.UPDATE_ENCHERE_ECHEC);
			throw businessException;
		}
	}


	@Override
	public Enchere selectById(int idArticle, int idUtilisateur) throws BusinessException {
		Enchere c = new Enchere();
		if(idArticle < 0 || idUtilisateur < 0) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_ENCHERE_NULL);
			throw businessException;	
		}
		try (Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(SELECTBYID);
			pstmt.setInt(1, idArticle);
			pstmt.setInt(2, idUtilisateur);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()){
				 c = itemBuilder(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_ENCHERE_ECHEC);
			throw businessException;
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
			businessException.ajouterErreur(CodesResultatDAL.SELECT_ENCHERE_ECHEC);
			throw businessException;
		}	
		return listeEnchere;		
	}


	@Override
	public ArrayList<Enchere> selectByNoArticle(int id) throws BusinessException {
		Enchere c = new Enchere();
		ArrayList<Enchere> listeEnchere = new ArrayList<Enchere>();
		
		if(id < 0){
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_ENCHERE_NULL);
			throw businessException;	
		}
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
			businessException.ajouterErreur(CodesResultatDAL.SELECT_ENCHERE_ECHEC);
			throw businessException;	
		}
		return listeEnchere;

	}


	@Override
	public ArrayList<Enchere> selectByNoUtilisateur(int id) throws BusinessException {
		Enchere c = new Enchere();
		ArrayList<Enchere> listeEnchere= new ArrayList<Enchere>();
		
		if(id < 0){
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_ENCHERE_NULL);
			throw businessException;	
		}
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
			businessException.ajouterErreur(CodesResultatDAL.INSERT_ENCHERE_ECHEC);
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
				businessException.ajouterErreur(CodesResultatDAL.BUILDER_ENCHERE_NULL);
				throw businessException;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.BUILDER_ENCHERE_ECHEC);
			throw businessException;
		}

		return al;
	}

}
