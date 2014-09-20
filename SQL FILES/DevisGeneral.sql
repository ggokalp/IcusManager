DROP TABLE devisgeneral;

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