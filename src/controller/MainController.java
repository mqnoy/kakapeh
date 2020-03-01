/*
 * aplikasi ini 
 */

package controller;

import applaporan.Dashboard;
import applaporan.Form_login_aplikasi;
import applaporan.Form_master_barang;
import applaporan.Form_master_karyawan;
import applaporan.Form_master_outlet;
import applaporan.Form_order;
import applaporan.Form_penjualan;
import applaporan.Laporan_penjualan;
import javax.swing.JOptionPane;

/**
 *
 * @author qnoy
 */
public class MainController {
   
    
    //untuk crud barang 
    public static boolean notifikasi_c_barang = false;
    public static boolean notifikasi_r_barang = false;
    public static boolean notifikasi_u_barang = false;
    public static boolean notifikasi_d_barang = false;
  
    
    //frame form login
    public void showLoginApp(){
        Form_login_aplikasi form_login = new Form_login_aplikasi();
        form_login.setVisible(true);
    }
    
    //frame dashboard
    public void showDashboard(){
        Dashboard dashboard = new Dashboard();
        dashboard.setVisible(true);
    }
    
    //frame form order
    public void showFormOrder(){
        Form_order frm_order = new Form_order();
        frm_order.setVisible(true);
    }
    
    //frame form penjualan 
    public void showFormPenjualan(){
        Form_penjualan frm_penjualan = new Form_penjualan();
        frm_penjualan.setVisible(true);
    }
    
    //frame laporan penjualan 
    public void showLapPenjualan(){
        Laporan_penjualan lap_penjualan = new Laporan_penjualan();
        lap_penjualan.setVisible(true);
    }
    
    //frame master barang  
    public void showFormMrBarang(){
        Form_master_barang frm_mr_barang = new Form_master_barang();
        frm_mr_barang.setVisible(true);
    }
    
    //frame master karyawan  
    public void showFormMrKaryawan(){
        Form_master_karyawan frm_mr_karyawan = new Form_master_karyawan();
        frm_mr_karyawan.setVisible(true);
    }
    
    //frame master outlet  
    public void showFormMrOutlet(){
        Form_master_outlet frm_mr_outlet = new Form_master_outlet();
        frm_mr_outlet.setVisible(true);
    }
}
