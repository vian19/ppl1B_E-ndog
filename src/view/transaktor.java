/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vian
 */
public class transaktor extends javax.swing.JFrame {

    /**
     * Creates new form transaktor
     */
    public transaktor() {
        initComponents();
        tanggal();
    }

    public void tanggal() {
        Thread p = new Thread() {

            public void run() {
                for (;;) {

                    Calendar cal = new GregorianCalendar();
                    int hari = cal.get(Calendar.DAY_OF_MONTH);
                    int bulan = cal.get(Calendar.MONTH);
                    int tahun = cal.get(Calendar.YEAR);
                    tanggalt.setText(hari + "/" + (bulan + 1) + "/" + tahun);
                }
            }
        };
        p.start();
    }

    public String getId() {
        return id.getText();
    }

    public void popUpPesan(String pesan) {
        JOptionPane.showMessageDialog(this, pesan);
    }

    public String gettanggalt() {
        return tanggalt.getText();
    }

    public String getIdp() {
        return idp.getText();
    }

    public String gettanggalp() {
        return tanggalp.getText();
    }

    public String getpembeli() {
        return nama.getText();
    }

    public String getalamat() {
        return alamat.getText();
    }

    public String getproduk() {
        return produk.getText();
    }

    public String getharga() {
        return harga.getText();
    }

    public String getbayar() {
        return bayarr.getText();
    }

    public String getkembalian() {
        return kembaliann.getText();
    }

    public String getbanyak() {
        return banyak.getText();
    }

    public String gettotal() {
        return total.getText();
    }

//    public String getstok() {
//        return stok.getText();
//    }
    public void setId(String isi) {
        this.id.setText(isi);
    }

    public void setIdp(String isi) {
        this.idp.setText(isi);
    }

    public void setpembeli(String isi) {
        this.nama.setText(isi);
    }

    public void setalamat(String isi) {
        this.alamat.setText(isi);
    }

    public void setproduk(String isi) {
        this.produk.setText(isi);
    }

    public void settanggalp(String isi) {
        this.tanggalp.setText(isi);
    }

    public void setharga(String isi) {
        this.harga.setText(isi);
    }

    public void setbayar(String isi) {
        this.bayarr.setText(isi);
    }

    public void setkembalian(String isi) {
        this.kembaliann.setText(isi);
    }

    public void setbanyak(String isi) {
        this.banyak.setText(isi);
    }

    public void settotal(String isi) {
        this.total.setText(isi);
    }

    public int getSelectedRow() {
        return tabel.getSelectedRow();
    }

    public void setTabel(DefaultTableModel tabel) {
        this.tabel.setModel(tabel);
    }

    public String getValueAt(int baris, int kolom) {
        return (String) this.tabel.getValueAt(baris, kolom);
    }

    public void banyak(CaretListener c) {
        banyak.addCaretListener(c);
    }

    public void Simpan(ActionListener e) {
        this.selesai.addActionListener(e);
    }

    public void Batal(ActionListener e) {
        this.batal.addActionListener(e);
    }

    public void addPilihListener(ActionListener listener) {
        pilih.addActionListener(listener);
    }

    public void message(String pesan) {
        JOptionPane.showMessageDialog(this, pesan);
    }

    public void addLogoutListener(ActionListener listener) {
        kembali.addActionListener(listener);
    }

    public void text(boolean status) {
        this.nama.setEnabled(status);
        this.alamat.setEnabled(status);
        this.produk.setEnabled(status);
        this.id.setEnabled(status); //from2
        this.tanggalp.setEnabled(status);
        this.banyak.setEnabled(status);
        this.idp.setEnabled(status);
        this.harga.setEnabled(status);
        this.bayarr.setEnabled(status);
        this.total.setEnabled(status);
        this.kembaliann.setEnabled(status);
    }


    public void buttonsave(boolean status) {
        this.selesai.setEnabled(status);

    }

    public void buttoncancel(boolean status) {
        this.batal.setEnabled(status);

    }


    public void buttonedit(boolean status) {
        this.pilih.setEnabled(status);
    }

    public void bayar(CaretListener c) {
        bayarr.addCaretListener(c);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kembali = new javax.swing.JButton();
        pilih = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        tanggalt = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        batal = new javax.swing.JButton();
        alamat = new javax.swing.JTextField();
        idp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        produk = new javax.swing.JTextField();
        tanggalp = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        harga = new javax.swing.JTextField();
        banyak = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        bayarr = new javax.swing.JTextField();
        total = new javax.swing.JLabel();
        kembaliann = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        selesai = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/kembali.png"))); // NOI18N
        kembali.setBorderPainted(false);
        kembali.setContentAreaFilled(false);
        kembali.setFocusPainted(false);
        getContentPane().add(kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, -1, -1));

        pilih.setText("Pilih");
        getContentPane().add(pilih, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Tanggal Transaksi");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, -1, -1));
        getContentPane().add(tanggalt, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, 150, 20));

        id.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 100, 20));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("IdPenjualan");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel12.setText("Nama Mitra");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));
        getContentPane().add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 160, -1));

        batal.setText("Batal");
        getContentPane().add(batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 80, -1));
        getContentPane().add(alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 160, -1));
        getContentPane().add(idp, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 160, -1));

        jLabel2.setText("Id Pemesanan");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel13.setText("Alamat Mitra");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel14.setText("Nama Produk");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        produk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produkActionPerformed(evt);
            }
        });
        getContentPane().add(produk, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 160, -1));
        getContentPane().add(tanggalp, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 160, -1));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel15.setText("Tanggal Pemesanan");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel16.setText("Harga");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));
        getContentPane().add(harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 160, -1));
        getContentPane().add(banyak, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, 160, -1));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel17.setText("Banyak Pemesanan");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, -1, -1));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel18.setText("Kembalian");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, -1, -1));

        jLabel19.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel19.setText("Bayar");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, -1, -1));

        jLabel20.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel20.setText("Total Harga");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, -1, -1));

        bayarr.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel1.add(bayarr, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 100, -1));

        total.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel1.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 100, 20));

        kembaliann.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel1.add(kembaliann, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 100, 20));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel21.setText("Pembayaran");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 500, 690, 160));

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabel);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 720, 400));

        selesai.setText("Selesai");
        getContentPane().add(selesai, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 670, 80, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/Halaman Sub Fitur.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void produkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_produkActionPerformed

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
            java.util.logging.Logger.getLogger(transaktor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(transaktor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(transaktor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(transaktor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new transaktor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamat;
    private javax.swing.JTextField banyak;
    private javax.swing.JButton batal;
    private javax.swing.JTextField bayarr;
    private javax.swing.JTextField harga;
    private javax.swing.JLabel id;
    private javax.swing.JTextField idp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton kembali;
    private javax.swing.JLabel kembaliann;
    private javax.swing.JTextField nama;
    private javax.swing.JButton pilih;
    private javax.swing.JTextField produk;
    private javax.swing.JButton selesai;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField tanggalp;
    private javax.swing.JLabel tanggalt;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}
