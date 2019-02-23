package assignment4;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main()
    {
        Scanner scanner = new Scanner(System.in);
        String playAgain = "y";

        Game game = new Game();

        while (playAgain.equals("y")) {
            System.out.println("Please enter player name:");
            String playerName = scanner.nextLine();

            game.player = new Player(playerName);
            game.board.clear();

            game.play();

            game.scoreBoard.addPlayer(game.player);
            game.scoreBoard.printScoreBoard();

            System.out.println("Do you want to play again? (y/n)");
            playAgain = scanner.nextLine().toLowerCase();
        }
    }
}
