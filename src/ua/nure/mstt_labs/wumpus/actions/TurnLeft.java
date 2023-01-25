package ua.nure.mstt_labs.wumpus.actions;

import ua.nure.mstt_labs.wumpus.world.AgentPosition;
import ua.nure.mstt_labs.wumpus.world.Orientation;
import ua.nure.mstt_labs.wumpus.world.WumpusCave;

/**
 * @author Eugene Goncharov
 */
public class TurnLeft implements Action {
    private final WumpusCave cave;

    public TurnLeft(WumpusCave cave) {
        this.cave = cave;
    }

    @Override
    public ActionResult act() {
        final AgentPosition agentPosition = cave.getAgent().getPosition();
        Orientation orientation = switch (agentPosition.getOrientation()) {
            case NORTH -> Orientation.WEST;
            case SOUTH -> Orientation.EAST;
            case EAST -> Orientation.NORTH;
            case WEST -> Orientation.SOUTH;
        };

        AgentPosition newPosition = new AgentPosition(agentPosition.getPosition(), orientation);
        cave.getAgent().setPosition(newPosition);

        return null;
    }
}
