package game.tictactoe;

public final class Answer {

    private final boolean endGame;
    private final String message;

    Answer(final boolean endGame, final String message) {
        this.endGame = endGame;
        this.message = message;
    }

    public boolean endsGame() {
        return endGame;
    }

    public String message() {
        return message;
    }
}
