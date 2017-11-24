/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class produk extends javax.swing.JFrame {

    /**
     * Creates new form mengelolaproduk
     */
    public produk() {
       initComponents();
       tanggal();
    }
           public void addKembaliListener(ActionListener listener) {
        kembali.addActionListener(listener);
    }

    public void tanggal() {
        Thread p = new Thread() {

            public void run() {
                for (;;) {

                    Calendar cal = new GregorianCalendar();
                    int hari = cal.get(Calendar.DAY_OF_MONTH);
                    int bulan = cal.get(Calendar.MONTH);
                    int tahun = cal.get(Calendar.YEAR);
                    tanggal.setText(hari + "/" + (bulan + 1) + "/" + tahun);
                }
            }
        };
        p.start();
    }

    public String getId() {
        return id.getText();
    }

//    public String getnama() {
//        return nama.getText();
//    }

    public String getnama() {
        return nama.getSelectedItem().toString();
    }

    public String getharga() {
        return harga.getText();
    }

    public String getjumlah() {
        return jumlah.getText();
    }

    public String getmasuk() {
        return tanggal.getText();
    }
//    public String getkeluar() {
//    return keluar.getText();
//    }
//    public String gettotal() {
//        return total.getText();
//    }
//    

    public void setId(String isi) {
        this.id.setText(isi);
    }

        public void setnama(int nama) {
        this.nama.setSelectedIndex(nama);
    }

    public void setharga(String isi) {
        this.harga.setText(isi);
    }

    public void setjumlah(String isi) {
        this.jumlah.setText(isi);
    }
//    public void setmasuk(String isi) {
//        this.tanggal.setText(isi);
//    }
//    public void setkeluar(String isi) {
//        this.keluar.setText(isi);
//    }
//    public void settotal(String isi) {
//        this.total.setText(isi);
//    }

    public int getSelectedRow() {
        return tabel.getSelectedRow();
    }

    public void setTabel(DefaultTableModel tabel) {
        this.tabel.setModel(tabel);
    }

    public String getValueAt(int baris, int kolom) {
        return (String) this.tabel.getValueAt(baris, kolom);
    }

    public void addSaveListener(ActionListener e) {
        this.btnSave.addActionListener(e);
    }

    public void addCancelListener(ActionListener e) {
        this.btnCancel.addActionListener(e);
    }

    public void addDeleteListener(ActionListener e) {
        this.delete.addActionListener(e);
    }

    public void addUpdateListener(ActionListener e) {
        this.update.addActionListener(e);
    }

    public void addEditListener(ActionListener e) {
        this.edit.addActionListener(e);
    }

    public void addAddShipperListener(ActionListener e) {
        this.btnAddShipper.addActionListener(e);
    }

    public void message(String pesan) {
        JOptionPane.showMessageDialog(this, pesan);
    }

    public void text(boolean status) {
        this.nama.setEnabled(status);
        this.harga.setEnabled(status);
        this.id.setEnabled(status); //from2
        this.jumlah.setEnabled(status);
//        this.tanggal.setEnabled(status);
//        this.keluar.setEnabled(status);
//        this.total.setEnabled(status);
    }

    public void button(boolean status) {
        this.btnSave.setEnabled(status);
        this.btnCancel.setEnabled(status);
        this.update.setEnabled(status);

    }

    public void buttonadd(boolean status) {
        this.btnAddShipper.setEnabled(status);
    }

    public void btndelete(boolean status) {
        this.delete.setEnabled(status);
    }

    public void btnedit(boolean status) {
        this.edit.setEnabled(status);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        edit = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        update = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        btnAddShipper = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        harga = new javax.swing.JTextField();
        id = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jumlah = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tanggal = new javax.swing.JLabel();
        nama = new javax.swing.JComboBox();
        kembali = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        getContentPane().add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 66, -1));

        jLabel3.setText("HargaProduk");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        getContentPane().add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, -1, -1));

        btnCancel.setText("CANCEL");
        btnCancel.setEnabled(false);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, -1, -1));

        btnSave.setText("SAVE");
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, -1, -1));

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        getContentPane().add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, -1, -1));

        btnAddShipper.setText("Add Produk");
        btnAddShipper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddShipperActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddShipper, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel2.setText("NamaProduk");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jLabel1.setText("idStok");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "idStok", "NamaProduk", "HargaProduk", "BanyakProduk", "TanggalMasuk"
            }
        ));
        jScrollPane1.setViewportView(tabel);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 641, 200));

        harga.setEnabled(false);
        getContentPane().add(harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 207, -1));
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 57, 22));

        jLabel6.setText("BanyakProduk");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        jumlah.setEnabled(false);
        jumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumlahActionPerformed(evt);
            }
        });
        getContentPane().add(jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 207, -1));

        jLabel4.setText("TanggalMasuk");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));
        getContentPane().add(tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 207, 23));

        nama.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "Telur Asin Kualitas 1", "Telur Asin Kualitas 2", "Telur Bebek" }));
        nama.setEnabled(false);
        getContentPane().add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 207, -1));

        kembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/kembali.png"))); // NOI18N
        kembali.setBorderPainted(false);
        kembali.setContentAreaFilled(false);
        kembali.setFocusPainted(false);
        getContentPane().add(kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/Stok Barang.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteActionPerformed

    private void btnAddShipperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddShipperActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddShipperActionPerformed

    private void jumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jumlahActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new produk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddShipper;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JTextField harga;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jumlah;
    private javax.swing.JButton kembali;
    private javax.swing.JComboBox nama;
    private javax.swing.JTable tabel;
    private javax.swing.JLabel tanggal;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}