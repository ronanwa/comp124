package edu.macalester.comp124.life;

/**
 * RuleSet implementing Conway's Game of Life.
 *
 * @author Michael Ekstrand <ekstrand@cs.umn.edu>
 */
public class HighLife implements RuleSet {

    public String getName() {
        return "HighLife";
    }

    /**
     * Applies the rules of Conway's Game of Life.
     *
     * @param isAlive       The value of the current cell (true = alive).
     * @param neighborCount The number of living neighbors of the cell.
     * @return true if the cell should be alive in the next generation.
     */
    public boolean applyRules(boolean isAlive, int neighborCount) {
        if (isAlive == true && neighborCount < 2) {
            return false;
        } else if (isAlive == true && neighborCount > 3) {
            return false;
        } else if (isAlive == false && neighborCount == 3) {
            return true;
        } else if (isAlive==false && neighborCount==6) {
            return true;
        } else {
            return isAlive;
        }
    }
}





















