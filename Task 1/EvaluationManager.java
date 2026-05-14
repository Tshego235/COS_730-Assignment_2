class EvaluationManager {

    private Database database = new Database();

    private int[] scores;
    private String decision;

    // [SubmissionController → EvaluationManager] startEvaluation()
    public void startEvaluation(Reviewer[] reviewers, String data) {
        CallTracker.record();

        scores = new int[reviewers.length];

        // [loop [each reviewer]]
        for (int i = 0; i < reviewers.length; i++) {

            int score = reviewers[i].submitScore();

            scores[i] = score;

            database.saveScore(score);
        }

        double avg = calculateAverage();

        boolean consensus = checkConsensus(scores);

        decision = applyRules(avg, consensus);
    }

    // [EvaluationManager self-call] calculateAverage()
    public double calculateAverage() {
        CallTracker.record();

        int sum = 0;

        for (int s : scores) {
            sum += s;
        }

        double avg = sum / (double) scores.length;

        System.out.println("  Average score: " + avg);

        return avg;
    }

    // [EvaluationManager self-call] checkConsensus()
    public boolean checkConsensus(int[] scores) {
        CallTracker.record();

        int first = scores[0];

        for (int s : scores) {
            if (s != first) {
                System.out.println("  No consensus.");
                return false;
            }
        }

        System.out.println("  Consensus reached.");

        return true;
    }

    // [EvaluationManager self-call] applyRules(avg, consensus)
    public String applyRules(double avg, boolean consensus) {
        CallTracker.record();

        if (avg >= 7 && consensus) {
            System.out.println("  Decision: ACCEPTED");
            return "accepted";
        }

        if (avg >= 5) {
            System.out.println("  Decision: REVISION");
            return "revision";
        }

        System.out.println("  Decision: REJECTED");

        return "rejected";
    }

    // [EvaluationManager → SubmissionController] getFinalDecision()
    public String getFinalDecision() {
        CallTracker.record();
        return decision;
    }
}