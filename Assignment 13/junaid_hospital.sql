-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 07, 2024 at 12:04 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `junaid_hospital`
--

-- --------------------------------------------------------

--
-- Table structure for table `appointments`
--

CREATE TABLE `appointments` (
  `id` int(11) NOT NULL,
  `type` varchar(250) DEFAULT NULL,
  `patient_id` int(11) DEFAULT NULL,
  `doctor_id` int(11) DEFAULT NULL,
  `date_time` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `amount` double UNSIGNED DEFAULT NULL,
  `appointment_id` int(11) DEFAULT NULL,
  `payer_name` varchar(250) NOT NULL,
  `date_time` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`amount`, `appointment_id`, `payer_name`, `date_time`) VALUES
(12121, 1, 'Me', '2024-10-06 15:02:51');

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `id` int(11) NOT NULL,
  `name` varchar(250) NOT NULL,
  `qualification` varchar(250) DEFAULT NULL,
  `designation` varchar(250) DEFAULT NULL,
  `salary` double NOT NULL,
  `department` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`id`, `name`, `qualification`, `designation`, `salary`, `department`) VALUES
(1, 'Dr. John Doe', 'MBBS', 'General Physician', 50000, 'General Medicine'),
(2, 'Dr. Jane Smith', 'MD', 'Cardiologist', 75000, 'Cardiology'),
(3, 'Dr. Alice Johnson', 'MD', 'Dermatologist', 60000, 'Dermatology'),
(4, 'Dr. Bob Brown', 'MS', 'Surgeon', 80000, 'Surgery'),
(5, 'Dr. Charlie Davis', 'PhD', 'Neurologist', 90000, 'Neurology'),
(6, 'Dr. Diana Evans', 'MBBS', 'Pediatrician', 55000, 'Pediatrics'),
(7, 'Dr. Eve Frank', 'MD', 'Oncologist', 95000, 'Oncology'),
(8, 'Dr. Frank Green', 'MS', 'Orthopedic Surgeon', 85000, 'Orthopedics'),
(9, 'Dr. George Hall', 'MD', 'Psychiatrist', 70000, 'Psychiatry'),
(10, 'Dr. Hannah Ivy', 'MBBS', 'Gynecologist', 65000, 'Gynecology'),
(11, 'Dr. Ian Jones', 'MD', 'Endocrinologist', 78000, 'Endocrinology'),
(12, 'Dr. Jack Kelly', 'MS', 'Neurosurgeon', 120000, 'Neurosurgery'),
(13, 'Dr. Kathy Lee', 'MBBS', 'General Practitioner', 52000, 'General Medicine'),
(14, 'Dr. Liam Martin', 'PhD', 'Immunologist', 88000, 'Immunology'),
(15, 'Dr. Mia Nelson', 'MD', 'Pulmonologist', 82000, 'Pulmonology'),
(16, 'Dr. Noah Olson', 'MS', 'Vascular Surgeon', 100000, 'Vascular Surgery'),
(17, 'Dr. Olivia Perry', 'MD', 'Radiologist', 74000, 'Radiology'),
(18, 'Dr. Paul Quinn', 'MBBS', 'Family Medicine', 53000, 'Family Medicine'),
(19, 'Dr. Quincy Reed', 'MD', 'Nephrologist', 90000, 'Nephrology'),
(20, 'Dr. Rachel Scott', 'PhD', 'Rheumatologist', 85000, 'Rheumatology'),
(21, 'Dr. Sam Taylor', 'MBBS', 'Ophthalmologist', 72000, 'Ophthalmology'),
(22, 'Dr. Tom Underwood', 'MD', 'Gastroenterologist', 78000, 'Gastroenterology'),
(23, 'Dr. Ursula Vance', 'MS', 'Plastic Surgeon', 110000, 'Plastic Surgery'),
(24, 'Dr. Victor White', 'PhD', 'Allergist', 68000, 'Allergy & Immunology'),
(25, 'Dr. Wendy Xander', 'MD', 'Anesthesiologist', 98000, 'Anesthesiology'),
(26, 'Dr. Xavier Young', 'MS', 'Trauma Surgeon', 115000, 'Trauma Surgery'),
(27, 'Dr. Yara Zane', 'MD', 'Pediatric Surgeon', 92000, 'Pediatric Surgery'),
(28, 'Dr. Zach Brown', 'PhD', 'Geneticist', 87000, 'Genetics'),
(29, 'Dr. Amber Clarke', 'MBBS', 'Urologist', 76000, 'Urology'),
(30, 'Dr. Brian Davis', 'MD', 'Hematologist', 80000, 'Hematology');

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `id` int(11) NOT NULL,
  `name` varchar(250) NOT NULL,
  `age` int(11) NOT NULL,
  `disease` varchar(250) DEFAULT NULL,
  `phone` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`id`, `name`, `age`, `disease`, `phone`) VALUES
(1, 'John Doe', 18, 'Cold', '12131'),
(2, 'Jane Smith', 22, 'Cold', '22132'),
(3, 'Alice Johnson', 30, 'Asthma', '33133'),
(4, 'Bob Brown', 45, 'Diabetes', '44134'),
(5, 'Charlie Davis', 27, 'Hypertension', '55135'),
(6, 'Diana Evans', 33, 'Allergy', '66136'),
(7, 'Eve Frank', 29, 'Flu', '77137'),
(8, 'Frank Green', 50, 'Cold', '88138'),
(9, 'George Hall', 60, 'Heart Disease', '99139'),
(10, 'Hannah Ivy', 25, 'Asthma', '10140'),
(11, 'Ian Jones', 40, 'Hypertension', '11141'),
(12, 'Jack Kelly', 32, 'Diabetes', '12142'),
(13, 'Kathy Lee', 19, 'Flu', '13143'),
(14, 'Liam Martin', 23, 'Cold', '14144'),
(15, 'Mia Nelson', 35, 'Asthma', '15145'),
(16, 'Noah Olson', 28, 'Hypertension', '16146'),
(17, 'Olivia Perry', 34, 'Allergy', '17147'),
(18, 'Paul Quinn', 47, 'Diabetes', '18148'),
(19, 'Quincy Reed', 55, 'Heart Disease', '19149'),
(20, 'Rachel Scott', 39, 'Asthma', '20150'),
(21, 'Sam Taylor', 26, 'Cold', '21151'),
(22, 'Tom Underwood', 31, 'Flu', '22152'),
(23, 'Ursula Vance', 38, 'Allergy', '23153'),
(24, 'Victor White', 48, 'Hypertension', '24154'),
(25, 'Wendy Xander', 52, 'Diabetes', '25155'),
(26, 'Xavier Young', 36, 'Heart Disease', '26156'),
(27, 'Yara Zane', 24, 'Flu', '27157'),
(28, 'Zach Brown', 43, 'Cold', '28158'),
(29, 'Amber Clarke', 30, 'Asthma', '29159'),
(30, 'Brian Davis', 27, 'Hypertension', '30160');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointments`
--
ALTER TABLE `appointments`
  ADD UNIQUE KEY `id` (`id`);

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD UNIQUE KEY `id` (`id`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD UNIQUE KEY `id` (`id`),
  ADD UNIQUE KEY `phone` (`phone`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
