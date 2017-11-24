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
import model.modelstok;
import model.modelpenjualan;
import view.masuk;
import view.homepemilik; 
import view.melihatstok;
import view.penjualan;


public class controllerhomepemilik {
    controlleruser login;
    homepemilik theView;
    
     public controllerhomepemilik() {
//        theView = view;
        theView = new view.homepemilik();
        theView.setVisible(true);
        theView.addtLoginListener(new LoginListener());
        theView.addtLogoutListener(new LogoutListener());
        theView.addMelihatStok(new MelihatStok());
        theView.addMelihatLaporanPenjualan(new LaporanPenjualan());
}
         public void checkLevel(int l) {
        switch (l) {
            case 1:
                theView.pemilik();
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
           

            } catch (SQLException ex) {
                Logger.getLogger(controllerhomepemilik.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }

          class MelihatStok implements ActionListener{
            @Override
          public void actionPerformed(ActionEvent e) {
           modelstok theModel;
             
            try {
                theView.dispose();
                theModel = new modelstok();
                melihatstok theView = new melihatstok();
                controllermelihatstok theController = new controllermelihatstok(theModel, theView);
                theView.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(controllerhomepemilik.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        }

       class LaporanPenjualan implements ActionListener{
            @Override
          public void actionPerformed(ActionEvent e) {
           modelpenjualan theModel;
             
            try {
                theView.dispose();
                theModel = new modelpenjualan();
                penjualan theView = new penjualan();
                controllerpenjualan theController = new controllerpenjualan(theModel, theView);
                theView.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(controllerhomepemilik.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        }
        }