package dal;

/**
 * Les codes disponibles sont entre 10000 et 19999
 */
public abstract class CodesResultatDAL {
	
	/**
	 * Echec général quand erreur non gérée à la création d'un objet
	 */
	public static final int BUILDER_OBJET_ECHEC=10000;
	
	/**
	 * Echec général quand exception non gérée à la création d'un objet
	 */
	public static final int BUILDER_OBJET_EXCEPTION=10001;
	
	/**
	 * Echec général quand erreur non gérée à l'insertion 
	 */
	public static final int INSERT_OBJET_ECHEC=10002;
	
	/**
	 * Echec général quand tentative d'ajouter un objet null
	 */
	public static final int INSERT_OBJET_NULL=10003;
	
	/**
	 * Echec général quand tentative de mettre à jour un objet null
	 */
	public static final int UPDATE_OBJET_NULL = 10004;
	/**
	 * Echec général quand tentative de suppresion d'un objet null
	 */
	public static final int DELETE_OBJET_NULL = 10005;
	
	/**
	 * Echec général quand erreur non gérée lors de la suppression d'un objet null
	 */
	public static final int DELETE_OBJET_ECHEC = 10006;
		
	/**
	 * Echec général quand tentative de sélection d'un objet null
	 */
	public static final int SELECT_OBJET_NULL = 10007;
	
	/**
	 * Echec général quand erreur non gérée à la sélection
	 */
	public static final int SELECT_OBJET_ECHEC = 10008;
	
	/**
	 * ARTICLE
	 */
	public static final int BUILDER_ARTICLE_ECHEC = 10009;
	public static final int BUILDER_ARTICLE_EXCEPTION = 10010;
	public static final int INSERT_ARTICLE_NULL=10011;
	public static final int INSERT_ARTICLE_ECHEC = 10012;
	public static final int UPDATE_ARTICLE_NULL = 10013;
	public static final int UPDATE_ARTICLE_ECHEC = 10014;
	public static final int DELETE_ARTICLE_NULL = 10015;
	public static final int DELETE_ARTICLE_ECHEC = 10016;
	public static final int SELECT_ARTICLE_NULL = 10017;
	public static final int SELECT_ARTICLE_ECHEC = 10018;
	
	/**
	 * UTILISATEUR
	 */
	public static final int BUILDER_UTILISATEUR_ECHEC = 10019;
	public static final int BUILDER_UTILISATEUR_EXCEPTION = 10020;
	public static final int INSERT_UTILISATEUR_NULL = 10021;
	public static final int INSERT_UTILISATEUR_ECHEC = 10022;
	public static final int UPDATE_UTILISATEUR_NULL = 10023;
	public static final int UPDATE_UTILISATEUR_ECHEC = 10024;
	public static final int DELETE_UTILISATEUR_NULL = 10025;
	public static final int DELETE_UTILISATEUR_ECHEC = 10026;
	public static final int SELECT_UTILISATEUR_NULL = 10027;
	public static final int SELECT_UTILISATEUR_ECHEC = 10028;

	/**
	 * CATEGORIE
	 */
	public static final int BUILDER_CATEGORIE_ECHEC = 10029;
	public static final int BUILDER_CATEGORIE_EXCEPTION = 10030;
	public static final int INSERT_CATEGORIE_NULL = 10031;
	public static final int INSERT_CATEGORIE_ECHEC = 10032;
	public static final int UPDATE_CATEGORIE_NULL = 10033;
	public static final int UPDATE_CATEGORIE_ECHEC = 10034;
	public static final int DELETE_CATEGORIE_NULL = 10035;
	public static final int DELETE_CATEGORIE_ECHEC = 10036;
	public static final int SELECT_CATEGORIE_NULL = 10037;
	public static final int SELECT_CATEGORIE_ECHEC = 10038;
	
	/**
	 * ENCHERES
	 */
	public static final int BUILDER_ENCHERES_ECHEC = 10039;
	public static final int BUILDER_ENCHERES_EXCEPTION = 10040;
	public static final int INSERT_ENCHERES_NULL = 10041;
	public static final int INSERT_ENCHERES_ECHEC = 10042;
	public static final int UPDATE_ENCHERES_NULL = 10043;
	public static final int UPDATE_ENCHERES_ECHEC = 10044;
	public static final int DELETE_ENCHERES_NULL = 10045;
	public static final int DELETE_ENCHERES_ECHEC = 10046;
	public static final int SELECT_ENCHERES_NULL = 10047;
	public static final int SELECT_ENCHERES_ECHEC = 10048;
	
	/**
	 * RETRAIT
	 */
	public static final int BUILDER_RETRAIT_ECHEC = 10049;
	public static final int BUILDER_RETRAIT_EXCEPTION = 10050;
	public static final int INSERT_RETRAIT_NULL = 10051;
	public static final int INSERT_RETRAIT_ECHEC = 10052;
	public static final int UPDATE_RETRAIT_NULL = 10053;
	public static final int UPDATE_RETRAIT_ECHEC = 10054;
	public static final int DELETE_RETRAIT_NULL = 10055;
	public static final int DELETE_RETRAIT_ECHEC = 10056;
	public static final int SELECT_RETRAIT_NULL = 10057;
	public static final int SELECT_RETRAIT_ECHEC = 10058;
}
