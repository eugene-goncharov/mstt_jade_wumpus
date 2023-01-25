package ua.nure.mstt_labs.wumpus.actions;

import ua.nure.mstt_labs.wumpus.world.AgentPosition;
import ua.nure.mstt_labs.wumpus.world.Orientation;
import ua.nure.mstt_labs.wumpus.world.WumpusCave;

/**
 * @author Eugene Goncharov
 */
public class TurnRight implements Action {
    private final WumpusCave cave;

    public TurnRight(WumpusCave cave) {
        this.cave = cave;
    }

    @Override
    public ActionResult act() {
        final AgentPosition agentPosition = cave.getAgent().getPosition();
        Orientation orientation = switch (agentPosition.getOrientation()) {
            case NORTH -> Orientation.EAST;
            case SOUTH -> Orientation.WEST;
            case EAST -> Orientation.SOUTH;
            case WEST -> Orientation.NORTH;
        };

        AgentPosition newPosition = new AgentPosition(agentPosition.getPosition(), orientation);
        cave.getAgent().setPosition(newPosition);

        return ActionResult.OK;
    }
}
