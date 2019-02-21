package assignment4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class PlayerTest {

    private String playerName = "TestPlayer1";
    private long playTime = 12345;

    @Test
    public void TestPlayerConstructor()
    {
        Player player = new Player(playerName);
        assertTrue(player.getPlayerName().equals(playerName));
        assertTrue(player.getPlayTime() == 0);
    }

    @Test
    public void TestSetPlayTime()
    {
        Player player = new Player(playerName);
        player.setPlayTime(playTime);
        assertTrue(player.getPlayTime() == playTime);
    }

    @Test
    public void TestGetPlayTime()
    {
        Player player = new Player(playerName);
        assertTrue(player.getPlayTime() == 0);
        player.setPlayTime(playTime);
        assertTrue(player.getPlayTime() == playTime);
    }

    @Test
    public void TestCompareTo()
    {
        Player player1 = new Player("TestPlayer1");
        Player player2 = new Player("TestPlayer2");
        Player player3 = new Player("TestPlayer3");

        player1.setPlayTime(100000);
        player2.setPlayTime(200000);
        player3.setPlayTime(300000);

        List<Player> playerList = new ArrayList<Player>();
        playerList.add(player3);
        playerList.add(player2);
        playerList.add(player1);

        Collections.sort(playerList);

        assertTrue(playerList.get(0).getPlayerName().equals(player1.getPlayerName()));
        assertTrue(playerList.get(1).getPlayerName().equals(player2.getPlayerName()));
        assertTrue(playerList.get(2).getPlayerName().equals(player3.getPlayerName()));
    }

    @Test
    public void TestToString()
    {
        Player player = new Player(playerName);
        long expectedPlayTimeInSec = 0;
        String expectedResult = playerName + "\t\t" + "[" + expectedPlayTimeInSec + "]";
        assertTrue(player.toString().equals(expectedResult));

        player.setPlayTime(playTime);
        expectedPlayTimeInSec = playTime / 1000;
        expectedResult = playerName + "\t\t" + "[" + expectedPlayTimeInSec + "]";
        assertTrue(player.toString().equals(expectedResult));
    }
}
