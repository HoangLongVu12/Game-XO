package Entity;

import java.util.ArrayList;


public class Game {
    public ArrayList<Player> players;
    public Board board;

    public Game(ArrayList players, Board board) {
        this.players = players;
        this.board = board;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
