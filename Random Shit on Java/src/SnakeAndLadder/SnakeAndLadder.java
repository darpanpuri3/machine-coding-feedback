package SnakeAndLadder;

import java.util.HashMap;
import java.util.Map;

public class SnakeAndLadder {
    public Map<Integer, Integer> ladders;
    public Map<Integer, Integer> snakes;
    public Map<Integer, Player> players;
    public int turn = 0;

    public SnakeAndLadder() {
        this.ladders = new HashMap<>();
        this.snakes = new HashMap<>();
        this.turn = 0;
        this.players = new HashMap<Integer, Player>();
    }

    public void addLadder(String s) {

        String[] points = s.split(" ");
        int start = Integer.parseInt(points[0]);
        int end = Integer.parseInt(points[1]);

        if (start > end) {
            throw new IllegalArgumentException("Ladders end must be greater than start");
        }

        this.ladders.put(start, end);
    }

    public void addSnake(String s) {
        String[] points = s.split(" ");
        int start = Integer.parseInt(points[0]);
        int end = Integer.parseInt(points[1]);
        if (start < end) {
            throw new IllegalArgumentException("Snake start must be greater than end!");
        }

        if (start == 100) {
            throw new IllegalArgumentException("Snake cant begin at 100");
        }
        this.snakes.put(start, end);
    }

    public void addPlayer(Integer index, String playerName) {
        this.players.put(index, new Player(playerName));
    }

    public void changeTurn() {
        this.turn = (this.turn + 1) % (this.players.size());
    }

    public int rollDie() {
        return 1 + (int)(Math.random() * 6.0);
    }

    public int getTurn() {
        return this.turn;
    }

    public int checkCaseForSnakeOrLadder(int value) {
        if (this.ladders.get(value) != null) {
            return checkCaseForSnakeOrLadder(this.ladders.get(value));
        }

        if (this.ladders.get(value) != null) {
            return checkCaseForSnakeOrLadder(this.snakes.get(value));
        }

        return value;
    }


    public Map<Integer, Integer> getLadders() {
        return ladders;
    }

    public void setLadders(Map<Integer, Integer> ladders) {
        this.ladders = ladders;
    }

    public Map<Integer, Integer> getSnakes() {
        return snakes;
    }

    public void setSnakes(Map<Integer, Integer> snakes) {
        this.snakes = snakes;
    }

    public Map<Integer, Player> getPlayers() {
        return players;
    }

    public void setPlayers(Map<Integer, Player> players) {
        this.players = players;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }
}
