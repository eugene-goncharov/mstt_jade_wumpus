package ua.nure.mstt_labs.wumpus.configs;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Eugene Goncharov
 */
public class NavigatorMessages {
    // Navigator messages
    public static final String INFORMATION_PROPOSAL_NAVIGATOR = "Give me information regarding your current status.";
    public final static Map<Integer, String> STATES = new LinkedHashMap<Integer, String>() {{
        put(1, "Stench");
        put(2, "Breeze");
        put(3, "Glitter");
        put(4, "Scream");
    }};
}
