package assignment4;


import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.springframework.boot.test.rule.OutputCapture;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertTrue;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.mockito.Mockito.*;

public class GameTest {

    @Test
    public void TestGameConstructor() {
        Game mockGame = new Game();

        assertTrue(mockGame.scoreBoard.getPlayerList().size() == 0);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertTrue(mockGame.board.getBoard()[i][j] == 0);
            }
        }
    }

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void TestPlayWin() {
        Game mockGame = new Game();
        mockGame.player = new Player("MockPlayer");

        mockGame.board = new Board();
        mockGame.board.makeAMove(0, 0, 8);
        mockGame.board.makeAMove(0, 1, 1);
        mockGame.board.makeAMove(0, 2, 6);

        mockGame.board.makeAMove(1, 0, 3);
        mockGame.board.makeAMove(1, 1, 5);
        mockGame.board.makeAMove(1, 2, 7);

        mockGame.board.makeAMove(2, 0, 4);
        mockGame.board.makeAMove(2, 1, 9);
        mockGame.board.makeAMove(2, 2, 2);

        mockGame.play();

        String printOutput = outputCapture.toString();
        assertTrue(printOutput.contains("Welcome MockPlayer! Let's start."));

        assertTrue(printOutput.contains("Congrats! You won."));
    }

    @Test
    public void TestPlayMakeAMoveAndWin() {
        Game mockGame = mock(Game.class);

        when(mockGame.enterAddOrDelete()).thenReturn("a");
        when(mockGame.enterRowOrCol("row")).thenReturn(1).thenReturn(0);
        when(mockGame.enterRowOrCol("column")).thenReturn(1).thenReturn(0);
        when(mockGame.enterNumber()).thenReturn(8);
        doCallRealMethod().when(mockGame).play();

        mockGame.player = new Player("MockPlayer");

        mockGame.board = new Board();
        mockGame.board.makeAMove(0, 0, 0);
        mockGame.board.makeAMove(0, 1, 1);
        mockGame.board.makeAMove(0, 2, 6);

        mockGame.board.makeAMove(1, 0, 3);
        mockGame.board.makeAMove(1, 1, 5);
        mockGame.board.makeAMove(1, 2, 7);

        mockGame.board.makeAMove(2, 0, 4);
        mockGame.board.makeAMove(2, 1, 9);
        mockGame.board.makeAMove(2, 2, 2);

        mockGame.play();

        String printOutput = outputCapture.toString();

        assertTrue(printOutput.contains("This cell has been occupied!"));
        assertTrue(printOutput.contains("Congrats! You won."));
    }

    @Test
    public void TestPlayDeleteAndMakeAMoveAndFull() {
        Game mockGame = mock(Game.class);

        when(mockGame.enterAddOrDelete()).thenReturn("a").thenReturn("a").thenReturn("a").thenReturn("d").thenReturn("a").thenReturn("a");
        when(mockGame.enterRowOrCol("row")).thenReturn(0).thenReturn(0).thenReturn(0).thenReturn(0).thenReturn(0).thenReturn(0);
        when(mockGame.enterRowOrCol("column")).thenReturn(0).thenReturn(1).thenReturn(0).thenReturn(1).thenReturn(0).thenReturn(1);
        when(mockGame.enterNumber()).thenReturn(1).thenReturn(8).thenReturn(8).thenReturn(1);
        doCallRealMethod().when(mockGame).play();

        mockGame.player = new Player("MockPlayer");

        mockGame.board = new Board();
        mockGame.board.makeAMove(0, 0, 0);
        mockGame.board.makeAMove(0, 1, 0);
        mockGame.board.makeAMove(0, 2, 6);

        mockGame.board.makeAMove(1, 0, 3);
        mockGame.board.makeAMove(1, 1, 5);
        mockGame.board.makeAMove(1, 2, 7);

        mockGame.board.makeAMove(2, 0, 4);
        mockGame.board.makeAMove(2, 1, 9);
        mockGame.board.makeAMove(2, 2, 2);

        mockGame.play();

        String printOutput = outputCapture.toString();

        assertTrue(printOutput.contains("Keep trying. Something is still wrong!"));
        assertTrue(printOutput.contains("Congrats! You won."));
    }


    @Rule
    public final TextFromStandardInputStream inputStream = emptyStandardInputStream();

    @Test
    public void TestEnterAddOrDelete() {
        Game mockGame = new Game();
        inputStream.provideLines("b", "a");
        assertTrue(mockGame.enterAddOrDelete().equals("a"));

        String printOutput = outputCapture.toString();

        assertTrue(printOutput.contains("Please enter add or delete(a/d):"));
    }

    @Test
    public void TestEnterRowOrCol() {
        Game mockGame = new Game();

        inputStream.provideLines("a", "1");
        assertTrue(mockGame.enterRowOrCol("row") == 1);

        String printOutput = outputCapture.toString();
        assertTrue(printOutput.contains("Please enter a row number(0, 1, 2):"));
    }

    @Test
    public void TestEnterNumber() {
        Game mockGame = new Game();

        mockGame.board = new Board();
        mockGame.board.makeAMove(0, 0, 2);

        inputStream.provideLines("", "0", "2", "1");
        assertTrue(mockGame.enterNumber() == 1);

        String printOutput = outputCapture.toString();

        assertTrue(printOutput.contains("Please enter a number(1~9):"));
        assertTrue(printOutput.contains("This number has been used!"));
    }
}
