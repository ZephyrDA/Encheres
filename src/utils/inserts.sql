DELETE FROM ENCHERES;
DELETE FROM RETRAITS;
DELETE FROM ARTICLES_VENDUS;
DELETE FROM UTILISATEURS;
DELETE FROM CATEGORIES;
DBCC CHECKIDENT (ARTICLES_VENDUS, RESEED, 0)
DBCC CHECKIDENT (UTILISATEURS, RESEED, 0)
DBCC CHECKIDENT (CATEGORIES, RESEED, 0)

INSERT INTO CATEGORIES(libelle) VALUES
	('Jouets pour adultes'),
	('Les accessoires du pr�tre'),
	('Collection Daesh'),
	('Les coups de coeur du F�rher');

INSERT INTO UTILISATEURS(pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) VALUES
	('JaiD�fonc�LesJumelles','Ben laden','Oussama','benladen@benladen.fr','0666666666','1 rue du trou perdu','04104','Au milieu du desert','TwinTower404',0,0),
	('OuvreBo�te3945','Mengele','Josef','torturenazi@yahoo.de','0767676767','Auschwitz Birkenau','32600','Oswie�im','sixmillionsbordel',0,0),
	('LePapePutain','Joseph Alsius Ratzinger','Beno�t XVI','quiveutmangermesbonbons@gmail.com','0712345678','Chapelle sixtine','00120','Vatican','DieuVousPenetreraTous',0,0),
	('Jou�ClubDorcel','Dorcel','Dorcel','lescrayonscestmapassion@orange.fr','0696969420','100 AV DU PRESIDENT','75016','Paris','LaMeilleurFaconDeJouer',0,0),
	('JaimeLesMomies','Macron','Emmanuel','presidentantiquaire@neuf.Fr','0600000000','55 Rue du Faubourg Saint-Honor�','75008','Paris','SybethSaitPasMettreUnMasque',6000000,0);

INSERT INTO ARTICLES_VENDUS(nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie) VALUES
	('Poireau en plastique','id�al pour jouer � la dinette avec sa soeur','2020/04/06','2020/04/10',1000,10000,4,1),
	('Missile M51','Pourrait aussi etre dans la cat�gorie jouet pour adulte que Collection Daesh','2020/04/06','2020/04/10',100000,2000000,1,3),
	('Uniforme nazi','Uniforme design� par Hugo Boss','2020/04/06','2020/04/10',500,20000,2,4),
	('F�rule Papale','Le sceptre que le pape utilise pour b�nir les enfants de choeur','2020/04/06','2020/04/10',20000,21000,3,2),
	('Crucifix','J�sus sur sa sainte croix','2020/04/06','2020/04/10',15,20,3,2),
	('Luger Po8','Arme de poing favorite des nazis','2020/04/06','2020/04/10',2000,20000000,2,4),
	('Le Coran �dition Daesh','Edition officielle de Daesh','2020/04/06','2020/04/10',50,60,1,3),
	('Ba�llon-boule','Ideal pour faire taire ses victimes','2020/04/06','2020/04/10',10,450,4,1);

INSERT INTO RETRAITS(no_article,rue,code_postal,ville) VALUES
	(2,'1 rue du trou perdu','04104','Au milieu du desert'),
	(7,'1 rue du trou perdu','04104','Au milieu du desert'),
	(6,'Auschwitz Birkenau','32600','Oswie�im'),
	(3,'Auschwitz Birkenau','32600','Oswie�im'),
	(4,'Chapelle sixtine','00120','Vatican'),
	(5,'Chapelle sixtine','00120','Vatican'),
	(1,'100 AV DU PRESIDENT','75016','Paris'),
	(8,'100 AV DU PRESIDENT','75016','Paris');

INSERT INTO ENCHERES(no_utilisateur,no_article,date_enchere,montant_enchere) VALUES
	(1,2,'2020/04/06',2000000),
	(2,3,'2020/04/07',20000),
	(3,4,'2020/04/08',21000),
	(4,5,'2020/04/09',20),
	(2,1,'2020/04/10',10000),
	(3,6,'2020/04/10',20000000),
	(4,7,'2020/04/10',60),
	(1,8,'2020/04/10',450);













































