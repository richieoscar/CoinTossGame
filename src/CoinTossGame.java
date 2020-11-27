import java.util.InputMismatchException;
import java.util.Scanner;

public class CoinTossGame {
    private Coin coin = new Coin();
    private Players playerOne;
    private Players playerTwo;
    Scanner scanner = new Scanner(System.in);
    private String playerOneGuess;
    private String playerTwoGuess;
    private int player1;
    private int player2;

    public int getPlayer1() {
        return player1;
    }

    public void setPlayer1(int player1) {
        this.player1 = player1;
    }

    public int getPlayer2() {
        return player2;
    }

    public void setPlayer2(int player2) {
        this.player2 = player2;
    }

    public CoinTossGame() {
    }

    public void createPlayers() {
        System.out.println("Coin Toss Game\nWelcome Players\nEnter Your Names");
        System.out.println();
        try {
            System.out.print("Player One: ");
            playerOne = new Players(scanner.next());
            System.out.print("Player Two: ");
            playerTwo = new Players(scanner.next());
        } catch (InputMismatchException e) {
            System.out.println("Invalid name");
        }
        System.out.println();

    }

    public String askGuess() {
        System.out.println("Make a Coin Side Guess: Heads or Tails?");
        System.out.print(playerOne.getName().toUpperCase() + ": Your Guess?  ");
        try {
            playerOne.setGuess(scanner.next());
            while (!validateGuess(playerOne.getGuess().toUpperCase())) {
                playerOne.setGuess(scanner.next());
            }
        } catch (InputMismatchException e) {
            System.out.println("Not a Valid Input");
        }

        return playerOne.getGuess().toUpperCase();
    }

    public String getPlayerOneGuess() {
        return playerOne.getGuess().toUpperCase();
    }

    public String setPlayerTwoGuess(String playerTwoGuess) {
        return playerTwoGuess;
    }


    public boolean validateGuess(String playerOneGuess) {
        boolean check = false;
        if (playerOneGuess.equals("HEADS")) {
            setPlayerTwoGuess("TAILS");
            setPlayer1(1);
            setPlayer2(0);
            check = true;

        } else if (playerOneGuess.equals("TAILS")) {
            setPlayerTwoGuess("HEADS");
            setPlayer1(0);
            setPlayer2(1);
            check = true;
        } else {
            System.out.println("Invalid, Try again");
            //setPlayerOneGuess();
            check = false;
        }
        return check;
    }

    public void processGameResults(String guess) {
        int value = coin.flip();
        if (getPlayer1() == coin.getSide()) {
            System.out.println(playerOne.getName().toUpperCase() +"  You Guessed Right!" );
            System.out.println();
        } else if (getPlayer2() == coin.getSide()) {
            System.out.println();
            System.out.println( playerTwo.getName().toUpperCase() +" You Guessed Right!" );
        }
        System.out.println("Game Over");
        scanner.close();
    }


}



