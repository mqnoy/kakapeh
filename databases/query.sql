-- query lihat semua list order atau barang masuk di outlet_id

select tbm.tgl_brg_masuk ,tbm.kd_order,tbm.det_stock_kd, mo.nm_outlet,tbm.order,tmb.nm_barang from tbl_brg_masuk tbm 
LEFT join tbl_master_outlet mo ON tbm.outlet_id = mo.id_outlet 
LEFT join tbl_master_barang tmb ON tbm.barang_id = tmb.id_barang


--query untuk laporan 
SELECT 
transaksi.id_outlet,
outlet.nama_outlet,
transaksi.tgl_closing,
transaksi.t_transaksi,
pengeluaran.t_pengeluaran,
(transaksi.t_transaksi - pengeluaran.t_pengeluaran) as omsetbersih,
(transaksi.t_transaksi + pengeluaran.t_pengeluaran) as omsetkotor
FROM (
		SELECT id_outlet, tgl_closing,SUM(subtotal) as t_transaksi FROM tbl_transaksi WHERE id_outlet ='1' AND  tgl_closing ='2020-03-18'
	)  transaksi
	LEFT  JOIN 
	(
		SELECT id_outlet ,SUM(subtotal) as t_pengeluaran FROM tbl_pengeluaran WHERE id_outlet ='1' AND  tgl_pengeluaran ='2020-03-18'
	) pengeluaran
	USING (id_outlet)
	LEFT JOIN 
	(
		SELECT id_outlet, nama_outlet FROM tbl_master_outlet tmo GROUP BY id_outlet 
	) outlet
	ON outlet.id_outlet = transaksi.id_outlet