package game.tictactoe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Board board = new Board(new Player[3][3]);
        UI ui = new UI(new Scanner(System.in), System.out);
        Arbiter arbiter = new Arbiter();
        Player firstPlayer = Player.X;
        Game game = new Game(board, ui, arbiter, firstPlayer);
        game.play();
    }
}
