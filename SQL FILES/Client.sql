DROP TABLE client;

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
