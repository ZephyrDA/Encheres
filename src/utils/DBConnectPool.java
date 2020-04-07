package utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import dal.DALException;
/**
 * Classe Connexion
 * @author quaranTeam
 *
 */

public class DBConnectPool {
	//se connecter
	public static Connection seConnecter() throws DALException {
		Connection cnx = null;
		InitialContext context = null;
		DataSource ds = null;

		//Initialisation du contexte initial
		try {
			context = new InitialContext();
		} catch (NamingException e) {
			throw new DALException("Erreur d'acces au contexte initial", e);
		}

		//Chargement du context via context.xml
		try {
			ds = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
		} catch (NamingException e) {
			throw new DALException("Objet introuvable dans l'annuaire", e);
		}
		//Pool de connexion
		try {
			cnx = ds.getConnection();
		} catch (SQLException e) {
			throw new DALException("Impossible d'obtenir le pool de connection", e);
			
		}
		return cnx;
	}
	//seDeconnecter
	public static void seDeconnecter(Statement stmt, Connection cnx) throws DALException{
		try {
			if (stmt!=null) stmt.close();
		} catch (SQLException e) {
			throw new DALException("Probleme de fermeture du statement",e);
		}

		try {
			if (cnx!=null) cnx.close();
		} catch (SQLException e) {
			throw new DALException("Probleme de fermeture de la connexion",e);
		}

	}
}
