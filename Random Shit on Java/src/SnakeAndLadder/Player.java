package SnakeAndLadder;

public class Player {

    public String name;
    public int position;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Player(String name) {
        this.name = name;
        this.position = 0;
    }

}
