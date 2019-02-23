package assignment4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    public Player player;
    public Board board;
    public ScoreBoard scoreBoard;
    private long startTime;
    private long endTime;

    private Scanner scanner = new Scanner(System.in);

    public Game() {
        this.scoreBoard = new ScoreBoard();
        this.board = new Board();
    }

    public void play() {
        startTime = System.currentTimeMillis();

        System.out.println("Welcome " + player.getPlayerName() + "! Let's start.");

        while (!board.isFull() || !board.isWin()) {

            board.printBoard();

            if (enterAddOrDelete().equals("a") && !board.isFull()) {
                boolean cellIsOccupied = true;
                int row = 0;
                int col = 0;

                while (cellIsOccupied) {
                    row = enterRowOrCol("row");
                    col = enterRowOrCol("column");
                    cellIsOccupied = !board.isCellEmpty(row, col);
                    if (cellIsOccupied) {
                        System.out.println("This cell has been occupied!");
                    }
                }

                int number = enterNumber();
                board.makeAMove(row, col, number);
            }
            else {
                System.out.println("Please delete a cell:");

                int row = enterRowOrCol("row");
                int col = enterRowOrCol("column");

                board.removeAMove(row, col);
            }

            if (!board.isWin() && board.isFull()) {
                System.out.println("Keep trying. Something is still wrong!");
            }
        }

        endTime = System.currentTimeMillis();
        player.setPlayTime(endTime - startTime);

        System.out.println("Congrats! You won.");
    }

    public String enterAddOrDelete() {
        String input = "";

        List<String> validInput = new ArrayList<String>();
        validInput.add("a");
        validInput.add("d");

        while (!validInput.contains(input)) {
            System.out.println("Please enter add or delete(a/d):");
            input = scanner.nextLine().toLowerCase();
        }

        return input;
    }

    public int enterRowOrCol(String rowOrCol) {
        String input = "";

        List<String> validInput = new ArrayList<String>();
        validInput.add("0");
        validInput.add("1");
        validInput.add("2");

        while (!validInput.contains(input)) {
            System.out.println("Please enter a " + rowOrCol + " number(0, 1, 2):");
            input = scanner.nextLine();
        }

        return Integer.valueOf(input);
    }

        public int enterNumber() {
        String input = "";

        List<String> validInput = new ArrayList<String>();
        validInput.add("1");
        validInput.add("2");
        validInput.add("3");
        validInput.add("4");
        validInput.add("5");
        validInput.add("6");
        validInput.add("7");
        validInput.add("8");
        validInput.add("9");

        while (!validInput.contains(input)) {
            System.out.println("Please enter a number(1~9):");
            input = scanner.nextLine();

            if (!input.equals("") && !input.equals("0") && board.isNumberIsUsed(Integer.valueOf(input))) {
                System.out.println("This number has been used!");
                input = "";
            }
        }

        return Integer.valueOf(input);
    }
}
