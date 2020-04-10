package bll;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import be.BusinessException;
import bo.Article;
import bo.Categorie;
import bo.Enchere;
import bo.Retrait;
import bo.Utilisateur;
import dal.dao.ArticleDAO;
import dal.dao.CategorieDAO;
import dal.dao.EnchereDAO;
import dal.dao.RetraitDAO;
import dal.dao.UtilisateurDAO;
import dal.dao.DAOFactory;



/**
 * 
 * @author Administrator
 *
 * Cette classe permet d'effectuer les traitements attendus
 */
public class EncheresManager {
	
	private UtilisateurDAO utilisateurDAO;
	private ArticleDAO articleDAO;
	private CategorieDAO categorieDAO;
	private RetraitDAO retraitDAO;
	private EnchereDAO enchereDAO;
	
	/**
	 * Le constructeur permet d'initialiser les variables DAO pour 
	 * permettre une communication avec la base de données. 
	 */
	public EncheresManager() {
		this.utilisateurDAO=DAOFactory.getUtilisateurDAO();
		this.articleDAO=DAOFactory.getArticleDAO();
		this.categorieDAO=DAOFactory.getCategorieDAO();
		this.retraitDAO=DAOFactory.getRetraitDAO();
		this.enchereDAO=DAOFactory.getEnchereDAO();
	}
	
	/**
	 * 
	 * M�thode en charge de l'ajout d'article
	 * @param libelle
	 * @param description
	 * @param categorie
	 * @param prixInitial
	 * @param dateDebut
	 * @param dateFin
	 * @param rueRetrait
	 * @param cpRetrait
	 * @param villeRetrait
	 * @param vendeur
	 * @return objet Article
	 * @throws BusinessException
	 */
	public Article ajouterArticle(String libelle, String description, Categorie categorie, int prixInitial, Date dateDebut, Date dateFin,
			String rueRetrait, String cpRetrait, String villeRetrait, Utilisateur vendeur) throws BusinessException
	{
		BusinessException exception = new BusinessException();
		this.validerDateDebut(dateDebut, exception);
		this.validerDateFin(dateDebut, dateFin, exception);
		Article article = new Article(libelle, description,dateDebut,dateFin,prixInitial,categorie,vendeur);	

		if(!exception.hasErreurs())
		{
			this.articleDAO.insert(article);
			this.ajouterRetrait(article, rueRetrait, cpRetrait, villeRetrait);
		}else {
			throw exception;
		}
		return article;
	}
	
	/**
	 * 
	 * M�thode en charge de la modification d'un Article
	 * @param article
	 * @throws BusinessException
	 */
	public void modifierArticle(Article article) throws BusinessException {
		
		BusinessException exception = new BusinessException();
		
		if(!exception.hasErreurs()) {
			this.articleDAO.update(article);
		}
		else {
			throw exception;
		}	
	}
	
	/**
	 * 
	 * M�thode en charge de la suppression d'un Article
	 * @param id
	 * @throws BusinessException
	 */
	public void supprimerArticle(int id) throws BusinessException {
		
		BusinessException exception = new BusinessException();
		
		if(!exception.hasErreurs()) {
			ArrayList<Retrait> retraits = this.getLesRetraits();
			for(Retrait ret : retraits) {
				if(ret.getArticle().getNo_article()==id) {
					this.supprimerRetrait(id);
				}
			}
			this.articleDAO.delete(id);
		}
		else {
			throw exception;
		}	
	}
	
	/**
	 * 
	 * M�thode en charge de la r�cup�ration d'un objet article
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public Article getArticle(int id) throws BusinessException {
		
		BusinessException exception = new BusinessException();
		Article article = new Article();
		if(!exception.hasErreurs()) {
			article= this.articleDAO.selectById(id);
		}
		else {
			throw exception;
		}		
		return article;
	}
	
	/**
	 * 
	 * M�thode en charge de la r�cup�rations des objets article
	 * @return
	 * @throws BusinessException
	 */
	public ArrayList<Article> getLesArticles() throws BusinessException {
		
		BusinessException exception = new BusinessException();
		ArrayList<Article> articles = new ArrayList<Article>();
		if(!exception.hasErreurs()) {
			articles = this.articleDAO.selectAll();
		}
		else {
			throw exception;
		}	
		return articles;
	}
	
