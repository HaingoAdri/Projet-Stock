create database Stock;

create table Composant(
    id_Comp VARCHAR(200) PRIMARY KEY NOT NULL,
    nom_Comp VARCHAR(200) NOT NULL,
    prix_Comp DOUBLE PRECISION NOT NULL
);

-- creation de sequence
create SEQUENCE stoque start with 1 maxvalue 9999 increment by 1;

-- creation de fonction stoque
create function getSequenceSotck()
RETURNS INT
language plpgsql
AS
$$
DECLARE
    idStock INTEGER;
BEGIN
    select nextVal('stocks_id_stock_seq') into idStock from stoque;

    return idStock;
end;
$$;

create table Produits(
    id_Pro VARCHAR(200) PRIMARY KEY NOT NULL,
    nom_Pro VARCHAR(200) NOT NULL,
    prix_Pro DOUBLE PRECISION NOT NULL
);
create table Stocks(
    id_Stock serial PRIMARY KEY NOT NULL,
    date_Stock date NOT NULL,
    produits VARCHAR(200) REFERENCES Produits(id_Pro),
    entree int ,
    sortie int ,
    reste int ,
    prix DOUBLE PRECISION
);

alter table stocks drop column composant;
alter table stocks add column composant VARCHAR(200) REFERENCES Composant(id_Comp);

CREATE TABLE magasin(
    id_Magasin VARCHAR(200) PRIMARY KEY NOT NULL,
    nom_Magasin VARCHAR(200) NOT null
);

alter table stocks add magasin VARCHAR(200) REFERENCES magasin(id_Magasin);


insert into Produits VALUES
    ('P001','Fanta',1200),
    ('P002','Limonade_Be',4200),
    ('P003','Biere',1200);
    
insert into magasin VALUES
    ('MOO1','M1'),
    ('MOO2','M2');
insert into stocks values ('0012','30/04/2023','P001','C007',20,40,20,4000,'MOO1');

   
    create or replace view stock_Dates 
   as 
   select date_Stock dates_S,p.nom_Pro produits,sum(entree) as entrer,sum(sortie) as sortie,sum(reste) as reste,sum(prix) as prix,m.nom_Magasin magasin
    from stocks 
    join produits p 
    on p.id_Pro=produits 
    join magasin m on m.id_Magasin=magasin
    group by stocks.date_Stock,p.nom_Pro,m.nom_Magasin;



    create or replace view magasin1 as
    select dates_S ,produits, sum(entrer) as entrer, sum(sortie) as sortie, sum(reste) as restes, sum(prix) as prix, magasin 
    from stock_dates  
    where magasin = 'M1' 
    group by magasin,produits,dates_S;

    create or replace view magasin2 as
    select dates_S , produits, sum(entrer) as entrer, sum(sortie) as sortie, sum(reste) as restes, sum(prix) as prix, magasin 
    from stock_dates  
    where magasin = 'M2' 
    group by magasin,produits,dates_S;

    

   create table repport(
       id_repport varchar(200) primary key,
       date_repport date not null,
       produits varchar(200) not null REFERENCES produits(id_pro),
        magasin varchar(200) not null REFERENCES magasin(id_magasin),
        quantite int
   );

    insert into repport VALUES
        ('R002','2023-01-01','P002','MOO1',0),
        ('R003','2023-01-06','P001','MOO1',279),
        ('R004','2023-01-06','P002','MOO1',91),
        ('R005','2023-01-08','P001','MOO1',274),
        ('R006','2023-01-08','P002','MOO1',86);


    insert into repport VALUES
        ('R007','2023-01-01','P002','MOO2',0),
        ('R008','2023-01-01','P001','MOO2',0);

    insert into repport VALUES ('R009','2023-01-01','P001','MOO1',0);
        
    create view repport_2s as 
    select date_repport, p.nom_Pro produit, m.nom_Magasin, quantite
    from repport
    join produits p 
    on p.id_Pro=produits 
    join magasin m on m.id_Magasin=magasin
    group by repport.date_repport,p.nom_Pro,m.nom_Magasin,repport.quantite;


   

    create or replace view repport_M1 as select * from repport_2s where nom_magasin='M1';

     create or replace view repport_M2 as select * from repport_2s where nom_magasin='M2';

  