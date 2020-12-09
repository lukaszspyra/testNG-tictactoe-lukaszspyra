package game.tictactoe;

public final class Answer {

    private final boolean endGame;
    private final boolean isThereAWinner;
    private final String message;

    Answer(final boolean endGame, final String message, final boolean isThereAWinner) {
        this.endGame = endGame;
        this.message = message;
        this.isThereAWinner = isThereAWinner;
    }

    public boolean endsGame() {
        return endGame;
    }

    public String message() {
        return message;
    }

    public boolean isThereAWinner(){
        return isThereAWinner;
    }
}
