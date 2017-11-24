/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.modeluser;
import view.masuk;
import view.homemitra;

/**
 *
 * @author ASUS
 */
public class controlleruser {

    modeluser theModel;
    masuk theView;
    
    public controlleruser(modeluser model, masuk view) {
        theModel = model;
        theView = view;
        theView.addLoginListener(new LoginListener());
        theView.setVisible(true);
    }

    class LoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String user = theView.user().getText();
            String pass = theView.pass().getText();
            int level = theModel.check(user, pass);
            int idmitra = theModel.getID(user, pass);
            if (level == 1) {
                new controllerhometransaktor();
                theView.dispose();
            } else if (level == 2) {
                new controllerhomepeternak();
                theView.dispose();
            } else if (level == 3) {
                new controllerhomepemilik();
                theView.dispose();
            } else if (level == 4) {
                new controllerhomemitra(idmitra);
                theView.dispose();
            } else {
                theView.salah();
            }

        }
    }
}
