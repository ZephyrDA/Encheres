package dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bo.Categorie;
import be.BusinessException;

class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	private static final String INSERT="INSERT INTO REPAS(date_repas, heure_repas) VALUES(?,?);";
	private static final String SELECT="SELECT * FROM REPAS;";
	private ArticleDAO alimentsDAO= DAOFactory.getAlimentsDAO(); 
	
	@Override
	public void insert(Categorie repas) throws BusinessException {
		if(repas==null)
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setDate(1, repas.getDateRepas());
			pstmt.setTime(2, repas.getHeureRepas());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next())
			{
				repas.setIdentifiant(rs.getInt(1));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if(e.getMessage().contains("CK_AVIS_note"))
			{
				businessException.ajouterErreur(CodesResultatDAL.INSERT_REPAS_ECHEC);
			}
			else
			{
				businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			}
			throw businessException;
		}	
	}

	private Categorie itemBuilder(ResultSet rs) throws BusinessException{
		Categorie rep;
		try {
			rep = new Categorie(rs.getInt("id_repas"),rs.getDate("date_repas"),rs.getTime("heure_repas"));
		}catch(SQLException e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.BUILDER_ALIMENTS_EXCEPTION);
			throw businessException;
		}

		return rep;
	}

	@Override
	public ArrayList<Categorie> selectAll() throws BusinessException {
		ArrayList<Categorie> listeRepas= new ArrayList<Categorie>();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
					Categorie a = itemBuilder(rs);	
					a.setLesAliments(alimentsDAO.selectByIdRepas(a.getIdentifiant()));
					listeRepas.add(a);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_REPAS_ECHEC);
			throw businessException;
		}	
		return listeRepas;
	}
}
