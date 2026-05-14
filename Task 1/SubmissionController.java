// [SubmissionController lifeline — central orchestrator]
class SubmissionController {

    private Validator validator = new Validator();

    private Database database = new Database();

    private ReviewerManager reviewerManager = new ReviewerManager();

    private EvaluationManager evaluationManager = new EvaluationManager();

    private NotificationService notificationService =
            new NotificationService();

    // [Researcher → UI → SubmissionController] submit(data)
    public void submit(String data) {

        CallTracker.record();

        boolean isValid = validator.validateFormat(data);

        if (!isValid) {
            System.out.println("  Error: Invalid submission");
            return;
        }

        database.saveSubmission(data);

        Reviewer[] reviewers =
                reviewerManager.getAvailableReviewers();

        reviewers = reviewerManager.filterConflicts(reviewers);

        reviewers = reviewerManager.checkWorkload(reviewers);

        for (Reviewer r : reviewers) {
            r.assignReview(data);
        }

        evaluationManager.startEvaluation(reviewers, data);

        String decision =
                evaluationManager.getFinalDecision();

        notificationService.sendNotification(decision);
    }
}