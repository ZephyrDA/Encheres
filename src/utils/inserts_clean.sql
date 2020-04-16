DELETE FROM ENCHERES;
DELETE FROM RETRAITS;
DELETE FROM ARTICLES_VENDUS;
DELETE FROM UTILISATEURS;
DELETE FROM CATEGORIES;
DBCC CHECKIDENT (ARTICLES_VENDUS, RESEED, 0)
DBCC CHECKIDENT (UTILISATEURS, RESEED, 0)
DBCC CHECKIDENT (CATEGORIES, RESEED, 0)

INSERT INTO CATEGORIES(libelle) VALUES
	('Informatique'),
	('Ameublement'),
	('Vetements'),
	('Sport et Loisirs');

INSERT INTO UTILISATEURS(pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) VALUES
	('BillGates','Gates','Bil','microsoft@outlook.com','0666666666','1 rue du trou perdu','04104','Au milieu du desert','BillGates',0,0),
	('JeffBezos','Bezos','Jeff','jeffbezos@yahoo.de','0767676767','Amazon','55555','New York','JeffBezos',0,0),
	('KarlLagerfeld','Lagerfeld','Karl','vetements@gmail.com','0712345678','Chapelle sixtine','00120','Vatican','KarlLagerfeld',0,0),
	('TiboInShape','InShape','Tibo','enormeetsec@orange.fr','0696969420','100 AV DU PRESIDENT','75016','Paris','TiboInShape',0,0),
	('Manu','Macron','Emmanuel','sybethsaitpasmettreunmasque@neuf.Fr','0600000000','55 Rue du Faubourg Saint-Honore','75008','Paris','Manu',6000000,1);

INSERT INTO ARTICLES_VENDUS(nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie,vignette) VALUES
	('AlienWare','PC Gaming','2020/04/06','2020/04/10',1000,10000,1,1,'./assets/alienware.jpg'),
	('souris ROCCAT','Souris gaming','2020/04/20','2020/04/24',100000,2000000,1,1,'./assets/roccat.jpg'),
	('Table Ikea','Gifi des idees de genie','2020/04/06','2020/04/10',500,20000,2,2,'./assets/ikea.jpg'),
	('Armoire Castorama','Decathlon, a fond la forme !','2020/04/20','2020/04/24',20000,21000,2,2,'./assets/castorama.jpg'),
	('Robe de soiree','Plein de paillettes, partout','2020/04/13','2020/04/18',15,20,3,3,'./assets/robe.jpg'),
	('Talon Haut','Pour les gens qui aiment marcher sur la pointe des pieds tout en faisant du bruit','2020/04/13','2020/04/18',2000,20000000,3,3,'./assets/talon_haut.jpg'),
	('Ballon de foot','Zidane a joue avec quand il etait gosse','2020/04/13','2020/04/18',50,60,4,4,'./assets/zidane.jpg'),
	('Raquette de tennis','Une raquette magique qui permet de gagner tous les matchs','2020/04/20','2020/04/24',10,450,4,4,'./assets/raquette.jpg');

INSERT INTO RETRAITS(no_article,rue,code_postal,ville) VALUES
	(1,'1 rue du trou perdu','04104','Au milieu du desert'),
	(2,'1 rue du trou perdu','04104','Au milieu du desert'),
	(3,'Amazon','55555','New York'),
	(4,'Amazon','55555','New York'),
	(5,'Chapelle sixtine','00120','Vatican'),
	(6,'Chapelle sixtine','00120','Vatican'),
	(7,'100 AV DU PRESIDENT','75016','Paris'),
	(8,'100 AV DU PRESIDENT','75016','Paris');

INSERT INTO ENCHERES(no_utilisateur,no_article,date_enchere,montant_enchere) VALUES
	(1,1,'2020/04/06',10000),
	(1,2,'2020/04/07',2000000),
	(2,3,'2020/04/08',20000),
	(2,4,'2020/04/09',21000),
	(3,5,'2020/04/10',20),
	(3,6,'2020/04/10',20000000),
	(4,7,'2020/04/10',60),
	(4,8,'2020/04/10',450);













































