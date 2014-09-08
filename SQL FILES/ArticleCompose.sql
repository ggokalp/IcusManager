drop table articlecompose;

CREATE TABLE articlecompose (
  idmaster int NOT NULL,
  idslave int NOT NULL,
  codemaster varchar(30) NOT NULL,
  codeslave varchar(30) NOT NULL,
  quantite int
);