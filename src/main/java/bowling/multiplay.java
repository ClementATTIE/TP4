/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowling;

/**
 *
 * @author Clément
 */
public class multiplay extends multiplayer{
    String name;
    SinglePlayerGame jeu;
    
    public multiplay(String lname){
    this.name= lname;
    jeu = new SinglePlayerGame();
    
    }

    public multiplay() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public SinglePlayerGame getJeu() {
        return jeu;
    }

    public String getName() {
        return name;
    }
    
    
    
}
