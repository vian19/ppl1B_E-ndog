/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.controllerproduk;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;


public class modelstok extends supermodel {
        private final koneksi kon;

    public modelstok() throws SQLException {
        super();
        kon = new koneksi("root", "", "ppl");
       
        }
    
    
    public DefaultTableModel getTableModel() throws SQLException{
        Object[] header = {"idStok", "namaProduk","HargaProduk","BanyakProduk","tanggalMasuk"};
        DefaultTableModel tableModel = new DefaultTableModel(null, header);
        
        String sql ="select * from stok "; 
                //"select namaProduk, SUM(BanyakProduk) as JumlahStok from stok group by namaProduk";
        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
        ResultSet rs = kon.getResult(sql);
        while (rs.next()) {
            String kolom[] = new String[5];
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 1);
            }
            tableModel.addRow(kolom);
        }
        return tableModel;
    }
    
     @Override
    public boolean delete(String query) {
        String queries = "DELETE FROM stok where idStok ='" + query + "'";
        return super.delete(queries); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(String query) {
        String queries = "UPDATE stok SET " + query;
        return super.update(queries); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean save(String query) {
        String queries = "INSERT INTO stok VALUES (" + query + ")";
        return super.save(queries); //To change body of generated methods, choose Tools | Templates.
    }
}
 