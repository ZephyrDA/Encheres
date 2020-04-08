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
import bo.Retrait;
import dal.CodesResultatDAL;
import dal.ConnectionProvider;

class RetraitDAOJdbcImpl implements RetraitDAO {

	private static final String INSERT="INSERT INTO RETRAIT(no_article,rue,code_postal,ville) VALUES(?,?,?,?);";
	private static final String UPDATE="UPDATE RETRAIT SET rue = ?, code_postal = ?, ville = ? WHERE no_artcle = ?";
	private static final String DELETE="DELETE FROM RETRAIT WHERE no_article = ?";
	private static final String SELECTBYID="SELECT * FROM RETRAIT WHERE no_article = ? ;";
	private static final String SELECTALL="SELECT * FROM RETRAIT;";
	
	@Override
	public void insert(Retrait retrait) throws BusinessException {
		if(retrait==null)
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(INSERT);
			pstmt.setInt(1, retrait.getArticle().getNo_article());
			pstmt.setString(2, retrait.getRue());
			pstmt.setString(3, retrait.getCode_postal());
			pstmt.setString(4, retrait.getVille());
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

	
	private Retrait itemBuilder(ResultSet rs) throws BusinessException{
		Retrait al;
		Article a;
		ArticleDAO articleDAO= DAOFactory.getArticleDAO();
		try {
			if(rs != null) {
				a = articleDAO.selectById(rs.getInt("no_article"));
				al = new Retrait(a,rs.getString("rue"),rs.getString("code_postal"),rs.getString("ville"));
			}else {
				al = new Retrait();
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
	public void update(Retrait retrait) throws BusinessException {
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE);
			pstmt.setString(1, retrait.getRue());
			pstmt.setString(2, retrait.getCode_postal());
			pstmt.setString(3, retrait.getVille());
			pstmt.setInt(1, retrait.getArticle().getNo_article());
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
	public Retrait selectById(int id) throws BusinessException {
		Retrait c = null;
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
	public ArrayList<Retrait> selectAll() throws BusinessException {
		ArrayList<Retrait> listeRetrait = new ArrayList<Retrait>();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECTALL);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
					Retrait a = itemBuilder(rs);	
					listeRetrait.add(a);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_REPAS_ECHEC);
			throw businessException;
		}	
		return listeRetrait;		
	}
}
