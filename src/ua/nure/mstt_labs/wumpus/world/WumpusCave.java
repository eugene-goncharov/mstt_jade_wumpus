package ua.nure.mstt_labs.wumpus.world;

/**
 * @author Eugene Goncharov
 */

import ua.nure.mstt_labs.wumpus.services.WorldConfiguration;

public class WumpusCave {

    private final int caveXDimension;
    private final int caveYDimension;

    private AgentPosition start = new AgentPosition(1, 1, Orientation.NORTH);

    public WumpusCave() {
        this(4, 4);
    }

    public WumpusCave(int caveXDimension, int caveYDimension) {
        if (caveXDimension < WorldConfiguration.MIN_DIMENSION || caveYDimension < WorldConfiguration.MIN_DIMENSION)
            throw new IllegalArgumentException("Cave size must have at least 1 dimension");

        this.caveXDimension = caveXDimension;
        this.caveYDimension = caveYDimension;
    }

    public int getCaveXDimension() {
        return caveXDimension;
    }

    public int getCaveYDimension() {
        return caveYDimension;
    }

    public AgentPosition getStart() {
        return start;
    }
}
