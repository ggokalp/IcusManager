drop table listedeprix;

CREATE TABLE listedeprix(
  IDCLIENT int NOT NULL,
  LISTENOM varchar(150),
  IDARTICLE int NOT NULL,
  libelle varchar(1500),
  famille int,
  prixvente double NOT NULL,
  PRIMARY KEY (IDCLIENT,LISTENOM,IDARTICLE)
);