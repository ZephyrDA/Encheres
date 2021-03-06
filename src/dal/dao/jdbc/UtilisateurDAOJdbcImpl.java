package dal.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import bo.Utilisateur;
import dal.CodesResultatDAL;
import dal.ConnectionProvider;
import dal.dao.UtilisateurDAO;
import be.BusinessException;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	private static final String INSERT="INSERT INTO UTILISATEURS(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, "
			+ "mot_de_passe, credit, administrateur) VALUES(?,?,?,?,?,?,?,?,?,?,?);";
	private static final String SELECT="SELECT * FROM UTILISATEURS;";
	private static final String UPDATE="UPDATE UTILISATEURS SET pseudo=?,nom=?,prenom=?,email=?,"
			+ "telephone=?,rue=?,code_postal=?,ville=?,mot_de_passe=?,credit=?,administrateur=? WHERE no_utilisateur=?;";
	private static final String DELETE="DELETE FROM UTILISATEURS WHERE no_utilisateur=?;";
	private static final String SELECTBYID="SELECT * FROM UTILISATEURS WHERE no_utilisateur=?;";
	private static final String SELECTBYPSEUDO = "SELECT * FROM UTILISATEURS WHERE pseudo=?;";
	private static final String SELECTBYEMAIL = "SELECT * FROM UTILISATEURS WHERE email=?;";

	
	private Utilisateur itemBuilder(ResultSet rs) throws BusinessException{
		Utilisateur rep;
		try {
			if(rs != null) {
				 rep = new Utilisateur(
						rs.getInt("no_utilisateur"),
						rs.getString("pseudo"),
						rs.getString("nom"),
						rs.getString("prenom"),
						rs.getString("email"),
						rs.getString("telephone"),
						rs.getString("rue"),
						rs.getString("code_postal"),
						rs.getString("ville"),
						rs.getString("mot_de_passe"),
						rs.getBoolean("administrateur"),
						rs.getInt("credit")
						);
			}else {
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.BUILDER_UTILISATEUR_NULL);
				throw businessException;	
			}			
		}catch(SQLException e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.BUILDER_UTILISATEUR_ECHEC);
			throw businessException;
		}	
		return rep;
	}
	
	@Override
	public void insert(Utilisateur utilisateur) throws BusinessException {
		if(utilisateur==null)
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_UTILISATEUR_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, utilisateur.getPseudo());
			pstmt.setString(2, utilisateur.getNom());
			pstmt.setString(3, utilisateur.getPrenom());
			pstmt.setString(4, utilisateur.getEmail());
			pstmt.setString(5, utilisateur.getTelephone());
			pstmt.setString(6, utilisateur.getRue());
			pstmt.setString(7, utilisateur.getCodePostal());
			pstmt.setString(8, utilisateur.getVille());
			pstmt.setString(9, utilisateur.getMotDePasse());
			pstmt.setInt(10, utilisateur.getCredit());
			pstmt.setBoolean(11, utilisateur.getAdministrateur());
			
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next())
			{
				utilisateur.setNoUtilisateur(rs.getInt(1));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_UTILISATEUR_ECHEC);			
			throw businessException;
		}	
	}

	@Override
	public void update(Utilisateur utilisateur) throws BusinessException {
		if(utilisateur==null)
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.UPDATE_UTILISATEUR_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, utilisateur.getPseudo());
			pstmt.setString(2, utilisateur.getNom());
			pstmt.setString(3, utilisateur.getPrenom());
			pstmt.setString(4, utilisateur.getEmail());
			pstmt.setString(5, utilisateur.getTelephone());
			pstmt.setString(6, utilisateur.getRue());
			pstmt.setString(7, utilisateur.getCodePostal());
			pstmt.setString(8, utilisateur.getVille());
			pstmt.setString(9, utilisateur.getMotDePasse());
			pstmt.setInt(10, utilisateur.getCredit());
			pstmt.setBoolean(11, utilisateur.getAdministrateur());
			pstmt.setInt(12, utilisateur.getNoUtilisateur());

			pstmt.executeUpdate();			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.UPDATE_UTILISATEUR_ECHEC);
			throw businessException;
		}	
		
	}

	
	@Override
	public void delete(int id) throws BusinessException {
		if(id==0)
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.DELETE_UTILISATEUR_NULL);
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
			businessException.ajouterErreur(CodesResultatDAL.DELETE_UTILISATEUR_ECHEC);			
			throw businessException;
		}		
	}


	@Override
	public Utilisateur selectById(int id) throws BusinessException {		
		if(id==0)
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_UTILISATEUR_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECTBYID);
			pstmt.setInt(1, id);			

			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return itemBuilder(rs);
			}else {
				return new Utilisateur();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_UTILISATEUR_ECHEC);			
			throw businessException;
		}	
	}
	
	@Override
	public ArrayList<Utilisateur> selectAll() throws BusinessException {
		ArrayList<Utilisateur> listeRepas= new ArrayList<Utilisateur>();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				listeRepas.add(itemBuilder(rs));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_UTILISATEUR_ECHEC);
			throw businessException;
		}	
		return listeRepas;
	}


	@Override
	public Utilisateur selectByPseudo(String pseudo) throws BusinessException {
		if(pseudo==null)
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_UTILISATEURBYPSEUDO_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECTBYPSEUDO);
			pstmt.setString(1, pseudo);			

			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return itemBuilder(rs);
			}else {
				return new Utilisateur();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_UTILISATEURBYPSEUDO_ECHEC);			
			throw businessException;
		}	
	}

	@Override
	public Utilisateur selectByEmail(String email) throws BusinessException {
		if(email==null)
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_UTILISATEURBYEMAIL_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECTBYEMAIL);
			pstmt.setString(1, email);			

			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return itemBuilder(rs);
			}else {
				return new Utilisateur();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_UTILISATEURBYEMAIL_ECHEC);			
			throw businessException;
		}	
	}
}
