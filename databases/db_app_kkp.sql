-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Mar 05, 2020 at 05:57 PM
-- Server version: 10.1.40-MariaDB
-- PHP Version: 7.1.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_app_kkp`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_data_stock`
--

CREATE TABLE `tbl_data_stock` (
  `id_stock` int(11) NOT NULL,
  `id_outlet` int(20) NOT NULL,
  `stock_awal` int(11) NOT NULL,
  `stock_akhir` int(11) NOT NULL,
  `id_barang` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_data_stock`
--

INSERT INTO `tbl_data_stock` (`id_stock`, `id_outlet`, `stock_awal`, `stock_akhir`, `id_barang`) VALUES
(1, 1, 100, 0, 1),
(2, 2, 20, 0, 2);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_master_barang`
--

CREATE TABLE `tbl_master_barang` (
  `id_barang` int(11) NOT NULL,
  `nama_barang` text NOT NULL,
  `kategori` text NOT NULL,
  `harga_satuan` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_master_barang`
--

INSERT INTO `tbl_master_barang` (`id_barang`, `nama_barang`, `kategori`, `harga_satuan`) VALUES
(1, 'Air Mineral', 'Beverage', 2000),
(2, 'Ayam-DADA', 'Food', 11000),
(3, 'Ayam-DADA SADIZ', 'Food', 13500),
(4, 'Ayam-DADA SALJU', 'Food', 13500),
(5, 'Ayam-PAHA ATAS', 'Food', 11000),
(6, 'Ayam-PAHA ATAS SADIZ', 'Food', 13500),
(7, 'Ayam-PAHA ATAS SALJU', 'Food', 13500),
(8, 'Ayam-PAHA BAWAH', 'Food', 9500),
(9, 'Ayam-PAHA BAWAH SADIZ', 'Food', 12000),
(10, 'Ayam-PAHA BAWAH SADIZ', 'Food', 12000),
(11, 'Ayam-SAYAP', 'Food', 8500),
(12, 'Ayam-SAYAP SADIZ', 'Food', 11000),
(13, 'Ayam-SAYAP SADIZ', 'Food', 11000),
(14, 'Beef Burger', 'Food', 8000),
(15, 'Cheese Burger', 'Food', 10000),
(16, 'Cheese Chicken Crispy Burger', 'Food', 10000),
(17, 'Chicken Crispy Burger', 'Food', 8000),
(18, 'Cola', 'Beverage', 0),
(19, 'Double Beef Burger', 'Food', 13000),
(20, 'Double Chicken Crispy Burger', 'Food', 13000),
(21, 'Gokil 1 (Nasi,Sayap)', 'Paket', 11500),
(22, 'Gokil 2 (Nasi,Paha Bawah)', 'Paket', 12500),
(23, 'Gokil 3 (Nasi,Dada)', 'Paket', 14000),
(24, 'Gokil 3 (Nasi,Paha Atas)', 'Paket', 14000),
(25, 'Goyang Super 1 (2 Sayap, Air Mineral)', 'Paket', 20000),
(26, 'Goyang Super 1 (2 Sayap, Ice Orange)', 'Paket', 20000),
(27, 'Goyang Super 1 (2 Sayap, Sweet Ice Tea)', 'Paket', 20000),
(28, 'Goyang Super 2 (1 Sayap + 1 Ph Bawah, Air Mineral)', 'Paket', 22000),
(29, 'Goyang Super 2 (1 Sayap + 1 Ph Bawah, Ice Orange)', 'Paket', 22000),
(30, 'Goyang Super 2 (1 Sayap + 1 Ph Bawah, Sweet Ice Tea)', 'Paket', 22000),
(31, 'Goyang Super 3 (1 Dada + 1 Ph Bawah, Air Mineral)', 'Paket', 24000),
(32, 'Goyang Super 3 (1 Dada + 1 Ph Bawah, Ice Orange)', 'Paket', 24000),
(33, 'Goyang Super 3 (1 Dada + 1 Ph Bawah, Sweet Ice Tea)', 'Paket', 24000),
(34, 'Goyang Super 3 (1 Dada + 1 Sayap, Air Mineral)', 'Paket', 24000),
(35, 'Goyang Super 3 (1 Dada + 1 Sayap, Ice Orange)', 'Paket', 24000),
(36, 'Goyang Super 3 (1 Dada + 1 Sayap, Sweet Ice Tea)', 'Paket', 24000),
(37, 'Goyang Super 3 (1 Ph Atas + 1 Ph Bawah, Air Mineral)', 'Paket', 24000),
(38, 'Goyang Super 3 (1 Ph Atas + 1 Ph Bawah, Ice Orange)', 'Paket', 24000),
(39, 'Goyang Super 3 (1 Ph Atas + 1 Ph Bawah, Sweet Ice Tea)', 'Paket', 24000),
(40, 'Goyang Super 3 (1 Ph Atas + 1 Sayap, Air Mineral)', 'Paket', 24000),
(41, 'Goyang Super 3 (1 Ph Atas + 1 Sayap, Ice Orange)', 'Paket', 24000),
(42, 'Goyang Super 3 (1 Ph Atas + 1 Sayap, Sweet Ice Tea)', 'Paket', 24000),
(43, 'Goyang 1 (2 Sayap)', 'Paket', 18000),
(44, 'Goyang 2 (1 Sayap + 1 Ph Bawah)', 'Paket', 20000),
(45, 'Goyang 3 (1 Dada+ 1 Ph Bawah)', 'Paket', 22000),
(46, 'Goyang 3 (1 Dada+ 1 Sayap)', 'Paket', 22000),
(47, 'Goyang 3 (1 Ph Atas+ 1 Ph Bawah)', 'Paket', 22000),
(48, 'Goyang 3 (1 Ph Atas+ 1 Sayap)', 'Paket', 22000),
(49, 'Ice Orange', 'Beverage', 2000),
(50, 'Kentang Ori', 'Food', 5000),
(51, 'Kentang Rasa', 'Food', 6000),
(52, 'Milky Go! Bubble Gum', 'Beverage', 6000),
(53, 'Milky Go! Coklat', 'Beverage', 6000),
(54, 'Milky Go! Green Tea', 'Beverage', 6000),
(55, 'Milky Go! Taro', 'Beverage', 6000),
(56, 'Milky Go! Thai Tea', 'Beverage', 3000),
(57, 'Nasi', 'Food', 4000),
(58, 'Rice 2 Go BBQ', 'Paket', 11000),
(59, 'Rice 2 Go Keju', 'Paket', 11000),
(60, 'Rice 2 Go Ori', 'Paket', 10000),
(61, 'Rice 2 Go Sadiz', 'Paket', 12500),
(62, 'SADIZ (Saos Pedas Abiz)', 'Food', 2500),
(63, 'Sadiz 1 (Nasi,Sayap Sadiz)', 'Paket', 14000),
(64, 'Sadiz 2 (Nasi,Paha Bawah Sadiz)', 'Paket', 15000),
(65, 'Sadiz 3 (Nasi,Dada Sadiz)', 'Paket', 16500),
(66, 'Sadiz 3 (Nasi,Paha Atas Sadiz)', 'Paket', 16500),
(67, 'SALJU (Saos Lumer Keju)', 'Food', 2500),
(68, 'Salju 1 (Nasi,Sayap,Salju)', 'Paket', 14000),
(69, 'Salju 2 (Nasi,Paha Bawah,Salju)', 'Paket', 15000),
(70, 'Salju 3 (Nasi,Dada,Salju)', 'Paket', 16500),
(71, 'Salju 3 (Nasi,Paha Atas,Salju)', 'Paket', 16500),
(72, 'Sosis Keju', 'Food', 6000),
(73, 'Sosis Ori', 'Food', 5000),
(74, 'Stee', 'Beverage', 0),
(75, 'Super Gokil 1 (Nasi,Sayap,Air Mineral)', 'Paket', 13000),
(76, 'Super Gokil 1 (Nasi,Sayap,Ice Orange)', 'Paket', 13000),
(77, 'Super Gokil 1 (Nasi,Sayap,Sweet Ice Tea)', 'Paket', 13000),
(78, 'Super Gokil 2 (Nasi,Paha Bawah,Air Mineral 330 ml)', 'Paket', 14000),
(79, 'Super Gokil 2 (Nasi,Paha Bawah,Ice Orange)', 'Paket', 14000),
(80, 'Super Gokil 2 (Nasi,Paha Bawah,Sweet Ice Tea)', 'Paket', 14000),
(81, 'Super Gokil 3 (Dada,Air Mineral 330 ml)', 'Paket', 15500),
(82, 'Super Gokil 3 (Dada,Ice Orange)', 'Paket', 15500),
(83, 'Super Gokil 3 (Dada,Sweet Ice Tea)', 'Paket', 15500),
(84, 'Super Gokil 3 (Paha Atas,Air Mineral 330 ml)', 'Paket', 15500),
(85, 'Super Gokil 3 (Paha Atas,Ice Orange)', 'Paket', 15500),
(86, 'Super Gokil 3 (Paha Atas,Sweet Ice Tea)', 'Paket', 15500),
(87, 'Sweet Ice Tea', 'Beverage', 2000),
(88, 'Minyak goreng', 'Additional barang', 10000),
(89, 'Gula', 'Additional barang', 3000),
(90, 'wewe', 'Beverage', 111);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_master_karyawan`
--

CREATE TABLE `tbl_master_karyawan` (
  `id_karyawan` int(11) NOT NULL,
  `nik` varchar(20) NOT NULL,
  `posisi` enum('admin','manager','kasir') NOT NULL,
  `nama_karyawan` text NOT NULL,
  `akses_password` varchar(50) NOT NULL,
  `nmr_tlp` char(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_master_karyawan`
--

INSERT INTO `tbl_master_karyawan` (`id_karyawan`, `nik`, `posisi`, `nama_karyawan`, `akses_password`, `nmr_tlp`) VALUES
(4, '2016', 'manager', 'azmi', '95192c98732387165bf8e396c0f2dad2', '82828282');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_master_outlet`
--

CREATE TABLE `tbl_master_outlet` (
  `id_outlet` int(11) NOT NULL,
  `nama_outlet` text NOT NULL,
  `kota` text NOT NULL,
  `alamat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_master_outlet`
--

INSERT INTO `tbl_master_outlet` (`id_outlet`, `nama_outlet`, `kota`, `alamat`) VALUES
(1, 'Let\'s Go Chicken  Outlet ASEM BARIS', 'Kota Administrasi Jakarta Selatan', 'Jl. Tebet Timur Dalam Raya No.4, RW.3, Tebet Tim., Kec. Tebet, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 12820'),
(3, 'Let\'s Go Chicken Cijantung', 'Kota Administrasi Jakarta Timur', 'mall cijantung ya');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_order_outlet`
--

CREATE TABLE `tbl_order_outlet` (
  `id_order_outlet` int(11) NOT NULL,
  `kd_order` varchar(20) NOT NULL,
  `id_outlet` int(11) NOT NULL,
  `jml_order` int(11) NOT NULL,
  `id_barang` int(11) NOT NULL,
  `id_karyawan` int(11) NOT NULL,
  `tanggal_order` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_pengeluaran`
--

CREATE TABLE `tbl_pengeluaran` (
  `id_pengeluaran` int(11) NOT NULL,
  `id_barang` int(11) NOT NULL,
  `kd_pengeluaran` varchar(20) NOT NULL,
  `qty` int(11) NOT NULL,
  `subtotal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_transaksi`
--

CREATE TABLE `tbl_transaksi` (
  `id_transaksi` int(11) NOT NULL,
  `id_outlet` int(11) NOT NULL,
  `id_barang` int(11) NOT NULL,
  `terjual` int(11) NOT NULL,
  `rusak` int(11) NOT NULL,
  `kd_pengeluaran` varchar(20) DEFAULT NULL,
  `karyawan_id` int(11) NOT NULL,
  `tgl_transaksi` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_data_stock`
--
ALTER TABLE `tbl_data_stock`
  ADD PRIMARY KEY (`id_stock`);

--
-- Indexes for table `tbl_master_barang`
--
ALTER TABLE `tbl_master_barang`
  ADD PRIMARY KEY (`id_barang`);

--
-- Indexes for table `tbl_master_karyawan`
--
ALTER TABLE `tbl_master_karyawan`
  ADD PRIMARY KEY (`id_karyawan`),
  ADD UNIQUE KEY `nik` (`nik`);

--
-- Indexes for table `tbl_master_outlet`
--
ALTER TABLE `tbl_master_outlet`
  ADD PRIMARY KEY (`id_outlet`);

--
-- Indexes for table `tbl_order_outlet`
--
ALTER TABLE `tbl_order_outlet`
  ADD PRIMARY KEY (`id_order_outlet`);

--
-- Indexes for table `tbl_pengeluaran`
--
ALTER TABLE `tbl_pengeluaran`
  ADD PRIMARY KEY (`id_pengeluaran`);

--
-- Indexes for table `tbl_transaksi`
--
ALTER TABLE `tbl_transaksi`
  ADD PRIMARY KEY (`id_transaksi`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_data_stock`
--
ALTER TABLE `tbl_data_stock`
  MODIFY `id_stock` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_master_barang`
--
ALTER TABLE `tbl_master_barang`
  MODIFY `id_barang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=91;

--
-- AUTO_INCREMENT for table `tbl_master_karyawan`
--
ALTER TABLE `tbl_master_karyawan`
  MODIFY `id_karyawan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tbl_master_outlet`
--
ALTER TABLE `tbl_master_outlet`
  MODIFY `id_outlet` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tbl_order_outlet`
--
ALTER TABLE `tbl_order_outlet`
  MODIFY `id_order_outlet` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_pengeluaran`
--
ALTER TABLE `tbl_pengeluaran`
  MODIFY `id_pengeluaran` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `tbl_transaksi`
--
ALTER TABLE `tbl_transaksi`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
