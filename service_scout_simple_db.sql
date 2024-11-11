-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 11, 2024 at 10:00 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `service_scout_simple_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `request`
--

CREATE TABLE `request` (
  `requestId` bigint(20) NOT NULL,
  `customer_id` bigint(20) NOT NULL,
  `contractor_id` bigint(20) NOT NULL,
  `description` varchar(255) NOT NULL,
  `status` varchar(50) DEFAULT 'PENDING',
  `request_id` bigint(20) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `request`
--

INSERT INTO `request` (`requestId`, `customer_id`, `contractor_id`, `description`, `status`, `request_id`, `created_at`) VALUES
(1, 2, 3, 'Fixing plumbing issue', 'PENDING', 1, '2024-11-11 15:53:22.000000');

-- --------------------------------------------------------

--
-- Table structure for table `request_seq`
--

CREATE TABLE `request_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `request_seq`
--

INSERT INTO `request_seq` (`next_val`) VALUES
(51);

-- --------------------------------------------------------

--
-- Table structure for table `review`
--

CREATE TABLE `review` (
  `reviewId` bigint(20) NOT NULL,
  `reviewer_id` bigint(20) NOT NULL,
  `contractor_id` bigint(20) NOT NULL,
  `textBody` text DEFAULT NULL,
  `rating` int(11) NOT NULL CHECK (`rating` between 1 and 5),
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `review_id` bigint(20) NOT NULL,
  `text_body` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `review`
--

INSERT INTO `review` (`reviewId`, `reviewer_id`, `contractor_id`, `textBody`, `rating`, `created_at`, `review_id`, `text_body`) VALUES
(1, 2, 3, NULL, 5, '2024-11-11 20:54:55', 2, 'The contractor was professional and did a great job. Highly recommended!');

-- --------------------------------------------------------

--
-- Table structure for table `review_seq`
--

CREATE TABLE `review_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `review_seq`
--

INSERT INTO `review_seq` (`next_val`) VALUES
(101);

-- --------------------------------------------------------

--
-- Table structure for table `specialty`
--

CREATE TABLE `specialty` (
  `specialtyId` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `specialty_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `specialty`
--

INSERT INTO `specialty` (`specialtyId`, `name`, `description`, `specialty_id`) VALUES
(1, 'Electrician', NULL, 1);

-- --------------------------------------------------------

--
-- Table structure for table `specialty_seq`
--

CREATE TABLE `specialty_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `specialty_seq`
--

INSERT INTO `specialty_seq` (`next_val`) VALUES
(51);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userId` bigint(20) NOT NULL,
  `userName` varchar(100) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `phoneNumber` varchar(15) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `role` varchar(255) NOT NULL,
  `accountStatus` varchar(50) DEFAULT 'active',
  `user_id` bigint(20) NOT NULL,
  `account_status` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userId`, `userName`, `password`, `phoneNumber`, `email`, `address`, `role`, `accountStatus`, `user_id`, `account_status`, `phone_number`, `user_name`) VALUES
(1, NULL, 'securepassword123', NULL, 'alice.walker@example.com', '123 Main St, Springfield, IL', 'user', 'active', 2, 'active', '234-567-8901', 'alice_walker'),
(2, NULL, 'mypassword789', NULL, 'john.smith@contractor.com', '456 Elm St, Denver, CO', 'contractor', 'active', 3, 'active', '345-678-9012', 'john_smith');

-- --------------------------------------------------------

--
-- Table structure for table `user_seq`
--

CREATE TABLE `user_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_seq`
--

INSERT INTO `user_seq` (`next_val`) VALUES
(101);

-- --------------------------------------------------------

--
-- Table structure for table `user_specialty`
--

CREATE TABLE `user_specialty` (
  `user_id` bigint(20) NOT NULL,
  `specialty_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_specialty`
--

INSERT INTO `user_specialty` (`user_id`, `specialty_id`) VALUES
(3, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `request`
--
ALTER TABLE `request`
  ADD PRIMARY KEY (`requestId`);

--
-- Indexes for table `review`
--
ALTER TABLE `review`
  ADD PRIMARY KEY (`reviewId`);

--
-- Indexes for table `specialty`
--
ALTER TABLE `specialty`
  ADD PRIMARY KEY (`specialtyId`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userId`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `user_specialty`
--
ALTER TABLE `user_specialty`
  ADD PRIMARY KEY (`user_id`,`specialty_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `request`
--
ALTER TABLE `request`
  MODIFY `requestId` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `review`
--
ALTER TABLE `review`
  MODIFY `reviewId` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `specialty`
--
ALTER TABLE `specialty`
  MODIFY `specialtyId` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `userId` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
