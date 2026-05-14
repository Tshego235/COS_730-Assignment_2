// FIX 1: Database injected — same shared instance as rest of system.
// FIX 4: Returns average directly — eliminates getFinalDecision() call.
// Removed: calculateAverage() (inlined), checkConsensus() (eliminated),
// applyRules() (moved to DecisionEngine), getFinalDecision() (gone).
class EvaluationService {

    private Database db;

    public EvaluationService(Database db) {
        this.db = db;
    }

    public double evaluate(Reviewer[] reviewers) {
        CallTracker.record();

        int total = 0;

        for (Reviewer r : reviewers) {

            int score = r.submitScore();

            total += score;

            db.saveScore(score);
        }

        double avg = total / (double) reviewers.length;

        System.out.println("  Average score: " + avg);

        return avg;
    }
}