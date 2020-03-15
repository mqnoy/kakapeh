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
import static applaporan.Form_transaksi.getIdBarang;
import static applaporan.Form_transaksi.getIdOutlet;
import static applaporan.Form_transaksi.jTable_barang_3;
import static applaporan.Form_transaksi.jTable_outlet3;
import static applaporan.Form_transaksi.jTable_pengeluaran;
import static applaporan.Form_transaksi.txt_frmt_terjual;
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
        System.out.println("readDataBarang()=>"+var_kategory);
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
     */
    public static void createDataPengeluaran(String pengeluaranKD) {
        int total_rowPengeluaran = jTable_pengeluaran.getRowCount();

        String sql = "INSERT INTO tbl_pengeluaran (kd_pengeluaran,id_barang,qty,subtotal) VALUES (?,?,?,?)";
        try {
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);

            for (int row = 0; row < total_rowPengeluaran; row++) {
                String kd_pengeluaran = pengeluaranKD;
                int int_brg_id = (Integer) jTable_pengeluaran.getValueAt(row, 0);
                int int_qty = (Integer) jTable_pengeluaran.getValueAt(row, 1);
                int int_subtotal = (Integer) jTable_pengeluaran.getValueAt(row, 2);

                ps.setString(1, kd_pengeluaran);
                ps.setInt(2, int_brg_id);
                ps.setInt(3, int_qty);
                ps.setInt(4, int_subtotal);

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
                    System.out.println("insert data transaksi gagal");
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
    public static void createDataTransaksi(int karyawanID, String tglTransaksi, String pengeluaranKD) {

        int outletID = getIdOutlet();
        int barangID = getIdBarang();
        int jmlTerjual = Integer.parseInt(txt_frmt_terjual.getText());
//        int jmlRusak = Integer.parseInt(txt_frmt_rusak.getText());

        //check stock sebelum insert
//        checkDataStock(int outlet, int barang);
//        System.out.println("orderid = " + outletID + "barangID = " + barangID + "jmlTerjual" + jmlTerjual + " jmlRusak" + jmlRusak);
        System.out.println("karyawanID = " + karyawanID + "tglRequest = " + tglTransaksi + "pengeluaranKD" + pengeluaranKD);
        try {
            String sql = "INSERT INTO tbl_transaksi (id_outlet, id_barang, terjual, rusak, kd_pengeluaran, karyawan_id,tgl_transaksi) VALUES (?,?,?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, outletID);
            ps.setInt(2, barangID);
            ps.setInt(3, jmlTerjual);
//            ps.setInt(4, jmlRusak);
            ps.setString(5, pengeluaranKD);
            ps.setInt(6, karyawanID);
            ps.setDate(7, java.sql.Date.valueOf(tglTransaksi));
            System.out.println(sql);
            int executeUpdate = ps.executeUpdate();
            if (executeUpdate > 0) {
                notifikasi_c_transaksi = true;
                System.out.println("insert data transaksi sukses");
            } else {
                notifikasi_c_transaksi = false;
                System.out.println("insert data transaksi gagal");
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
        
        String sql = "INSERT INTO tbl_order_outlet (kd_order, id_outlet, jml_order, id_barang, id_karyawan, tanggal_order) VALUES (?,?,?,?,?,?)";
        String sql_stock = "";

        int jml_stock_akhir = 0;
        ArrayList<Integer> check_data_stock = new ArrayList<Integer>();
        int stock_sebelumnya = 0;

        try {
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);

            for (int row = 0; row < total_rowOrder; row++) {
                String kd_order = jTable_order_draft.getValueAt(row, 0).toString();
                int outletID = Integer.parseInt(jTable_order_draft.getValueAt(row, 1).toString());
                int jmlOrder = Integer.parseInt(jTable_order_draft.getValueAt(row, 2).toString());
                int barangID = Integer.parseInt(jTable_order_draft.getValueAt(row, 3).toString());

                //set untuk tabel order
                ps.setString(1, kd_order);
                ps.setInt(2, outletID);
                ps.setInt(3, jmlOrder);
                ps.setInt(4, barangID);
                ps.setInt(5, karyawanID);
                ps.setDate(6, java.sql.Date.valueOf(tglOrder));

                
                check_data_stock.add(checkDataStock(outletID, barangID, tglOrder));
                //jika ada order di tanggal sebelumnya maka masuk pada [stock awal(saat selesai clousing)+order]  
                //untuk tanggal order berikutnya.
                if (!check_data_stock.get(row).equals(0)) {
                    stock_sebelumnya = check_data_stock.get(row);
//                    sql_stock = "UPDATE tbl_data_stock SET stock_awal = ("+stock_sebelumnya+"+?) "
//                            + "WHERE id_outlet = ? AND id_barang = ?";
                    sql_stock = "INSERT tbl_data_stock (stock_awal, id_outlet, id_barang,tgl_stock) VALUES(?,?,?,?)";
                    System.out.println("ada sisa stock sbelumnya = "+check_data_stock.get(row));
                } else {
                    sql_stock = "INSERT tbl_data_stock (stock_awal, id_outlet, id_barang,tgl_stock) VALUES(?,?,?,?)";
                    System.out.println("tidak ada sisa stock sbelumnya = "+check_data_stock.get(row));
                }
                PreparedStatement ps_data_stock = conn.prepareStatement(sql_stock);

                if (!check_data_stock.get(row).equals(0)) {
                    //set untuk tabel stock
                    ps_data_stock.setInt(1, stock_sebelumnya+jmlOrder);
                    
                } else {
                    //set untuk tabel stock
                    ps_data_stock.setInt(1, jmlOrder);
                }
                ps_data_stock.setInt(2, outletID);
                ps_data_stock.setInt(3, barangID);
                ps_data_stock.setDate(4, java.sql.Date.valueOf(tglOrder));

                ps_data_stock.executeUpdate();
                ps.addBatch();
                System.out.println(sql_stock);
            }
            int[] executeUpdate = ps.executeBatch();

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

    public static int checkDataStock(int outlet, int barang, String tgl_stock) {
        int stockAkhir = 0;
        String sql = "SELECT stock_akhir FROM tbl_data_stock WHERE tgl_stock = date('"+tgl_stock+"') - INTERVAL 1 DAY AND id_outlet=" + outlet + " "
                + "AND id_barang=" + barang;
        ResultSet hasil;
        try {
            Statement stmt = conn.createStatement();
            hasil = stmt.executeQuery(sql);
            while (hasil.next()) {
                stockAkhir = hasil.getInt("stock_akhir");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("checkDataStock()=>"+sql);

        return stockAkhir;
    }

    /* end CRUD outlet order */
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
        } else if (tableName.equals(jTable_karyawan)) {
            Object[] baris = {"id", "Nik", "jabatan", "nama", "alamat"};
            tabmode = new DefaultTableModel(null, baris);
            jTable_karyawan.setModel(tabmode);
        }

        return tabmode;
    }
}
