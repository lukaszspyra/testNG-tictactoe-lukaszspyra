package game.tictactoe;

public class Main {

    public static void main(String[] args) {
        Board board = new Board(new Player[3][3]);
        UI ui = new UI();
        Arbiter arbiter = new Arbiter();
        Player firstPlayer = Player.X;
        Game game = new Game(board, ui, arbiter, firstPlayer);
        Player winner = game.play();
    }
}
