-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 08, 2022 at 01:08 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gamehex`
--

-- --------------------------------------------------------

--
-- Table structure for table `articles`
--

CREATE TABLE `articles` (
  `articleID` int(50) NOT NULL,
  `content` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `articles`
--

INSERT INTO `articles` (`articleID`, `content`) VALUES
(8, 'Yasmine Daly is da best'),
(10, 'hello everyone here u can express ur thoughts'),
(11, 'i miss you guysssss');

-- --------------------------------------------------------

--
-- Table structure for table `coach`
--

CREATE TABLE `coach` (
  `coachId` int(9) NOT NULL,
  `rating` float NOT NULL,
  `userID` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `coach`
--

INSERT INTO `coach` (`coachId`, `rating`, `userID`) VALUES
(107, 0, 63),
(109, 0, 47);

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `userID` int(11) NOT NULL,
  `articleID` int(11) NOT NULL,
  `like` int(11) NOT NULL,
  `dislike` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `games`
--

CREATE TABLE `games` (
  `contentID` int(11) NOT NULL,
  `contentTitle` varchar(100) NOT NULL,
  `contentDate` date NOT NULL,
  `gamingContent` blob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `info`
--

CREATE TABLE `info` (
  `contentID` int(11) NOT NULL,
  `contentTitle` varchar(100) NOT NULL,
  `contentDate` date NOT NULL,
  `infoContent` longtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `matches`
--

CREATE TABLE `matches` (
  `matchid` int(11) NOT NULL,
  `team1` int(11) NOT NULL,
  `team2` int(11) NOT NULL,
  `matchres` varchar(255) NOT NULL,
  `matchcom` varchar(300) NOT NULL,
  `matchdate` date NOT NULL DEFAULT current_timestamp(),
  `matchtime` time NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id_product` int(11) NOT NULL,
  `ref` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `description` varchar(100) NOT NULL,
  `price` int(11) NOT NULL,
  `review` int(11) NOT NULL,
  `state` varchar(20) NOT NULL,
  `id_supplier` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id_product`, `ref`, `name`, `description`, `price`, `review`, `state`, `id_supplier`) VALUES
(1, 'RD1234', 'yaourt', 'desc1', 20, 5, 'Availble', 0),
(8, 'Rb747', 'Laptop', 'Echri terbah', 2000, 9, 'Availble', 1);

-- --------------------------------------------------------

--
-- Table structure for table `session`
--

CREATE TABLE `session` (
  `sessionId` int(9) NOT NULL,
  `startTime` time NOT NULL,
  `Date` date NOT NULL,
  `rating` float NOT NULL,
  `coachId` int(9) NOT NULL,
  `userID` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `session`
--

INSERT INTO `session` (`sessionId`, `startTime`, `Date`, `rating`, `coachId`, `userID`) VALUES
(46, '01:38:00', '2022-03-10', 0, 109, 0),
(47, '02:52:00', '2022-03-18', 0, 107, 0),
(49, '13:44:00', '2022-03-02', 0, 107, 0),
(50, '13:48:00', '2022-03-03', 0, 107, 0),
(51, '16:52:00', '2022-03-18', 0, 107, 0),
(52, '16:57:00', '2022-03-17', 0, 107, 0);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `id_supplier` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `start_date` date DEFAULT NULL,
  `leave_date` date DEFAULT NULL,
  `nbr_units_sold` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`id_supplier`, `name`, `start_date`, `leave_date`, `nbr_units_sold`) VALUES
(1, 'HP', '2022-02-01', '2022-02-28', 0),
(2, 'Dell', '2022-02-28', '2022-03-28', 4);

-- --------------------------------------------------------

--
-- Table structure for table `teammembers`
--

CREATE TABLE `teammembers` (
  `riotId` int(11) NOT NULL,
  `memberRole` varchar(255) NOT NULL,
  `memberPhone` int(11) NOT NULL,
  `memberMail` varchar(255) NOT NULL,
  `teamId` int(11) NOT NULL,
  `userID` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `teammembers`
--

INSERT INTO `teammembers` (`riotId`, `memberRole`, `memberPhone`, `memberMail`, `teamId`, `userID`) VALUES
(2133, 'Captain', 51908081, 'yasmine@esprit.tn', 35, 63),
(1312, 'Player', 98776654, 'aziz@esprit.tn', 35, 63),
(1323, 'Player', 98090797, 'moudhaffer@esprit.tn', 35, 63),
(1232, 'Player', 56786678, 'ramy@esprit.tn', 35, 63),
(2313, 'Player', 40987907, 'skander@esprit.tn', 35, 63),
(2313, 'Player', 70919872, 'amine@esprit.tn', 35, 63),
(1234, 'Captain', 51908081, 'cap@esprit.tn', 36, 61),
(5442, 'Player', 98776672, 'player1@gmail.com', 36, 61),
(8765, 'Player', 98736823, 'player2@gmail.com', 36, 61),
(4323, 'Player', 55788493, 'player3@gmail.com', 36, 61),
(9776, 'Player', 98337583, 'player4@gmail.com', 36, 61),
(5333, 'Player', 98373783, 'player5@gmail.com', 36, 61);

-- --------------------------------------------------------

--
-- Table structure for table `teams`
--

CREATE TABLE `teams` (
  `teamId` int(11) NOT NULL,
  `teamName` varchar(255) NOT NULL,
  `teamTag` varchar(3) NOT NULL,
  `teamMail` varchar(255) NOT NULL,
  `teamReg` varchar(255) NOT NULL,
  `userID` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `teams`
--

INSERT INTO `teams` (`teamId`, `teamName`, `teamTag`, `teamMail`, `teamReg`, `userID`) VALUES
(35, 'TeamYasmine', 'jaz', 'yasmine@esprit.tn', 'Sousse', 63),
(36, 'Pentagon', 'ptg', 'pentagon@esprit.tn', 'Ariana', 61);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userID` int(9) NOT NULL,
  `name` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `CIN` int(12) NOT NULL,
  `phone` int(8) NOT NULL,
  `date` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `pwd` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL DEFAULT 'CLIENT'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userID`, `name`, `lastName`, `CIN`, `phone`, `date`, `email`, `pwd`, `role`) VALUES
(47, 'admin1', 'admin1', 111, 111, '2022-03-01', 'admin1@esprit.tn', 'e0cf25ad42683b3df678c61f42c6bda', 'COACH'),
(48, 'admin2', 'admin2', 222, 222, '2022-03-02', 'admin2@esprit.tn', 'c84258e9c39059a89ab77d846ddab99', 'CLIENT'),
(49, 'ramy', 'bh', 15999999, 15999999, '2022-03-24', 'ramy@esprit.tn', '523abbf5102c72e2697b93cc70702219', 'CLIENT'),
(50, 'ramy', 'bh', 789, 789, '2022-03-03', 'rambo25bh@gmail.com', 'd145c5e1104931b93db2bf3ffba7bc6', 'CLIENT'),
(51, 'ramy', 'bh', 456, 456, '2022-03-04', 'ramy.benhassine@esprit.tn', 'd145c5e1104931b93db2bf3ffba7bc6', 'CLIENT'),
(56, 'abir', 'ka', 12345678, 12345678, '2022-03-08', 'abiresprit.tn', '1cc759abc93da14bb5bd987113144', 'CLIENT'),
(57, 'lina', 'kalech', 44578958, 44578958, '2022-03-16', 'lina@esprit.tn', '2fadd5d08c1e4be63018a92edaabf79f', 'CLIENT'),
(59, 'med', 'ka', 12345678, 12345677, '2022-03-03', 'med@esprit.tn', 'd9dce9351b2d70a0188ce64b4f7bbdf7', 'CLIENT'),
(61, 'anas', 'br', 78945612, 78945612, '2022-03-02', 'anas@esprit.tn', '76eb649c47cbecad7c36e71374bc9a5', 'CLIENT'),
(63, 'Yasmine', 'Daly', 12345678, 51908081, '2022-02-28', 'yasmine@esprit.tn', '7dfc6d74628885f45b85e3d3ffbb947b', 'COACH'),
(64, 'hanine', 'abidi', 34871234, 13095347, '12/08/1999', 'hanine.abidi@esprit.tn', '7f66c619ee3c36dc7421e021b78b', 'ADMIN'),
(67, 'Jasmin', 'Quinn', 9098787, 98341625, '2022-03-16', 'gamehex2022@gmail.com', '7dfc6d74628885f45b85e3d3ffbb947b', 'ADMIN'),
(68, 'ramy', 'bh', 456, 456, '2022-03-04', 'ramy.benhassine@esprit.tn', 'd145c5e1104931b93db2bf3ffba7bc6', 'CLIENT'),
(69, 'Coach', 'Pro', 12345678, 90787989, '2022-03-09', 'coach@esprit.tn', 'f931b13aead02d7fcdb2f84ef794f', 'CLIENT');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `articles`
--
ALTER TABLE `articles`
  ADD PRIMARY KEY (`articleID`);

--
-- Indexes for table `coach`
--
ALTER TABLE `coach`
  ADD PRIMARY KEY (`coachId`),
  ADD KEY `FK_coach_user` (`userID`);

--
-- Indexes for table `feedback`
--
ALTER TABLE `feedback`
  ADD KEY `userID` (`userID`),
  ADD KEY `articleID` (`articleID`);

--
-- Indexes for table `games`
--
ALTER TABLE `games`
  ADD PRIMARY KEY (`contentID`);

--
-- Indexes for table `info`
--
ALTER TABLE `info`
  ADD PRIMARY KEY (`contentID`);

--
-- Indexes for table `matches`
--
ALTER TABLE `matches`
  ADD PRIMARY KEY (`matchid`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id_product`),
  ADD KEY `id_supplier` (`id_supplier`);

