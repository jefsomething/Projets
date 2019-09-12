SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- bdd jstutz
--


CREATE DATABASE IF NOT EXISTS jstutz;
USE jstutz;

--
-- creation des tables
--

CREATE TABLE IF NOT EXISTS `Client` (
  `NumClient` int(5) NOT NULL,
  `NomClient` varchar(15) NOT NULL,
  `Ville` varchar(15) NOT NULL,
  PRIMARY KEY (`NumClient`)	
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS `Compte` (
  `NumCompte` int(5) unsigned AUTO_INCREMENT NOT NULL,
  `NumClient` int(5) NOT NULL,
  `DateOuverture` date NOT NULL,
  `Solde` decimal(10,2) DEFAULT NULL,
  `PMVR` decimal(5,2) NOT NULL,
  PRIMARY KEY (`NumCompte`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS `Secteur` (
  `CodeSecteur` varchar(5) NOT NULL,
  `LibSecteur` varchar(15) NOT NULL,
  PRIMARY KEY (`CodeSecteur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS `Valeur` (
  `CodeValeur` varchar(5) NOT NULL,
  `Denomination` varchar(15) NOT NULL,
  `CodeSecteur` varchar(5) NOT NULL,
  `Indice` varchar(15) NOT NULL,
  `Cours` decimal(6,2) NOT NULL,
  PRIMARY KEY (`CodeValeur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS `Operation` (
  `NoOpe` int(5) unsigned AUTO_INCREMENT NOT NULL,
  `NumCompte` int(5) unsigned NOT NULL,
  `CodeValeur` varchar(5) NOT NULL,
  `DateOpe` date NOT NULL,
  `Nature` varchar(5) NOT NULL,
  `Qte` decimal(15,0) NOT NULL,
  `Montant` decimal(15,2) NOT NULL,
  PRIMARY KEY (`NoOpe`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS `Portefeuille` (
  `NumCompte` int(5) unsigned NOT NULL,
  `CodeValeur` varchar(5) NOT NULL,
  `Quantite` decimal(10,0) DEFAULT NULL,
  `PAM` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (NumCompte, CodeValeur)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;





/*  ajout des cles etrangeres */
ALTER TABLE `Compte`
  ADD CONSTRAINT `Compte_ibfk_1` FOREIGN KEY (`NumClient`) REFERENCES `Client` (`NumClient`) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `Valeur`
  ADD CONSTRAINT `Valeur_ibfk_1` FOREIGN KEY (`CodeSecteur`) REFERENCES `Secteur` (`CodeSecteur`) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `Operation`
  ADD CONSTRAINT `Operation_ibfk_1` FOREIGN KEY (`CodeValeur`) REFERENCES `Valeur` (`CodeValeur`) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `Portefeuille`
  ADD CONSTRAINT `Portefeuille_ibfk_1` FOREIGN KEY (`NumCompte`) REFERENCES `Compte` (`NumCompte`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `Portefeuille_ibfk_2` FOREIGN KEY (`CodeValeur`) REFERENCES `Valeur` (`CodeValeur`) ON DELETE NO ACTION ON UPDATE NO ACTION;





/* insertion de valeurs que 'client' peut acquerir */
INSERT INTO `Secteur` (`CodeSecteur`, `LibSecteur`) VALUES
('S1', 'Energies'),
('S2', 'Automobiles'),
('S3', 'Pharmacie');

INSERT INTO `Valeur` (`CodeValeur`, `Denomination`, `CodeSecteur`, `Indice`, `Cours`) VALUES
('EDF', 'EDF', 'S1', 'SBF120', '14'),
('RNO', 'RENAULT', 'S2', 'CAC40', '70'),
('SAN', 'SANOFI', 'S3', 'CAC40', '75');





/* client 'Prudent' ouvre un compte de 5000 euros*/
INSERT INTO `Client` (`NumClient`, `NomClient`, `Ville`) VALUES
('101', 'Prudent', 'Nancy');
INSERT INTO `Compte` (`NumClient`, `DateOuverture`, `Solde`, `PMVR`) VALUES
('101', CURDATE(), 5000.00, 0.00);

/* Prudent achete ensuite pour 1200 euros de valeurs EDF*/
INSERT INTO `Operation` (`NoOpe`, `NumCompte`, `CodeValeur`, `DateOpe`, `Nature`, `Qte`, `Montant`) VALUES
('1', '1', 'EDF', CURDATE(), 'A', 100, 1200.00);

/*  premiers INSERT INTO dans la table Portefeuille  */ 
INSERT INTO Portefeuille (`NumCompte`, `CodeValeur`, `Quantite`, `PAM`) VALUES (
(SELECT NumCompte FROM Operation WHERE NoOpe = (SELECT MAX(NoOpe) FROM Operation)),
(SELECT CodeValeur FROM Operation WHERE NoOpe = (SELECT MAX(NoOpe) FROM Operation)),
(SELECT Qte FROM Operation WHERE NoOpe = (SELECT MAX(NoOpe) FROM Operation)),
(SELECT Montant/Qte FROM Operation WHERE NoOpe = (SELECT MAX(NoOpe) FROM Operation))
);



/* mise a jour de Compte.Solde suivant le montant des valeurs achetees
On repetera ce bloc de calculs apres chaque operation client, achat ou vente. 
(on prend la derniere operation, si Nature = Achat, alors deduire le Montant de Solde pour le client, sinon ajouter le montant) */
 
UPDATE Compte SET Solde = CASE 
    WHEN (SELECT Nature FROM (SELECT * FROM Operation WHERE NoOpe = (SELECT MAX(NoOpe) FROM Operation))test ) ='A'
    THEN Solde-(SELECT Montant FROM (SELECT * FROM Operation WHERE NoOpe = (SELECT MAX(NoOpe) FROM Operation))test ) 
    
    WHEN (SELECT Nature FROM (SELECT * FROM Operation WHERE NoOpe = (SELECT MAX(NoOpe) FROM Operation))test ) ='V'
    THEN Solde+(SELECT Montant FROM (SELECT * FROM Operation WHERE NoOpe = (SELECT MAX(NoOpe) FROM Operation))test )
END
WHERE NumCompte = (SELECT NumCompte FROM (SELECT * FROM Operation WHERE NoOpe = (SELECT MAX(NoOpe) FROM Operation))test );

/*la table est a jour: un client a des valeurs, le portefeuille reflete cet achat, le solde a et debite en fonction */





/*un nouveau client 'Trader' ouvre un compte et depose 8000 euros*/
INSERT INTO `Client` (`NumClient`, `NomClient`, `Ville`) VALUES
('102', 'Trader', 'Metz');
INSERT INTO `Compte` (`NumClient`, `DateOuverture`, `Solde`, `PMVR`) VALUES
('102', 2011-11-11, 8000.00, 0.00);

/* Trader achete pour 1200 euros de valeurs EDF */
insert into `Operation` (`NoOpe`, `Numcompte`, `CodeValeur`, `DateOpe`, `Nature`, `Qte`, `Montant`) values
('2', '2', 'edf', '2018-10-15', 'a', 100, 3000.00);

/* mise a jour de Portefeuille:
-------------------------------
Difficulté rencontree: faire un UPDATE de Portefeuille en fonction des operations;
il est possible de recuperer la derniere operation realisee en partant du calcul :
(SELECT * FROM Operation WHERE NoOpe = (SELECT MAX(NoOpe) FROM Operation) )

J'ai choisi une autre solution pour mettre a jour Portefeuille:

pour chaque nouvelle operation vente/achat de valeur: 
    -conserver la table mais vider les donnees avec TRUNCATE,
    -creer des vues A,V,X pour effectuer les differents calculs necessaires,
    -inserer les resulats obtenus dans Portefeuille
    -supprimer les vues A,V,X

cette solution a neanmoins le desavantage de necessiter plus de resources machines
sur une large base de donnee. */

TRUNCATE Portefeuille;
CREATE VIEW A AS SELECT NumCompte, CodeValeur, SUM(Qte) QA, Montant, SUM(Montant)/SUM(Qte) AS PAM
                 FROM Operation
                 WHERE Nature = 'A'
                GROUP BY NumCompte, CodeValeur;

CREATE VIEW V AS SELECT NumCompte, CodeValeur, SUM(Qte) QV, Montant, SUM(Montant)/SUM(Qte) AS PAV
                 FROM Operation
                 WHERE Nature = 'V'
                 GROUP BY NumCompte, CodeValeur;

CREATE VIEW X AS
	SELECT A.NumCompte, A.CodeValeur, COALESCE(NULL, QA-QV, QA) AS Quantite, A.PAM
	FROM A LEFT JOIN V ON A.NumCompte = V.NumCompte AND A.CodeValeur=V.CodeValeur;
	
INSERT INTO Portefeuille SELECT * FROM X;

DROP VIEW A,V,X;

/* mise a jour de Compte.Solde*/
UPDATE Compte SET Solde = CASE 
    WHEN (SELECT Nature FROM (SELECT * FROM Operation WHERE NoOpe = (SELECT MAX(NoOpe) FROM Operation))test ) ='A'
    THEN Solde-(SELECT Montant FROM (SELECT * FROM Operation WHERE NoOpe = (SELECT MAX(NoOpe) FROM Operation))test ) 
    
    WHEN (SELECT Nature FROM (SELECT * FROM Operation WHERE NoOpe = (SELECT MAX(NoOpe) FROM Operation))test ) ='V'
    THEN Solde+(SELECT Montant FROM (SELECT * FROM Operation WHERE NoOpe = (SELECT MAX(NoOpe) FROM Operation))test )
END
WHERE NumCompte = (SELECT NumCompte FROM (SELECT * FROM Operation WHERE NoOpe = (SELECT MAX(NoOpe) FROM Operation))test );


/* mise a jour de Compte.PMVR*/
CREATE VIEW A AS SELECT NumCompte, SUM(Montant) MA FROM Operation WHERE Nature = 'A' GROUP BY NumCompte;
CREATE VIEW V AS SELECT NumCompte, SUM(Montant) MV FROM Operation WHERE Nature = 'V' GROUP BY NumCompte;
CREATE VIEW M AS SELECT A.NumCompte, COALESCE(NULL, MA-MV, MA) AS 'Montant'  FROM A LEFT JOIN V ON A.NumCompte = V.NumCompte ;
CREATE VIEW QPAM AS SELECT NumCompte, SUM(Quantite*PAM) AS 'R' FROM Portefeuille GROUP BY NumCompte ;
CREATE VIEW X AS SELECT QPAM.NumCompte, Montant-R AS NEW FROM M JOIN QPAM ON M.NumCompte=QPAM.NumCompte;

UPDATE Compte SET PMVR=(SELECT NEW FROM X WHERE NumCompte = (SELECT NumCompte FROM (SELECT * FROM Operation WHERE NoOpe = (SELECT MAX(NoOpe) FROM Operation))test ) )
 WHERE NumCompte=(SELECT NumCompte FROM (SELECT * FROM Operation WHERE NoOpe = (SELECT MAX(NoOpe) FROM Operation))test );

DROP VIEW A,V,M,QPAM,X;









/* plus bas, on repete d'autres operations, differentes operations pour des clients differents */
INSERT INTO `Client` (`NumClient`, `NomClient`, `Ville`) VALUES
('103', 'PasLesMoyens', 'Metz');

INSERT INTO `Operation` (`NoOpe`, `NumCompte`, `CodeValeur`, `DateOpe`, `Nature`, `Qte`, `Montant`) VALUES
(3, '1', 'RNO', '2018-10-18', 'A', 20, 1400.00),
(4, '2', 'EDF', '2018-07-18', 'A', 200, 3000.00),
(5, '2', 'EDF', '2018-10-18', 'V', 100, 1400.00),
(6, '2', 'RNO', '2018-09-18', 'A', 30, 1800.00),
(7, '2', 'RNO', '2018-10-30', 'V', 30, 2100.00);

/* apres toutes ces operations, ou comme ici apres un ensemble d'operation, 
   on remet les tables Portefeuille et compte a jour avec les calculs precedents*/

/* mise a jour de Portefeuille */
TRUNCATE Portefeuille;
CREATE VIEW A AS SELECT NumCompte, CodeValeur, SUM(Qte) QA, Montant, SUM(Montant)/SUM(Qte) AS PAM
                 FROM Operation
                 WHERE Nature = 'A'
                GROUP BY NumCompte, CodeValeur;

CREATE VIEW V AS SELECT NumCompte, CodeValeur, SUM(Qte) QV, Montant, SUM(Montant)/SUM(Qte) AS PAV
                 FROM Operation
                 WHERE Nature = 'V'
                 GROUP BY NumCompte, CodeValeur;

CREATE VIEW X AS
	SELECT A.NumCompte, A.CodeValeur, COALESCE(NULL, QA-QV, QA) AS Quantite, A.PAM
	FROM A LEFT JOIN V ON A.NumCompte = V.NumCompte AND A.CodeValeur=V.CodeValeur;
	
INSERT INTO Portefeuille SELECT * FROM X;
DROP VIEW A,V,X;



/* mise a jour de Compte.Solde*/
UPDATE Compte SET Solde = CASE 
    WHEN (SELECT Nature FROM (SELECT * FROM Operation WHERE NoOpe = (SELECT MAX(NoOpe) FROM Operation))test ) ='A'
    THEN Solde-(SELECT Montant FROM (SELECT * FROM Operation WHERE NoOpe = (SELECT MAX(NoOpe) FROM Operation))test ) 
    
    WHEN (SELECT Nature FROM (SELECT * FROM Operation WHERE NoOpe = (SELECT MAX(NoOpe) FROM Operation))test ) ='V'
    THEN Solde+(SELECT Montant FROM (SELECT * FROM Operation WHERE NoOpe = (SELECT MAX(NoOpe) FROM Operation))test )
END
WHERE NumCompte = (SELECT NumCompte FROM (SELECT * FROM Operation WHERE NoOpe = (SELECT MAX(NoOpe) FROM Operation))test );


/* mise a jour de Compte.PMVR*/
CREATE VIEW A AS SELECT NumCompte, SUM(Montant) MA FROM Operation WHERE Nature = 'A' GROUP BY NumCompte;
CREATE VIEW V AS SELECT NumCompte, SUM(Montant) MV FROM Operation WHERE Nature = 'V' GROUP BY NumCompte;
CREATE VIEW M AS SELECT A.NumCompte, COALESCE(NULL, MA-MV, MA) AS 'Montant'  FROM A LEFT JOIN V ON A.NumCompte = V.NumCompte ;
CREATE VIEW QPAM AS SELECT NumCompte, SUM(Quantite*PAM) AS 'R' FROM Portefeuille GROUP BY NumCompte ;
CREATE VIEW X AS SELECT QPAM.NumCompte, Montant-R AS NEW FROM M JOIN QPAM ON M.NumCompte=QPAM.NumCompte;

UPDATE Compte SET PMVR=(SELECT NEW FROM X WHERE NumCompte = (SELECT NumCompte FROM (SELECT * FROM Operation WHERE NoOpe = (SELECT MAX(NoOpe) FROM Operation))test ) )
 WHERE NumCompte=(SELECT NumCompte FROM (SELECT * FROM Operation WHERE NoOpe = (SELECT MAX(NoOpe) FROM Operation))test );
DROP VIEW A,V,M,QPAM,X;







