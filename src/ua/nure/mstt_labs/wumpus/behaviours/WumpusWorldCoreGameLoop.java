package ua.nure.mstt_labs.wumpus.behaviours;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import ua.nure.mstt_labs.wumpus.actions.ActionResult;
import ua.nure.mstt_labs.wumpus.actions.Actions;
import ua.nure.mstt_labs.wumpus.agents.WumpusWorldAgent;
import ua.nure.mstt_labs.wumpus.configs.MessagesConfig;

/**
 * @author Eugene Goncharov
 */
public class WumpusWorldCoreGameLoop extends CyclicBehaviour {

    public WumpusWorldCoreGameLoop(WumpusWorldAgent agent) {
        super(agent);
    }

    @Override
    public void action() {
        MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.PROPOSE);
        ACLMessage msg = myAgent.receive(mt);

        if (msg != null) {
            final WumpusWorldAgent agent = (WumpusWorldAgent) myAgent;
            String message = msg.getContent();
            System.out.println(myAgent.getName() + ": Current state:");

            boolean sendTerminateMessage = false;
            boolean sendWinMessage = false;

            switch (message) {
                case MessagesConfig.SPELEOLOGIST_TURN_LEFT -> agent.doAction(Actions.TURN_LEFT);
                case MessagesConfig.SPELEOLOGIST_TURN_RIGHT -> agent.doAction(Actions.TURN_RIGHT);
                case MessagesConfig.SPELEOLOGIST_MOVE_FORWARD -> {
                    ActionResult moveForwardResult = agent.doAction(Actions.MOVE_FORWARD);
                    sendTerminateMessage = !agent.isAgentAlive();
                }
                case MessagesConfig.SPELEOLOGIST_GRAB -> agent.doAction(Actions.GRAB);
                case MessagesConfig.SPELEOLOGIST_SHOOT -> agent.doAction(Actions.SHOOT);
                case MessagesConfig.SPELEOLOGIST_CLIMB -> {
                    ActionResult climbResult = agent.doAction(Actions.CLIMB);

                    if (climbResult.isSuccessful())
                        sendWinMessage = true;
                    else
                        sendTerminateMessage = true;
                }
                default -> System.out.println(myAgent.getName() + ": There is no action!");
            }

            ACLMessage reply = msg.createReply();
            reply.setPerformative(ACLMessage.INFORM);

            //noinspection ConstantValue
            if (sendWinMessage) {
                reset();
                reply.setContent(MessagesConfig.WIN_MESSAGE);
                myAgent.send(reply);
                return;
            }

            if (!sendTerminateMessage) {
                reply.setContent(MessagesConfig.OK_MESSAGE);
                myAgent.send(reply);
            } else {
                reset();
                reply.setContent(MessagesConfig.FAIL_MESSAGE);
            }


        } else {
            block();
        }
    }
}
