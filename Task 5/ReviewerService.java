// FIX 1: Database injected via constructor — no separate instance.
// FIX 2: filterAndSelect() is a real single-pass filter replacing the two
// sequential calls (filterConflicts + checkWorkload) from the baseline.
class ReviewerService {

    private Database db;

    public ReviewerService(Database db) {
        this.db = db;
    }

    // Replaces:
    // getAvailableReviewers()
    // + filterConflicts()
    // + checkWorkload()
    public Reviewer[] getOptimisedReviewers() {
        CallTracker.record();

        Reviewer[] all = db.fetchReviewers();

        return filterAndSelect(all);
    }

    // Single pass — checks both conflict and workload in one loop
    private Reviewer[] filterAndSelect(Reviewer[] reviewers) {
        CallTracker.record();

        java.util.List<Reviewer> selected =
                new java.util.ArrayList<>();

        for (Reviewer r : reviewers) {

            if (!r.hasConflict() && !r.isOverloaded()) {
                selected.add(r);
            }
        }

        System.out.println(
                "  Reviewers selected after filtering: "
                        + selected.size()
        );

        return selected.toArray(new Reviewer[0]);
    }
}