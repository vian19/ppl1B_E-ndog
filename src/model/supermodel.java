/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;

/**
 *
 * @author Vian Elfada
 */
public class supermodel {

    private koneksi kon;

    public supermodel() throws SQLException {
        this.kon = new koneksi("root", "", "ppl");
    }

    public boolean save(String query) {
        try {
            kon.execute(query);
            return true;
        } catch (SQLException e) {
            e.getMessage();
            return false;
        }
    }

    public boolean update(String query) {
        try {
            kon.execute(query);
            return true;
        } catch (SQLException e) {
            e.getMessage();
            return false;
        }
    }

    public boolean delete(String query) {
        try {
            kon.execute(query);
            return true;
        } catch (SQLException e) {
            e.getMessage();
            return false;
        }
    }

}
