/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad_neodatis;

import java.util.Date;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/**
 *
 * @author oracle
 */
public class DBHandler {

    public static final String ODB_NAME = "tutorial1.neodatis";
    ODB odb = null;

    public DBHandler() {

    }

    public void conectar() {
        odb = ODBFactory.open(ODB_NAME);
    }

    public void desconectar() {
        odb.close();
    }

    public void showGames(){
        Objects<Game> game=odb.getObjects(Game.class);
        Game g=null;
        while(game.hasNext()){
            g=game.next();
            System.out.println(g.toString());
        }
    }
    
    /*
    CONSULTAS
    */
    
    //Al metodo le paso la clase y una condicion variable=value, y me devuelve una lista con los objetos
    public Objects<Object> buscarObjecto(Class clase,String var,String varValue){
        
        IQuery query = odb.criteriaQuery(clase,Where.equal(var, varValue));

        Objects<Object> obj = odb.getObjects(query);
        Object object=null;
        
        while(obj.hasNext()){
            object=obj.next();
            System.out.println(object.toString());
        }
        //Hago el reset para que el iterador vuelva a la posicion inicial
        obj.reset();
        return obj;
        
    }
    
    //mostrar deportes
    public void mostrarDeportes(){
        IQuery query = odb.criteriaQuery(Sport.class);
        Objects<Sport> obj = odb.getObjects(query);
        while(obj.hasNext()){
            System.out.println(obj.next().toString());
        }
    }
    
    //mostrar jugadores
    public void mostrarJugadores(){
        IQuery query = odb.criteriaQuery(Player.class);
        Objects<Player> obj = odb.getObjects(query);
        while(obj.hasNext()){
            System.out.println(obj.next().toString());
        }
    }
    
    //actualiza el nombre de un jugador
    public void actualizarNombreJugador(String nombre,String nuevoNombre){
        IQuery query = odb.criteriaQuery(Player.class,Where.equal("name", nombre));
        Objects<Player> obj = odb.getObjects(query);
        Player p=null;
        while(obj.hasNext()){
            p=obj.next();
            p.setName(nuevoNombre);
            odb.store(p);
        }
    }
    
    //mostrar los jugadores de x deporte
    public void mostrarJugadoresDeporte(String deporte){
        IQuery query = odb.criteriaQuery(Player.class,Where.equal("favoriteSport", deporte));
        Objects<Player> obj = odb.getObjects(query);
        while(obj.hasNext()){
            System.out.println(obj.next().toString());
        }
    }
    
    
    
    
    public void step2() throws Exception {
// Create instance
        Sport volleyball = new Sport("volley-ball");
        Sport tennis= new Sport("Tennis");
// Create 4 players
        Player player1 = new Player("olivier", new Date(), volleyball,1000);
        Player player2 = new Player("pierre", new Date(), volleyball,1500);
        Player player3 = new Player("elohim", new Date(), volleyball,2000);
        Player player4 = new Player("minh", new Date(), volleyball,1300);
        Player player5 = new Player("luis",new Date(),tennis,1600);
        Player player6 = new Player("carlos",new Date(),tennis,2000);
        Player player7 = new Player("luis",new Date(),tennis,1500);
        Player player8 = new Player("jose",new Date(),tennis,3000);

        // Create two teams
        Team team1 = new Team("Paris");
        Team team2 = new Team("Montpellier");
        Team team3=new Team("Bordeux");
        Team team4= new Team("Lion");
// Set players for team1
        team1.addPlayer(player1);
        team1.addPlayer(player2);        
// Set players for team2
        team2.addPlayer(player3);
        team2.addPlayer(player4);
        
        team3.addPlayer(player5);
        team3.addPlayer(player6);
        
        team4.addPlayer(player7);
        team4.addPlayer(player8);
// Then create a volley ball game for the two teams
        Game game1 = new Game(new Date(), volleyball, team1, team2);
        Game game2 = new Game(new Date(), tennis, team3, team4);
        try {

// Store the object
            odb.store(game1);
            odb.store(game2);
            odb.commit();
        } finally {
            if (odb != null) {


            }

        }
    }
}
