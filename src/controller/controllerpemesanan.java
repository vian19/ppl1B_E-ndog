/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.mysql.jdbc.UpdatableResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import model.modelpemesanan;
import view.pemesanan;

public class controllerpemesanan {

    int id;
    modelpemesanan theModel;
    pemesanan theView;

    public controllerpemesanan(modelpemesanan theModel, pemesanan theView, int id) throws SQLException {
        this.id = id;
        this.theModel = theModel;
        this.theView = theView;
        theView.setVisible(true);
        theView.setTabel(theModel.getTableModel());
        theView.addSaveListener(new controllerpemesanan.saveListener());
        theView.pilihListener(new controllerpemesanan.pilih());
        theView.addCancelListener(new controllerpemesanan.cancelListener());
        theView.addKembaliListener(new kembaliListener());
    }

    private class pilih implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int baris = theView.getSelectedRow();
//            ;
            if (baris != -1) {
                String idStok = theView.getValueAt(baris, 0);
                theView.setidStok(idStok);
                theView.setidMitra("" + id);
                theView.text(true);
                theView.button(true);
            }
        }
    }

    private class cancelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.text(false);
            theView.button(false);
//            theView.buttonadd(true);
        }
    }

//    private class addListener implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            theView.text(true);
//            theView.button(true);
//            theView.buttonadd(false);
//        }
//    }
    private class saveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //pengecekan untuk data kosong
            if (theView.getjumlah().toString().equalsIgnoreCase("")) {
                theView.popUpPesan("Data Tidak Lengkap !");
            } else {
                int jumlahpesan = Integer.parseInt(theView.getjumlah().toString());
                int produkTerpilih = Integer.parseInt(theView.getValueAt(
                        Integer.parseInt(theView.getidStok().toString()) - 1,
                        2
                ).toString());
                //pengecekan bila stok lebih kecil daripada jumlah pemesanan
                if (jumlahpesan > produkTerpilih) {
                    theView.popUpPesan("Maaf, Stok tidak mencukupi");
                } else {
                    boolean hasil = theModel.save("NULL,'" + theView.getidMitra() + "','" + theView.getidStok() + "','" + theView.gettanggal() + "','" + theView.getjumlah() + "','dalam proses'");
                    if (hasil) {
                        theView.popUpPesan("Pemesanan Berhasil");
                        hitungStok();
                    } else {
                        theView.popUpPesan("Pemesanan Gagal");
                    }
                    theView.setTabel(theModel.getTableModel());
                    theView.setidMitra("");
                    theView.setidStok("");
                    theView.settanggal("");
                    theView.setjumlah("");
                    theView.text(false);
                    theView.button(false);
                }
            }
        }
    }

    private class kembaliListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
            new controllerhomemitra(id);
        }
    }

    private void hitungStok() {
        boolean cekUpdate = false;
        int pesanan = Integer.parseInt(theView.getjumlah());
        DefaultTableModel stok = theModel.ambilStok();
        String namaProduk = "";
        int produk = Integer.parseInt(theView.getidStok());
        switch (produk) {
            case 1:
                namaProduk = "Telur Asin Kualitas 1";
                break;
            case 2:
                namaProduk = "Telur Asin Kualitas 2";
                break;
            case 3:
                namaProduk = "Telur Bebek";
                break;
            default:
                System.out.println("ga ada apa apa");
        }
        //mengecek satu persatu stok yang dibeli sesuai pilihan pembeli
        for (int i = 0; i < stok.getRowCount(); i++) {
            //pengecekan stok mana yang akan dibeli
            if (stok.getValueAt(i, 1).toString().equalsIgnoreCase(namaProduk)) {
                //pengecekan apakah produk tersebut, stoknya ada atau tidak
                if (Integer.parseInt(stok.getValueAt(i, 2).toString()) > 0) {
                    int stokBarang = Integer.parseInt(stok.getValueAt(i, 2).toString());
                    int hasil = stokBarang - pesanan;
                    /**
                     * jika hasil lebih kecil, artinya pesanan masih ada, dan
                     * stok sudah habis pada baris i di tabel stok dan akan
                     * dilakukan perhitungan kembali untuk stok di baris
                     * selanjutnya pada tabel
                     *
                     * nilai pada tabel di update menjadi 0, maksudnya untuk
                     * menandakan bahwa stok pada baris tersebut sudah habis,
                     * dan melakukan pengecekan pada baris baris selanjutnya
                     */
                    if (hasil < 0) {
                        cekUpdate = theModel.updateStok(Integer.parseInt(stok.getValueAt(i, 0).toString()), 0);
                        pesanan = hasil * -1;
                        continue;

                        /**
                         * jika hasil = 0, artinya pesanan dan stok pada baris i
                         * di tabel sesuai, dan hanya melakukan update tabel dan
                         * perulangan berhenti, karena tidak ada pesanan yang
                         * tersisa
                         */
                    } else if (hasil == 0) {
                        cekUpdate = theModel.updateStok(Integer.parseInt(stok.getValueAt(i, 0).toString()), 0);
                        break;

                        /**
                         * jika hasil > 0, artinya jumlah stok yang dikurangi
                         * pesanan masih ada sisa, dan update tabel dengan sisa
                         * stok yang ada
                         */
                    } else if (hasil > 0) {
                        cekUpdate = theModel.updateStok(Integer.parseInt(stok.getValueAt(i, 0).toString()), hasil);
                        break;
                    }
                }
            }
        }
        if (cekUpdate) {
            System.out.println("Update produk berhasil");
        } else {
            System.out.println("Update produk gagal");
        }
    }
}
