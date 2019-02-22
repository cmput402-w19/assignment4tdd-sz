package assignment4;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.rule.OutputCapture;

import static org.junit.Assert.assertTrue;

public class BoardTest {

    @Test
    public void TestBoardConstructor() {
        Board mockBoard = new Board();
        int[][] gameBoard = mockBoard.getBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertTrue(gameBoard[i][j] == 0);
            }
        }
    }

    @Test
    public void TestMakeAMove() {
        Board mockBoard = new Board();
        int row = 0;
        int col = 0;
        int number = 1;
        mockBoard.makeAMove(row, col, number);
        assertTrue(mockBoard.getBoard()[row][col] == number);

        row = 1;
        col = 2;
        number = 2;
        mockBoard.makeAMove(row, col, number);
        assertTrue(mockBoard.getBoard()[row][col] == number);
    }

    @Test
    public void TestDeleteAMove() {
        Board mockBoard = new Board();

        int row = 0;
        int col = 0;
        int number = 1;
        mockBoard.makeAMove(row, col, number);
        mockBoard.removeAMove(row, col);
        assertTrue(mockBoard.getBoard()[row][col] == 0);

        row = 1;
        col = 2;
        number = 2;
        mockBoard.makeAMove(row, col, number);
        mockBoard.removeAMove(row, col);
        assertTrue(mockBoard.getBoard()[row][col] == 0);
    }

    @Test
    public void TestIsFull() {
        Board mockBoard = new Board();
        int number = 1;

        assertTrue(!mockBoard.isFull());

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                mockBoard.makeAMove(row, col, number);
                number++;
            }
        }

        assertTrue(mockBoard.isFull());
    }

    @Test
    public void TestIsCellEmpty() {
        Board mockBoard = new Board();
        assertTrue(mockBoard.isCellEmpty(1, 2));

        int row = 2;
        int col = 2;
        int number = 1;
        mockBoard.makeAMove(row, col, number);
        assertTrue(!mockBoard.isCellEmpty(2, 2));
    }

    @Test
    public void TestIsWin() {
        Board mockLoseBoard = new Board();
        int number = 1;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                mockLoseBoard.makeAMove(row, col, number);
                number++;
            }
        }
        assertTrue(!mockLoseBoard.isWin());

        Board mockWinBoard1 = new Board();
        mockWinBoard1.makeAMove(0, 0, 8);
        mockWinBoard1.makeAMove(0, 1, 1);
        mockWinBoard1.makeAMove(0, 2, 6);

        mockWinBoard1.makeAMove(1, 0, 3);
        mockWinBoard1.makeAMove(1, 1, 5);
        mockWinBoard1.makeAMove(1, 2, 7);

        mockWinBoard1.makeAMove(2, 0, 4);
        mockWinBoard1.makeAMove(2, 1, 9);
        mockWinBoard1.makeAMove(2, 2, 2);
        assertTrue(mockWinBoard1.isWin());
    }

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void TestPrintEmptyBoard() {
        Board mockBoard = new Board();
        mockBoard.printBoard();
        String printOutput = outputCapture.toString();

        assertTrue(printOutput.contains("-------"));
        assertTrue(printOutput.contains("| | | |"));
    }

    @Test
    public void TestPrintNonEmptyBoard() {
        Board mockBoard = new Board();
        int number = 1;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                mockBoard.makeAMove(row, col, number);
                number++;
            }
        }

        mockBoard.printBoard();

        String printOutput = outputCapture.toString();

        assertTrue(printOutput.contains("-------"));
        assertTrue(printOutput.contains("|1|2|3|"));
        assertTrue(printOutput.contains("|4|5|6|"));
        assertTrue(printOutput.contains("|7|8|9|"));
    }

    @Test
    public void TestIsNumberIsUsed() {
        Board mockBoard = new Board();
        mockBoard.makeAMove(1, 1, 5);
        assertTrue(mockBoard.isNumberIsUsed(5));
        assertTrue(!mockBoard.isNumberIsUsed(6));
    }
}
