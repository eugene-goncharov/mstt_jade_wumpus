package ua.nure.mstt_labs.wumpus.agents;

import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import ua.nure.mstt_labs.wumpus.services.WorldConfiguration;

/**
 * @author Eugene Goncharov
 */
public class WumpusWorldAgent extends Agent {

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
}
