package Entity;

public class Board {
    public String[] board;

    public Board() {
        this.board = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    }

    public String[] getBoard() {
        return board;
    }

    public void setBoard(String[] board) {
        this.board = board;
    }
}
