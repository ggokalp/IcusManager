drop table article;

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