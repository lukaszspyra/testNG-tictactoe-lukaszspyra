package game.tictactoe;

import java.util.Arrays;

public class Board {
    private final PlayerMark[][] gameBoard;

    Board(final PlayerMark[][] gameBoard) {
        this.gameBoard = gameBoard;
    }

    PlayerMark[][] getGameBoard() {
        return gameBoard;
    }

    public boolean isValid(Move move) {
        return inBoardLimit(move) && isNotPlayedYet(move);
    }

    private boolean inBoardLimit(Move move){
        return !(move.getRow() > 2 || move.getRow() < 0 || move.getColumn() > 2 || move.getColumn() < 0);
    }

    private boolean isNotPlayedYet(Move move){
        return gameBoard[move.getRow()][move.getColumn()] == null;
    }

    public Board playAt(Move makeUpMove){
        gameBoard[makeUpMove.getRow()][makeUpMove.getColumn()] = makeUpMove.getPlayerMark();
        return this;
    }

    @Override
    public String toString() {
        return "Board{" +
                "gameBoard=" + Arrays.deepToString(gameBoard) +
                '}';
    }
}
