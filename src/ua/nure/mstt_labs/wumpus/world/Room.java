package ua.nure.mstt_labs.wumpus.world;

import java.util.Objects;

/**
 * @author Eugene Goncharov
 */
public final class Room {
    private final RoomContent content;

    public Room(RoomContent content) {
        this.content = content;
    }

    public RoomContent getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Room room = (Room) o;
        return content == room.content;
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("").append(content);
        sb.append('}');
        return sb.toString();
    }
}
