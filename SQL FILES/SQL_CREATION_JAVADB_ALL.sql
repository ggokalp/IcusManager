drop table menu;
DROP TABLE client;
drop table listedeprix;
drop table articlecompose;
drop table artcorresp;
drop table article;
DROP TABLE devisdetails;
DROP TABLE devisgeneral;


CREATE TABLE menu (
  id int NOT NULL GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
  code varchar(10) NOT NULL,
  nom varchar(100) NOT NULL,
  utilisateur int,
  droit int,
  PRIMARY KEY (id),
  UNIQUE(code)
);

CREATE TABLE client (
  id int NOT NULL GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
  code varchar(30) NOT NULL,
  societe varchar(200),
  formejuridique varchar(20),
  categorie varchar(100),
  pays varchar(100),
  adrue varchar(300),
  adville varchar(150),
  adcp varchar(25),
  adlivrue varchar(300),
  adlivville varchar(150),
  adlivcp varchar(25),
  modereglement varchar(20),
  bloque char(1),
  modetva varchar(30),
  remise int,
  remarque varchar(150),
  numentreprise varchar(25),
  representant varchar(150),
  dernierecommande varchar(8), -- OR DATE ?
  tarif varchar(50),
  PRIMARY KEY (id)
);

ALTER TABLE client 
ADD CONSTRAINT code_UNIQUE UNIQUE (code);


CREATE TABLE article (
  id int NOT NULL GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
  code varchar(30) NOT NULL,
  libellefrl varchar(1500),
  libellenll varchar(1500),
  libelleenl varchar(1500),
  libellefrc varchar(250),
  libellenlc varchar(250),
  libelleenc varchar(250),
  famille varchar(20),
  prixachat double NOT NULL,
  prixvente double NOT NULL,
  prixventettc double NOT NULL,
  stock int,
  compose int,
  bloque int,
  PRIMARY KEY (id)
);


CREATE TABLE listedeprix(
  IDCLIENT int NOT NULL,
  LISTENOM varchar(150),
  IDARTICLE int NOT NULL,
  libelle varchar(1500),
  famille varchar(20),
  prixvente double NOT NULL,
  PRIMARY KEY (IDCLIENT,LISTENOM,IDARTICLE)
);

CREATE TABLE articlecompose (
  idmaster int NOT NULL,
  idslave int NOT NULL,
  codemaster varchar(30) NOT NULL,
  codeslave varchar(30) NOT NULL,
  quantite int
);

CREATE TABLE ARTCORRESP(
  id int NOT NULL, 
  code varchar(30) NOT NULL,
  PRIMARY KEY (id)
);


CREATE TABLE devisgeneral (
	id int NOT NULL GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
	nopiece varchar(100),
	datepiece varchar(15),
	status varchar(10),
	dateecheance varchar(10),
	idclient int,
	societe varchar(100),
	codetarif varchar(100),
	refer varchar(100),
	remarque varchar(1000),
	transfere varchar(10),
	derniertransfert varchar(20),
	totalht double,
	totaltva double,
	totalttc double,
	PRIMARY KEY (id)
);


CREATE TABLE devisdetails (
	id int NOT NULL GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
	iddevis int,
	nopiece varchar(100), 
	article varchar(100),
	descritpion varchar(5000),
	prixht double,
	quantite integer,
	prixtotht double,
	PRIMARY KEY (id),
	foreign key (iddevis) references devisgeneral(id)
);

select dg.ID, dd.NOPIECE, dd.ARTICLE, dd.DESCRITPION, dd.PRIXHT, dd.QUANTITE, dd.PRIXTOTHT from devisdetails dd join devisgeneral dg on dg.NOPIECE=dd.NOPIECE;


INSERT INTO APP.MENU (NOM, CODE, UTILISATEUR, DROIT) VALUES ('Client: Editer','aaa', 1, 1);
INSERT INTO APP.MENU (NOM, CODE, UTILISATEUR, DROIT) VALUES ('Client: Devis','aab', 1, 1);
INSERT INTO APP.MENU (NOM, CODE, UTILISATEUR, DROIT) VALUES ('Client: Facture','aac', 1, 1);
INSERT INTO APP.MENU (NOM, CODE, UTILISATEUR, DROIT) VALUES ('Article: Edition','aba', 1, 1);
INSERT INTO APP.MENU (NOM, CODE, UTILISATEUR, DROIT) VALUES ('Fournisseur: Editer','aca', 1, 1);
INSERT INTO APP.MENU (NOM, CODE, UTILISATEUR, DROIT) VALUES ('Fournisseur: Devis','acb', 1, 1);
INSERT INTO APP.MENU (NOM, CODE, UTILISATEUR, DROIT) VALUES ('Fournisseur: Bon de commande','acc', 1, 1);
INSERT INTO APP.MENU (NOM, CODE, UTILISATEUR, DROIT) VALUES ('Fournisseur: Facture','acd', 1, 1);