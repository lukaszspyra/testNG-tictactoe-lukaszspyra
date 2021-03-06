package spyra.lukasz.game.tictactoe.tictactoe;

final class Arbiter {

    Answer judge(Board board) {
        var gameBoard = board.getGameBoard();
        if (checkRows(gameBoard) || checkColumns(gameBoard) || checkDiagonals(gameBoard)) {
            return createAnswer(true, "Congratulations you win", true);
        }
        if (!board.isAnyCellEmpty()) {
            return createAnswer(true, "End of game - tie", false);
        }
        return createAnswer(false, "Game in progress", false);
    }

    boolean checkRows(Player[][] gameBoard) {
        for (int i = 0; i < gameBoard.length; i++) {
            if (checkCellsForWin(gameBoard[i][0], gameBoard[i][1], gameBoard[i][2])) {
                return true;
            }
        }
        return false;
    }

    boolean checkColumns(Player[][] gameBoard) {
        for (int i = 0; i < gameBoard.length; i++) {
            if (checkCellsForWin(gameBoard[0][i], gameBoard[1][i], gameBoard[2][i])) {
                return true;
            }
        }
        return false;
    }

    boolean checkDiagonals(Player[][] gameBoard) {
        return (checkCellsForWin(gameBoard[0][0], gameBoard[1][1], gameBoard[2][2]) ||
                checkCellsForWin(gameBoard[0][2], gameBoard[1][1], gameBoard[2][0]));
    }

    private boolean checkCellsForWin(final Player playerMark, final Player playerMark1, final Player playerMark2) {
        if (playerMark == null || playerMark1 == null || playerMark2 == null) {
            return false;
        }
        return playerMark == playerMark1 && playerMark1 == playerMark2;
    }

    private Answer createAnswer(boolean endGame, String message, boolean isThereAWinner) {
        return new Answer(endGame, message, isThereAWinner);
    }

}
