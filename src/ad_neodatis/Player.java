/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad_neodatis;

import java.util.Date;

public class Player {

    private String name;
    private Date birthDate;
    private Sport favoriteSport;
    private int salario;

    public Player(String name, Date birthDate, Sport favoriteSport,int salario) {
        this.name = name;
        this.birthDate = birthDate;
        this.favoriteSport = favoriteSport;
        this.salario=salario;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Sport getFavoriteSport() {
        return favoriteSport;
    }

    public void setFavoriteSport(Sport favoriteSport) {
        this.favoriteSport = favoriteSport;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", birthDate=" + birthDate + ", favoriteSport=" + favoriteSport + ", salario=" + salario + '}';
    } 
    
}
