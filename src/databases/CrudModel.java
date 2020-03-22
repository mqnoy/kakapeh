/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databases;

import static applaporan.Form_master_barang.*;
import static applaporan.Form_master_barang.jTable_barang;
import static applaporan.Form_master_karyawan.*;
import static applaporan.Form_master_karyawan.jTable_karyawan;
import static applaporan.Form_master_outlet.*;
import static applaporan.Form_master_outlet.jTable_outlet;
import static applaporan.Form_outlet_order.jTable_barang_2;
import static applaporan.Form_outlet_order.jTable_order_draft;
import static applaporan.Form_outlet_order.jTable_outlet_2;
import static applaporan.Form_transaksi.jTable_barang_3;
import static applaporan.Form_transaksi.jTable_outlet3;
import static applaporan.Form_transaksi.jTable_pengeluaran;
import static applaporan.Form_transaksi.jTable_transaksi;
import static applaporan.Laporan.jTable_outlet4;
import static applaporan.Library.strTo_MD5;
import controller.MainController;
import static controller.MainController.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rifky <qnoy.rifky@gmail.com>
 */
public class CrudModel extends ConfigDatabase {

    public static final Connection conn = new ConfigDatabase().getConn();
    MainController mc = new MainController();
    /*
     *  global query
     */

    public static int countData(String pk, String table) {
        int totalData = 0;
        String sql = "SELECT count(" + pk + ") as total_data FROM " + table + "";
        ResultSet hasil;
        try {
            Statement stmt = conn.createStatement();
            hasil = stmt.executeQuery(sql);
            while (hasil.next()) {
                totalData = hasil.getInt("total_data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(sql + "=> " + totalData);

        return totalData;

    }
    /* end global query */
    /*
     *  CRUD AREA KARYAWAN
     */

    public static void createDataKaryawan() {
        char[] rawPass = txt_karyawan_password.getPassword();
        String inputPass = new String(rawPass);
        String md5pass = strTo_MD5(inputPass);
        try {
            String sql = "INSERT INTO tbl_master_karyawan (nik,posisi,nama_karyawan,akses_password,nmr_tlp) VALUES (?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, txt_karyawan_nik.getText());
            ps.setString(2, cb_karyawan_posisi.getSelectedItem().toString());
            ps.setString(3, txt_karyawan_nama.getText());
            ps.setString(4, md5pass);
            ps.setString(5, txt_karyawan_tlp.getText());

            int executeUpdate = ps.executeUpdate();
            if (executeUpdate > 0) {
                notifikasi_c_karyawan = true;
            } else {
                notifikasi_c_karyawan = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void readDataKaryawan(String var_selected, String var_keywords, JTable table) {
        DefaultTableModel tabmode = getDatatabel(table);
        String sql = null;
        try {
            if (var_keywords != null) {
                //query search
                sql = "SELECT * FROM tbl_master_karyawan WHERE nama_karyawan LIKE '%" + var_keywords + "%' ";
            } else {
                //query select smua data 
                sql = "SELECT * FROM tbl_master_karyawan ORDER BY posisi";
            }
            System.out.println(sql);

            ResultSet hasil = null;
            try {
                Statement stmt = conn.createStatement();
                hasil = stmt.executeQuery(sql);
            } catch (SQLException ex) {
                Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (hasil.next()) {
                int col0 = hasil.getInt("id_karyawan");
                String col1 = hasil.getString("nik");
                String col2 = hasil.getString("posisi");
                String col3 = hasil.getString("nama_karyawan");
                String col4 = hasil.getString("nmr_tlp");

                Object[] data = {col0, col1, col2, col3, col4};
                tabmode.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void updateDataKaryawan(int id, boolean ganti_pass) {
        String sql = "";
        String inputPass = "", md5pass = "";
        if (ganti_pass) {
            char[] rawPass = txt_karyawan_password.getPassword();
            inputPass = new String(rawPass);
            md5pass = strTo_MD5(inputPass);
            sql = "UPDATE tbl_master_karyawan SET nik=?, posisi=?, nama_karyawan=?,akses_password=?, nmr_tlp=? WHERE id_karyawan=" + id;
        } else {
            sql = "UPDATE tbl_master_karyawan SET nik=?, posisi=?, nama_karyawan=?, nmr_tlp=? WHERE id_karyawan=" + id;
        }
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            if (ganti_pass) {
                ps.setString(1, txt_karyawan_nik.getText());
                ps.setString(2, cb_karyawan_posisi.getSelectedItem().toString());
                ps.setString(3, txt_karyawan_nama.getText());
                ps.setString(4, md5pass);
                ps.setString(5, txt_karyawan_tlp.getText());

            } else {
                ps.setString(1, txt_karyawan_nik.getText());
                ps.setString(2, cb_karyawan_posisi.getSelectedItem().toString());
                ps.setString(3, txt_karyawan_nama.getText());
                ps.setString(4, txt_karyawan_tlp.getText());
            }

            int executeUpdate = ps.executeUpdate();
            if (executeUpdate > 0) {
                notifikasi_u_karyawan = true;
            } else {
                notifikasi_u_karyawan = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void deleteDataKaryawan(int id) {
        try {
            String sql = "DELETE FROM tbl_master_karyawan WHERE id_karyawan=" + id;
            PreparedStatement ps = conn.prepareStatement(sql);

            int executeUpdate = ps.executeUpdate();
            if (executeUpdate > 0) {
                notifikasi_d_karyawan = true;
            } else {
                notifikasi_d_karyawan = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /* END CRUD AREA KARYAWAN */

    /*
     *  CRUD AREA OUTLET
     */
    public static void createDataOutlet() {
        try {

            String sql = "INSERT INTO tbl_master_outlet (nama_outlet,kota,alamat) VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, txt_outlet_nama.getText());
            ps.setString(2, cb_outlet_kota.getSelectedItem().toString());
            ps.setString(3, txt_outlet_alamat.getText());

            int executeUpdate = ps.executeUpdate();
            if (executeUpdate > 0) {
                notifikasi_c_outlet = true;
            } else {
                notifikasi_c_outlet = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void readDataOutlet(String var_selected, String var_keywords, JTable table) {
        DefaultTableModel tabmode = getDatatabel(table);
        String sql = null;
        try {
            if (var_keywords != null) {
                //query search
                sql = "SELECT * FROM tbl_master_outlet WHERE nama_outlet LIKE '%" + var_keywords + "%' ";
            } else {
                //query select smua data 
                sql = "SELECT * FROM tbl_master_outlet";
            }
            System.out.println(sql);

            ResultSet hasil = null;
            try {
                Statement stmt = conn.createStatement();
                hasil = stmt.executeQuery(sql);
            } catch (SQLException ex) {
                Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            int NUMBERS = 1;
            while (hasil.next()) {
                int col0 = hasil.getInt("id_outlet");
                String col1 = hasil.getString("nama_outlet");
                String col2 = hasil.getString("kota");
                String col3 = hasil.getString("alamat");

                Object[] data = {col0, col1, col2, col3};
                tabmode.addRow(data);
                NUMBERS++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void updateDataOutlet(int id) {
        try {
            String sql = "UPDATE tbl_master_outlet SET nama_outlet=?, kota=?, alamat=? WHERE id_outlet=" + id;
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, txt_outlet_nama.getText());
            ps.setString(2, cb_outlet_kota.getSelectedItem().toString());
            ps.setString(3, txt_outlet_alamat.getText());

            int executeUpdate = ps.executeUpdate();
            if (executeUpdate > 0) {
                notifikasi_u_outlet = true;
            } else {
                notifikasi_u_outlet = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void deleteDataOutlet(int id) {
        try {
            String sql = "DELETE FROM tbl_master_outlet WHERE id_outlet=" + id;
            PreparedStatement ps = conn.prepareStatement(sql);

            int executeUpdate = ps.executeUpdate();
            if (executeUpdate > 0) {
                notifikasi_d_outlet = true;
            } else {
                notifikasi_d_outlet = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /* END CRUD AREA OUTLET */
    /*
     *  CRUD AREA BARANG
     */

    public static void createDataBarang() {
        try {

            String sql = "INSERT INTO tbl_master_barang (nama_barang,kategori,harga_satuan,satuan) VALUES (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, txt_brg_nm_barang.getText());
            ps.setString(2, cb_brg_kategori.getSelectedItem().toString());
            ps.setInt(3, Integer.parseInt(txt_brg_harga.getText().trim()));
            ps.setString(4, cb_brg_satuan.getSelectedItem().toString());

            int executeUpdate = ps.executeUpdate();
            if (executeUpdate > 0) {
                notifikasi_c_barang = true;
            } else {
                notifikasi_c_barang = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void readDataBarang(String var_kategory, String var_keywords, JTable table) {
        System.out.println("readDataBarang()=>" + var_kategory);
        DefaultTableModel tabmode = getDatatabel(table);
        String sql = null;
        try {
            if (var_kategory != null && var_keywords == null) {//untuk tampilan barang per kategory
                switch (var_kategory) {
                    case "menu":
                        sql = "SELECT * FROM tbl_master_barang WHERE kategori ='Beverage' OR kategori ='Food' OR kategori ='Paket'";
                        break;
                    case "material":
                        sql = "SELECT * FROM tbl_master_barang WHERE kategori ='Material'";
                        break;
                    case "additional":
                        //jika ada additional / uang tak terduga 
                        sql = "SELECT * FROM tbl_master_barang WHERE kategori ='Additional barang'";
                        break;
                }
            } else if (var_kategory != null && var_keywords != null) {//untuk pencarian per kategory
                switch (var_kategory) {
                    case "menu":
                        sql = "SELECT * FROM tbl_master_barang WHERE kategori ='Beverage' OR kategori ='Food' OR kategori ='Paket' AND nama_barang LIKE '%" + var_keywords + "%' ";
                        break;
                    case "material":
                        sql = "SELECT * FROM tbl_master_barang WHERE kategori ='Material' AND nama_barang LIKE '%" + var_keywords + "%' ";
                        break;
                    case "additional":
                        //jika ada additional / uang tak terduga 
                        sql = "SELECT * FROM tbl_master_barang WHERE kategori ='Additional barang' AND nama_barang LIKE '%" + var_keywords + "%' ";
                        break;
                }
            } else {//untuk master barang
                if (var_keywords != null) {
                    //query search
                    sql = "SELECT * FROM tbl_master_barang WHERE nama_barang LIKE '%" + var_keywords + "%' ";
                } else {
                    //query select smua data menu
                    sql = "SELECT * FROM tbl_master_barang ORDER BY nama_barang ASC";
                }
            }

            System.out.println(sql);

            ResultSet hasil = null;
            try {
                Statement stmt = conn.createStatement();
                hasil = stmt.executeQuery(sql);
            } catch (SQLException ex) {
                Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (hasil.next()) {
                int col0 = hasil.getInt("id_barang");
                String col1 = hasil.getString("nama_barang");
                String col2 = hasil.getString("kategori");
                String col3 = hasil.getString("harga_satuan");
                String col4 = hasil.getString("satuan");
                Object[] data = {col0, col1, col2, col3, col4};
                tabmode.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void updateDataBarang(int id) {
        try {
            String sql = "UPDATE tbl_master_barang SET nama_barang=?, kategori=?, harga_satuan=?, satuan=? WHERE id_barang=" + id;
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, txt_brg_nm_barang.getText());
            ps.setString(2, cb_brg_kategori.getSelectedItem().toString());
            ps.setInt(3, Integer.parseInt(txt_brg_harga.getText()));
            ps.setString(4, cb_brg_satuan.getSelectedItem().toString());

            int executeUpdate = ps.executeUpdate();
            if (executeUpdate > 0) {
                notifikasi_u_barang = true;
            } else {
                notifikasi_u_barang = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void deleteDataBarang(int id) {
        try {
            String sql = "DELETE FROM tbl_master_barang WHERE id_barang=" + id;
            PreparedStatement ps = conn.prepareStatement(sql);

            int executeUpdate = ps.executeUpdate();
            if (executeUpdate > 0) {
                notifikasi_d_barang = true;
            } else {
                notifikasi_d_barang = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /* END CRUD AREA BARANG */

    /*
     *  CRUD AREA PENGELUARAN 
     * 1= ada
     * 0= tidak ada
     */
    public static void createDataPengeluaran(int ada, String tglPengeluaran, int outletID) {
        int total_rowPengeluaran = jTable_pengeluaran.getRowCount();
        String sql = "";
        try {
            sql = "INSERT INTO tbl_pengeluaran (id_outlet,id_barang,qty,subtotal,tgl_pengeluaran) VALUES (?,?,?,?,?)";

            if (ada == 1) {

                conn.setAutoCommit(false);
                PreparedStatement ps = conn.prepareStatement(sql);

                for (int row = 0; row < total_rowPengeluaran; row++) {
                    String tglpengeluaran = tglPengeluaran;
                    int int_outlet_id = (Integer) jTable_pengeluaran.getValueAt(row, 0);
                    int int_brg_id = (Integer) jTable_pengeluaran.getValueAt(row, 1);
                    int int_qty = (Integer) jTable_pengeluaran.getValueAt(row, 2);
                    int int_subtotal = (Integer) jTable_pengeluaran.getValueAt(row, 3);

                    ps.setInt(1, int_outlet_id);
                    ps.setInt(2, int_brg_id);
                    ps.setInt(3, int_qty);
                    ps.setInt(4, int_subtotal);
                    ps.setDate(5, java.sql.Date.valueOf(tglpengeluaran));

                    ps.addBatch();
                    System.out.println(sql);
                }
                int[] executeUpdate = ps.executeBatch();

                conn.commit();
                for (int row = 0; row < total_rowPengeluaran; row++) {
                    if (executeUpdate[row] > 0) {
                        notifikasi_c_pengeluaran = true;

                    } else {
                        notifikasi_c_pengeluaran = false;
                    }
                }

            } else {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, outletID);
                ps.setInt(2, 0);
                ps.setInt(3, 0);
                ps.setInt(4, 0);
                ps.setDate(5, java.sql.Date.valueOf(tglPengeluaran));
                int executeUpdate = ps.executeUpdate();
                if (executeUpdate > 0) {
                    notifikasi_c_pengeluaran = true;
                } else {
                    notifikasi_c_pengeluaran = false;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void readDataPengeluaran(String var_selected, String var_keywords, JTable table) {
        DefaultTableModel tabmode = getDatatabel(table);
        String sql = null;
        try {
            //jika ada additional / uang tak terduga 
            if (var_selected != null) {
                sql = "tbl_pengeluaran WHERE kategori ='Additional barang'";
            } else {//jika tidak ada uang tak terduga
                if (var_keywords != null) {
                    //query search
                    sql = "SELECT * FROM tbl_master_barang WHERE nama_barang LIKE '%" + var_keywords + "%' ";
                } else {
                    //query select smua data menu
                    sql = "SELECT * FROM tbl_master_barang ORDER BY nama_barang ASC";
                }
            }

            System.out.println(sql);

            ResultSet hasil = null;
            try {
                Statement stmt = conn.createStatement();
                hasil = stmt.executeQuery(sql);
            } catch (SQLException ex) {
                Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (hasil.next()) {
                int col0 = hasil.getInt("id_barang");
                String col1 = hasil.getString("nama_barang");
                String col2 = hasil.getString("kategori");
                String col3 = hasil.getString("harga_satuan");
                Object[] data = {col0, col1, col2, col3};
                tabmode.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /* end CRUD pengeluaran*/
    /*
     *  CRUD AREA transaksi
     */
    public static void createDataTransaksi(int karyawanID, String tglTransaksi) {

        int totalRowTransaksi = jTable_transaksi.getRowCount();

        String sql = "INSERT INTO tbl_transaksi (id_outlet, id_barang, terjual, karyawan_id,tgl_closing,subtotal) VALUES (?,?,?,?,?,?)";

        try {
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);

            for (int row = 0; row < totalRowTransaksi; row++) {
                Date tglClosing = java.sql.Date.valueOf(tglTransaksi);
                int int_outlet_id = Integer.parseInt(jTable_transaksi.getValueAt(row, 0).toString());
                int int_brg_id = Integer.parseInt(jTable_transaksi.getValueAt(row, 1).toString());
                int int_terjual = Integer.parseInt(jTable_transaksi.getValueAt(row, 2).toString());
                int int_subtotal = Integer.parseInt(jTable_transaksi.getValueAt(row, 3).toString());

                ps.setInt(1, int_outlet_id);
                ps.setInt(2, int_brg_id);
                ps.setInt(3, int_terjual);
                ps.setInt(4, karyawanID);
                ps.setDate(5, tglClosing);
                ps.setInt(6, int_subtotal);

                ps.addBatch();
                System.out.println(sql);
            }
            int[] executeUpdate = ps.executeBatch();

            conn.commit();
            for (int row = 0; row < totalRowTransaksi; row++) {
                if (executeUpdate[row] > 0) {
                    notifikasi_c_transaksi = true;

                } else {
                    notifikasi_c_transaksi = false;
                    System.out.println("insert data transaksi gagal");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /* end CRUD transaksi*/
    /*
     *  CRUD AREA outlet order
     *  note :  
     * jika order pertama kali maka insert ke table stock
     * jika order untuk menambah stock maka update ke table stock
    
     */
    public static void createDataOrder(int karyawanID, String tglOrder, String OderKD) {
        int total_rowOrder = jTable_order_draft.getRowCount();

        //query untuk insert ke tabel order
        String sql_insert_order = "INSERT INTO tbl_order_outlet (kd_order, id_outlet, jml_order, id_barang, id_karyawan, tanggal_order) VALUES (?,?,?,?,?,?)";
        String sql_stock = "";

        int jml_stock_akhir = 0;
        int stock_sebelumnya = 0;

        ArrayList<Integer> data_jml_order_tglsama = new ArrayList<Integer>();
        ArrayList<Integer> data_jml_order_sebelumnya = new ArrayList<Integer>();

        PreparedStatement ps_data_stock;

        try {
            conn.setAutoCommit(false);
            PreparedStatement ps_order = conn.prepareStatement(sql_insert_order);

            for (int row = 0; row < total_rowOrder; row++) {
                String tgl_order = tglOrder;
                String kd_order = jTable_order_draft.getValueAt(row, 0).toString();
                int outletID = Integer.parseInt(jTable_order_draft.getValueAt(row, 1).toString());
                int jmlOrder = Integer.parseInt(jTable_order_draft.getValueAt(row, 2).toString());
                int barangID = Integer.parseInt(jTable_order_draft.getValueAt(row, 3).toString());
                int terpakai = Integer.parseInt(jTable_order_draft.getValueAt(row, 4).toString());
                int rusak = Integer.parseInt(jTable_order_draft.getValueAt(row, 5).toString());

                //check pake logic 2 dulu
                data_jml_order_tglsama.add(checkDataOrder(2, outletID, barangID, tglOrder));
                //jika ada di tanggal yang sama
                if (!data_jml_order_tglsama.get(row).equals(0)) {
                    //query update tbl_data_stock di tanggal sama stockawal bertambah
                    sql_stock = "UPDATE tbl_data_stock SET "
                            + " stock_awal=(stock_awal+" + jmlOrder + ") ,"
                            + " stock_akhir=(stock_awal-(terpakai+" + terpakai + ")-(rusak+" + rusak + ") ),"
                            + " terpakai=terpakai+"+terpakai+" ,rusak=rusak+"+rusak 
                            + " WHERE tgl_stock='" + tgl_order + "' AND id_barang=" + barangID + " AND id_outlet=" + outletID;
                    System.out.println(sql_stock);
                    ps_data_stock = conn.prepareStatement(sql_stock);

                } else {
                    //jika tidak di tanggal yang sama
                    //execute logic 1
                    data_jml_order_sebelumnya.add(checkDataOrder(1, outletID, barangID, tglOrder));
                    if (!data_jml_order_sebelumnya.get(row).equals(0)) {
                        // TO DO
                        //akan bug jika tanggal sebelumnya ada order ,, rusak di isi dan terpakai di isi

                        int stockAkhir = data_jml_order_sebelumnya.get(row);
                        int stockAwalBerikutnya = stockAkhir + jmlOrder;
                        //query update tbl_data_stock [stock awal+order]  untuk tanggal order berikutnya.
                        sql_stock = "INSERT INTO tbl_data_stock (id_outlet,stock_awal,stock_akhir,id_barang,rusak,terpakai,tgl_stock)  "
                                + "VALUES (?,?,(stock_awal-" + terpakai + "-" + rusak + "),?,?,?,?)";
                        ps_data_stock = conn.prepareStatement(sql_stock);
                        ps_data_stock.setInt(1, outletID);
                        ps_data_stock.setInt(2, stockAwalBerikutnya);
                        ps_data_stock.setInt(3, barangID);
                        ps_data_stock.setInt(4, rusak);
                        ps_data_stock.setInt(5, terpakai);
                        ps_data_stock.setDate(6, java.sql.Date.valueOf(tgl_order));

                    } else {//outlet baru pertama kali order
                        //query insert tbl_data_stock
                        sql_stock = "INSERT INTO tbl_data_stock (id_outlet,stock_awal,stock_akhir,id_barang,rusak,terpakai,tgl_stock)  "
                                + "VALUES (?,?,(stock_awal-" + terpakai + "-" + rusak + "),?,?,?,?)";
                        ps_data_stock = conn.prepareStatement(sql_stock);
                        ps_data_stock.setInt(1, outletID);
                        ps_data_stock.setInt(2, jmlOrder);
                        ps_data_stock.setInt(3, barangID);
                        ps_data_stock.setInt(4, rusak);
                        ps_data_stock.setInt(5, terpakai);
                        ps_data_stock.setDate(6, java.sql.Date.valueOf(tgl_order));

                    }
                }
                //insert untuk data order ke tabel order
                //set untuk tabel order
                ps_order.setString(1, kd_order);
                ps_order.setInt(2, outletID);
                ps_order.setInt(3, jmlOrder);
                ps_order.setInt(4, barangID);
                ps_order.setInt(5, karyawanID);
                ps_order.setDate(6, java.sql.Date.valueOf(tglOrder));

                ps_order.addBatch();
                ps_data_stock.executeUpdate();

                System.out.println(sql_stock);
            }
            int[] executeUpdate = ps_order.executeBatch();

            conn.commit();
            for (int row = 0; row < total_rowOrder; row++) {
                if (executeUpdate[row] > 0) {
                    notifikasi_c_order = true;

                } else {
                    notifikasi_c_order = false;
                    System.out.println("insert data order gagal");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static int checkDataOrder(int logic, int outlet, int barang, String tgl_stock) {
        int data = 0;
        String sql = "";
        ResultSet hasil;

        //logic 1 = jika ada order di tanggal sebelumnya maka masuk pada [stock awal+order]  
        //untuk tanggal order berikutnya.
        if (logic == 1) {
            sql = "SELECT stock_akhir as data FROM tbl_data_stock WHERE tgl_stock = date('" + tgl_stock + "') - INTERVAL 1 DAY AND id_outlet=" + outlet + " "
                    + "AND id_barang=" + barang;
            System.out.println(sql);

            //logic 2 = jika ada order di tanggal sama stock bertambah
        } else if (logic == 2) {
            sql = "SELECT jml_order as data FROM tbl_order_outlet WHERE tanggal_order = date('" + tgl_stock + "') AND id_outlet=" + outlet + " "
                    + "AND id_barang=" + barang;
            System.out.println(sql);
        }
        try {
            Statement stmt = conn.createStatement();
            hasil = stmt.executeQuery(sql);
            while (hasil.next()) {
                data = hasil.getInt("data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return data;
    }

    /* end CRUD outlet order */
    /* begin reporting area */
    public static int getTotalReport(String report, int idOutlet, String tglAwal, String tglAkhir) {
        int totalData = 0;
        String sql = "";
        switch (report) {
            case "omsetkotor":
                sql = "SELECT SUM(x.omsetkotor) as data FROM ("
                        + "SELECT "
                        + "transaksi.t_transaksi as omsetkotor "
                        + "FROM ( "
                        + "		SELECT id_outlet, tgl_closing,SUM(subtotal) as t_transaksi FROM tbl_transaksi WHERE id_outlet =" + idOutlet + " AND tgl_closing  BETWEEN '" + tglAwal + "' AND '" + tglAkhir + "' GROUP BY tgl_closing "
                        + "	)  transaksi "
                        + "	LEFT JOIN  "
                        + "	( "
                        + "		SELECT id_outlet, nama_outlet FROM tbl_master_outlet tmo WHERE tmo.id_outlet =" + idOutlet + ""
                        + "	) outlet "
                        + "	ON outlet.id_outlet = transaksi.id_outlet "
                        + ") x ";
                break;
            case "omsetbersih":
                sql = "SELECT SUM(x.omsetbersih) as data FROM ("
                        + "SELECT "
                        + "(transaksi.t_transaksi - pengeluaran.t_pengeluaran) as omsetbersih "
                        + "FROM ( "
                        + "		SELECT id_outlet, tgl_closing,SUM(subtotal) as t_transaksi FROM tbl_transaksi WHERE id_outlet =" + idOutlet + " AND tgl_closing  BETWEEN '" + tglAwal + "' AND '" + tglAkhir + "' GROUP BY tgl_closing "
                        + "	)  transaksi "
                        + "	LEFT  JOIN  "
                        + "	( "
                        + "		SELECT id_outlet ,SUM(subtotal) as t_pengeluaran FROM tbl_pengeluaran WHERE id_outlet =" + idOutlet + " AND tgl_pengeluaran BETWEEN '" + tglAwal + "' AND '" + tglAkhir + "' GROUP BY tgl_pengeluaran "
                        + "	) pengeluaran "
                        + "	USING (id_outlet) "
                        + "	LEFT JOIN  "
                        + "	( "
                        + "		SELECT id_outlet, nama_outlet FROM tbl_master_outlet tmo WHERE tmo.id_outlet =" + idOutlet + ""
                        + "	) outlet "
                        + "	ON outlet.id_outlet = transaksi.id_outlet "
                        + ") x ";

                break;
            case "uangstoran":
                sql = "SELECT SUM(x.uangstoran) as data FROM ("
                        + "SELECT "
                        + "(transaksi.t_transaksi - pengeluaran.t_pengeluaran) as uangstoran "
                        + "FROM ( "
                        + "		SELECT id_outlet, tgl_closing,SUM(subtotal) as t_transaksi FROM tbl_transaksi WHERE id_outlet =" + idOutlet + " AND tgl_closing  BETWEEN '" + tglAwal + "' AND '" + tglAkhir + "' GROUP BY tgl_closing "
                        + "	)  transaksi "
                        + "	LEFT  JOIN  "
                        + "	( "
                        + "		SELECT id_outlet ,SUM(subtotal) as t_pengeluaran FROM tbl_pengeluaran WHERE id_outlet =" + idOutlet + " AND tgl_pengeluaran BETWEEN '" + tglAwal + "' AND '" + tglAkhir + "' GROUP BY tgl_pengeluaran "
                        + "	) pengeluaran "
                        + "	USING (id_outlet) "
                        + "	LEFT JOIN  "
                        + "	( "
                        + "		SELECT id_outlet, nama_outlet FROM tbl_master_outlet tmo WHERE tmo.id_outlet =" + idOutlet + ""
                        + "	) outlet "
                        + "	ON outlet.id_outlet = transaksi.id_outlet "
                        + ") x ";

                break;
        }

        ResultSet hasil;
        try {
            Statement stmt = conn.createStatement();
            hasil = stmt.executeQuery(sql);
            while (hasil.next()) {
                totalData = hasil.getInt("data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(sql + "=> " + totalData);

        return totalData;
    }
    /* end reporting area */

    /*
     *  otentikasi user dengan database
     */
    public HashMap loginModel(String nik, String pass) {
        String sql = null;
        HashMap<String, Object> data = new HashMap<String, Object>();
        try {
            //query select
            sql = "SELECT * FROM tbl_master_karyawan WHERE nik ='" + nik + "' AND akses_password='" + pass + "' ";
            System.out.println(sql);

            ResultSet hasil = null;
            try {
                Statement stmt = conn.createStatement();
                hasil = stmt.executeQuery(sql);

            } catch (SQLException ex) {
                Logger.getLogger(CrudModel.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            while (hasil.next()) {
                data.put("karyawanid", String.valueOf(hasil.getInt("id_karyawan")));
                data.put("nik", hasil.getString("nik"));
                data.put("jabatan", hasil.getString("posisi"));
                data.put("password", hasil.getString("akses_password"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudModel.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    /* otentikasi user dengan database */

    /*
     * method untuk mengambil dan mencocokan variabel JTable
     */
    public static DefaultTableModel getDatatabel(JTable tableName) {

        DefaultTableModel tabmode = null;
        if (tableName.equals(jTable_barang)) {
            Object[] baris = {"id", "Nama barang", "kategory ", "harga(Rp)", "satuan"};
            tabmode = new DefaultTableModel(null, baris);
            jTable_barang.setModel(tabmode);
        } else if (tableName.equals(jTable_barang_2)) {
            Object[] baris = {"id", "Nama barang", "kategory ", "harga(Rp)", "satuan"};
            tabmode = new DefaultTableModel(null, baris);
            jTable_barang_2.setModel(tabmode);
        } else if (tableName.equals(jTable_barang_3)) {
            Object[] baris = {"id", "Nama barang", "kategory ", "harga(Rp)", "satuan"};
            tabmode = new DefaultTableModel(null, baris);
            jTable_barang_3.setModel(tabmode);
        } else if (tableName.equals(jTable_outlet)) {
            Object[] baris = {"id", "Nama outlet", "kota", "alamat outlet"};
            tabmode = new DefaultTableModel(null, baris);
            jTable_outlet.setModel(tabmode);
        } else if (tableName.equals(jTable_outlet_2)) {
            Object[] baris = {"id", "Nama outlet", "kota", "alamat outlet"};
            tabmode = new DefaultTableModel(null, baris);
            jTable_outlet_2.setModel(tabmode);
        } else if (tableName.equals(jTable_outlet3)) {
            Object[] baris = {"id", "Nama outlet", "kota", "alamat outlet"};
            tabmode = new DefaultTableModel(null, baris);
            jTable_outlet3.setModel(tabmode);
        } else if (tableName.equals(jTable_outlet4)) {
            Object[] baris = {"id", "Nama outlet", "kota", "alamat outlet"};
            tabmode = new DefaultTableModel(null, baris);
            jTable_outlet4.setModel(tabmode);
        } else if (tableName.equals(jTable_karyawan)) {
            Object[] baris = {"id", "Nik", "jabatan", "nama", "alamat"};
            tabmode = new DefaultTableModel(null, baris);
            jTable_karyawan.setModel(tabmode);
        }

        return tabmode;
    }
}
