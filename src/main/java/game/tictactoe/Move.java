package game.tictactoe;

public final class Move {
    private final int row;
    private final int column;
    private final Player player;

    Move(int row, int column, Player player) {
        this.row = row;
        this.column = column;
        this.player = player;
    }

    int getRow() {
        return row;
    }

    int getColumn() {
        return column;
    }

    Player getPlayer() {
        return player;
    }

}