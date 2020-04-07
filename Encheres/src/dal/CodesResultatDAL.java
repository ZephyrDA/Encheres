package dal;

/**
 * Les codes disponibles sont entre 10000 et 19999
 */
public abstract class CodesResultatDAL {
	
	/**
	 * Echec général quand tentative d'ajouter un objet null
	 */
	public static final int INSERT_OBJET_NULL=10000;
	
	/**
	 * Echec général quand erreur non gérée à l'insertion 
	 */
	public static final int INSERT_OBJET_ECHEC=10001;
	
	/**
	 * Echec de l'insertion d'un avis à cause de la note
	 */
	public static final int INSERT_REPAS_ECHEC=10002;
	
	/**
	 * Echec général quand erreur non gérée à l'insertion 
	 */
	public static final int INSERT_ALIMENTS_ECHEC=10003;
	
	/**
	 * Echec général quand erreur non gérée à l'insertion 
	 */
	public static final int SELECT_ALIMENTS_ECHEC=10004;
	
	/**
	 * Echec général quand erreur non gérée à l'insertion 
	 */
	public static final int SELECT_REPAS_ECHEC=10005;
	
	public static final int BUILDER_ALIMENTS_ECHEC=10006;
	public static final int BUILDER_ALIMENTS_EXCEPTION=10007;
	
	public static final int BUILDER_REPAS_ECHEC=10008;
	public static final int BUILDER_REPAS_EXCEPTION=10009;
}
