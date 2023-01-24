package ua.nure.mstt_labs.wumpus.world;

import ua.nure.mstt_labs.wumpus.services.WorldConfiguration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Eugene Goncharov
 */
public class WumpusCave {
    private final Map<Position, Room> map;
    private AgentPosition currentAgentPosition;

    public WumpusCave() {

        Position startPosition = new Position(1, 1);
        this.currentAgentPosition = new AgentPosition(startPosition, Orientation.NORTH);
        this.map = new HashMap<>();

        this.map.put(startPosition, new Room(RoomContent.EMTPY));
        this.map.put(new Position(1, 2), new Room(RoomContent.BREEZE));
        this.map.put(new Position(1, 3), new Room(RoomContent.PIT));
        this.map.put(new Position(1, 4), new Room(RoomContent.BREEZE));

        this.map.put(new Position(2, 1), new Room(RoomContent.STENCH));
        this.map.put(new Position(2, 2), new Room(RoomContent.EMTPY));
        this.map.put(new Position(2, 3), new Room(RoomContent.BREEZE));
        this.map.put(new Position(2, 4), new Room(RoomContent.EMTPY));

        this.map.put(new Position(3, 1), new Room(RoomContent.WUMPUS));
        this.map.put(new Position(3, 2), new Room(RoomContent.STENCH));
        this.map.put(new Position(3, 3), new Room(RoomContent.EMTPY));
        this.map.put(new Position(3, 4), new Room(RoomContent.BREEZE));

        this.map.put(new Position(4, 1), new Room(RoomContent.STENCH));
        this.map.put(new Position(4, 2), new Room(RoomContent.EMTPY));
        this.map.put(new Position(4, 3), new Room(RoomContent.BREEZE));
        this.map.put(new Position(4, 4), new Room(RoomContent.PIT));
    }

    public AgentPosition getCurrentAgentPosition() {
        return currentAgentPosition;
    }
}
