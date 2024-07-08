package Service;

import Entity.Board;
import Entity.Game;
import Entity.Player;

import java.util.ArrayList;

public class GameService {
    public Game initGame(Player player1,Player player2 ){
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);
        Board board = new Board();
        Game game = new Game(players, board);
        System.out.println("New game: ");
        System.out.println("Player1: " + player1.getName() + " and his chosen mark: " + player1.getChosenMark());
        System.out.println("Player2: " + player2.getName() + " and his chosen mark: " + player2.getChosenMark());
        showBoard(game);
        return game;
    }
    public void showBoard(Game game){
        for(int i = 0; i < 9; i++) {
            if(i % 3 == 2) {
                System.out.println(game.board.getBoard()[i]);
                continue;
            }
            System.out.print(game.board.getBoard()[i]);
            System.out.print("|");
        }
    }

    public boolean checkWinner(int turn,Game game) {
        boolean winnerFound = false;
        if(game.board.getBoard()[0].equals(game.board.getBoard()[1]) && game.board.getBoard()[1].equals(game.board.getBoard()[2])) {
            winnerFound = true;
        }
        if(game.board.getBoard()[3].equals(game.board.getBoard()[4]) && game.board.getBoard()[4].equals(game.board.getBoard()[5])) {
            winnerFound = true;
        }
        if(game.board.getBoard()[6].equals(game.board.getBoard()[7]) && game.board.getBoard()[7].equals(game.board.getBoard()[8])) {
            winnerFound = true;
        }
        if(game.board.getBoard()[0].equals(game.board.getBoard()[3]) && game.board.getBoard()[3].equals(game.board.getBoard()[6])) {
            winnerFound = true;
        }
        if(game.board.getBoard()[1].equals(game.board.getBoard()[4]) && game.board.getBoard()[4].equals(game.board.getBoard()[7])) {
            winnerFound = true;
        }
        if(game.board.getBoard()[2].equals(game.board.getBoard()[5]) && game.board.getBoard()[5].equals(game.board.getBoard()[8])) {
            winnerFound = true;
        }
        if(game.board.getBoard()[0].equals(game.board.getBoard()[4]) && game.board.getBoard()[5].equals(game.board.getBoard()[8])) {
            winnerFound = true;
        }
        if(game.board.getBoard()[2].equals(game.board.getBoard()[4]) && game.board.getBoard()[4].equals(game.board.getBoard()[6])) {
            winnerFound = true;
        }
        return winnerFound;
    }
}
