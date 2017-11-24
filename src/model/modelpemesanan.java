/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import controller.controllerpemesanan;

/**
 *
 * @author Vian
 */
public class modelpemesanan extends supermodel {

    private final koneksi kon;

    public modelpemesanan() throws SQLException {
        super();
        kon = new koneksi("root", "", "ppl");
    }

    public DefaultTableModel getTableModel() {
        Object[] header = {"Id Produk", "Produk", "Banyak Produk", "Harga Produk"};
        DefaultTableModel tableModel = new DefaultTableModel(null, header);

        String sql = "select idStok, namaProduk, SUM(BanyakProduk) as JumlahStok , HargaProduk from stok group by namaProduk";
        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
        try {
            ResultSet rs = kon.getResult(sql);
            while (rs.next()) {
                String kolom[] = new String[4];
                for (int i = 0; i < kolom.length; i++) {
                    kolom[i] = rs.getString(i + 1);
                }
                tableModel.addRow(kolom);
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return tableModel;
    }

    @Override
    public boolean save(String query) {
        String queries = "INSERT INTO pemesanan VALUES (" + query + ")";
        System.out.println(queries);
        return super.save(queries); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * method untuk mengambil data stok, dan diproses pada controller untuk
     * mengurangi stok yang dipesan
     *
     * @throws SQLException
     */
    public DefaultTableModel ambilStok() {
        Object[] header = {"Id Stok", "namaProduk", "banyak stok"};
        String sql = "SELECT idStok, namaProduk, BanyakProduk FROM stok;";
        DefaultTableModel hasil = new DefaultTableModel(null, header);
        try {
            ResultSet rs = kon.getResult(sql);
            while (rs.next()) {
                String kolom[] = new String[3];
                for (int i = 0; i < kolom.length; i++) {
                    kolom[i] = rs.getString(i + 1);
                }
                hasil.addRow(kolom);
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return hasil;
    }

    public boolean updateStok(int id, int stok) {
        String sql = "UPDATE stok SET BanyakProduk = " + stok + " WHERE idStok = " + id + ";";
        return super.update(sql);
    }

}
