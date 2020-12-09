package game.tictactoe;

public enum Player {

    X {
        @Override
        Player nextPlayer() {
            return O;
        }
    },
    O {
        @Override
        Player nextPlayer() {
            return X;
        }
    },
    ;

    private final UI ui = new UI();

    Move makeMove(Board board) {

        return ui.readMove(board, this);
    }

    abstract Player nextPlayer();

}
