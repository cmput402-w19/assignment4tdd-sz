package assignment4;

import org.junit.Test;

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
}
