// Replaces SubmissionController.
// FIX 1: Single shared Database passed to all services via constructors.
// submit() is a clean linear pipeline matching the optimised sequence diagram.
class SubmissionSystem {

    private Database database =
            new Database();

    private DecisionEngine decisionEngine =
            new DecisionEngine();

    private ReviewerService reviewerService =
            new ReviewerService(database);

    private EvaluationService evaluationService =
            new EvaluationService(database);

    private NotificationService notificationService =
            new NotificationService();

    public void submit(String data) {

        CallTracker.record();

        // Step 1: Validate
        if (!decisionEngine.validate(data)) {

            notificationService.notify("rejected");

            return;
        }

        // Step 2: Save
        database.saveSubmission(data);

        // Step 3: Select reviewers
        Reviewer[] reviewers =
                reviewerService.getOptimisedReviewers();

        // Step 4: Evaluate
        double avg =
                evaluationService.evaluate(reviewers);

        // Step 5: Decide
        String decision =
                decisionEngine.decide(avg);

        // Step 6: Notify
        notificationService.notify(decision);
    }
}