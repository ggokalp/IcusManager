drop table menu;

CREATE TABLE menu (
  id int NOT NULL GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
  code varchar(10) NOT NULL,
  nom varchar(100) NOT NULL,
  image varchar(100) NOT NULL,
  utilisateur int,
  droit int,
  PRIMARY KEY (id),
  UNIQUE(code)
);

INSERT INTO APP.MENU (NOM, CODE, IMAGE, UTILISATEUR, DROIT) VALUES ('Article','art', '/pictures/menu/bag.png', 1,1);
INSERT INTO APP.MENU (NOM, CODE, IMAGE, UTILISATEUR, DROIT) VALUES ('Client','cli','/pictures/menu/client.png', 1, 1);
INSERT INTO APP.MENU (NOM, CODE, IMAGE, UTILISATEUR, DROIT) VALUES ('Devis Client','clid','/pictures/menu/notes.png', 1, 1);
INSERT INTO APP.MENU (NOM, CODE, IMAGE, UTILISATEUR, DROIT) VALUES ('Facture Client','clif','/pictures/menu/invoice.png', 1, 1);
INSERT INTO APP.MENU (NOM, CODE, IMAGE, UTILISATEUR, DROIT) VALUES ('Graphique','graph','/pictures/menu/chart.png', 1, 1);
INSERT INTO APP.MENU (NOM, CODE, IMAGE, UTILISATEUR, DROIT) VALUES ('Fournisseur','fourn','/pictures/menu/fourn.png', 1, 1);
INSERT INTO APP.MENU (NOM, CODE, IMAGE, UTILISATEUR, DROIT) VALUES ('Bon de commande','bon','/pictures/menu/bon.png', 1, 1);
INSERT INTO APP.MENU (NOM, CODE, IMAGE, UTILISATEUR, DROIT) VALUES ('Facture Fourn.','forunf','/pictures/menu/fourni.png', 1, 1);

