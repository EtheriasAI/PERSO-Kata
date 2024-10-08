package com.github.romankh3.maventemplaterepository;

import com.github.romankh3.maventemplaterepository.strategies.EastMove;
import com.github.romankh3.maventemplaterepository.strategies.NorthMove;
import com.github.romankh3.maventemplaterepository.strategies.SouthMove;
import com.github.romankh3.maventemplaterepository.strategies.WestMove;

import java.util.HashMap;
import java.util.Map;

/**
 * The Mower that moves on the lawn
 */
public class Mower {
    int x;
    int y;
    Direction d;
    int limitX;
    int limitY;

    private Map<Direction, MoveToStrategy> moveToStrategies;

    /**
     * A mower with its initial position
     * @param x       x coordinate of the mower
     * @param y       y coordinate of the mower
     * @param d       direction of the mower
     * @param limitX  limit x coordinate of the lawn
     * @param limitY  limit y coordinate of the lawn
     */
    public Mower(int x, int y, char d, int limitX, int limitY) {
        this.x = x;
        this.y = y;
        this.d = Direction.valueOf(String.valueOf(d));
        this.limitX = limitX;
        this.limitY = limitY;

        this.moveToStrategies = new HashMap<>();
        this.moveToStrategies.put(Direction.N, new NorthMove());
        this.moveToStrategies.put(Direction.E, new EastMove());
        this.moveToStrategies.put(Direction.S, new SouthMove());
        this.moveToStrategies.put(Direction.W, new WestMove());
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLimitX() {
        return limitX;
    }

    public int getLimitY() {
        return limitY;
    }

    /**
     * Moves or orienting the mower
     * @param c control of the mower for one move
     */
    public void move(Control c) {
        switch (c) {
            case G:
                // Change the enum value
                this.d = (this.d.ordinal() > 0) ? Direction.values()[(d.ordinal() - 1)] : Direction.W;
                break;
            case D:
                // Change the enum value
                this.d = (this.d.ordinal() < 3) ? Direction.values()[(d.ordinal() + 1)] : Direction.N;
                break;
            case A:
                // step forward
                MoveToStrategy strategy = moveToStrategies.get(d);
                if (strategy != null) {
                    strategy.move(this);
                }
                break;
            default:
                System.out.println("control: " + c);
                break;
        }
    }
}