--
-- Indexes for table `session`
--
ALTER TABLE `session`
  ADD PRIMARY KEY (`sessionId`),
  ADD KEY `FK_session_coach` (`coachId`),
  ADD KEY `FK_session_user` (`userID`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id_supplier`);

--
-- Indexes for table `teammembers`
--
ALTER TABLE `teammembers`
  ADD KEY `team_members_FK` (`teamId`);

--
-- Indexes for table `teams`
--
ALTER TABLE `teams`
  ADD PRIMARY KEY (`teamId`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `articles`
--
ALTER TABLE `articles`
  MODIFY `articleID` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `coach`
--
ALTER TABLE `coach`
  MODIFY `coachId` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=110;

--
-- AUTO_INCREMENT for table `matches`
--
ALTER TABLE `matches`
  MODIFY `matchid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id_product` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `session`
--
ALTER TABLE `session`
  MODIFY `sessionId` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `id_supplier` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `teams`
--
ALTER TABLE `teams`
  MODIFY `teamId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `userID` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `coach`
--
ALTER TABLE `coach`
  ADD CONSTRAINT `FK_coach_user` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `feedback`
--
ALTER TABLE `feedback`
  ADD CONSTRAINT `feedback_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`),
  ADD CONSTRAINT `feedback_ibfk_2` FOREIGN KEY (`articleID`) REFERENCES `articles` (`articleID`);

--
-- Constraints for table `session`
--
ALTER TABLE `session`
  ADD CONSTRAINT `FK_session_coach` FOREIGN KEY (`coachId`) REFERENCES `coach` (`coachId`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_session_user` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `teammembers`
--
ALTER TABLE `teammembers`
  ADD CONSTRAINT `team_members_FK` FOREIGN KEY (`teamId`) REFERENCES `teams` (`teamId`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
