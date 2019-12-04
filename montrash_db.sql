-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 04, 2019 at 04:06 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `montrash_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `pengangkutan`
--

CREATE TABLE `pengangkutan` (
  `id` int(11) NOT NULL,
  `tanggal_pengangkutan` date NOT NULL,
  `status_angkut` tinyint(4) NOT NULL,
  `keterangan` text,
  `id_transaksi` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pengangkutan`
--

INSERT INTO `pengangkutan` (`id`, `tanggal_pengangkutan`, `status_angkut`, `keterangan`, `id_transaksi`) VALUES
(1, '2020-01-01', 1, 'Sampahnya ada di samping rumah pak', 1),
(2, '2020-01-01', 1, NULL, 2),
(3, '2020-01-28', 1, NULL, 1),
(4, '2020-01-28', 1, NULL, 4),
(8, '2020-03-14', 1, NULL, 11),
(9, '2020-03-14', 1, NULL, 10),
(10, '2020-01-14', 1, NULL, 12);

-- --------------------------------------------------------

--
-- Table structure for table `pengguna`
--

CREATE TABLE `pengguna` (
  `id` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `alamat` varchar(255) NOT NULL,
  `email` varchar(50) NOT NULL,
  `no_hp` varchar(20) NOT NULL,
  `password` varchar(255) NOT NULL,
  `status` varchar(20) NOT NULL DEFAULT 'aktif',
  `level` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pengguna`
--

INSERT INTO `pengguna` (`id`, `nama`, `alamat`, `email`, `no_hp`, `password`, `status`, `level`) VALUES
(1, 'Admin', 'PGA', 'admin@gmail.com', '085268579748', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', 'aktif', 'admin'),
(2, 'Naufal', 'Bojongsoang, Kab. Bandung', 'naufal@gmail.com', '08152345123', '745DE6038585A515FCD174F25AD92EEF50DE7B0A', 'aktif', 'user'),
(3, 'Furqoon', 'Bekasi', 'furqoon@gmail.com', '08153423678', 'CCA7FCF68F0D4F3927546EAC0DD87A40B60E462C', 'aktif', 'user'),
(4, 'Reza', 'Sekayu	', 'reza@gmail.com', '08153445678', 'B96DBF74436B3F73DB2F27C2FB7C966EB1F47360', 'aktif', 'user');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id` int(11) NOT NULL,
  `tanggal_transaksi` date DEFAULT NULL,
  `jumlah_bayar` float NOT NULL,
  `status_pembayaran` tinyint(4) NOT NULL,
  `id_pengguna` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id`, `tanggal_transaksi`, `jumlah_bayar`, `status_pembayaran`, `id_pengguna`) VALUES
(1, '2020-02-01', 20000, 1, 2),
(2, '2019-12-03', 20000, 1, 3),
(4, '2020-01-02', 20000, 1, 3),
(10, '2020-03-01', 20000, 1, 2),
(11, '2020-03-01', 20000, 1, 3),
(12, '2020-01-02', 20000, 1, 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pengangkutan`
--
ALTER TABLE `pengangkutan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_id_transaksi` (`id_transaksi`);

--
-- Indexes for table `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`id`),
  ADD KEY `email` (`email`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_id_pengguna` (`id_pengguna`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pengangkutan`
--
ALTER TABLE `pengangkutan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `pengguna`
--
ALTER TABLE `pengguna`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `pengangkutan`
--
ALTER TABLE `pengangkutan`
  ADD CONSTRAINT `fk_id_transaksi` FOREIGN KEY (`id_transaksi`) REFERENCES `transaksi` (`id`);

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `fk_id_pengguna` FOREIGN KEY (`id_pengguna`) REFERENCES `pengguna` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
