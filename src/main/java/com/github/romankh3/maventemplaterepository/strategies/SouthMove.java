package com.github.romankh3.maventemplaterepository.strategies;

import com.github.romankh3.maventemplaterepository.MoveToStrategy;
import com.github.romankh3.maventemplaterepository.Mower;

/**
 * Strategy for moving the mower to the south
 */
public class SouthMove implements MoveToStrategy {
    @Override
    public void move(Mower mower) {
        int y = mower.getY();

        // Check that the mower stays in the lawn
        y = (y > 0) ? y -= 1 : y;

        mower.setY(y);
    }
}
