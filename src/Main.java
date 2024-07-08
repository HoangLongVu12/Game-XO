import Entity.Game;
import Entity.Player;
import Service.GameService;
import Service.PlayerService;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // scanner for input
        Scanner sc = new Scanner(System.in);

        // create name of player1
        String player1Name;
        while (true) {
            System.out.println("Please give the name of first player!!!");
            player1Name = sc.next();
            if (containsOnlyLetters(player1Name)) {
                System.out.println("Player1: " + player1Name);
                break;
            } else {
                System.out.println("You have given unvalid name");
            }
        }
        // chose mark for player 1
        String player1Mark;
        while (true) {
            System.out.println("Chose a mark for player1!!!");
            player1Mark = sc.next();
            if (containsOnlyXorO(player1Mark)) {
                System.out.println("Player1's Mark: " + player1Mark);
                break;
            } else {
                System.out.println("You have given unvalid mark");
            }
        }
        // create player1
        Player player1 = new Player(player1Name, player1Mark);


        // create name of player2
        String player2Name;
        while (true) {
            System.out.println("Please give the name of second player!!!");
            player2Name = sc.next();
            if (containsOnlyLetters(player2Name)) {
                System.out.println("Player2: " + player2Name);
                break;
            } else {
                System.out.println("You have given unvalid name");
            }
        }
        // create mark for player 2
        String player2Mark;
        if(Objects.equals(player1.getChosenMark(), "X")) {
            player2Mark = "O";
            System.out.println("Player2's Mark:" + player2Mark);
        } else {
            player2Mark = "X";
            System.out.println("Player2's Mark: " + player2Mark);
        }

        // create player2
        Player player2 = new Player(player2Name, player2Mark);
        GameService gameService = new GameService();

        // create new Game
        Game game = gameService.initGame(player1,player2);
        PlayerService playerService = new PlayerService();

        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < 9; i++) {
            while (true) {
                Integer playerMove = sc.nextInt();
                if (!containsNumber(numbers,playerMove)) {
                    numbers.add(playerMove);
                    if(playerMove % 2 == 1) {
                        System.out.println("Player1's move: " + playerMove);
                    } else {
                        System.out.println("Player2's move: " + playerMove);
                    }
                    playerService.move(i,playerMove,game,gameService);
                    break;
                }
                else {
                    System.out.println("The number has been chosen already!!!");
                }
            }
            if(gameService.checkWinner(i,game)) {
                if(i % 2 == 0 ) {
                    System.out.println("the winner is: " + player1.getName());
                    break;
                } else {
                    System.out.println("the winner is: " + player2.getName());
                    break;
                }
            }
            if(i == 8){
                System.out.println("Game finished!!! We got a draw");
            }
        }

    }


    public static boolean containsOnlyLetters(String str) {
        return str != null && str.matches("[a-zA-Z]+");
    }
    public static boolean containsOnlyXorO(String str) {
        return str != null && str.chars().allMatch(c -> c == 'X' || c == 'O');
    }
    public static boolean containsNumber(ArrayList numbers, Integer number) {
        return numbers.contains(number);
    }
}