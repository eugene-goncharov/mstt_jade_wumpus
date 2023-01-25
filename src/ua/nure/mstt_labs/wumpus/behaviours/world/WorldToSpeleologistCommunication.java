package ua.nure.mstt_labs.wumpus.behaviours.world;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import ua.nure.mstt_labs.wumpus.agents.WumpusWorldAgent;
import ua.nure.mstt_labs.wumpus.configs.MessagesConfig;
import ua.nure.mstt_labs.wumpus.configs.SpeleologistMessages;

import java.util.Objects;

/**
 * @author Eugene Goncharov
 */
public class WorldToSpeleologistCommunication extends CyclicBehaviour {

    public WorldToSpeleologistCommunication(WumpusWorldAgent agent) {
        super(agent);
    }

    @Override
    public void action() {
        MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.CFP);
        ACLMessage msg = myAgent.receive(mt);

        if (msg != null) {
            String message = msg.getContent();

            if (Objects.equals(message, SpeleologistMessages.ENTER_CAVE)) {
                ACLMessage reply = msg.createReply();
                reply.setPerformative(ACLMessage.CONFIRM);
                reply.setContent(MessagesConfig.OK_MESSAGE);
                myAgent.send(reply);
            }
        } else {
            block();
        }
    }
}
