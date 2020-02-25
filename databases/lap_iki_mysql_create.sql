CREATE TABLE `tbl_master_barang` (
	`id_barang` int NOT NULL AUTO_INCREMENT,
	`nm_barang` TEXT NOT NULL,
	`ktg_barang` enum('Beverage','Food','Paket') NOT NULL,
	`hrg_pokok_brg` int NOT NULL,
	PRIMARY KEY (`id_barang`)
);

CREATE TABLE `tbl_stock` (
	`id_stock` int NOT NULL AUTO_INCREMENT,
	`stock_det_kd` varchar(20) NOT NULL,
	PRIMARY KEY (`id_stock`)
);

CREATE TABLE `tbl_master_karyawan` (
	`id_karyawan` int NOT NULL AUTO_INCREMENT,
	`nik` int NOT NULL UNIQUE,
	`nm_karyawan` TEXT NOT NULL,
	`akses_password` varchar(50) NOT NULL,
	`alamat_karyawan` TEXT NOT NULL,
	PRIMARY KEY (`id_karyawan`)
);

CREATE TABLE `tbl_brg_keluar` (
	`id_brg_keluar` int NOT NULL AUTO_INCREMENT,
	`outlet_id` int NOT NULL,
	`barang_id` int NOT NULL,
	`terpakai` int NOT NULL,
	`terjual` int NOT NULL,
	`karyawan_id` int NOT NULL,
	`tgl_brg_keluar` DATETIME NOT NULL,
	`selisih` int NOT NULL,
	PRIMARY KEY (`id_brg_keluar`)
);

CREATE TABLE `tbl_master_outlet` (
	`id_outlet` int NOT NULL AUTO_INCREMENT,
	`nm_outlet` TEXT NOT NULL,
	`kota` TEXT NOT NULL,
	`alamat_outlet` TEXT NOT NULL,
	`stock_id` int NOT NULL,
	PRIMARY KEY (`id_outlet`)
);

CREATE TABLE `tbl_brg_masuk` (
	`id_brg_masuk` int NOT NULL AUTO_INCREMENT,
	`outlet_id` int NOT NULL,
	`order` int NOT NULL,
	`id_outlet` int NOT NULL,
	`barang_id` int NOT NULL,
	`karyawan_id` int NOT NULL,
	`tgl_brg_masuk` int NOT NULL,
	PRIMARY KEY (`id_brg_masuk`)
);

CREATE TABLE `tbl_detail_stock` (
	`id_det_stock` int NOT NULL AUTO_INCREMENT,
	`kd_det_stock` varchar(20) NOT NULL,
	`stock_awal` int NOT NULL,
	`stock_akhir` int NOT NULL,
	`barang_id` int NOT NULL,
	PRIMARY KEY (`id_det_stock`)
);

ALTER TABLE `tbl_brg_keluar` ADD CONSTRAINT `tbl_brg_keluar_fk0` FOREIGN KEY (`outlet_id`) REFERENCES `tbl_master_outlet`(`id_outlet`);

ALTER TABLE `tbl_brg_keluar` ADD CONSTRAINT `tbl_brg_keluar_fk1` FOREIGN KEY (`barang_id`) REFERENCES `tbl_master_barang`(`id_barang`);

ALTER TABLE `tbl_brg_keluar` ADD CONSTRAINT `tbl_brg_keluar_fk2` FOREIGN KEY (`karyawan_id`) REFERENCES `tbl_master_karyawan`(`id_karyawan`);

ALTER TABLE `tbl_master_outlet` ADD CONSTRAINT `tbl_master_outlet_fk0` FOREIGN KEY (`stock_id`) REFERENCES `tbl_stock`(`id_stock`);

ALTER TABLE `tbl_brg_masuk` ADD CONSTRAINT `tbl_brg_masuk_fk0` FOREIGN KEY (`id_outlet`) REFERENCES `tbl_master_outlet`(`id_outlet`);

ALTER TABLE `tbl_brg_masuk` ADD CONSTRAINT `tbl_brg_masuk_fk1` FOREIGN KEY (`barang_id`) REFERENCES `tbl_master_barang`(`id_barang`);

ALTER TABLE `tbl_brg_masuk` ADD CONSTRAINT `tbl_brg_masuk_fk2` FOREIGN KEY (`karyawan_id`) REFERENCES `tbl_master_karyawan`(`id_karyawan`);

ALTER TABLE `tbl_detail_stock` ADD CONSTRAINT `tbl_detail_stock_fk0` FOREIGN KEY (`barang_id`) REFERENCES `tbl_master_barang`(`id_barang`);

