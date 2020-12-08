package game.tictactoe;

public enum Player{

    X,
    O,
    ;

    Move makeMove(int row, int column){
        return new Move(row, column, this);
    }
}
