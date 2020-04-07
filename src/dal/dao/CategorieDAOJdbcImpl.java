package dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import be.BusinessException;
import bo.Article2;
import bo.Categorie;
import bo.Categorie2;
import dal.CodesResultatDAL;
import dal.ConnectionProvider;

class CategorieDAOJdbcImpl implements CategorieDAO {

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
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
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
				al = new Categorie(rs.getInt("no_categorie"),rs.getString("libelle"));
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
	public void delete(int id) throws BusinessException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(Categorie categorie) throws BusinessException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void selectById(int id) throws BusinessException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void selectAll() throws BusinessException {
		// TODO Auto-generated method stub
		
	}

}
