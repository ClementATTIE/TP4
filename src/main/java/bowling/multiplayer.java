/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowling;
import java.util.ArrayList;
/**
 *
 * @author Clément
 */
public class multiplayer implements multiplayergame{
    
    boolean start = false;
    ArrayList<multiplay> game = new ArrayList<multiplay>();
    int joueur =0;
    SinglePlayerGame a= new SinglePlayerGame();
    
    @Override
    public String startNewGame(String[] playerName) throws Exception {
        if(playerName.length ==0 || playerName == null){
        throw new Exception("il faut au moins un joueur dans la partie");
        }
        game.clear();
        
        for(int i=0;i<playerName.length;i++){
        game.add(new multiplay(playerName[i]));
        }
        start = true;
        return "partie débutée";
        
    }

    @Override
    public String lancer(int nombreDeQuillesAbattues) throws Exception {
        if(start==false){
        throw new Exception("aucune partie en cours");
        }
        a = game.get(joueur).getJeu();
        a.lancer(nombreDeQuillesAbattues);
        
        if(a.isFinished()||a.hasCompletedFrame()){
            joueur = joueur++;
            
        }
        
        if(!start){
            return "partie terminé";
        } else {
            int tour = a.getFrameNumber();
            int ball = a.getNextBallNumber();
            return "Prochain tir du joueur: "+game.get(joueur+1).getName()+", tour n° "+tour+", boule n° "+ball;
            
        }
    }

    @Override
    public int scoreFor(String playerName) throws Exception {
        
        for(int i=0; i< game.size();i++)
            if(game.get(i).getName().equals(playerName)){
            return game.get(i).getJeu().score();
            }
        
        throw new Exception("joueur non trouvé");
    }
    
}
