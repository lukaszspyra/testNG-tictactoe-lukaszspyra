package game.tictactoe;

import java.util.Arrays;
import java.util.Objects;

public final class Board {
    private final Player[][] gameBoard;

    Board(final Player[][] gameBoard) {
        this.gameBoard = gameBoard;
    }

    Player[][] getGameBoard() {
        return gameBoard;
    }

    public boolean isValid(Move move) {
        return inBoardLimits(move) && isNotPlayedYet(move);
    }

    private boolean inBoardLimits(Move move){
        return !(move.getRow() > 2 || move.getRow() < 0 || move.getColumn() > 2 || move.getColumn() < 0);
    }

    private boolean isNotPlayedYet(Move move){
        return gameBoard[move.getRow()][move.getColumn()] == null;
    }

    public boolean isAnyCellEmpty(){
        return Arrays.stream(gameBoard).anyMatch(Objects::isNull);
    }

    public Board playAt(Move makeUpMove){
        gameBoard[makeUpMove.getRow()][makeUpMove.getColumn()] = makeUpMove.getPlayer();
        return this;
    }

    @Override
    public String toString() {
        return "Board{" +
                "gameBoard=" + Arrays.deepToString(gameBoard) +
                '}';
    }
}
