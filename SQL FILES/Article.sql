drop table article;

CREATE TABLE article (
  id int NOT NULL GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
  code varchar(30) NOT NULL,
  libellefr varchar(1500),
  libellenl varchar(1500),
  libelleen varchar(1500),
  famille varchar(20),
  prixachat double NOT NULL,
  prixvente double NOT NULL,
  prixventettc double NOT NULL,
  stock int,
  compose int,
  bloque int,
  PRIMARY KEY (id)
);