package dal.dao;

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

class EnchereDAOJdbcImpl implements EnchereDAO {

	private static final String INSERT="INSERT INTO CATEGORIE(libelle) VALUES(?);";
	private static final String UPDATE="UPDATE CATEGORIE SET libelle = ? WHERE no_categorie = ?";
	private static final String DELETE="DELETE FROM CATEGORIE WHERE no_categorie = ?";
	private static final String SELECTBYID="SELECT * FROM CATEGORIE WHERE no_categorie = ? ;";
	private static final String SELECTALL="SELECT * FROM CATEGORIE;";
	
	@Override
	public void insert(Enchere enchere) throws BusinessException {
		if(enchere==null)
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, enchere.getLibelle());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next())
			{
				enchere.setNo_categorie(rs.getInt(1));
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
	public void update(Enchere enchere) throws BusinessException {
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(DELETE);
			pstmt.setInt(1, enchere.getNo_categorie());
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
	public Enchere selectById(int idArticle, int idUtilisateur) throws BusinessException {
		Enchere c = null;
		try (Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(SELECTBYID);
			pstmt.setInt(1, id);

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
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<Enchere> selectByNoUtilisateur(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
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
