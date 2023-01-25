package ua.nure.mstt_labs.wumpus.actions;

import ua.nure.mstt_labs.wumpus.world.AgentPosition;
import ua.nure.mstt_labs.wumpus.world.Room;
import ua.nure.mstt_labs.wumpus.world.RoomContent;
import ua.nure.mstt_labs.wumpus.world.WumpusCave;

/**
 * @author Eugene Goncharov
 */
public class GrabItem implements Action {
    private final WumpusCave cave;

    public GrabItem(WumpusCave cave) {
        this.cave = cave;
    }

    @Override
    public ActionResult act() {
        AgentPosition agentPosition = this.cave.getAgent().getPosition();

        Room room = this.cave.getRoomAt(agentPosition.getPosition());
        if (room.getContent().equals(RoomContent.GOLD)) {
            this.cave.getAgent().grabGold();
        }

        return null;
    }
}
