/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applaporan;

import controller.MainController;
import static controller.MainController.notifikasi_c_transaksi;
import controller.Otentikasi;
import static controller.Otentikasi.getGrant;
import static databases.CrudModel.createDataPengeluaran;
import static databases.CrudModel.createDataTransaksi;
import static databases.CrudModel.readDataBarang;
import static databases.CrudModel.readDataOutlet;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rifky <qnoy.rifky@gmail.com>
 */
public class Form_transaksi extends javax.swing.JFrame {

    Otentikasi otentikasi = new Otentikasi();
    MainController frame = new MainController();
    public Library lib = new Library();
    public String tgl_pengeluaran = "1999-01-01";
    public String kd_pengeluaran_draf = "";
    
    int uangTakterduga = 0;
    static int outletid = 0;
    static int barangid = 0;
    static int barangHrg = 0;
    int karyawanID = -1;

    boolean additional = false;
    int id_nm_barang, qty_barang, harga_item;
    int subtotal = 0;
    int subtotal_menu = 0;
    static int totalPengeluaran = 0;

    /**
     * Creates new form Form_penjualan
     */
    public Form_transaksi() {
        if (getGrant()) {
            initComponents();
            btn_item_additional.setEnabled(false);
            btn_selesai.setEnabled(false);
            btn_hitung.setEnabled(false);
            karyawanID = otentikasi.getIdKaryawan(); //prod
            btn_tambah_additional.setEnabled(false);
            i_tgl_pengeluaran.requestFocus(true);
            btn_hapus_trans.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(rootPane, "silahkan login dahulu", "tidak ada akses", 2);
            frame.showLoginApp();
        }

    }

    private void setAdditionalBrg(boolean var) {
        this.additional = var;
    }

    private boolean getAdditionalBrg() {
        return this.additional;
    }

    private void setSubtotal(int y) {
        this.subtotal = y;
    }

    private int getSubtotal() {
        return this.subtotal;
    }

    public static int getTotalPengeluaran() {
        return totalPengeluaran;
    }

    private void setIdOutlet(int var) {
        outletid = var;
    }

    public static int getIdOutlet() {
        return outletid;
    }

    //untuk menu
    private void setIdBarang(int var) {
        barangid = var;
    }

    public static int getIdBarang() {
        return barangid;
    }

    private void setHrgBarang(int var) {
        barangHrg = var;
    }

    public static int getHrgBarang() {
        return barangHrg;
    }

    private void setSubtotalMenu(int var) {
        subtotal_menu = var;
    }

    public int getSubtotalMenu() {
        return subtotal_menu;
    }

    private void eventClickBarang(boolean x) {
        if (x) {
            //jika ada aditional event mouse click untuk additioanl
            int row = jTable_barang_3.getSelectedRow();
            id_nm_barang = Integer.parseInt(jTable_barang_3.getModel().getValueAt(row, 0).toString());
            String val_nm_barang = jTable_barang_3.getModel().getValueAt(row, 1).toString();

            harga_item = Integer.parseInt(jTable_barang_3.getModel().getValueAt(row, 3).toString());

            System.out.println(harga_item);
            lbl_nm_item.setText(val_nm_barang);

            jDialog_barang.setVisible(false);

        } else {
            //untuk event cari menu
            int row = jTable_barang_3.getSelectedRow();
            int id_nm_barang = Integer.parseInt(jTable_barang_3.getModel().getValueAt(row, 0).toString());
            String val_nm_barang = jTable_barang_3.getModel().getValueAt(row, 1).toString();
            int harga_barang = Integer.parseInt(jTable_barang_3.getModel().getValueAt(row, 3).toString());

            txt_nama_barang.setText(val_nm_barang);
            setIdBarang(id_nm_barang);
            setHrgBarang(harga_barang);
            jDialog_barang.setVisible(false);

        }
    }
    
    private void clear(){
        i_tgl_pengeluaran.setCalendar(null);
        lbl_frmt_nm_outlet.setText("-");
        txt_nama_barang.setText("-");
        txt_frmt_terjual.setText("0");
        txt_qty_item.setText("0");
        lbl_nm_item.setText("-");
        lbl_trans_total_item.setText("0");
        lbl_trans_grandtotal.setText("0");
        clearDraft();
    }
    
