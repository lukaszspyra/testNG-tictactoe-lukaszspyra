package game.tictactoe;

public enum Player{

    X{
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

    Move makeMove(int row, int column){
        return new Move(row, column, this);
    }

    abstract Player nextPlayer();

}
