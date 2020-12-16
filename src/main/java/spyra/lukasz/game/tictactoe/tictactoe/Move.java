package spyra.lukasz.game.tictactoe.tictactoe;

import java.util.Objects;

final class Move {
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

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Move move = (Move) o;
        return row == move.row &&
                column == move.column &&
                player == move.player;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column, player);
    }
}