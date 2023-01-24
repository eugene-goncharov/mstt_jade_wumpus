package ua.nure.mstt_labs.wumpus.world;

/**
 * @author Eugene Goncharov
 */
public enum Orientation {
    NORTH("North"),
    WEST("West"),
    SOUTH("South"),
    EAST("East");

    Orientation(String sym) {
        symbol = sym;
    }

    private final String symbol;

    public String getSymbol() {
        return symbol;
    }
}
