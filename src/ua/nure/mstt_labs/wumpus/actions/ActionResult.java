package ua.nure.mstt_labs.wumpus.actions;

/**
 * @author Eugene Goncharov
 */
public class ActionResult {
    public static final ActionResult OK = new ActionResult(true);
    public static final ActionResult FAILED = new ActionResult(false);
    private final boolean successful;

    public ActionResult(boolean successful) {
        this.successful = successful;
    }

    public boolean isSuccessful() {
        return successful;
    }
}
