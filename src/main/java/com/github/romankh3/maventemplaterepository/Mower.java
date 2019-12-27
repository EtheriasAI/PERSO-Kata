package com.github.romankh3.maventemplaterepository;

public class Mower {
    int x;
    int y;
    Direction d;
    int limitX;
    int limitY;

    public Mower(int x, int y, char d,int limitX, int limitY) {
        this.x = x;
        this.y = y;
        this.d = Direction.valueOf(String.valueOf(d));
        this.limitX = limitX;
        this.limitY = limitY;
    }

    public void move(Control c) {

        switch (c) {
            case G:
                this.d = (this.d.ordinal() > 0) ? Direction.values()[(d.ordinal() - 1)] : Direction.W;
                break;
            case D:
                this.d = (this.d.ordinal() < 3) ? Direction.values()[(d.ordinal() + 1)] : Direction.N;
                break;
            case A:
                moveForward();
                break;
            default:
                System.out.println("control: " + c);
                break;
        }
    }

    private void moveForward(){
        switch (d) {
            case N:
                this.y = (this.y < this.limitY) ? this.y += 1 : this.y;
                break;
            case E:
                this.x = (this.x < this.limitX) ? this.x += 1 : this.x;
                break;
            case S:
                this.y = (this.y > 0) ? this.y -= 1 : this.y;
                break;
            case W:
                this.x = (this.x > 0) ? this.x -= 1 : this.x;
                break;
            default:
                System.out.println("direction: " + this.d);
                break;
        }
    }
}


