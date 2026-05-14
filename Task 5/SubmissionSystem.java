class SubmissionSystem {
    private Database            database            = new Database();
    private DecisionEngine      decisionEngine      = new DecisionEngine();
    private ReviewerService     reviewerService     = new ReviewerService(database);
    private EvaluationService   evaluationService   = new EvaluationService(database);
    private NotificationService notificationService = new NotificationService();

    public void submit(String data) {
        CallTracker.record();

        if (!decisionEngine.validate(data)) {
            notificationService.notify("rejected");
            return;
        }

        database.saveSubmission(data);

        Reviewer[] reviewers = reviewerService.getOptimisedReviewers();
        double avg           = evaluationService.evaluate(reviewers);
        String decision      = decisionEngine.decide(avg);
        notificationService.notify(decision);
    }
}
