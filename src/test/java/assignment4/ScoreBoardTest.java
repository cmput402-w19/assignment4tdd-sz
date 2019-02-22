package assignment4;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.rule.OutputCapture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ScoreBoardTest {

    @Test
    public void TestScoreBoardConstructor()
    {
        ScoreBoard scoreBoard = new ScoreBoard();
        assertTrue(scoreBoard.getPlayerList().size()==0);
    }

    @Test
    public void TestAddPlayer()
    {
        ScoreBoard scoreBoard = new ScoreBoard();
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");
        scoreBoard.addPlayer(player1);
        scoreBoard.addPlayer(player2);

        List<Player> players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);
        assertTrue(scoreBoard.getPlayerList().equals(players));
    }

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void TestPrintScoreBoard()
    {
        Collections mockCollections = mock(Collections.class);
        ScoreBoard scoreBoard = new ScoreBoard();
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");
        scoreBoard.addPlayer(player1);
        scoreBoard.addPlayer(player2);

        scoreBoard.printScoreBoard();
        
        String printOutput = outputCapture.toString();
        assertTrue(printOutput.contains("============Score Board============"));
        assertTrue(printOutput.contains("player1\t\t[0]"));
        assertTrue(printOutput.contains("player2\t\t[0]"));
        assertTrue(printOutput.contains("==================================="));

        verify(mockCollections).sort(scoreBoard.getPlayerList());
    }
}
