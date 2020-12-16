package spyra.lukasz.game.tictactoe.tictactoe;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

final class Board {

    private final Player[][] gameBoard;

    Board(final Player[][] gameBoard) {
        this.gameBoard = gameBoard;
    }

    Player[][] getGameBoard() {
        return gameBoard;
    }

    public boolean isAvailable(Move move) {
        return gameBoard[move.getRow()][move.getColumn()] == null;
    }

    public boolean inBoardLimits(int userNumber) {
        return !(userNumber >= gameBoard.length || userNumber < 0);
    }

    public boolean isAnyCellEmpty() {
        return Arrays
                .stream(gameBoard)
                .flatMap(Stream::of)
                .anyMatch(Objects::isNull);
    }

    public Board playAt(Move makeUpMove) {
        gameBoard[makeUpMove.getRow()][makeUpMove.getColumn()] = makeUpMove.getPlayer();
        return this;
    }

}
