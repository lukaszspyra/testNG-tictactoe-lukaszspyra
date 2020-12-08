package game.tictactoe;

import java.util.Scanner;

public final class Game {

    private final Board board;
    private final Arbiter arbiter;

    public Game(final Board board, final Arbiter arbiter) {
        this.board = board;
        this.arbiter = arbiter;
    }

    public static void main(String[] args) {
        Board board = new Board(new Player[3][3]);
        Arbiter arbiter = new Arbiter();
        Game game = new Game(board, arbiter);

        Scanner scanner = new Scanner(System.in);
        var currentPlayer = Player.X;
        Move move;

        while (true) {
            System.out.println("Player" + currentPlayer + " row <1;3>: ");
            var first = scanner.nextInt();
            System.out.println("Player" + currentPlayer + " column <1;3>: ");
            var second = scanner.nextInt();
            move = currentPlayer.makeMove(first - 1, second - 1);

            if (!game.board.isValid(move)) {
                System.out.println("Invalid input - try again!");
                continue;
            }

            Board updatedBoard = game.board.playAt(move);
            System.out.println(updatedBoard);
            if (game.arbiter.judge(updatedBoard)) {
                System.out.println("You win");
                break;
            }
            currentPlayer = currentPlayer.nextPlayer();
        }
    }
}
