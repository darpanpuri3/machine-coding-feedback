import SnakeAndLadder.SnakeAndLadder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import SnakeAndLadder.Player;

public class ApplicationRunner {
    public static void main(String[] args) throws IOException {
        SnakeAndLadder game = new SnakeAndLadder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to snakes and ladders!");
        System.out.println("Enter number of snakes!");
        int snakes = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Enter snakes!");
        while (snakes > 0) {
            String s = bufferedReader.readLine();;
            game.addSnake(s);
            snakes--;
        }

        System.out.println("Enter number of ladders!");
        int ladders = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Enter ladders!");
        while (ladders > 0) {
            String s = bufferedReader.readLine();
            game.addLadder(s);
            ladders--;
        }

        System.out.println("Enter number of players!");
        int numberOfPlayers = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Enter name of players!");
        int playerIndex = 0;
        while (numberOfPlayers > 0) {
            String s = bufferedReader.readLine();
            game.addPlayer(playerIndex, s);
            numberOfPlayers--;
            playerIndex++;
        }

        System.out.println("Game starts!");
        while (true) {
            int turn = game.getTurn();
            Player player = game.getPlayers().get(turn);
            System.out.println(player.getName() + "'s turn, wanna role ?");
            if (!bufferedReader.readLine().equalsIgnoreCase("y")) {
                System.out.println("Game is finished, player doesn't want to play anymore!");
                System.exit(0);
            }
            int die = game.rollDie();
            int value = player.getPosition() + die <= 100 ? player.getPosition() + die : player.getPosition();
            value = game.checkCaseForSnakeOrLadder(value);
            System.out.println(player.getName() + " rolled a " + die + " and moved from " + player.getPosition() + " to " + value);
            if (value == 100) {
                System.out.println(player.getName() + " won!");
                System.exit(0);
            }
            player.setPosition(value);
            game.changeTurn();
        }
    }
}
