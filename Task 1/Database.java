class Database {

    // [SubmissionController → Database] saveSubmission(data)
    public void saveSubmission(String data) {
        CallTracker.record();
        System.out.println("  [DB] Submission saved.");
    }

    // [ReviewerManager → Database] fetchReviewers() : reviewerList
    public Reviewer[] fetchReviewers() {
        CallTracker.record();

        return new Reviewer[]{
            new Reviewer("Reviewer A"),
            new Reviewer("Reviewer B"),
            new Reviewer("Reviewer C")
        };
    }

    // [EvaluationManager → Database] saveScore(score)
    public void saveScore(int score) {
        CallTracker.record();
        System.out.println("  [DB] Score saved: " + score);
    }
}