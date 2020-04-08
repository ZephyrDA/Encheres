package dal.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
 
import be.BusinessException;
import bo.Categorie;
import dal.CodesResultatDAL;
import dal.ConnectionProvider;
import dal.dao.CategorieDAO;

public class CategorieDAOJdbcImpl implements CategorieDAO {

	private static final String INSERT="INSERT INTO CATEGORIE(libelle) VALUES(?);";
	private static final String UPDATE="UPDATE CATEGORIE SET libelle = ? WHERE no_categorie = ?";
	private static final String DELETE="DELETE FROM CATEGORIE WHERE no_categorie = ?";
	private static final String SELECTBYID="SELECT * FROM CATEGORIE WHERE no_categorie = ? ;";
	private static final String SELECTALL="SELECT * FROM CATEGORIE;";
	
	@Override
	public void insert(Categorie categorie) throws BusinessException {
		if(categorie==null)
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_CATEGORIE_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, categorie.getLibelle());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next())
			{
				categorie.setNo_categorie(rs.getInt(1));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_CATEGORIE_ECHEC);			
			throw businessException;
		}	
	}

	
	private Categorie itemBuilder(ResultSet rs) throws BusinessException{
		Categorie al;
		try {
			if(rs != null) {
				al = new Categorie(rs.getInt("no_categorie"),rs.getString("libelle"));
			}else {
				al = new Categorie();
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.BUILDER_CATEGORIE_NULL);
				throw businessException;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.BUILDER_CATEGORIE_ECHEC);
			throw businessException;
		}

		return al;
	}


	@Override
	public void delete(int id) throws BusinessException {
		if(id<0)
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.DELETE_CATEGORIE_NULL);
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
			businessException.ajouterErreur(CodesResultatDAL.DELETE_CATEGORIE_ECHEC);
			throw businessException;
		}	
	}


	@Override
	public void update(Categorie categorie) throws BusinessException {
		if(categorie == null){
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.UPDATE_CATEGORIE_NULL);
			throw businessException;
		}
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE);
			pstmt.setString(1, categorie.getLibelle());
			pstmt.setInt(2, categorie.getNo_categorie());
			pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.UPDATE_CATEGORIE_ECHEC);
			throw businessException;
		}
	}


	@Override
	public Categorie selectById(int id) throws BusinessException {
		Categorie c = new Categorie();
		if(id < 0 ) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_CATEGORIE_NULL);
			throw businessException;
		}
		try (Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(SELECTBYID);
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()){
				 c = itemBuilder(rs);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_CATEGORIE_ECHEC);
			throw businessException;
		}
		return c;
	}


	@Override
	public ArrayList<Categorie> selectAll() throws BusinessException {
		ArrayList<Categorie> listeCategorie= new ArrayList<Categorie>();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECTALL);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
					Categorie a = itemBuilder(rs);	
					listeCategorie.add(a);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_CATEGORIE_ECHEC);
			throw businessException;
		}	
		return listeCategorie;		
	}
}
