package game.tictactoe;

public final class Move {
    private int row;
    private int column;
    private Player playerMark;

    Move(int row, int column, Player playerMark) {
        this.row = row;
        this.column = column;
        this.playerMark = playerMark;
    }

    int getRow() {
        return row;
    }

    int getColumn() {
        return column;
    }

    Player getPlayerMark() {
        return playerMark;
    }

}