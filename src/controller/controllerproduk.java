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
import model.modelstok;
import view.produk;


public class controllerproduk {

    modelstok theModel;
    produk theView;
    

    public controllerproduk(modelstok theModel, produk theView) throws SQLException {
        this.theModel = theModel;
        this.theView = theView;
        theView.setVisible(true);
        theView.setTabel(theModel.getTableModel());
        theView.addSaveListener(new saveListener());
        theView.addAddShipperListener(new addListener());
        theView.addCancelListener(new cancelListener());
        theView.addDeleteListener(new deleteListener());
        theView.addUpdateListener(new updateListener());
        theView.addEditListener(new editListener());
        theView.addKembaliListener(new kembaliListener());
    }
 
    private class editListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int baris = theView.getSelectedRow();
            if (baris != -1) {

                String stokid = theView.getValueAt(baris, 0);
                String nama = theView.getValueAt(baris, 1);
                String harga = theView.getValueAt(baris, 2);
                String jumlah= theView.getValueAt(baris, 3);
                String masuk= theView.getValueAt(baris, 4);
//                String keluar= theView.getValueAt(baris, 5);
//                String total= theView.getValueAt(baris, 6);
                

                theView.setId(stokid);
//                theView.setnama(nama);
                theView.setharga(harga);
                theView.setjumlah(jumlah);
//                theView.setmasuk(masuk);
//                theView.setkeluar(keluar);
//                theView.settotal(total);
                theView.text(true);
            }
        }
    }

    private class updateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
               int baris = theView.getSelectedRow();
                String stokid = theView.getId();
                String nama = theView.getnama();
                String harga = theView.getharga();
                String jumlah = theView.getjumlah();
                String masuk= theView.getmasuk();
//                String keluar= theView.getkeluar();
//                String total=theView.gettotal();
                
                theModel.update("NamaProduk='" + nama + "', HargaProduk ='" + harga + "',BanyakProduk= '"+jumlah+ "',tanggalMasuk= '"+masuk+"' WHERE idStok=" + stokid);

                theView.text(true);
                theView.button(true);
                theView.buttonadd(false);
                theView.setTabel(theModel.getTableModel());
            } catch (SQLException ex) {
                Logger.getLogger(controllerproduk.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private class cancelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.text(false);
            theView.button(false);
            theView.buttonadd(true);
        }
    }

    private class addListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.text(true);
            theView.button(true);
            theView.buttonadd(false);
        }
    }

    private class deleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int baris = theView.getSelectedRow();
                String stokid = theView.getValueAt(baris, 0);
                System.out.println(stokid);
                theModel.delete(stokid);
                theView.text(true);
                theView.button(true);

                theView.buttonadd(false);
                theView.setTabel(theModel.getTableModel());
            } catch (SQLException ex) {
                Logger.getLogger(controllerproduk.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class saveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theModel.save("NULL,'" + theView.getnama() + "','" + theView.getharga() + "','" + theView.getjumlah() + "','" + theView.getmasuk() + "'" + "");
                theView.setTabel(theModel.getTableModel());
                theView.setharga("");
                theView.setjumlah("");
                theView.btndelete(true);
                theView.text(false);
                theView.button(false);
                theView.buttonadd(true);
            } catch (SQLException ex) {
                Logger.getLogger(controllerproduk.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private class kembaliListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
            new controllerhomepeternak();
        }
    }
}


