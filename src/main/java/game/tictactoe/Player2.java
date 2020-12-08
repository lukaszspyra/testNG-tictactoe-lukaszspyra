package game.tictactoe;

public final class Player2 implements Player {

    private final PlayerMark currentPlayerMark;

    Player2(final PlayerMark currentPlayerMark) {
        this.currentPlayerMark = currentPlayerMark;
    }

    @Override
    public Move makeMove(int row, int column){
        return new Move(row, column, currentPlayerMark);
    }

}