	/**
	 * 
	 * M�thode en charge de l'ajout d'une enchere
	 * @param montant
	 * @param acheteur
	 * @param idArticle
	 * @return Enchere
	 * @throws BusinessException
	 */
	public Enchere ajouterEnchere(int montant, Utilisateur acheteur, int idArticle) throws BusinessException
	{
		BusinessException exception = new BusinessException();
		
		Date date = new Date(Calendar.getInstance().getTime().getTime());	
		Enchere enchere=new Enchere(date,montant,acheteur);
		
		if(!exception.hasErreurs())
		{
			this.enchereDAO.insert(enchere, idArticle);
		}
		
		if(exception.hasErreurs())
		{
			throw exception;
		}
		return enchere;
	}
	
	
	/**
	 * 
	 * M�thode en charge de la modification d'une ench�re
	 * @param article
	 * @throws BusinessException
	 */
	public void modifierEnchere(Enchere enchere, int idArticle) throws BusinessException {
		
		BusinessException exception = new BusinessException();
		
		if(!exception.hasErreurs()) {
			this.enchereDAO.update(enchere, idArticle);
		}
		else {
			throw exception;
		}	
	}
	
	/**
	 * 
	 * M�thode en charge de la suppression d'une enchere
	 * @param id
	 * @throws BusinessException
	 */
	public void supprimerEnchere(int idArticle, int idAcheteur) throws BusinessException {
		
		BusinessException exception = new BusinessException();
		
		if(!exception.hasErreurs()) {
			this.enchereDAO.delete(idArticle,idAcheteur);
		}
		else {
			throw exception;
		}	
	}
	
	/**
	 * 
	 * M�thode en charge de la r�cup�ration d'un objet enchere
	 * @param id
	 * @return Enchere
	 * @throws BusinessException
	 */
	public Enchere getEnchere(int idArticle, int idUtilisateur) throws BusinessException {
		
		BusinessException exception = new BusinessException();
		Enchere enchere= new Enchere();
		if(!exception.hasErreurs()) {
			enchere = this.enchereDAO.selectById(idArticle,idUtilisateur);
		}
		else {
			throw exception;
		}	
		return enchere;
	}
	
	/**
	 * 
	 * M�thode en charge de la récupération des objets enchere
	 * @throws BusinessException
	 * @return ArrayList<Enchere>
	 */
	public ArrayList<Enchere> getLesEncheres() throws BusinessException {
		
		BusinessException exception = new BusinessException();
		ArrayList<Enchere> encheres = new ArrayList<Enchere>();
		if(!exception.hasErreurs()) {
			encheres = (ArrayList<Enchere>) this.enchereDAO.selectAll();
		}
		else {
			throw exception;
		}		
		return encheres;
	}
	
	/**
	 * 
	 * Méthode en charge de la récupération de l'acheteur d'un article si l'article est vendu et que des enchères existent pour cet article
	 * @param idArticle
	 * @return Utilisateur
	 * @throws BusinessException
	 */
	public Utilisateur getAcheteur(int idArticle) throws BusinessException {
		
		BusinessException exception = new BusinessException();
		Article article = this.getArticle(idArticle);		
		Utilisateur vendeur = new Utilisateur();
		validerArticleVendu(article.getDate_fin_encheres(), exception);
		ArrayList<Enchere> encheres = this.getEncheresByArticle(idArticle);
		int prixVente=0; 
		if(!exception.hasErreurs()&& encheres.size()!=0) {
			for (Enchere e : encheres) {
				if(e.getMontantEnchere()>prixVente) {
					vendeur = e.getUtilisateur();
					prixVente = e.getMontantEnchere();
				}
			}
		}
		else {
			throw exception;
		}	
		return vendeur;
	}
	
	/**
	 * Méthode en charge de la récupérations des enchères faites pour un article
	 * @param idArticle
	 * @return ArrayList<Enchere>
	 * @throws BusinessException 
	 */
	private ArrayList<Enchere> getEncheresByArticle(int idArticle) throws BusinessException {
		BusinessException exception = new BusinessException();
		ArrayList<Enchere> encheres = new ArrayList<Enchere>();
		if(!exception.hasErreurs()) {
			encheres= this.enchereDAO.selectByNoArticle(idArticle);
		}
		else {
			throw exception;
		}			
		return encheres;
	}

	/**
	 * 
	 * M�thode en charge de l'ajout d'une categorie
	 * @param montant
	 * @param acheteur
	 * @param idArticle
	 * @return Categorie
	 * @throws BusinessException
	 */
	public Categorie ajouterCategorie(String libelle) throws BusinessException
	{
		BusinessException exception = new BusinessException();
		
		Categorie categorie=new Categorie(libelle);
		
		if(!exception.hasErreurs())
		{
			this.categorieDAO.insert(categorie);
		}
		
		if(exception.hasErreurs())
		{
			throw exception;
		}
		return categorie;
	}
	
