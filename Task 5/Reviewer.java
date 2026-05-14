// Extended with conflict and overload flags to support real filtering.
class Reviewer {

    private String name;

    private boolean conflict;

    private boolean overloaded;

    private java.util.Random random =
            new java.util.Random(42);

    public Reviewer(
            String name,
            boolean conflict,
            boolean overloaded
    ) {
        this.name = name;
        this.conflict = conflict;
        this.overloaded = overloaded;
    }

    public boolean hasConflict() {
        return conflict;
    }

    public boolean isOverloaded() {
        return overloaded;
    }

    public void assignReview(String data) {
        CallTracker.record();
        System.out.println("  " + name + " assigned to review.");
    }

    public int submitScore() {
        CallTracker.record();

        int score = random.nextInt(10) + 1;

        System.out.println("  " + name + " submitted score: " + score);

        return score;
    }
}