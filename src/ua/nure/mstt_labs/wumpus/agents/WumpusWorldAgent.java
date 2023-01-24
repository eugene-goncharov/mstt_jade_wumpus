package ua.nure.mstt_labs.wumpus.agents;

import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import ua.nure.mstt_labs.wumpus.services.WorldConfiguration;
import ua.nure.mstt_labs.wumpus.world.AgentPosition;
import ua.nure.mstt_labs.wumpus.world.WumpusCave;

/**
 * @author Eugene Goncharov
 */
public class WumpusWorldAgent extends Agent {
    private WumpusCave cave;
    private AgentPosition agentPosition;

    public WumpusWorldAgent() {
        this.cave = new WumpusCave(4, 4,
                WorldConfiguration.DEFAULT_CAVE_CONFIGURATION);
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
}
