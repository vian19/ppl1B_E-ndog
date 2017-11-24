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
import view.melihatstok;


public class controllermelihatstok {
      modelstok theModel;
    melihatstok theView;
    
    public controllermelihatstok(modelstok theModel,melihatstok theView)  throws SQLException {
        this.theModel = theModel;
        this.theView = theView;
        theView.setVisible(true);
        theView.setTabel(theModel.getTableModel());
        theView.addKembaliListener(new kembaliListener());
    }
        private class kembaliListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
            new controllerhomepemilik();
        }
    }
}