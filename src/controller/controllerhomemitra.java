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
import javax.swing.JButton;
import model.modeluser;
import model.modelpemesanan;
import view.masuk;
import view.homemitra;
import view.pemesanan;

public class controllerhomemitra {

    int id;
    controlleruser login;
    homemitra theView;

    public controllerhomemitra(int id) {
        this.id = id;
//        theView = view;
        theView = new view.homemitra();
        theView.setVisible(true);
        theView.addtLoginListener(new LoginListener());
        theView.addPemesananListener(new PemesananListener());
        theView.addtLogoutListener(new LogoutListener());

    }

    public void checkLevel(int l) {
        switch (l) {
            case 1:
                theView.mitra();
                break;

            default:
                throw new AssertionError();
        }
    }

    class LoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class PemesananListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theView.dispose();
                controllerpemesanan tambah = new controllerpemesanan(new modelpemesanan(), new pemesanan(), id);
            } catch (SQLException ex) {
                Logger.getLogger(controllerproduk.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    class LogoutListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            modeluser theModel;

            try {
                theView.dispose();
                theModel = new modeluser();
                masuk theView = new masuk();
                controlleruser controller = new controlleruser(theModel, theView);
                theView.setVisible(true);

            } catch (SQLException ex) {
                Logger.getLogger(controllerhomemitra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
