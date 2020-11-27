public class GameLauncher {
    public static void main(String[] args) {
       GameLauncher.launchGame();
    }

    private static void launchGame(){
        CoinTossGame test = new CoinTossGame();
        test.createPlayers();
        test.askGuess();
        String guess = test.getPlayerOneGuess();
        test.validateGuess(guess);
        test.processGameResults(guess);
    }
}
