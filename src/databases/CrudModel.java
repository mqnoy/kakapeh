/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databases;

import static applaporan.Form_master_barang.jTable_barang;
import static controller.MainController.*;
import static applaporan.Form_master_barang.*;
import static applaporan.Form_master_karyawan.jTable_karyawan;
import static applaporan.Form_master_outlet.jTable_outlet;
import static applaporan.Form_order.jTable_barang_2;
import static applaporan.Form_order.jTable_outlet_2;
import static applaporan.Form_penjualan.jTable_barang_3;
import static applaporan.Form_penjualan.jTable_outlet3;
import java.sql.*;
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
    
    
    /*
     *  global query
     */
    public static int countData(String pk, String table){
        int totalData = 0;
        String sql = "SELECT count("+pk+") as total_data FROM "+table+"";
        ResultSet hasil;
        try {
            Statement stmt = conn.createStatement();
            hasil = stmt.executeQuery(sql);
            while(hasil.next()){
                totalData = hasil.getInt("total_data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(sql+"=> "+ totalData);

        return totalData;
    
    }
    /* end global query */
    /*
     *  CRUD AREA KARYAWAN
     */
    public static void readDataKaryawan(String var_selected, String var_keywords, JTable table){
        DefaultTableModel tabmode = getDatatabel(table);
        String sql = null;
        try {
            if (var_selected != null && var_keywords != null) {
                //query search
                sql = "SELECT * FROM tbl_master_karyawan WHERE nm_karyawan LIKE '%" + var_keywords + "%' ";
            } else {
                //query select smua data 
                sql = "SELECT * FROM tbl_master_karyawan";
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
                String col1 = hasil.getString("nik");
                String col2 = hasil.getString("jabatan");                
                String col3 = hasil.getString("nm_karyawan");
                String col4 = hasil.getString("alamat_karyawan");
               
                Object[] data = {NUMBERS, col1, col2, col3, col4};
                tabmode.addRow(data);
                NUMBERS++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /* END CRUD AREA BARANG */
    
    /*
     *  CRUD AREA OUTLET
     */
    public static void readDataOutlet(String var_selected, String var_keywords, JTable table){
        DefaultTableModel tabmode = getDatatabel(table);
        String sql = null;
        try {
            if (var_keywords != null) {
                //query search
                sql = "SELECT * FROM tbl_master_outlet WHERE nm_outlet LIKE '%" + var_keywords + "%' ";
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
                String col1 = hasil.getString("nm_outlet");
                String col2 = hasil.getString("kota");                
                String col3 = hasil.getString("alamat_outlet");
               
                Object[] data = {NUMBERS, col1, col2, col3};
                tabmode.addRow(data);
                NUMBERS++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /* END CRUD AREA OUTLET */
    /*
     *  CRUD AREA BARANG
     */
    public static void createDataBarang(){
        try {
            boolean check_kdmenu;
            String sql = "INSERT INTO tbl_master_barang (nama_barang,kategori,harga_satuan) VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, txt_brg_nm_barang.getText());
            ps.setString(2, cb_brg_kategori.getSelectedItem().toString());
            ps.setInt(3, Integer.parseInt(txt_brg_harga.getText().trim()));

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
    public static void readDataBarang(String var_selected, String var_keywords, JTable table) {
        DefaultTableModel tabmode = getDatatabel(table);
        String sql = null;
        try {
            if (var_keywords != null) {
                //query search
                sql = "SELECT * FROM tbl_master_barang WHERE nama_barang LIKE '%" + var_keywords + "%' ";
            } else {
                //query select smua data menu
                sql = "SELECT * FROM tbl_master_barang ORDER BY nama_barang ASC";
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
    public static void updateDataBarang(int id){
        try {
            String sql = "UPDATE tbl_master_barang SET nama_barang=?, kategori=?, harga_satuan=? WHERE id_barang=" + id;
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,txt_brg_nm_barang.getText());
            ps.setString(2,cb_brg_kategori.getSelectedItem().toString());
            ps.setInt(3,Integer.parseInt(txt_brg_harga.getText()));

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
    public static void deleteDataBarang(int id){
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
    
    public void getKategoryToCb(){
        
    }
    /* END CRUD AREA BARANG */
    
    /*
     *  otentikasi user dengan database
     */
    public HashMap loginModel(String nik,String pass){
        String sql = null;
        HashMap<String,String> data = new HashMap<String,String>();
        try {
            //query select
            sql = "SELECT * FROM tbl_master_karyawan WHERE nik ='" + nik + "' AND akses_password='"+pass+"' ";
            System.out.println(sql);

            ResultSet hasil = null;
            try {
                Statement stmt = conn.createStatement();
                hasil = stmt.executeQuery(sql);
            } catch (SQLException ex) {
                Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (hasil.next()) {
                data.put("nik",hasil.getString("nik"));
                data.put("jabatan",hasil.getString("jabatan"));                
                data.put("password",hasil.getString("akses_password"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
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
            Object[] baris = {"id", "Nama barang", "kategory ", "harga(Rp)"};
            tabmode = new DefaultTableModel(null, baris);
            jTable_barang.setModel(tabmode);
        }else if (tableName.equals(jTable_barang_2)) {
            Object[] baris = {"id", "Nama barang", "kategory ", "harga(Rp)"};
            tabmode = new DefaultTableModel(null, baris);
            jTable_barang_2.setModel(tabmode);
        }  else if (tableName.equals(jTable_barang_3)) {
            Object[] baris = {"id", "Nama barang", "kategory ", "harga(Rp)"};
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
        }else if (tableName.equals(jTable_outlet3)) {
            Object[] baris = {"id", "Nama outlet", "kota", "alamat outlet"};
            tabmode = new DefaultTableModel(null, baris);
            jTable_outlet3.setModel(tabmode);
        }  else if (tableName.equals(jTable_karyawan)) {
            Object[] baris = {"id", "Nik", "jabatan", "nama", "alamat"};
            tabmode = new DefaultTableModel(null, baris);
            jTable_karyawan.setModel(tabmode);
        } 
        

        return tabmode;
    }
}
