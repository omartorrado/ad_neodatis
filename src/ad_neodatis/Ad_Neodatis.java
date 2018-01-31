/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad_neodatis;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oracle
 */
public class Ad_Neodatis {    

    public static void main(String[] args) {
        DBHandler db=new DBHandler();
        db.conectar();
        try {
            //db.step2();
            db.showGame();
        } catch (Exception ex) {
            Logger.getLogger(Ad_Neodatis.class.getName()).log(Level.SEVERE, null, ex);
        }
        db.desconectar();
    }
        
}
