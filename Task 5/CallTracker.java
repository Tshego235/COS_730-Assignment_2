class CallTracker {

    public static int callCount = 0;

    public static void reset() {
        callCount = 0;
    }

    public static void record() {
        callCount++;
    }

    public static int get() {
        return callCount;
    }
}