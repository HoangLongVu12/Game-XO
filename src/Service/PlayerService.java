package Service;

import Entity.Game;

public class PlayerService {
    public void move(int turn,int number,Game game, GameService gameService) {
        if(turn % 2 == 0) {
            game.board.getBoard()[number-1] = game.getPlayers().get(0).getChosenMark();
        } else {
            game.board.getBoard()[number-1] = game.getPlayers().get(1).getChosenMark();
        }
        gameService.showBoard(game);
    }
}
