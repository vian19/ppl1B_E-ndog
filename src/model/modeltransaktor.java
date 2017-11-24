/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import controller.controllertransaksi;

/**
 *
 * @author Vian
 */
public class modeltransaktor extends supermodel {

    private koneksi kon;

    public modeltransaktor() throws SQLException {
        super();
        kon = new koneksi("root", "", "ppl");
    }

    public DefaultTableModel getTableModel() throws SQLException {
        Object[] header = {"idPemesanan", "tanggalPemesanan", "nama", "alamat", "namaProduk", "HargaProduk", "jumlahProduk", "Status Pembayaran"};
        DefaultTableModel tableModel = new DefaultTableModel(null, header);

        ResultSet rs = kon.getResult("SELECT p.idPemesanan, p.tanggalPemesanan, m.nama, m.alamat,s.namaProduk,s.HargaProduk,p.jumlahProduk,p.statusPembayaran "
                + "from pemesanan p join mitra m on p.idMitra=m.idMitra "
                + "join stok s on p.idStok=s.idStok");

        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }

        while (rs.next()) {
            String baris[] = new String[8];
            for (int i = 0; i < baris.length; i++) {
                baris[i] = rs.getString(i + 1);
            }
            tableModel.addRow(baris);
        }
        return tableModel;
    }

    @Override
    public boolean save(String query) {
        String queries = "INSERT INTO penjualan VALUES (" + query + ")";
        return super.save(queries); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean updatePemesanan(int id) throws SQLException {
        String query = "UPDATE pemesanan SET statusPembayaran='lunas' WHERE idPemesanan = '" + id + "'";
        kon.execute(query);
        return true;
    }

}
