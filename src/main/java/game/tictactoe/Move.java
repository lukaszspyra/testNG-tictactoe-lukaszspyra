package game.tictactoe;

public final class Move {
    private int row;
    private int column;
    private PlayerMark playerMark;

    Move(int row, int column, PlayerMark playerMark) {
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

    PlayerMark getPlayerMark() {
        return playerMark;
    }

}