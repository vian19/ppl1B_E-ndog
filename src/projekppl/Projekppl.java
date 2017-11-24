/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekppl;

import controller.controlleruser;
import java.sql.SQLException;
import model.modeluser;
import view.masuk;

public class Projekppl {

    public static void main(String[] args) throws SQLException {
        modeluser theModel = new modeluser();
        masuk theView = new masuk();
        controlleruser theController = new controlleruser(theModel, theView);
    }

}
