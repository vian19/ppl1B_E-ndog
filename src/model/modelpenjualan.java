/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.controllerpenjualan;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class modelpenjualan {

    private final koneksi kon;

    public modelpenjualan() throws SQLException {
        super();
        kon = new koneksi("root", "", "ppl");

    }

    public DefaultTableModel getTableModel() throws SQLException {
        Object[] header = {"idPenjualan", "idPemesanan", "JumlahYangDibayarkan", "HargaTotal", "TanggalPenjualan", "statusPembayaran"};
        DefaultTableModel tableModel = new DefaultTableModel(null, header);

        String sql = "select * from penjualan";
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
}
