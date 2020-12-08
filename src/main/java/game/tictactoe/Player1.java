package game.tictactoe;

public final class Player1 implements Player{

    private final PlayerMark currentPlayerMark;

    Player1(final PlayerMark currentPlayerMark) {
        this.currentPlayerMark = currentPlayerMark;
    }

    @Override
    public Move makeMove(int row, int column){
        return new Move(row, column, currentPlayerMark);
    }

}