    private void clearDraft(){
        DefaultTableModel tblTransaksi = (DefaultTableModel) jTable_transaksi.getModel();
        while (tblTransaksi.getRowCount() > 0) {
            tblTransaksi.removeRow(0);
        }
        
        DefaultTableModel tblPengeluaran = (DefaultTableModel) jTable_pengeluaran.getModel();
        while (tblPengeluaran.getRowCount() > 0) {
            tblPengeluaran.removeRow(0);
        }
        btn_selesai.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog_barang = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_barang_3 = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();
        txt_cari_barang = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jDialog_outlet = new javax.swing.JDialog();
        jPanel21 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTable_outlet3 = new javax.swing.JTable();
        txt_cari_outlet1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        i_tgl_pengeluaran = new com.toedter.calendar.JDateChooser();
        lbl_frmt_nm_outlet = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txt_frmt_terjual = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_nama_barang = new javax.swing.JLabel();
        btn_cari_menu = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable_transaksi = new javax.swing.JTable();
        btn_tambah_trans = new javax.swing.JButton();
        btn_hapus_trans = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btn_selesai = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        rd_trans_ada = new javax.swing.JRadioButton();
        rd_trans_tdkada = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_pengeluaran = new javax.swing.JTable();
        btn_item_additional = new javax.swing.JButton();
        txt_qty_item = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        lbl_nm_item = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btn_tambah_additional = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        lbl_trans_total_item = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbl_trans_grandtotal = new javax.swing.JLabel();
        btn_hitung = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jDialog_barang.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialog_barang.setMinimumSize(new java.awt.Dimension(552, 443));
        jDialog_barang.setUndecorated(true);
        jDialog_barang.setResizable(false);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setText("Barang");

        jTable_barang_3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id barang", "nama barang", "kategory", "harga", "satuan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_barang_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_barang_3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable_barang_3);
        if (jTable_barang_3.getColumnModel().getColumnCount() > 0) {
            jTable_barang_3.getColumnModel().getColumn(0).setResizable(false);
            jTable_barang_3.getColumnModel().getColumn(1).setResizable(false);
            jTable_barang_3.getColumnModel().getColumn(2).setResizable(false);
            jTable_barang_3.getColumnModel().getColumn(3).setResizable(false);
            jTable_barang_3.getColumnModel().getColumn(4).setResizable(false);
        }

