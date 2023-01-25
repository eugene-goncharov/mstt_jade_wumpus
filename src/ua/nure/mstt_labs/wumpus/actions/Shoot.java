package ua.nure.mstt_labs.wumpus.actions;

import ua.nure.mstt_labs.wumpus.world.Agent;
import ua.nure.mstt_labs.wumpus.world.WumpusCave;

/**
 * @author Eugene Goncharov
 */
public class Shoot implements Action {
    private final WumpusCave cave;

    public Shoot(WumpusCave cave) {
        this.cave = cave;
    }

    @Override
    public ActionResult act() {
        final Agent agent = cave.getAgent();

        if (agent.isHasArrow() && cave.isFacingWumpus(agent.getPosition())) {
            agent.shoot();
            this.cave.shootWumpus();
        }


        return null;
    }
}
