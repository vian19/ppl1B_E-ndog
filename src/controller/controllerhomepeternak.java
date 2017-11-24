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
import view.masuk;
import view.homepeternak; 
import view.produk;
import view.sppk;



public class controllerhomepeternak {
    controlleruser login;
    homepeternak theView;
    
     public controllerhomepeternak() {
//        theView = view;
        theView = new view.homepeternak();
        theView.setVisible(true);
        theView.addtLoginListener(new LoginListener());
        theView.addsppk(new SPPKListener());
        theView.addMengelolaProduk(new ProdukListener());
        theView.addtLogoutListener(new LogoutListener());
 
}
         public void checkLevel(int l) {
        switch (l) {
            case 1:
                theView.peternak();
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
    class ProdukListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
           try {
            theView.dispose();
            controllerproduk mengelola = new controllerproduk(new modelstok(), new produk());
        } catch (SQLException ex) {
            Logger.getLogger(controllerproduk.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
        class SPPKListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
           try {
            theView.dispose();
            controllersppk mengelola = new controllersppk(new sppk());
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