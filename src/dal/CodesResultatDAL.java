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

	public static final int SELECT_OBJET_NULL = 10010;

	public static final int BUILDER_ARTICLE_ECHEC = 10011;

	public static final int BUILDER_ARTICLE_EXCEPTION = 10013;

	public static final int INSERT_ARTICLE_ECHEC = 10014;

	public static final int UPDATE_ARTICLE_NULL = 10015;

	public static final int DELETE_ID_NULL = 10016;

	public static final int SELECT_ARTICLE_NULL = 10017;

	public static final int BUILDER_UTILISATEUR_EXCEPTION = 10018;

	public static final int UPDATE_UTILISATEUR_NULL = 10019;

	public static final int INSERT_UTILISATEUR_ECHEC = 10020;

	public static final int UPDATE_UTILISATEUR_ECHEC = 10021;

	public static final int DELETE_UTILISATEUR_ECHEC = 10022;

	public static final int SELECT_UTILISATEUR_NULL = 10023;

	public static final int SELECT_UTILISATEUR_ECHEC = 10024;

}
