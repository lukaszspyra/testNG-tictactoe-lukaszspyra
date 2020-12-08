package game.tictactoe;

public final class Arbiter {

    boolean judge(Board board) {
        return (checkRows(board) || checkColumns(board) || checkDiagonals(board));
    }

    private boolean checkRows(Board board) {
        PlayerMark[][] gameBoard = board.getGameBoard();
        for (int i = 0; i < gameBoard.length; i++) {
            if (checkCellsForWin(gameBoard[i][0], gameBoard[i][1], gameBoard[i][2])) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns(Board board) {
        PlayerMark[][] gameBoard = board.getGameBoard();
        for (int i = 0; i < gameBoard.length; i++) {
            if (checkCellsForWin(gameBoard[0][i], gameBoard[1][i], gameBoard[2][i])) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals(Board board) {
        PlayerMark[][] gameBoard = board.getGameBoard();
        return (checkCellsForWin(gameBoard[0][0], gameBoard[1][1], gameBoard[2][2]) ||
                checkCellsForWin(gameBoard[0][2], gameBoard[1][1], gameBoard[2][2]));
    }

    private boolean checkCellsForWin(final PlayerMark playerMark, final PlayerMark playerMark1, final PlayerMark playerMark2) {
        if (playerMark == null || playerMark1 == null || playerMark2 == null){
            return false;
        }
        return playerMark == playerMark1 && playerMark1 == playerMark2;
    }

}
