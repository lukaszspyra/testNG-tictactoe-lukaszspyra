package game.tictactoe;

import java.util.Objects;

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

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Answer)) return false;
        final Answer answer = (Answer) o;
        return endGame == answer.endGame &&
                isThereAWinner == answer.isThereAWinner &&
                Objects.equals(message, answer.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(endGame, isThereAWinner, message);
    }
}
