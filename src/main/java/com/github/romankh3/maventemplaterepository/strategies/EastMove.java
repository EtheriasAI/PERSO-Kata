package com.github.romankh3.maventemplaterepository.strategies;

import com.github.romankh3.maventemplaterepository.MoveToStrategy;
import com.github.romankh3.maventemplaterepository.Mower;

/**
 * Strategy for moving the mower to the east
 */
public class EastMove implements MoveToStrategy {
    @Override
    public void move(Mower mower) {

        int x = mower.getX();

        // Check that the mower stays in the lawn
        x = (x < mower.getLimitX()) ? x += 1 : x;

        mower.setX(x);
    }
}