	/**
	 * 
	 * M�thode en charge de la modification d'une categorie
	 * @param libelle
	 * @throws BusinessException
	 */
	public void modifierCategorie(Categorie categorie) throws BusinessException
	{
		BusinessException exception = new BusinessException();
				
		if(!exception.hasErreurs())
		{
			this.categorieDAO.update(categorie);
		}
		
		if(exception.hasErreurs())
		{
			throw exception;
		}
	}
	
	/**
	 * 
	 * M�thode en charge de la suppression d'une cat�gorie.
	 * @param id
	 * @throws BusinessException
	 */
	public void supprimerCategorie(int id) throws BusinessException
	{
		BusinessException exception = new BusinessException();
				
		if(!exception.hasErreurs())
		{
			this.categorieDAO.delete(id);
		}
		
		if(exception.hasErreurs())
		{
			throw exception;
		}
	}
	
	/**
	 * 	 
	 * M�thode en charge de la r�cup�ration d'un objet categorie
	 * @param id
	 * @return Categorie
	 * @throws BusinessException
	 */
	public Categorie getCategorie(int id) throws BusinessException {
		
		BusinessException exception = new BusinessException();
		Categorie cat= new Categorie();
		if(!exception.hasErreurs()) {
			cat= this.categorieDAO.selectById(id);
		}
		else {
			throw exception;
		}			
		return cat;
	}
	
	/**
	 * 
	 * M�thode en charge de la r�cup�rations des objets enchere
	 * @return Categories
	 * @throws BusinessException
	 */
	public ArrayList<Categorie> getLesCategories() throws BusinessException {
		
		BusinessException exception = new BusinessException();
		ArrayList<Categorie> cat= new ArrayList<Categorie>();
		if(!exception.hasErreurs()) {
			 cat= (ArrayList<Categorie>) this.categorieDAO.selectAll();
		}
		else {
			throw exception;
		}			
		return cat;
	}
	
