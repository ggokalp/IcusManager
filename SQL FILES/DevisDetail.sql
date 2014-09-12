DROP TABLE devisdetails;

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
	PRIMARY KEY (id)
);

-- COmment