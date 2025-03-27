-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3307
-- Généré le : jeu. 27 mars 2025 à 15:21
-- Version du serveur : 11.3.2-MariaDB
-- Version de PHP : 8.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `sdis`
--

-- --------------------------------------------------------

--
-- Structure de la table `caserne`
--

DROP TABLE IF EXISTS `caserne`;
CREATE TABLE IF NOT EXISTS `caserne` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `caserne`
--

INSERT INTO `caserne` (`id`, `nom`) VALUES
(1, 'Ifs'),
(2, 'Lisieux'),
(3, 'Le Hom'),
(4, 'Caen Folie Couvrechef');

-- --------------------------------------------------------

--
-- Structure de la table `intervention`
--

DROP TABLE IF EXISTS `intervention`;
CREATE TABLE IF NOT EXISTS `intervention` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `lieu` varchar(50) DEFAULT NULL,
  `date` varchar(99) DEFAULT NULL,
  `heure_appel` varchar(99) DEFAULT NULL,
  `heure_arrivee` varchar(99) DEFAULT NULL,
  `duree` varchar(99) DEFAULT NULL,
  `id_situation` int(250) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `intervention_ibfk_1` (`id_situation`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `intervention`
--

INSERT INTO `intervention` (`id`, `lieu`, `date`, `heure_appel`, `heure_arrivee`, `duree`, `id_situation`) VALUES
(1, 'Caen', '2025-03-04', '18h52', '19h02', '30min', 1),
(2, 'Paris', '2024-09-25', '11h02', '11h12', '45min', 2);

-- --------------------------------------------------------

--
-- Structure de la table `pompier`
--

DROP TABLE IF EXISTS `pompier`;
CREATE TABLE IF NOT EXISTS `pompier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bip` varchar(10) DEFAULT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `caserne_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_pom_caserne` (`caserne_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `pompier`
--

INSERT INTO `pompier` (`id`, `bip`, `nom`, `prenom`, `caserne_id`) VALUES
(1, NULL, 'LEROY', 'Pierrick', 1),
(2, NULL, 'MASSON', 'Bastien', 1),
(3, NULL, 'DUVAL', 'Matthias', 4),
(4, NULL, 'MADJI', 'Walid', 4),
(6, NULL, 'CHAUVEL', 'Jules', 1),
(7, NULL, 'CAUVIN', 'Nayah', 1),
(8, NULL, 'TRAORE', 'Sylvain', 3),
(9, NULL, 'BOULEAU', 'Line', 3),
(10, NULL, 'MANCEL', 'Florianne', 2),
(11, NULL, 'PONTIER', 'Claire', 2),
(12, NULL, 'BARON', 'Gwladys', 3),
(13, NULL, 'PASTOR', 'Lucas', 1),
(14, NULL, 'BAREAU', 'Mila', 1),
(15, NULL, 'CHgdgfdgdfgVEL', 'Julegdfdgfs', 1);

-- --------------------------------------------------------

--
-- Structure de la table `situation`
--

DROP TABLE IF EXISTS `situation`;
CREATE TABLE IF NOT EXISTS `situation` (
  `id` int(250) NOT NULL AUTO_INCREMENT,
  `type` varchar(99) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `situation`
--

INSERT INTO `situation` (`id`, `type`) VALUES
(1, 'Feu dans un appartement'),
(2, 'Feu de broussailes'),
(3, 'Ascenseur bloqué');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `pompier`
--
ALTER TABLE `pompier`
  ADD CONSTRAINT `fk_pom_caserne` FOREIGN KEY (`caserne_id`) REFERENCES `caserne` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
