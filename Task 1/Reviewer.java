// [Reviewer lifeline]
class Reviewer {

    private String name;
    private java.util.Random random = new java.util.Random(42);

    public Reviewer(String name) {
        this.name = name;
    }

    // [loop [assign reviewers] → Reviewer] assignReview()
    public void assignReview(String data) {
        CallTracker.record();
        System.out.println("  " + name + " assigned to review.");
    }

    // [loop [each reviewer] → EvaluationManager] submitScore() : score
    public int submitScore() {
        CallTracker.record();

        int score = random.nextInt(10) + 1;

        System.out.println("  " + name + " submitted score: " + score);

        return score;
    }
}