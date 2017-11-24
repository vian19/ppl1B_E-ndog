package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import model.modeluser;
import model.modeltransaktor;
import view.transaktor;
import view.masuk;
import view.hometransaktor;

/**
 *
 * @author Vian
 */
public class controllertransaksi {

    transaktor theView;
    modeltransaktor theModel;
    hometransaktor view;

    public controllertransaksi(modeltransaktor theModel, transaktor theView) throws SQLException {
        this.theModel = theModel;
        this.theView = theView;
        theView.setVisible(true);
        theView.setTabel(theModel.getTableModel());
        theView.Simpan(new selesai());
        theView.Batal(new batal());
        theView.addPilihListener(new pilihListener());
        theView.bayar(new bayar());
        theView.banyak(new total());
        theView.addLogoutListener(new kembaliListener());
    }

    private class bayar implements CaretListener {

        @Override
        public void caretUpdate(CaretEvent e) {

            if (theView.getbayar().equals("")) {
                theView.setkembalian("0");
            } else {
                theView.setkembalian(Integer.parseInt(theView.getbayar()) - Integer.parseInt(theView.gettotal())+ "");
            }
        }
    }

    private class total implements CaretListener {

        @Override
        public void caretUpdate(CaretEvent e) {

            if (theView.getbanyak().equals("")) {
                theView.settotal("0");
            } else {
                theView.settotal(Integer.parseInt(theView.getharga()) * Integer.parseInt(theView.getbanyak())
                        + "");
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


    private class batal implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.text(false);
            theView.buttonsave(true);
            theView.buttoncancel(true);
            theView.buttonedit(true);
            
            theView.setIdp("");
            theView.settanggalp("");
            theView.setpembeli("");
            theView.setalamat("");
            theView.setproduk("");
            theView.setharga("");
            theView.setbanyak("");
            theView.setbayar("");
            theView.settotal("");
            theView.setkembalian("");
       }
    }

    private class pilihListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int baris = theView.getSelectedRow();
            if (theView.getValueAt(baris, 7).equalsIgnoreCase("lunas")) {
                theView.popUpPesan("Maaf, Pemesanan sudah lunas!");
            } else {
                if (baris != -1) {
                    String idPemesanan = theView.getValueAt(baris, 0);
                    String tanggalPemesanan = theView.getValueAt(baris, 1);
                    String nama = theView.getValueAt(baris, 2);
                    String alamat = theView.getValueAt(baris, 3);
                    String namaProduk = theView.getValueAt(baris, 4);
                    String HargaProduk = theView.getValueAt(baris, 5);
                    String jumlahProduk = theView.getValueAt(baris, 6);

                    theView.setIdp(idPemesanan);
                    theView.settanggalp(tanggalPemesanan);
                    theView.setpembeli(nama);
                    theView.setalamat(alamat);
                    theView.setproduk(namaProduk);
                    theView.setharga(HargaProduk);
                    theView.setbanyak(jumlahProduk);

                    theView.text(true);
//                theView.textbayar(true);
                    theView.buttonsave(true);
                    theView.buttoncancel(true);

                }
            }
        }
    }

    private class selesai implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (Integer.parseInt(theView.getkembalian()) >= 0) {
                    if (Integer.parseInt(theView.getkembalian()) > 0) {
                        theView.popUpPesan("Uang Anda Kembali " + theView.getkembalian());
                    }
                    theModel.save("NULL,'" + theView.getIdp() + "','" + theView.getbayar() + "','" + theView.gettotal() + "','" + theView.gettanggalt() + "'" + "");
                    theModel.updatePemesanan(Integer.parseInt(theView.getIdp()));
                } else {
                    theView.popUpPesan("Uang Anda Kurang " + theView.getkembalian().replace("-", ""));
                }
                theView.setTabel(theModel.getTableModel());
                theView.setId("");
                theView.setIdp("");
                theView.setpembeli("");
                theView.setbanyak("");
                theView.setharga("");
                theView.settotal("");
                theView.setbayar("");
                theView.setkembalian("");

                theView.text(false);
                theView.buttonsave(false);
                theView.buttoncancel(false);
                theView.buttonedit(true);
            } catch (SQLException ex) {
                Logger.getLogger(controllertransaksi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
