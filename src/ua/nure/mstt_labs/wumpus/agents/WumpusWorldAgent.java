package ua.nure.mstt_labs.wumpus.agents;

import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import ua.nure.mstt_labs.wumpus.actions.*;
import ua.nure.mstt_labs.wumpus.behaviours.WumpusWorldCoreGameLoop;
import ua.nure.mstt_labs.wumpus.configs.WorldConfiguration;
import ua.nure.mstt_labs.wumpus.world.WumpusCave;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Eugene Goncharov
 */
public class WumpusWorldAgent extends Agent {
    private WumpusCave cave;
    private Map<Actions, Action> actions = new HashMap<>();

    public WumpusWorldAgent() {

        this.cave = new WumpusCave();

        this.actions.put(Actions.TURN_LEFT, new TurnLeft(this.cave));
        this.actions.put(Actions.TURN_RIGHT, new TurnRight(this.cave));
        this.actions.put(Actions.MOVE_FORWARD, new MoveForward(this.cave));
    }

    @Override
    protected void setup() {
        System.out.println("[" + getAID().getName() + "] agent is ready.");

        DFAgentDescription agentDescription = new DFAgentDescription();
        agentDescription.setName(getAID());

        ServiceDescription serviceDescription = new ServiceDescription();
        serviceDescription.setType(WorldConfiguration.WUMPUS_WORLD_TYPE);
        serviceDescription.setName(WorldConfiguration.WUMPUS_WORLD_AGENT_SERVICE_DESCRIPTION);
        agentDescription.addServices(serviceDescription);

        try {
            DFService.register(this, agentDescription);
        } catch (FIPAException fe) {
            fe.printStackTrace();
        }
        addBehaviour(new WumpusWorldCoreGameLoop(this));
    }

    @Override
    protected void takeDown() {
        try {
            DFService.deregister(this);
        } catch (FIPAException fe) {
            fe.printStackTrace();
        }
        System.out.println("Agent " + getAID().getName() + " shutting down.");
    }

    public ActionResult doAction(Actions actionKey) {
        final Action action = this.actions.get(actionKey);
        if (action == null) {
            throw new RuntimeException("No such action " + actionKey.toString());
        }

        ActionResult result = action.act();
        return ActionResult.OK;
    }

    public boolean isAgentAlive() {
        return this.cave.getAgent().isAlive();

    }
}
