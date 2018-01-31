/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad_neodatis;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.neodatis.odb.Objects;

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
            //db.showGames();
            //db.mostrarDeportes();
            //db.actualizarNombreJugador("patata", "luis");
            //db.mostrarJugadores();
            db.mostrarJugadoresDeporte("Tennis");
            
            
            /*
            //Recuperamos la lista de objetos y los vamos casteando al iterar por ella, para acceder a sus metodos
            
            Objects<Object> lista=db.buscarObjecto(Player.class, "name", "luis");
            
            System.out.println(lista.toArray()[0]);
            while(lista.hasNext()){
                System.out.println("Hay next");
                Player p=(Player)lista.next();
                System.out.println(p.getName());
            }
                    */
        } catch (Exception ex) {
            Logger.getLogger(Ad_Neodatis.class.getName()).log(Level.SEVERE, null, ex);
        }
        db.desconectar();
    }
        
}
