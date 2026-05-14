class ReviewerManager {

    private Database database = new Database();

    // [ReviewerManager → Database] fetchReviewers()
    public Reviewer[] getAvailableReviewers() {
        CallTracker.record();
        return database.fetchReviewers();
    }

    // [ReviewerManager self-call] filterConflicts(reviewerList)
    public Reviewer[] filterConflicts(Reviewer[] reviewers) {
        CallTracker.record();
        System.out.println("  Filtering conflicts.");
        return reviewers;
    }

    // [ReviewerManager self-call] checkWorkload(reviewerList)
    public Reviewer[] checkWorkload(Reviewer[] reviewers) {
        CallTracker.record();
        System.out.println("  Checking workload.");
        return reviewers;
    }
}