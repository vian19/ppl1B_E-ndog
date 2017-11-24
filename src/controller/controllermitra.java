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
import model.modeluser;
import view.member;


public class controllermitra {


    modeluser theModel;
    member theView;
    

    public controllermitra(modeluser theModel, member theView) throws SQLException {
        this.theModel = theModel;
        this.theView = theView;
        theView.setVisible(true);
        theView.setTabel(theModel.getTableModel());
        theView.addSaveListener(new saveListener());
        theView.addDeleteListener(new deleteListener());  
        theView.addKembaliListener(new kembaliListener());
        theView.setlevel("4");
    }
 
    private class deleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int baris = theView.getSelectedRow();
                String idmember = theView.getValueAt(baris, 0);
                System.out.println(idmember);
                theModel.delete(idmember);

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
                theModel.save("NULL,'" + theView.getuser() + "','" + theView.getpassword() + "','"+theView.getlevel()+"'" + "");
                theView.setTabel(theModel.getTableModel());
                theView.setuser("");
                theView.setpassword("");
                theView.setlevel("");
                theView.btndelete(true);
            } catch (SQLException ex) {
                Logger.getLogger(controllerproduk.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private class kembaliListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
            new controllerhometransaktor();
        }
    }
}
