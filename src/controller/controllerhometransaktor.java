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
import model.modeluser;
import model.modeltransaktor;
import view.hometransaktor;
import view.transaktor;
import view.masuk;
import view.member;

/**
 *
 * @author Vian
 */
public class controllerhometransaktor {

    controlleruser login;
    hometransaktor theView;

    public controllerhometransaktor() {
//        theView = view;
        theView = new view.hometransaktor();
        theView.setVisible(true);
        theView.addtLoginListener(new LoginListener());
        theView.addtLogoutListener(new LogoutListener());
        theView.addPendaftaranMember(new PendaftaranMember());
        theView.addTransaksi(new Transaksi());

    }


    public void checkLevel(int l) {
        switch (l) {
            case 1:
                theView.transaktor();
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

    class PendaftaranMember implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                controllermitra daftar = new controllermitra(new modeluser(), new member());
                theView.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(controllermitra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
        class Transaksi implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                controllertransaksi transaksi = new controllertransaksi(new modeltransaktor(), new transaktor());
                theView.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(controllertransaksi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
