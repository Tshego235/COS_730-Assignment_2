class DecisionEngine {

    // Replaces Validator.validateFormat()
    public boolean validate(String data) {
        CallTracker.record();
        return data != null && !data.trim().isEmpty();
    }

    // Replaces EvaluationManager.applyRules(avg, consensus)
    // Consensus check removed
    public String decide(double avg) {
        CallTracker.record();

        if (avg >= 7) {
            return "accepted";
        }

        if (avg >= 5) {
            return "revision";
        }

        return "rejected";
    }
}