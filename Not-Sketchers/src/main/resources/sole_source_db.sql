-- phpMyAdmin SQL Dump
-- version 5.1.1deb5ubuntu1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Apr 02, 2023 at 04:20 PM
-- Server version: 8.0.32-0ubuntu0.22.04.2
-- PHP Version: 8.1.2-1ubuntu2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sole_source_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `Customer_ID` int NOT NULL,
  `Customer_Forename` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `Customer_Lastname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `Customer_PhoneNumber` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `Customer_Email` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `Customer_Password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `Customer_AddressLine1` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `Customer_AddressLine2` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `Customer_Postcode` char(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `Customer_IsAdmin` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `Order_ID` int NOT NULL,
  `Customer_ID` int DEFAULT NULL,
  `Product_Name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `Quantity` int DEFAULT NULL,
  `Order_Date` timestamp NULL DEFAULT NULL,
  `Order_Status` enum('PROCESSED','SHIPPED','DONE') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `Product_ID` int NOT NULL,
  `Product_Name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `Product_Category` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `Product_Price` decimal(4,2) DEFAULT NULL,
  `Product_StockCount` int DEFAULT NULL,
  `Product_ImageFilePath` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `Gender` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `Size` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`Product_ID`, `Product_Name`, `Product_Category`, `Product_Price`, `Product_StockCount`, `Product_ImageFilePath`, `Gender`, `Size`) VALUES
