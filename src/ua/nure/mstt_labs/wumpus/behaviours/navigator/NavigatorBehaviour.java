package ua.nure.mstt_labs.wumpus.behaviours.navigator;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import ua.nure.mstt_labs.wumpus.agents.NavigatorAgent;
import ua.nure.mstt_labs.wumpus.configs.MessagesConfig;
import ua.nure.mstt_labs.wumpus.configs.NavigatorMessages;
import ua.nure.mstt_labs.wumpus.parsers.SpeleologistMessageParser;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Eugene Goncharov
 */
public class NavigatorBehaviour extends CyclicBehaviour {
    private int time;

    public NavigatorBehaviour(NavigatorAgent agent) {
        super(agent);
        this.time = 0;
    }

    @Override
    public void action() {
        MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.INFORM);
        ACLMessage msg = myAgent.receive(mt);

        if (msg != null) {
            final String messageContent = msg.getContent();

            if (SpeleologistMessageParser.isAskingForHelpMessage(messageContent)) {
                ACLMessage reply = msg.createReply();
                reply.setPerformative(ACLMessage.REQUEST);
                reply.setContent(NavigatorMessages.INFORMATION_PROPOSAL_NAVIGATOR);

                System.out.println(myAgent.getName() + ": " + NavigatorMessages.INFORMATION_PROPOSAL_NAVIGATOR);
                myAgent.send(reply);
            } else if (SpeleologistMessageParser.isGivingInformationMessage(messageContent)) {
                ACLMessage reply = msg.createReply();
                reply.setPerformative(ACLMessage.PROPOSE);
                
                String advice = getAdvice(messageContent);
                reply.setContent(advice);

                System.out.println(myAgent.getName() + ": " + advice);
                myAgent.send(reply);

            } else
                System.out.println(myAgent.getName() + ": Navigator received unexpected message.");
        } else {
            block();
        }
    }


    private String getAdvice(String content) {
        boolean stench = false;
        boolean breeze = false;
        boolean glitter = false;
        boolean scream = false;

        String advicedAction = "";

        for (Map.Entry<Integer, String> entry : NavigatorMessages.STATES.entrySet()) {
            String value = entry.getValue();
            Pattern pattern = Pattern.compile("\\b" + value + "\\b", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(content);
            if (matcher.find()) {
                switch (value) {
                    case "Stench":
                        stench = true;
                    case "Breeze":
                        breeze = true;
                    case "Glitter":
                        glitter = true;
                    case "Scream":
                        scream = true;
                }
            }
        }

        switch (time) {
            case 0, 2, 4, 6 -> {
                advicedAction = MessagesConfig.MESSAGE_FORWARD;
                time++;
            }
            case 1 -> {
                advicedAction = MessagesConfig.MESSAGE_RIGHT;
                time++;
            }
            case 3, 5 -> {
                advicedAction = MessagesConfig.MESSAGE_LEFT;
                time++;
            }
        }

        int rand = 1 + (int) (Math.random() * 3);
        return switch (rand) {
            case 1 -> MessagesConfig.ACTION_PROPOSAL1 + advicedAction;
            case 2 -> MessagesConfig.ACTION_PROPOSAL2 + advicedAction;
            case 3 -> MessagesConfig.ACTION_PROPOSAL3 + advicedAction;
            default -> "";
        };
    }
}
