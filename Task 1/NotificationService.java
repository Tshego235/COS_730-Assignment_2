class NotificationService {

    // [SubmissionController → NotificationService]
    public void sendNotification(String decision) {
        CallTracker.record();

        switch (decision) {

            case "accepted":
                notifyAcceptance();
                break;

            case "rejected":
                notifyRejection();
                break;

            case "revision":
                notifyRevision();
                break;
        }
    }

    private void notifyAcceptance() {
        CallTracker.record();
        System.out.println("  Notification: Accepted");
    }

    private void notifyRejection() {
        CallTracker.record();
        System.out.println("  Notification: Rejected");
    }

    private void notifyRevision() {
        CallTracker.record();
        System.out.println("  Notification: Revision Required");
    }
}