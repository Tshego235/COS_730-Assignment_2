class Database {

    public void saveSubmission(String data) {
        CallTracker.record();
        System.out.println("  [DB] Submission saved.");
    }

    public Reviewer[] fetchReviewers() {
        CallTracker.record();

        // Reviewers carry real conflict/overload flags for filtering
        return new Reviewer[] {
                new Reviewer("Reviewer A", false, false),
                new Reviewer("Reviewer B", true, false),
                new Reviewer("Reviewer C", false, false),
                new Reviewer("Reviewer D", false, true)
        };
    }

    public void saveScore(int score) {
        CallTracker.record();
        System.out.println("  [DB] Score saved: " + score);
    }
}