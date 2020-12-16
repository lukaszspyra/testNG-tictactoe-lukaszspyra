package spyra.lukasz.game.tictactoe.tictactoe;

import java.util.Scanner;

enum Player {

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

    private final UI ui = new UI(new Scanner(System.in), System.out);

    Move makeMove(Board board) {

        return ui.readMove(board, this);
    }

    abstract Player nextPlayer();

}