(1, 'SoleSource High Heel 1s', 'High Heels', '25.00', 1, 'https://raw.githubusercontent.com/DevPinda/Not-Sketchers/main/Not-Sketchers/src/main/resources/static/img/heels_v2_1.jpeg', 'Female', 'UK 5'),
(2, 'SoleSource High Heel 2s', 'High Heels', '30.00', 5, 'https://raw.githubusercontent.com/DevPinda/Not-Sketchers/main/Not-Sketchers/src/main/resources/static/img/heels_v2_2_new.png', 'Female', 'UK 6'),
(3, 'SoleSource High Heel 3s', 'High Heels', '35.00', 9, 'https://raw.githubusercontent.com/DevPinda/Not-Sketchers/main/Not-Sketchers/src/main/resources/static/img/heels_v2_3.jpeg', 'Female', 'UK 7'),
(4, 'SoleSource High Heel 4s', 'High Heels', '20.00', 2, 'https://raw.githubusercontent.com/DevPinda/Not-Sketchers/main/Not-Sketchers/src/main/resources/static/img/heels_v2_4.jpeg', 'Female', 'UK 8'),
(5, 'SoleSource High Heel 5s', 'High Heels', '40.00', -1, 'https://raw.githubusercontent.com/DevPinda/Not-Sketchers/main/Not-Sketchers/src/main/resources/static/img/heels_v2_5.jpeg', 'Female', 'UK 9'),
(6, 'SoleSource Slider 1s', 'Sliders', '15.00', -1, 'https://raw.githubusercontent.com/DevPinda/Not-Sketchers/main/Not-Sketchers/src/main/resources/static/img/sliders_v2_1_new.png', 'Male', 'UK 10'),
(7, 'SoleSource Slider 2s', 'Sliders', '10.00', 8, 'https://raw.githubusercontent.com/DevPinda/Not-Sketchers/main/Not-Sketchers/src/main/resources/static/img/sliders_v2_2.jpeg', 'Male', 'UK 5'),
(8, 'SoleSource Slider 3s', 'Sliders', '17.00', 10, 'https://raw.githubusercontent.com/DevPinda/Not-Sketchers/main/Not-Sketchers/src/main/resources/static/img/sliders_v2_3_new.png', 'Both', 'UK 6'),
(9, 'SoleSource Slider 4s', 'Sliders', '7.00', 9, 'https://raw.githubusercontent.com/DevPinda/Not-Sketchers/main/Not-Sketchers/src/main/resources/static/img/sliders_v2_4_new.png', 'Both', 'UK 7'),
(10, 'SoleSource Slider 5s', 'Sliders', '12.50', 10, 'https://raw.githubusercontent.com/DevPinda/Not-Sketchers/main/Not-Sketchers/src/main/resources/static/img/sliders_v2_5.jpeg', 'Male', 'UK 8'),
(11, 'SoleSource Trainer 1s', 'Trainers', '37.00', 10, 'https://raw.githubusercontent.com/DevPinda/Not-Sketchers/main/Not-Sketchers/src/main/resources/static/img/trainers_v2_1_new.png', 'Both', 'UK 9'),
(12, 'SoleSource Trainer 2s', 'Trainers', '44.00', 10, 'https://raw.githubusercontent.com/DevPinda/Not-Sketchers/main/Not-Sketchers/src/main/resources/static/img/trainers_v2_2.jpeg', 'Male', 'UK 10'),
(13, 'SoleSource Trainer 3s', 'Trainers', '36.00', 10, 'https://raw.githubusercontent.com/DevPinda/Not-Sketchers/main/Not-Sketchers/src/main/resources/static/img/trainers_v2_3.jpeg', 'Both', 'UK 5'),
(14, 'SoleSource Trainer 4s', 'Trainers', '56.00', 10, 'https://raw.githubusercontent.com/DevPinda/Not-Sketchers/main/Not-Sketchers/src/main/resources/static/img/trainers_v2_4_new.png', 'Male', 'UK 6'),
(15, 'SoleSource Trainer 5s', 'Trainers', '67.00', 10, 'https://raw.githubusercontent.com/DevPinda/Not-Sketchers/main/Not-Sketchers/src/main/resources/static/img/trainers_v2_5_new.png', 'Male', 'UK 7'),
(16, 'SoleSource Flip Flop 1s', 'Flip Flops', '3.00', 10, 'https://raw.githubusercontent.com/DevPinda/Not-Sketchers/main/Not-Sketchers/src/main/resources/static/img/flip_flops_v2_1.jpeg', 'Both', 'UK 8'),
(17, 'SoleSource Flip Flop 2s', 'Flip Flops', '7.50', 10, 'https://raw.githubusercontent.com/DevPinda/Not-Sketchers/main/Not-Sketchers/src/main/resources/static/img/flip_flops_v2_2.jpeg', 'Female', 'UK 9'),
(18, 'SoleSource Flip Flop 3s', 'Flip Flops', '12.00', 10, 'https://raw.githubusercontent.com/DevPinda/Not-Sketchers/main/Not-Sketchers/src/main/resources/static/img/flip_flops_v2_3.jpeg', 'Female', 'UK 10'),
(19, 'SoleSource Flip Flop 4s', 'Flip Flops', '20.00', 10, 'https://raw.githubusercontent.com/DevPinda/Not-Sketchers/main/Not-Sketchers/src/main/resources/static/img/flip_flops_v2_4.jpeg', 'Female', 'UK 5'),
(20, 'SoleSource Flip Flop 5s', 'Flip Flops', '10.00', 10, 'https://raw.githubusercontent.com/DevPinda/Not-Sketchers/main/Not-Sketchers/src/main/resources/static/img/flip_flops_v2_5.jpeg', 'Both', 'UK 6'),
(21, 'SoleSource Football Boot 1s', 'Football Boots', '67.00', 10, 'https://raw.githubusercontent.com/DevPinda/Not-Sketchers/main/Not-Sketchers/src/main/resources/static/img/football_boots_v2_1.jpeg', 'Male', 'UK 7'),
(22, 'SoleSource Football Boot 2s', 'Football Boots', '75.00', 10, 'https://raw.githubusercontent.com/DevPinda/Not-Sketchers/main/Not-Sketchers/src/main/resources/static/img/football_boots_v2_2.jpeg', 'Male', 'UK 8'),
(23, 'SoleSource Football Boot 3s', 'Football Boots', '90.00', 9, 'https://raw.githubusercontent.com/DevPinda/Not-Sketchers/main/Not-Sketchers/src/main/resources/static/img/football_boots_v2_3.jpeg', 'Male', 'UK 9'),
(24, 'SoleSource Football Boot 4s', 'Football Boots', '83.00', 10, 'https://raw.githubusercontent.com/DevPinda/Not-Sketchers/main/Not-Sketchers/src/main/resources/static/img/football_boots_v2_4.jpeg', 'Male', 'UK 10'),
(25, 'SoleSource Football Boot 5s', 'Football Boots', '94.00', 10, 'https://raw.githubusercontent.com/DevPinda/Not-Sketchers/main/Not-Sketchers/src/main/resources/static/img/football_boots_v2_5.jpeg', 'Both', 'UK 5');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`Customer_ID`),
  ADD UNIQUE KEY `Customer_Email` (`Customer_Email`),
  ADD KEY `Customer_ID` (`Customer_ID`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`Order_ID`),
  ADD KEY `Order_ID` (`Order_ID`),
  ADD KEY `fk_orders_customer` (`Customer_ID`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`Product_ID`),
  ADD KEY `Product_ID` (`Product_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `Customer_ID` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `Order_ID` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `Product_ID` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `fk_orders_customer` FOREIGN KEY (`Customer_ID`) REFERENCES `customer` (`Customer_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
