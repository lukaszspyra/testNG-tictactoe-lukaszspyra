package game.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class Game {

    private final Board board;
    private final Arbiter arbiter;
    private final List<Player> players;

    public Game(final Board board, final Arbiter arbiter, final List<Player> players) {
        this.board = board;
        this.arbiter = arbiter;
        this.players = players;
    }

    public static void main(String[] args) {

        Player player1 = new Player1(PlayerMark.X);
        Player player2 = new Player2(PlayerMark.O);
        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        Board board = new Board(new PlayerMark[3][3]);
        Arbiter arbiter = new Arbiter();
        Game game = new Game(board, arbiter, players);

        Scanner scanner = new Scanner(System.in);
        var nextPlayer = players.get(0);
        Move move;

        while (true) {
            System.out.println("Player" + nextPlayer.getClass().getSimpleName() + " row <1;3>: ");
            var first = scanner.nextInt();
            System.out.println("Player" + nextPlayer.getClass().getSimpleName() + " column <1;3>: ");
            var second = scanner.nextInt();
            move = nextPlayer.makeMove(first - 1, second - 1);

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
            nextPlayer = game.nextTurn(nextPlayer);
        }
    }

    private Player nextTurn(final Player lastPlayed) {
        int lastPlayerIndex = players.indexOf(lastPlayed);
        if ((lastPlayerIndex + 1) < players.size()) {
            return players.get(lastPlayerIndex + 1);
        }
        return players.get(0);
    }
}
