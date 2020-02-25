/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databases;

import static applaporan.Form_master_barang.jTable_barang;
import static applaporan.Form_master_outlet.jTable_outlet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
     *  CRUD AREA OUTLET
     */
    public static void readDataOutlet(String var_selected, String var_keywords, JTable table){
        DefaultTableModel tabmode = getDatatabel(table);
        String sql = null;
        try {
            if (var_selected != null && var_keywords != null) {
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
    public static void readDataBarang(String var_selected, String var_keywords, JTable table) {
        DefaultTableModel tabmode = getDatatabel(table);
        String sql = null;
        try {
            if (var_selected != null && var_keywords != null) {
                //query search
                sql = "SELECT * FROM tbl_master_barang WHERE nm_barang LIKE '%" + var_keywords + "%' ";
            } else {
                //query select smua data menu
                sql = "SELECT * FROM tbl_master_barang";
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
                String col1 = hasil.getString("nm_barang");
                String col2 = hasil.getString("ktg_barang");
                String col3 = hasil.getString("hrg_pokok_brg");
                Object[] data = {NUMBERS, col1, col2, col3};
                tabmode.addRow(data);
                NUMBERS++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void getKategoryToCb(){
        
    }
    /* END CRUD AREA BARANG */
    
    
    /*
    * method untuk mengambil dan mencocokan variabel JTable
    */
    public static DefaultTableModel getDatatabel(JTable tableName) {

        DefaultTableModel tabmode = null;
        if (tableName.equals(jTable_barang)) {
            Object[] baris = {"No", "Nama barang", "kategory ", "harga(Rp)"};
            tabmode = new DefaultTableModel(null, baris);
            jTable_barang.setModel(tabmode);
        } else if (tableName.equals(jTable_outlet)) {
            Object[] baris = {"No", "Nama outlet", "kota", "alamat outlet"};
            tabmode = new DefaultTableModel(null, baris);
            jTable_outlet.setModel(tabmode);
        } 
        

        return tabmode;
    }
}
