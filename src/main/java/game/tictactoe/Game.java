package game.tictactoe;

import java.util.Optional;

final class Game {

    private final Arbiter arbiter;
    private final UI ui;
    private Board board;
    private Player currentPlayer;


    public Game(final Board board, final UI ui, final Arbiter arbiter, final Player firstPlayer) {
        this.board = board;
        this.ui = ui;
        this.arbiter = arbiter;
        this.currentPlayer = firstPlayer;
    }

    public Optional<Player> play() {
        do {
            board = playerChoosesCell();
            currentPlayer = currentPlayer.nextPlayer();
        } while (arbiterDoesNotStopTheGame());
        return gameEnds();
    }

    private boolean arbiterDoesNotStopTheGame() {
        return !arbiter.judge(board).endsGame();
    }

    private Board playerChoosesCell() {
        ui.printBoard(board);
        Move move = currentPlayer.makeMove(board);
        return board.playAt(move);
    }

    private Optional<Player> gameEnds() {
        ui.printBoard(board);
        Answer answer = arbiter.judge(board);
        if (answer.isThereAWinner()){
            ui.showMessage(currentPlayer + " - " + answer.message());
            return Optional.of(currentPlayer);
        }
        ui.showMessage(answer.message());
        return Optional.empty();
    }
}
