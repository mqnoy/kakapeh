-- query lihat semua list order atau barang masuk di outlet_id

select tbm.tgl_brg_masuk ,tbm.kd_order,tbm.det_stock_kd, mo.nm_outlet,tbm.order,tmb.nm_barang from tbl_brg_masuk tbm 
LEFT join tbl_master_outlet mo ON tbm.outlet_id = mo.id_outlet 
LEFT join tbl_master_barang tmb ON tbm.barang_id = tmb.id_barang