        jButton10.setBackground(new java.awt.Color(244, 51, 51));
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("cari");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(244, 51, 51));
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("x");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txt_cari_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(jButton10)))
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton7)
                        .addGap(0, 29, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cari_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jDialog_barangLayout = new javax.swing.GroupLayout(jDialog_barang.getContentPane());
        jDialog_barang.getContentPane().setLayout(jDialog_barangLayout);
        jDialog_barangLayout.setHorizontalGroup(
            jDialog_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog_barangLayout.setVerticalGroup(
            jDialog_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog_barangLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jDialog_outlet.setMinimumSize(new java.awt.Dimension(538, 371));
        jDialog_outlet.setUndecorated(true);
        jDialog_outlet.setResizable(false);

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder("Daftar outlet"));
        jPanel20.setOpaque(false);

        jTable_outlet3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id outlet", "nama outlet", "lokasi", "alamat"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_outlet3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_outlet3MouseClicked(evt);
            }
        });
        jScrollPane16.setViewportView(jTable_outlet3);

        jButton4.setBackground(new java.awt.Color(244, 51, 51));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("cari outlet");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txt_cari_outlet1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4)
                    .addComponent(txt_cari_outlet1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButton8.setBackground(new java.awt.Color(244, 51, 51));
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("x");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton8))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialog_outletLayout = new javax.swing.GroupLayout(jDialog_outlet.getContentPane());
        jDialog_outlet.getContentPane().setLayout(jDialog_outletLayout);
        jDialog_outletLayout.setHorizontalGroup(
            jDialog_outletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog_outletLayout.setVerticalGroup(
            jDialog_outletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(992, 676));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Form transaksi outlet");

        jPanel3.setOpaque(false);

        jLabel4.setText("tanggal closing");

        jLabel5.setText("nama outlet");

        i_tgl_pengeluaran.setBackground(new java.awt.Color(255, 255, 255));
        i_tgl_pengeluaran.setDateFormatString("yyyy-MM-dd ");

        lbl_frmt_nm_outlet.setText("-");

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Penjualan outlet"));
        jPanel8.setOpaque(false);

        jLabel7.setText("terjual");

        txt_frmt_terjual.setText("0");

        jLabel6.setText("nama item");

        txt_nama_barang.setText("-");
        txt_nama_barang.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txt_nama_barangPropertyChange(evt);
            }
        });

        btn_cari_menu.setBackground(new java.awt.Color(244, 51, 51));
        btn_cari_menu.setForeground(new java.awt.Color(255, 255, 255));
        btn_cari_menu.setText("cari item menu");
        btn_cari_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cari_menuActionPerformed(evt);
            }
        });

        jTable_transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id outlet", "id barang", "terjual", "subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_transaksiMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable_transaksi);
        if (jTable_transaksi.getColumnModel().getColumnCount() > 0) {
            jTable_transaksi.getColumnModel().getColumn(0).setResizable(false);
            jTable_transaksi.getColumnModel().getColumn(1).setResizable(false);
            jTable_transaksi.getColumnModel().getColumn(2).setResizable(false);
            jTable_transaksi.getColumnModel().getColumn(3).setResizable(false);
        }

        btn_tambah_trans.setBackground(btn_cari_menu.getBackground());
        btn_tambah_trans.setForeground(btn_cari_menu.getForeground());
        btn_tambah_trans.setText("tambah");
        btn_tambah_trans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambah_transActionPerformed(evt);
            }
        });

        btn_hapus_trans.setBackground(btn_cari_menu.getBackground());
        btn_hapus_trans.setForeground(btn_cari_menu.getForeground());
        btn_hapus_trans.setText("hapus");
        btn_hapus_trans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapus_transActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_nama_barang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_cari_menu, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_frmt_terjual, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_hapus_trans)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_tambah_trans)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(btn_cari_menu)
                .addGap(21, 21, 21)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(txt_nama_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_frmt_terjual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_tambah_trans)
                            .addComponent(btn_hapus_trans)))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(244, 51, 51));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("cari outlet");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(i_tgl_pengeluaran, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_frmt_nm_outlet, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i_tgl_pengeluaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                            .addComponent(lbl_frmt_nm_outlet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_selesai.setBackground(btn_cari_menu.getBackground());
        btn_selesai.setForeground(btn_cari_menu.getForeground());
        btn_selesai.setText("selesai");
        btn_selesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_selesaiActionPerformed(evt);
            }
        });

        jButton5.setBackground(btn_cari_menu.getBackground());
        jButton5.setForeground(btn_cari_menu.getForeground());
        jButton5.setText("kembali");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Addtional barang"));
        jPanel5.setOpaque(false);

        buttonGroup1.add(rd_trans_ada);
        rd_trans_ada.setText("ada");
        rd_trans_ada.setOpaque(false);
        rd_trans_ada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_trans_adaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rd_trans_tdkada);
        rd_trans_tdkada.setText("tidak ada");
        rd_trans_tdkada.setOpaque(false);
        rd_trans_tdkada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_trans_tdkadaActionPerformed(evt);
            }
        });

        jTable_pengeluaran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id outlet", "item", "qty", "subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable_pengeluaran);

        btn_item_additional.setBackground(btn_cari_menu.getBackground());
        btn_item_additional.setForeground(btn_cari_menu.getForeground());
        btn_item_additional.setText("pilih item");
        btn_item_additional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_item_additionalActionPerformed(evt);
            }
        });

        txt_qty_item.setText("0");

        jLabel13.setText("jumlah item");

        lbl_nm_item.setText("-");
        lbl_nm_item.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                lbl_nm_itemPropertyChange(evt);
            }
        });

        jLabel16.setText("nama item");

        btn_tambah_additional.setBackground(btn_cari_menu.getBackground());
        btn_tambah_additional.setForeground(btn_cari_menu.getForeground());
        btn_tambah_additional.setText("tambah");
        btn_tambah_additional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambah_additionalActionPerformed(evt);
            }
        });

        jButton6.setBackground(btn_cari_menu.getBackground());
        jButton6.setForeground(btn_cari_menu.getForeground());
        jButton6.setText("bersihkan");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addGap(20, 321, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(txt_qty_item, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn_tambah_additional)
                                        .addGap(8, 8, 8))
                                    .addComponent(lbl_nm_item, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(rd_trans_ada)
                                .addGap(18, 18, 18)
                                .addComponent(rd_trans_tdkada)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_item_additional)))
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rd_trans_ada)
                    .addComponent(rd_trans_tdkada)
                    .addComponent(btn_item_additional))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nm_item, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_qty_item, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_tambah_additional))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6))
        );

        jLabel12.setText("Total Additional (Rp) ");

        lbl_trans_total_item.setText("0");

        jLabel15.setText("Grand Total (Rp) ");

        lbl_trans_grandtotal.setText("0");

        btn_hitung.setBackground(btn_cari_menu.getBackground());
        btn_hitung.setForeground(btn_cari_menu.getForeground());
        btn_hitung.setText("hitung");
        btn_hitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hitungActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(244, 51, 51));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("bersih");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_selesai, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(25, 25, 25))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_hitung)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lbl_trans_total_item, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                            .addComponent(lbl_trans_grandtotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_trans_total_item, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_trans_grandtotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btn_hitung)
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5)
                            .addComponent(btn_selesai)
                            .addComponent(jButton2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_item_additionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_item_additionalActionPerformed
        // TODO add your handling code here:
        //munculin dialog barang
        readDataBarang("additional", null, jTable_barang_3);
        jDialog_barang.setLocationRelativeTo(null);
        jDialog_barang.setVisible(true);
        setAdditionalBrg(true);//untuk event mouse click di table
    }//GEN-LAST:event_btn_item_additionalActionPerformed

    private void jTable_barang_3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_barang_3MouseClicked
        // TODO add your handling code here:
        eventClickBarang(this.getAdditionalBrg());

    }//GEN-LAST:event_jTable_barang_3MouseClicked

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        String keyword = null;
        if (!txt_cari_barang.getText().isEmpty()) {
            keyword = txt_cari_barang.getText().trim();
            readDataBarang(null, keyword, jTable_barang_3);
        } else {
            JOptionPane.showMessageDialog(null, "nama barang kosong!", "pencarian", 1);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        jDialog_barang.setVisible(false);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btn_cari_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cari_menuActionPerformed
        // TODO add your handling code here:
        //munculin dialog barang
        readDataBarang("menu", null, jTable_barang_3);
        jDialog_barang.setLocationRelativeTo(null);
        jDialog_barang.setVisible(true);
        setAdditionalBrg(false);
    }//GEN-LAST:event_btn_cari_menuActionPerformed

    private void rd_trans_adaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_trans_adaActionPerformed
        // TODO add your handling code here:
        //untuk additional biaya / uang tak terduga
        btn_item_additional.setEnabled(true);
        btn_tambah_additional.setEnabled(true);
        btn_hitung.setEnabled(true);
    }//GEN-LAST:event_rd_trans_adaActionPerformed

    private void btn_tambah_additionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambah_additionalActionPerformed
        subtotal = harga_item * qty_barang;

        //code insert data ke table pengeluaran
        qty_barang = Integer.parseInt(txt_qty_item.getText());
        setSubtotal(harga_item * qty_barang);

        DefaultTableModel model = (DefaultTableModel) jTable_pengeluaran.getModel();
        model.addRow(new Object[]{
            getIdOutlet(), id_nm_barang, qty_barang, getSubtotal()
        });
        btn_hitung.setEnabled(true);

    }//GEN-LAST:event_btn_tambah_additionalActionPerformed

    private void btn_hitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hitungActionPerformed
        // TODO add your handling code here:
        int row_JTBLpengeluaran = jTable_pengeluaran.getRowCount();
        int row_JTBLtransaksi = jTable_transaksi.getRowCount();
        int raw_totalPengeluaran = 0;
        int raw_totalTransaksi = 0;
        int grandTotal = 0;
        for (int i = 0; i < row_JTBLpengeluaran; i++) {
            raw_totalPengeluaran += Integer.parseInt(jTable_pengeluaran.getModel().getValueAt(i, 3).toString());
            System.out.println("data subtotal" + raw_totalPengeluaran);
        }
        for (int i = 0; i < row_JTBLtransaksi; i++) {
            raw_totalTransaksi += Integer.parseInt(jTable_transaksi.getModel().getValueAt(i, 3).toString());
            System.out.println("data transaksi" + raw_totalTransaksi);
        }
        grandTotal = raw_totalTransaksi;
        totalPengeluaran = raw_totalPengeluaran;
        System.out.println("grandTotal =>" + grandTotal);
        //set total semua
        lbl_trans_total_item.setText(String.valueOf(totalPengeluaran));
        lbl_trans_grandtotal.setText(String.valueOf(grandTotal));

        if (rd_trans_ada.isSelected() && raw_totalPengeluaran == 0) {
            btn_selesai.setEnabled(false);
            JOptionPane.showMessageDialog(this, "isi data additional terlebih dahulu", "notifikasi", 2);
        } else if (raw_totalTransaksi == 0) {
            btn_selesai.setEnabled(false);
            JOptionPane.showMessageDialog(this, "isi data transaksi terlebih dahulu", "notifikasi", 2);
        } else {
            //enable tombol selesai
            btn_selesai.setEnabled(true);
            btn_selesai.requestFocus(true);
        }
    }//GEN-LAST:event_btn_hitungActionPerformed

    private void btn_selesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_selesaiActionPerformed
        Date raw_tgl = i_tgl_pengeluaran.getDate();
        tgl_pengeluaran = Library.parsing_Jdate(raw_tgl, "yyyy-MM-dd",null);

        System.out.println(this.getAdditionalBrg());
        if (this.getAdditionalBrg()) {//jika ada pengeluaran
            //insert ke tabel pengeluaran jika ada
            createDataPengeluaran(1, tgl_pengeluaran, getIdOutlet());
        } else {
            createDataPengeluaran(0, tgl_pengeluaran, getIdOutlet());//jika tidak 
        }

        // insert tabel transaksi
        createDataTransaksi(otentikasi.getIdKaryawan(), tgl_pengeluaran);
        if (notifikasi_c_transaksi) {
            JOptionPane.showMessageDialog(this, "data transaksi outlet berhasil di simpan", "notifikasi", 1);
            clear();
        } else {
            JOptionPane.showMessageDialog(this, "data transaksi outlet gagal di simpan", "notifikasi", 2);
        }
    }//GEN-LAST:event_btn_selesaiActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tblPengeluaran = (DefaultTableModel) jTable_pengeluaran.getModel();
        while (tblPengeluaran.getRowCount() > 0) {
            tblPengeluaran.removeRow(0);
        }
        btn_hitung.setEnabled(false);
        lbl_trans_total_item.setText("0");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void rd_trans_tdkadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_trans_tdkadaActionPerformed
        // TODO add your handling code here:
        btn_item_additional.setEnabled(false);
        btn_tambah_additional.setEnabled(false);
        lbl_trans_total_item.setText("0");
        btn_hitung.setEnabled(true);
    }//GEN-LAST:event_rd_trans_tdkadaActionPerformed

    private void txt_nama_barangPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txt_nama_barangPropertyChange
        // TODO add your handling code here:
        jTable_outlet3.requestFocus(true);
    }//GEN-LAST:event_txt_nama_barangPropertyChange

    private void lbl_nm_itemPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lbl_nm_itemPropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_lbl_nm_itemPropertyChange

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btn_tambah_transActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambah_transActionPerformed
        try {
            int terjual = Integer.parseInt(txt_frmt_terjual.getText());
            //code insert data ke table pengeluaran
            setSubtotalMenu(getHrgBarang() * terjual);

            DefaultTableModel model = (DefaultTableModel) jTable_transaksi.getModel();
            model.addRow(new Object[]{
                getIdOutlet(), getIdBarang(), txt_frmt_terjual.getText(), getSubtotalMenu()
            });
            btn_selesai.setEnabled(true);
        } catch (NumberFormatException e) {
            Logger.getLogger(Form_transaksi.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(rootPane, "isi kolom terlebih dahulu", "notifikasi", 2);
        }
        
    }//GEN-LAST:event_btn_tambah_transActionPerformed

    private void jTable_outlet3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_outlet3MouseClicked
        // TODO add your handling code here:
        int row = jTable_outlet3.getSelectedRow();
        String val_nm_outlet = jTable_outlet3.getModel().getValueAt(row, 1).toString();
        int id_nm_outlet = Integer.parseInt(jTable_outlet3.getModel().getValueAt(row, 0).toString());
        setIdOutlet(id_nm_outlet);
        lbl_frmt_nm_outlet.setText(val_nm_outlet);
        jDialog_outlet.setVisible(false);
    }//GEN-LAST:event_jTable_outlet3MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String keyword = null;
        if (!txt_cari_outlet1.getText().isEmpty()) {
            keyword = txt_cari_outlet1.getText().trim();
            readDataOutlet(null, keyword, jTable_outlet3);
        } else {
            JOptionPane.showMessageDialog(null, "nama outlet kosong!", "pencarian", 1);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        jDialog_outlet.setVisible(false);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        readDataOutlet(null, null, jTable_outlet3);
        jDialog_outlet.setLocationRelativeTo(null);
        jDialog_outlet.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_hapus_transActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapus_transActionPerformed
        // TODO add your handling code here:
        try {
            DefaultTableModel tblTransaksi = (DefaultTableModel) jTable_transaksi.getModel();
            int getSelected = jTable_transaksi.getSelectedRow();
            tblTransaksi.removeRow(getSelected);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "pilih terlebih dahulu", "notifikasi", 2);
        }
    }//GEN-LAST:event_btn_hapus_transActionPerformed

    private void jTable_transaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_transaksiMouseClicked
        // TODO add your handling code here:
        btn_hapus_trans.setEnabled(true);
    }//GEN-LAST:event_jTable_transaksiMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cari_menu;
    private javax.swing.JButton btn_hapus_trans;
    private javax.swing.JButton btn_hitung;
    private javax.swing.JButton btn_item_additional;
    private javax.swing.JButton btn_selesai;
    private javax.swing.JButton btn_tambah_additional;
    private javax.swing.JButton btn_tambah_trans;
    private javax.swing.ButtonGroup buttonGroup1;
    public static com.toedter.calendar.JDateChooser i_tgl_pengeluaran;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JDialog jDialog_barang;
    private javax.swing.JDialog jDialog_outlet;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    public static javax.swing.JTable jTable_barang_3;
    public static javax.swing.JTable jTable_outlet3;
    public static javax.swing.JTable jTable_pengeluaran;
    public static javax.swing.JTable jTable_transaksi;
    private javax.swing.JLabel lbl_frmt_nm_outlet;
    private javax.swing.JLabel lbl_nm_item;
    private javax.swing.JLabel lbl_trans_grandtotal;
    private javax.swing.JLabel lbl_trans_total_item;
    private javax.swing.JRadioButton rd_trans_ada;
    private javax.swing.JRadioButton rd_trans_tdkada;
    private javax.swing.JTextField txt_cari_barang;
    private javax.swing.JTextField txt_cari_outlet1;
    public static javax.swing.JTextField txt_frmt_terjual;
    private javax.swing.JLabel txt_nama_barang;
    private javax.swing.JTextField txt_qty_item;
    // End of variables declaration//GEN-END:variables
}
