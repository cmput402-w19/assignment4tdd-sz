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
        player3.setPlayTime(200000);

        assertTrue(player1.compareTo(player2) == -1);
        assertTrue(player2.compareTo(player3) == 0);
        assertTrue(player3.compareTo(player1) == 1);
    }

    @Test
    public void TestToString()
    {
        Player player = new Player(playerName);
        long expectedPlayTimeInSec = 0;
        String expectedResult = playerName + "\t\t" + "[" + expectedPlayTimeInSec + "] sec";
        assertTrue(player.toString().equals(expectedResult));

        player.setPlayTime(playTime);
        expectedPlayTimeInSec = playTime / 1000;
        expectedResult = playerName + "\t\t" + "[" + expectedPlayTimeInSec + "] sec";
        assertTrue(player.toString().equals(expectedResult));
    }
}
