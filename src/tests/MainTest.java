/**
 * 
 */
package tests;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import be.BusinessException;
import bll.EncheresManager;
import bo.Article;
import bo.Categorie;
import bo.Enchere;
import bo.Retrait;
import bo.Utilisateur;

/**
 * Classe en charge de
 * @author Elian
 * @version Encheres - v1.0
 * @date 8 avr. 2020
 */
public class MainTest {
	
	static EncheresManager manager = new EncheresManager();
	
	public static void main(String[] args) {
	
		//Tests Utilisateurs
		try{
						
			Utilisateur userInsert1 = manager.ajouterUtilisateur("Wabbit", "Leven�", "Elian", "elevenefly@gmail.com", "0658599369", "12 Square Henri Dunant",
					 "35700", "Rennes", "mdp", "mdp", false); 			
			Utilisateur userGet1 = manager.getUtilisateur(1);
			ArrayList<Utilisateur> lesUtilisateurs = manager.getLesUtilisateurs();
			
			System.out.println("-----------------------Test Utilisateurs-----------------------");
			System.out.println("Insertion User 1 :");
			System.out.println(userInsert1.toString());
			System.out.println("----------------------------------------------");
			System.out.println("Get User 1 :");
			System.out.println(userGet1.toString());
			System.out.println("----------------------------------------------");
			System.out.println("Get Users :");
			for(Utilisateur u : lesUtilisateurs) {
			System.out.println(u.toString());
			}
			System.out.println("----------------------------------------------");
			
			Utilisateur updateUser = lesUtilisateurs.get(1);
			updateUser.setPseudo("Le Boss En Fait");
			manager.modifierUtilisateur(updateUser);
			
			System.out.println("update User 2 :");
			System.out.println(updateUser.toString());
			System.out.println("----------------------------------------------");
			
			manager.supprimerUtilisateur(userInsert1.getNoUtilisateur());
			lesUtilisateurs = manager.getLesUtilisateurs();
			
			System.out.println("delete inserted User :");
			for(Utilisateur u : lesUtilisateurs) {
				System.out.println(u.toString());
				}
			System.out.println("----------------------------------------------");

			
		}
		catch(BusinessException e){
			e.printStackTrace();
		}
		
		//Tests Cat�gories
		try{
						
			Categorie catInsert1 = manager.ajouterCategorie("CategorieTest1"); 			
			Categorie catGet1 = manager.getCategorie(1);
			ArrayList<Categorie> lesCategories = manager.getLesCategories();
			
			System.out.println("-----------------------Test Categories-----------------------");
			System.out.println("Insertion Categorie 1 :");
			System.out.println(catInsert1.toString());
			System.out.println("----------------------------------------------");
			System.out.println("Get Categorie 1 :");
			System.out.println(catGet1.toString());
			System.out.println("----------------------------------------------");
			System.out.println("Get Categories :");
			for(Categorie u : lesCategories) {
			System.out.println(u.toString());
			}
			System.out.println("----------------------------------------------");
			
			Categorie updateCat = lesCategories.get(1);
			updateCat.setLibelle("La meilleur cat�gorie");
			manager.modifierCategorie(updateCat);
			
			System.out.println("update Categorie 2 :");
			System.out.println(updateCat.toString());
			System.out.println("----------------------------------------------");
			
			manager.supprimerCategorie(catInsert1.getNo_categorie());
			
			System.out.println("delete inserted Categorie :");
			for(Categorie u : lesCategories) {
				System.out.println(u.toString());
				}
			System.out.println("----------------------------------------------");

			
		}
		catch(BusinessException e){
			e.printStackTrace();
		}
		
		//Tests Article
		try{
			Categorie cat = manager.getCategorie(1);			
			Date date1 = new Date(2020, 8, 12);
			Date date2 = new Date(2020, 12, 12);
			Utilisateur vendeur = manager.getUtilisateur(1);

			Article artInsert1 = manager.ajouterArticle("Ballon de volley", "Parfait �tat, jamais servi", cat, 15, date1, date2,
					"1 Rue des Lilas", "22130", "Dinan", vendeur); 			
			Article artGet1 = manager.getArticle(1);
			ArrayList<Article> lesArticles = manager.getLesArticles();
			
			System.out.println("-----------------------Test Articles-----------------------");
			System.out.println("Insertion Article 1 :");
			System.out.println(artInsert1.toString());
			System.out.println("----------------------------------------------");
			System.out.println("Get Article 1 :");
			System.out.println(artGet1.toString());
			System.out.println("----------------------------------------------");
			System.out.println("Get Articles :");
			for(Article u : lesArticles) {
			System.out.println(u.toString());
			}
			System.out.println("----------------------------------------------");
			
			Article updateArt = lesArticles.get(1);
			updateArt.setNom_article("Ballon de Foot");
			manager.modifierArticle(updateArt);
			
			System.out.println("update Article 2 :");
			System.out.println(updateArt.toString());
			System.out.println("----------------------------------------------");
			
			manager.supprimerArticle(artInsert1.getNo_article());
			
			System.out.println("delete inserted Article :");
			for(Article u : lesArticles) {
				System.out.println(u.toString());
				}
			System.out.println("----------------------------------------------");			
		}
		catch(BusinessException e){
			e.printStackTrace();
		}
		
		//Tests Retrait
		try{
			Article art=manager.getArticle(1);
			
			Retrait retInsert1 = manager.ajouterRetrait(art, "Carimel", "22130", "Languenan");			
			Retrait retGet1 = manager.getRetrait(1);
			ArrayList<Retrait> lesRetraits = manager.getLesRetraits();
			
			System.out.println("-----------------------Test Retraits-----------------------");
			System.out.println("Insertion Retrait 1 :");
			System.out.println(retInsert1.toString());
			System.out.println("----------------------------------------------");
			System.out.println("Get Retrait 1 :");
			System.out.println(retGet1.toString());
			System.out.println("----------------------------------------------");
			System.out.println("Get Retraits :");
			for(Retrait u : lesRetraits) {
			System.out.println(u.toString());
			}
			System.out.println("----------------------------------------------");
			
			Retrait updateRet = lesRetraits.get(1);
			updateRet.setVille("Nantes");
			manager.modifierRetrait(updateRet);
			
			System.out.println("update Retrait 2 :");
			System.out.println(updateRet.toString());
			System.out.println("----------------------------------------------");
			
			manager.supprimerRetrait(retInsert1.getArticle().getNo_article());
			
			System.out.println("delete inserted Retrait :");
			for(Retrait u : lesRetraits) {
				System.out.println(u.toString());
				}
			System.out.println("----------------------------------------------");			
		}
		catch(BusinessException e){
			e.printStackTrace();
		}
		
		//Tests Enchere
		try{
			Article art=manager.getArticle(1);
			Utilisateur user=manager.getUtilisateur(1);
			
			Enchere enchInsert1 = manager.ajouterEnchere(150, user, art.getNo_article());			
			Enchere enchGet1 = manager.getEnchere(1,1);
			ArrayList<Enchere> lesEncheres = manager.getLesEncheres();
			
			System.out.println("-----------------------Test Encheres-----------------------");
			System.out.println("Insertion Enchere 1 :");
			System.out.println(enchInsert1.toString());
			System.out.println("----------------------------------------------");
			System.out.println("Get Enchere 1 :");
			System.out.println(enchGet1.toString());
			System.out.println("----------------------------------------------");
			System.out.println("Get Encheres :");
			for(Enchere u : lesEncheres) {
			System.out.println(u.toString());
			}
			System.out.println("----------------------------------------------");
			
			Enchere updateEnch = lesEncheres.get(1);
			updateEnch.setMontantEnchere(180);
			manager.modifierEnchere(updateEnch, art.getNo_article());
			
			System.out.println("update Enchere 1 :");
			System.out.println(updateEnch.toString());
			System.out.println("----------------------------------------------");
			
			manager.supprimerEnchere(art.getNo_article(), enchInsert1.getUtilisateur().getNoUtilisateur());
			
			System.out.println("delete inserted Enchere :");
			for(Enchere u : lesEncheres) {
				System.out.println(u.toString());
				}
			System.out.println("----------------------------------------------");			
		}
		catch(BusinessException e){
			e.printStackTrace();
		}
	}
}
