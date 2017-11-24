/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class modeluser extends supermodel {

    koneksi kon;

    public modeluser() throws SQLException {
        super();
        kon = new koneksi("root", "", "ppl");
    }
    public DefaultTableModel getTableModel() throws SQLException{
        Object[] header = {"id_user", "username","password","level"};
        DefaultTableModel tableModel = new DefaultTableModel(null, header);
        
        String sql = "select * from user where level=4";
        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
        ResultSet rs = kon.getResult(sql);
        while (rs.next()) {
            String kolom[] = new String[4];
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 1);
            }
            tableModel.addRow(kolom);
        }
        return tableModel;
    }
    public int check(String user, String pass) {
        String query = "SELECT * FROM user WHERE username = '" + user + "' and password = '" + pass + "'";
        int level = 0;
        try {
            ResultSet rs = kon.getResult(query);
            while (rs.next()) {
                level = Integer.valueOf(rs.getString(4));
            }
        } catch (SQLException ex) {
            ex.getSQLState();
        }
        return level;
    }

    /**
     * query masih salah, ga bisa ambil id mitra
     *
     * @param user
     * @param pass
     * @return
     */
    public int getID(String user, String pass) {
        String query = "SELECT m.idMitra FROM mitra m JOIN user u ON m.idUser = u.id_user WHERE u.username = '" + user + "' or u.password = '" + pass + "'";
        int id = -1;
        try {
            ResultSet rs = kon.getResult(query);
            while (rs.next()) {
                id = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.getMessage();
        }
        return id;
    }
        
     @Override
    public boolean delete(String query) {
        String queries = "DELETE FROM user where id_user ='" + query + "'";
        return super.delete(queries); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean save(String query) {
        String queries = "INSERT INTO user VALUES (" + query + ")";
        return super.save(queries); //To change body of generated methods, choose Tools | Templates.
    }
}
