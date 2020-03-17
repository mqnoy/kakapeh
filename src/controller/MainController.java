/*
 * aplikasi ini 
 */

package controller;

import applaporan.Dashboard;
import applaporan.Form_login_aplikasi;
import applaporan.Form_master_barang;
import applaporan.Form_master_karyawan;
import applaporan.Form_master_outlet;
import applaporan.Form_outlet_order;
import applaporan.Form_transaksi;
import applaporan.Laporan;
import applaporan.Pengaturan;

/**
 *
 * @author qnoy
 */
public class MainController {
    
    //global
    public static int idBarang = 0;
    public static int idoutlet = 0;
   
    //untuk crud barang 
    public static boolean notifikasi_c_barang = false;
    public static boolean notifikasi_r_barang = false;
    public static boolean notifikasi_u_barang = false;
    public static boolean notifikasi_d_barang = false;
    
    //untuk crud outlet 
    public static boolean notifikasi_c_outlet = false;
    public static boolean notifikasi_r_outlet = false;
    public static boolean notifikasi_u_outlet = false;
    public static boolean notifikasi_d_outlet = false;
    
    //untuk crud karyawan 
    public static boolean notifikasi_c_karyawan = false;
    public static boolean notifikasi_r_karyawan = false;
    public static boolean notifikasi_u_karyawan = false;
    public static boolean notifikasi_d_karyawan = false;
    
    //untuk crud pengeluaran
    public static boolean notifikasi_c_pengeluaran = false;
    public static boolean notifikasi_r_pengeluaran = false;
    public static boolean notifikasi_u_pengeluaran = false;
    public static boolean notifikasi_d_pengeluaran = false;
    
    //untuk crud transaksi
    public static boolean notifikasi_c_transaksi = false;
    public static boolean notifikasi_r_transaksi = false;
    public static boolean notifikasi_u_transaksi = false;
    public static boolean notifikasi_d_transaksi = false;
    
    //untuk crud outlet order
    public static boolean notifikasi_c_order = false;
    public static boolean notifikasi_r_order = false;
    public static boolean notifikasi_u_order = false;
    public static boolean notifikasi_d_order = false;
    
    //global
    public void setIdBarang(int val){
        this.idBarang = val;
    }
    public static int getIdBarang(){
        return idBarang;
    }
    public void setOutletId(int val){
        this.idoutlet = val;
    }
    public static int getOutletId(){
        return idoutlet;
    }
    
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
        Form_outlet_order frm_outlet_order =  new Form_outlet_order();
        frm_outlet_order.setVisible(true);
    }
    
    //frame form transaksi 
    public void showFormPenjualan(){
        Form_transaksi frm_penjualan = new Form_transaksi();
        frm_penjualan.setVisible(true);
    }
       
    //frame laporan penjualan 
    public void showLaporan(){
        Laporan laporan = new Laporan();
        laporan.setVisible(true);
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
    
    //frame pengaturan  
    public void showPengaturan(){
        Pengaturan pengaturan = new Pengaturan();
        pengaturan.setVisible(true);
    }
}
