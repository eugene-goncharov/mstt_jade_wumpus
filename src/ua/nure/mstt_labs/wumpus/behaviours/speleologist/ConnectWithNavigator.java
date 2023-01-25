package ua.nure.mstt_labs.wumpus.behaviours.speleologist;

import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import ua.nure.mstt_labs.wumpus.agents.SpeleologistAgent;
import ua.nure.mstt_labs.wumpus.configs.WorldConfiguration;

/**
 * @author Eugene Goncharov
 */
public class ConnectWithNavigator extends Behaviour {

    private boolean isDone = false;

    public ConnectWithNavigator(SpeleologistAgent agent) {
        super(agent);
    }

    @Override
    public void action() {
        DFAgentDescription template = new DFAgentDescription();
        ServiceDescription sd = new ServiceDescription();
        sd.setType(WorldConfiguration.NAVIGATOR_AGENT_TYPE);
        template.addServices(sd);

        try {
            DFAgentDescription[] result = DFService.search(myAgent, template);
            if (result != null && result.length > 0) {
                AID navigationAgent = result[0].getName();
                myAgent.addBehaviour(new CommunicationWithNavigationAgent((SpeleologistAgent) myAgent, navigationAgent));
                isDone = true;
            } else {
                block();
            }
        } catch (FIPAException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean done() {
        return isDone;
    }
}