package ua.nure.mstt_labs.wumpus.world;

/**
 * @author Eugene Goncharov
 */
public class AgentPosition {
    private final Position position;
    private final Orientation orientation;

    public AgentPosition(Position position, Orientation orientation) {
        this.position = position;
        this.orientation = orientation;
    }

    public Position getPosition() {
        return position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

}

