package assignment4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoreBoard {
    private List<Player> playerList;

    public ScoreBoard(){
        playerList = new ArrayList<Player>();
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void addPlayer(Player player){
        playerList.add(player);
    }

    public void printScoreBoard(){
        Collections.sort(playerList);
        System.out.println("============Score Board============");
        for(Player player : playerList){
            System.out.println(player.toString());
        }
        System.out.println("===================================");
    }
}
