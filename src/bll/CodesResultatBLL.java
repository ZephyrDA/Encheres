package bll;

/**
 * Les codes disponibles sont entre 20000 et 29999
 */
public abstract class CodesResultatBLL {
	
	/**
	 * Echec quand la description de l'avis ne respecte pas les règles définies
	 */
	public static final int REGLE_DATE_REPAS_ERREUR=20000;
	/**
	 * Echec quand la note de l'avis ne respecte pas les règles définies
	 */
	public static final int REGLE_HEURE_REPAS_ERREUR=20001;
	
	/**
	 * Echec quand la description de l'avis ne respecte pas les règles définies
	 */
	public static final int REGLE_NOM_ALIMENT_ERREUR=20002;
	/**
	 * Echec quand la note de l'avis ne respecte pas les règles définies
	 */
	public static final int REGLE_LE_REPAS_ERREUR=20003;
	
	
}