	/**
	 * 
	 * M�thode en charge de l'ajout d'un utilisateur
	 * @param pseudo
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param telephone
	 * @param rue
	 * @param codePostal
	 * @param ville
	 * @param mdp1
	 * @param mdp2
	 * @param administrateur
	 * @return
	 * @throws BusinessException
	 */
	public Utilisateur ajouterUtilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String mdp1, String mdp2, boolean administrateur) throws BusinessException
	{
		BusinessException exception = new BusinessException();
		this.validerMotDePasse(mdp1, mdp2, exception);
		Utilisateur utilisateur = new Utilisateur( pseudo,  nom,  prenom,  email,  telephone, rue,  codePostal,  ville,  mdp1,  administrateur);
		
		if(!exception.hasErreurs())
		{
			this.utilisateurDAO.insert(utilisateur);
		}
		
		if(exception.hasErreurs())
		{
			throw exception;
		}
		return utilisateur;
	}
	
	/**
	 * 
	 * M�thode en charge de la modification d'un utilisateur
	 * @param utilisateur
	 * @return
	 * @throws BusinessException
	 */
	public void modifierUtilisateur(Utilisateur utilisateur) throws BusinessException
	{
		BusinessException exception = new BusinessException();
		
		if(!exception.hasErreurs())
		{
			this.utilisateurDAO.update(utilisateur);
		}
		
		if(exception.hasErreurs())
		{
			throw exception;
		}
	}
	
	/**
	 * 
	 * M�thode en charge de la suppression d'un utilisateur
	 * @param id
	 * @throws BusinessException
	 */
	public void supprimerUtilisateur(int id) throws BusinessException
	{
		BusinessException exception = new BusinessException();
		
		if(!exception.hasErreurs())
		{
			this.utilisateurDAO.delete(id);
		}
		
		if(exception.hasErreurs())
		{
			throw exception;
		}
	} 
	
	/**
	 * 
	 * M�thode en charge de la r�cup�ration d'un objet Utilisateur
	 * @param id
	 * @return Utilisateur
	 * @throws BusinessException
	 */
	public Utilisateur getUtilisateur(int id) throws BusinessException {
		
		BusinessException exception = new BusinessException();
		Utilisateur user = new Utilisateur();
		if(!exception.hasErreurs()) {
			user= this.utilisateurDAO.selectById(id);
		}
		else {
			throw exception;
		}	
		return user;
	}
	
	/**
	 * 
	 * M�thode en charge de la r�cup�ration des utilisateurs
	 * @return  ArrayList<Utilisateur>
	 * @throws BusinessException
	 */
	public ArrayList<Utilisateur> getLesUtilisateurs() throws BusinessException {
		
		BusinessException exception = new BusinessException();
		ArrayList<Utilisateur> users = new ArrayList<Utilisateur>();
		if(!exception.hasErreurs()) {
			users = this.utilisateurDAO.selectAll();
		}
		else {
			throw exception;
		}
		return users;
	}
	
	/**
	 * 
	 * M�thode en charge de l'ajout d'un Retrait
	 * @param article
	 * @param rue
	 * @param code_postal
	 * @param ville
	 * @throws BusinessException
	 */
	public Retrait ajouterRetrait(Article article, String rue, String code_postal, String ville) throws BusinessException
	{
		BusinessException exception = new BusinessException();
		
		Retrait retrait = new Retrait(article, rue,code_postal ,ville);
		
		if(!exception.hasErreurs())
		{
			this.retraitDAO.insert(retrait);
		}
		
		if(exception.hasErreurs())
		{
			throw exception;
		}
		return retrait;
	}
	
	/**
	 * 
	 * M�thode en charge de la modification d'un objet retrait
	 * @param retrait
	 * @throws BusinessException
	 */
	public void modifierRetrait(Retrait retrait) throws BusinessException
	{
		BusinessException exception = new BusinessException();
				
		if(!exception.hasErreurs())
		{
			this.retraitDAO.update(retrait);
		}
		
		if(exception.hasErreurs())
		{
			throw exception;
		}
	}
	
	/**
	 * 
	 * M�thode en charge de la suppression d'un objet Retrait
	 * @param id
	 * @throws BusinessException
	 */
	public void supprimerRetrait(int id) throws BusinessException
	{
		BusinessException exception = new BusinessException();
				
		if(!exception.hasErreurs())
		{
			this.retraitDAO.delete(id);
		}
		
		if(exception.hasErreurs())
		{
			throw exception;
		}
	}
	/**
	 * 
	 * M�thode en charge de la r�cup�ration d'un objet Retrait
	 * @param id
	 * @return retrait
	 * @throws BusinessException
	 */
	public Retrait getRetrait(int id) throws BusinessException
	{
		BusinessException exception = new BusinessException();
		Retrait retrait=new Retrait();
		if(!exception.hasErreurs())
		{
			retrait= this.retraitDAO.selectById(id);
		}
		
		if(exception.hasErreurs())
		{
			throw exception;
		}
		return retrait;
	}
	
	/**
	 * 
	 * Méthode en charge de la récupération des retraits
	 * @return
	 * @throws BusinessException
	 */
	public ArrayList<Retrait> getLesRetraits() throws BusinessException
	{
		BusinessException exception = new BusinessException();
		ArrayList<Retrait> retraits = new ArrayList<Retrait>();
		if(!exception.hasErreurs())
		{
			retraits= (ArrayList<Retrait>) this.retraitDAO.selectAll();
		}
		
		if(exception.hasErreurs())
		{
			throw exception;
		}
		return retraits;
	}
	
	
	/**
	 * 
	 * M�thode en charge de v�rifier que la date de d�but d'ench�re n'est pas pass�. 
	 * En cas d'erreur le code est enregistr� dans l'objet BusinessException.
	 * @param date
	 * @param businessException
	 */
	private void validerDateDebut(Date date, BusinessException businessException)
	{
		Date d = new Date(Calendar.getInstance().getTime().getTime());
		if(date.compareTo(d)<=0)
		{
			businessException.ajouterErreur(CodesResultatBLL.REGLE_DATE_DEBUT_ENCHERE);
		}
	}
		
	/**
	 * 
	 * M�thode en charge de v�rifier que la date de fin d'ench�re n'est pas avant la date de d�but. 
	 * En cas d'erreur le code est enregistr� dans l'objet BusinessException.
	 * @param date
	 * @param businessException
	 */
	private void validerDateFin(Date dateDebut,Date dateFin, BusinessException businessException)
	{
		if(dateFin.compareTo(dateDebut)<0)
		{
			businessException.ajouterErreur(CodesResultatBLL.REGLE_DATE_FIN_ENCHERE);
		}
	}
	
	/**
	 * 
	 * Méthode en charge de la vérification de la confirmation du mot de passe
	 * @param mdp1
	 * @param mdp2
	 * @param businessException
	 */
	private void validerMotDePasse(String mdp1, String mdp2, BusinessException businessException)
	{
		if(!mdp1.equals(mdp2))
		{
			businessException.ajouterErreur(CodesResultatBLL.REGLE_MOTSDEPASSE_DIFFRENTS);
		}
	}
	
	/**
	 * 
	 * Méthode en charge de vérifier si la date de vente d'un article est passée
	 * @param dateFin
	 * @param businessException
	 */
	private void validerArticleVendu(Date dateFin, BusinessException businessException)
	{
		Date d = new Date(Calendar.getInstance().getTime().getTime());
		if(dateFin.compareTo(d)>=0)
		{
			businessException.ajouterErreur(CodesResultatBLL.REGLE_FIN_ENCHERE_NON_ATTEINTE);
		}
	}
}
