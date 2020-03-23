/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applaporan;

import controller.MainController;
import static controller.Otentikasi.getGrant;
import databases.CrudModel;
import static databases.CrudModel.readDataOutlet;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Rifky <qnoy.rifky@gmail.com>
 */
public class Laporan extends javax.swing.JFrame {
    MainController frame = new MainController();
    static int outletid = 0;
    Map outlet_meta = new HashMap();

    /**
     * Creates new form Form_laporan_penjualan
     */
    public Laporan() {
        if (getGrant()) {
            initComponents();
            btn_cari_outlet.requestFocus(true);
            btn_cetak_omsetBersih.setEnabled(false);
            btn_cetak_omsetKotor.setEnabled(false);
            btn_cetak_uangSetoran.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(rootPane, "silahkan login dahulu", "tidak ada akses", 2);
            frame.showLoginApp();
        }

    }

    private void setIdOutlet(int var) {
        outletid = var;
    }

    public static int getIdOutlet() {
        return outletid;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog_outlet = new javax.swing.JDialog();
        jPanel21 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTable_outlet4 = new javax.swing.JTable();
        txt_cari_outlet1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_cari_outlet = new javax.swing.JButton();
        lbl_outlet_alamat = new javax.swing.JLabel();
        lbl_outlet = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        rpt_tanggal_akhir = new com.toedter.calendar.JDateChooser();
        jButton5 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        rpt_tanggal_awal = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        btn_cetak_omsetKotor = new javax.swing.JButton();
        btn_cetak_uangSetoran = new javax.swing.JButton();
        btn_cetak_omsetBersih = new javax.swing.JButton();

        jDialog_outlet.setMinimumSize(new java.awt.Dimension(466, 359));
        jDialog_outlet.setResizable(false);

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder("Daftar outlet"));
        jPanel20.setOpaque(false);

