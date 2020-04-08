package bll;

/**
 * Les codes disponibles sont entre 20000 et 29999
 */
public abstract class CodesResultatBLL {
	
	/**
	 * Echec quand la date de debut d'enchère est passée
	 */
	public static final int REGLE_DATE_DEBUT_ENCHERE = 20000;
	
	/**
	 * Echec quand la date de fin d'enchère est avant la date de début
	 */
	public static final int REGLE_DATE_FIN_ENCHERE = 20001;

	public static final int REGLE_MOTSDEPASSE_DIFFRENTS = 20002;
	
	
}
