package assignment4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoreBoard {
    private List<Player> players;

    public ScoreBoard(){
        players = new ArrayList<Player>();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public void printScoreBoard(){
        Collections.sort(players);
        System.out.println("----------");
        for(Player player : players){
            System.out.println(player.toString());
        }
        System.out.println("----------");
    }
}
