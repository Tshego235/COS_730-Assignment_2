// FIX 4: No switch statement — decision already resolved by DecisionEngine.
// Single method, complexity 1. Three private notify methods eliminated.
class NotificationService {

    public void notify(String decision) {
        CallTracker.record();
        System.out.println("  Final Decision: " + decision);
    }
}