        jTable_outlet4.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable_outlet4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_outlet4MouseClicked(evt);
            }
        });
        jScrollPane16.setViewportView(jTable_outlet4);

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
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txt_cari_outlet1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)))
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

        jButton8.setText("x");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jDialog_outletLayout = new javax.swing.GroupLayout(jDialog_outlet.getContentPane());
        jDialog_outlet.getContentPane().setLayout(jDialog_outletLayout);
        jDialog_outletLayout.setHorizontalGroup(
            jDialog_outletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jDialog_outletLayout.setVerticalGroup(
            jDialog_outletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Laporan");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Outlet"));
        jPanel2.setOpaque(false);

        btn_cari_outlet.setBackground(new java.awt.Color(244, 51, 51));
        btn_cari_outlet.setForeground(new java.awt.Color(255, 255, 255));
        btn_cari_outlet.setText("cari outlet");
        btn_cari_outlet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cari_outletActionPerformed(evt);
            }
        });

        lbl_outlet_alamat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_outlet_alamat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_outlet_alamat.setText("alamat");
        lbl_outlet_alamat.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lbl_outlet.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_outlet.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_outlet.setText("lokasi");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbl_outlet, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbl_outlet_alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addComponent(btn_cari_outlet)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_outlet, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_outlet_alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_cari_outlet)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("priode"));
        jPanel3.setOpaque(false);

        rpt_tanggal_akhir.setDateFormatString("yyyy-MM-dd ");

        jButton5.setBackground(new java.awt.Color(244, 51, 51));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("cari data");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("tanggal");

        rpt_tanggal_awal.setDateFormatString("yyyy-MM-dd ");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("tanggal");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton5))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rpt_tanggal_akhir, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rpt_tanggal_awal, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 27, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rpt_tanggal_awal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rpt_tanggal_akhir, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton5)
                .addContainerGap())
        );

        jButton7.setBackground(new java.awt.Color(244, 51, 51));
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("kembali");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(244, 51, 51));
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("bersihkan");

        btn_cetak_omsetKotor.setBackground(new java.awt.Color(244, 51, 51));
        btn_cetak_omsetKotor.setForeground(new java.awt.Color(255, 255, 255));
        btn_cetak_omsetKotor.setText("laporan pendapatan kotor");
        btn_cetak_omsetKotor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cetak_omsetKotorActionPerformed(evt);
            }
        });

        btn_cetak_uangSetoran.setBackground(new java.awt.Color(244, 51, 51));
        btn_cetak_uangSetoran.setForeground(new java.awt.Color(255, 255, 255));
        btn_cetak_uangSetoran.setText("cetak uang setoran");
        btn_cetak_uangSetoran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cetak_uangSetoranActionPerformed(evt);
            }
        });

        btn_cetak_omsetBersih.setBackground(new java.awt.Color(244, 51, 51));
        btn_cetak_omsetBersih.setForeground(new java.awt.Color(255, 255, 255));
        btn_cetak_omsetBersih.setText("laporan pendapatan bersih");
        btn_cetak_omsetBersih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cetak_omsetBersihActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_cetak_omsetKotor, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cetak_omsetBersih, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cetak_uangSetoran, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 25, Short.MAX_VALUE))
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btn_cetak_omsetKotor)
                        .addGap(18, 18, 18)
                        .addComponent(btn_cetak_omsetBersih)
                        .addGap(14, 14, 14)
                        .addComponent(btn_cetak_uangSetoran))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void putReport(String whatis) {

        Date tanggalAwal_rpt = rpt_tanggal_awal.getDate();
        Date tanggalAkhir_rpt = rpt_tanggal_akhir.getDate();
        String final_tanggalAwal_rpt = Library.parsing_Jdate(tanggalAwal_rpt, "yyyy-MM-dd");
        String final_tanggalAkhir_rpt = Library.parsing_Jdate(tanggalAkhir_rpt, "yyyy-MM-dd");

        Library.getReport(final_tanggalAwal_rpt, final_tanggalAkhir_rpt, whatis, getIdOutlet(), outlet_meta);
    }
    private void btn_cetak_omsetKotorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetak_omsetKotorActionPerformed
        this.putReport("omsetkotor");
    }//GEN-LAST:event_btn_cetak_omsetKotorActionPerformed

    private void btn_cetak_uangSetoranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetak_uangSetoranActionPerformed
        this.putReport("uangsetoran");
    }//GEN-LAST:event_btn_cetak_uangSetoranActionPerformed

    private void btn_cetak_omsetBersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetak_omsetBersihActionPerformed
        this.putReport("omsetbersih");
    }//GEN-LAST:event_btn_cetak_omsetBersihActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btn_cari_outletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cari_outletActionPerformed
        readDataOutlet(null, null, jTable_outlet4);
        jDialog_outlet.setLocationRelativeTo(null);
        jDialog_outlet.setVisible(true);
    }//GEN-LAST:event_btn_cari_outletActionPerformed

    private void jTable_outlet4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_outlet4MouseClicked
        int row = jTable_outlet4.getSelectedRow();
        String val_nm_outlet = jTable_outlet4.getModel().getValueAt(row, 1).toString();
        int id_nm_outlet = Integer.parseInt(jTable_outlet4.getModel().getValueAt(row, 0).toString());
        String val_almt_outlet = jTable_outlet4.getModel().getValueAt(row, 3).toString();
        setIdOutlet(id_nm_outlet);
        lbl_outlet.setText(val_nm_outlet);
        lbl_outlet_alamat.setText(val_almt_outlet);

        outlet_meta.put("om_nama", val_nm_outlet);
        outlet_meta.put("om_info", val_almt_outlet);

        //close dialog
        jDialog_outlet.setVisible(false);
    }//GEN-LAST:event_jTable_outlet4MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        jDialog_outlet.setVisible(false);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO :
        //pakai sub query sum lagi jika gk ketemu cara untuk proses sum di jreport
        HashMap<String, Integer> get_data = new HashMap<String, Integer>();
        int sumOmsetKotor = 0;
        int sumUangStoran = 0;
        Date tanggalAwal_rpt = rpt_tanggal_awal.getDate();
        Date tanggalAkhir_rpt = rpt_tanggal_akhir.getDate();
        String final_tanggalAwal_rpt = Library.parsing_Jdate(tanggalAwal_rpt, "yyyy-MM-dd");
        String final_tanggalAkhir_rpt = Library.parsing_Jdate(tanggalAkhir_rpt, "yyyy-MM-dd");

        get_data = CrudModel.getTotalReport("omsetkotor", getIdOutlet(), final_tanggalAwal_rpt, final_tanggalAkhir_rpt);
        if (get_data.get("data_t_omsetkotor") != 0) {
            sumOmsetKotor = get_data.get("data_t_omsetkotor");
            JOptionPane.showMessageDialog(this, "data omset kotor ditemukan", "notifikasi", 1);
            System.out.println("total sum : " + sumOmsetKotor);
            outlet_meta.put("om_sum_omsetkotor", sumOmsetKotor);
            btn_cetak_omsetKotor.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "tidak ada data omset kotor", "notifikasi", 2);
        }

        get_data = CrudModel.getTotalReport("omsetbersih", getIdOutlet(), final_tanggalAwal_rpt, final_tanggalAkhir_rpt);
        if (get_data.get("data_omsetbersih") != 0) {
            JOptionPane.showMessageDialog(this, "data omset bersih ditemukan", "notifikasi", 1);
            btn_cetak_omsetBersih.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "tidak ada data omset bersih", "notifikasi", 2);
        }

        get_data = CrudModel.getTotalReport("uangstoran", getIdOutlet(), final_tanggalAwal_rpt, final_tanggalAkhir_rpt);
        if (get_data.get("data_t_uangstoran") != 0) {
            sumUangStoran = get_data.get("data_t_uangstoran");
            JOptionPane.showMessageDialog(this, "data uang setoran ditemukan", "notifikasi", 1);
            System.out.println("total sum : " + sumUangStoran);
            outlet_meta.put("om_sum_uangstoran", sumUangStoran);
            btn_cetak_uangSetoran.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "tidak ada data uang storan", "notifikasi", 2);
        }

    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Laporan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cari_outlet;
    private javax.swing.JButton btn_cetak_omsetBersih;
    private javax.swing.JButton btn_cetak_omsetKotor;
    private javax.swing.JButton btn_cetak_uangSetoran;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JDialog jDialog_outlet;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane16;
    public static javax.swing.JTable jTable_outlet4;
    private javax.swing.JLabel lbl_outlet;
    private javax.swing.JLabel lbl_outlet_alamat;
    private com.toedter.calendar.JDateChooser rpt_tanggal_akhir;
    private com.toedter.calendar.JDateChooser rpt_tanggal_awal;
    private javax.swing.JTextField txt_cari_outlet1;
    // End of variables declaration//GEN-END:variables
}
