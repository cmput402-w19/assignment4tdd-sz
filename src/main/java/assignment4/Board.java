package assignment4;


import java.util.Arrays;

public class Board {
    private int gameBoard[][];

    public Board() {
        gameBoard = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // 0 means empty
                gameBoard[i][j] = 0;
            }
        }
    }

    public int[][] getBoard() {
        return gameBoard;
    }

    public void makeAMove(int row, int col, int number) {
        gameBoard[row][col] = number;
    }

    public void removeAMove(int row, int col) {
        gameBoard[row][col] = 0;
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameBoard[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isCellEmpty(int row, int col) {
        return gameBoard[row][col] == 0;
    }

    public boolean isWin() {
        int[] currentBoard = new int[9];
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                currentBoard[index] = gameBoard[i][j];
                index++;
            }
        }

        for (int i = 0; i < 8; i++) {
            if (Arrays.equals(Solution.SolutionArray[i], currentBoard)) {
                return true;
            }
        }
        return false;
    }

    public void printBoard() {
        System.out.println("-------");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("|");
                String cell = gameBoard[i][j] == 0 ? " " : String.valueOf(gameBoard[i][j]);
                System.out.print(cell);
            }
            System.out.println("|");
            System.out.println("-------");

        }
    }

    public boolean isNumberIsUsed(int number) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameBoard[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }
}
