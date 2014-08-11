drop table menu;

CREATE TABLE menu (
  id int NOT NULL GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
  code varchar(10) NOT NULL,
  nom varchar(100) NOT NULL,
  utilisateur int,
  droit int,
  PRIMARY KEY (id),
  UNIQUE(code),
);


INSERT INTO APP.MENU (NOM, CODE, UTILISATEUR, DROIT) VALUES ('Client: Editer','aaa', 1, 1);
INSERT INTO APP.MENU (NOM, CODE, UTILISATEUR, DROIT) VALUES ('Client: Devis','aab', 1, 1);
INSERT INTO APP.MENU (NOM, CODE, UTILISATEUR, DROIT) VALUES ('Client: Facture','aac', 1, 1);

INSERT INTO APP.MENU (NOM, CODE, UTILISATEUR, DROIT) VALUES ('Article: Edition','aba', 1, 1);

INSERT INTO APP.MENU (NOM, CODE, UTILISATEUR, DROIT) VALUES ('Fournisseur: Editer','aca', 1, 1);
INSERT INTO APP.MENU (NOM, CODE, UTILISATEUR, DROIT) VALUES ('Fournisseur: Devis','acb', 1, 1);
INSERT INTO APP.MENU (NOM, CODE, UTILISATEUR, DROIT) VALUES ('Fournisseur: Bon de commande','acc', 1, 1);
INSERT INTO APP.MENU (NOM, CODE, UTILISATEUR, DROIT) VALUES ('Fournisseur: Facture','acd', 1, 1);