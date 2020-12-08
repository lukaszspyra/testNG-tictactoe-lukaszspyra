package game.tictactoe;

public final class Main {

    public static void main(String[] args) {
        Board board = new Board(new Player[3][3]);
        Arbiter arbiter = new Arbiter();
        Player firstPlayer = Player.X;
        Game game = new Game(board, arbiter, firstPlayer);
        game.play();
    }

}
