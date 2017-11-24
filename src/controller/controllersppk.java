/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.homepeternak;
import view.sppk;

public class controllersppk {


    private sppk theView;

    public controllersppk( sppk theView) throws SQLException {
        this.theView = theView;
        theView.setVisible(true);
        this.theView.hasilListener(new hasilPerformed());
        theView.addKembaliListener(new kembaliListener());
    }

    private class hasilPerformed implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            double berat = Double.parseDouble(theView.getberat());
            double ukuran = Double.parseDouble(theView.getukuran());
            double hasil = (Math.log(100) / Math.log(10)) * (berat + 7.57 - 1.7 * Math.pow(ukuran, 0.37));
            int pilihan = theView.getPilihanGambar();

            System.out.println(pilihan);
            if (pilihan == 1) {
                if (hasil > 72) {
                    theView.setTindakan("Telur Asin Berkualitas 1");
                } else if (hasil >= 60 && hasil < 72) {
                    theView.setTindakan("Telur Asin Berkualitas 2");
                } else if (hasil > 0 && hasil < 60) {
                    theView.setTindakan("Telur Asin Berkualitas Biasa");
                } else {
                    theView.setTindakan("Tidak Diketahui");
                }
            } else if (pilihan == 2) {
                if (hasil > 72) {
                    theView.setTindakan("Telur Asin Berkualitas 1");
                } else if (hasil >= 60 && hasil < 72) {
                    theView.setTindakan("Telur Asin Berkualitas 2");
                } else if (hasil > 0 && hasil < 60) {
                    theView.setTindakan("Telur Asin Berkualitas Biasa");
                } else {
                    theView.setTindakan("Tidak Diketahui");
                }
            } else if (pilihan == 3) {
                if (hasil > 72) {
                    theView.setTindakan("Telur Asin Berkualitas 1");
                } else if (hasil >= 60 && hasil < 72) {
                    theView.setTindakan("Telur Asin Berkualitas 2");
                } else if (hasil > 0 && hasil < 60) {
                    theView.setTindakan("Telur Asin Berkualitas Biasa");
                } else {
                    theView.setTindakan("Tidak Diketahui");
                }
            }

        }

    }

    public double rumus(double H, double W) {
        double hasil = 0;
        int kualitas = -1;
        hasil = (Math.log(100) / Math.log(10)) * (H + 7.57 - 1.7 * Math.pow(W, 0.37));
        return hasil;
    }

    private class kembaliListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
            new controllerhomepeternak();
        }
    }

}
