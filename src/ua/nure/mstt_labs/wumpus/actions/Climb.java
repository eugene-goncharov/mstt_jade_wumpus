package ua.nure.mstt_labs.wumpus.actions;

import ua.nure.mstt_labs.wumpus.world.AgentPosition;
import ua.nure.mstt_labs.wumpus.world.Room;
import ua.nure.mstt_labs.wumpus.world.RoomContent;
import ua.nure.mstt_labs.wumpus.world.WumpusCave;

/**
 * @author Eugene Goncharov
 */
public class Climb implements Action {
    private final WumpusCave cave;

    public Climb(WumpusCave cave) {
        this.cave = cave;
    }

    @Override
    public ActionResult act() {
        return ActionResult.OK;
    }
}
