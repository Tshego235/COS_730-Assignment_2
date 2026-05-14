public class OptimisedMain {

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║   OPTIMISED SYSTEM — Valid run        ║");
        System.out.println("╚══════════════════════════════════════╝");

        CallTracker.reset();

        SubmissionSystem sys =
                new SubmissionSystem();

        sys.submit("Research paper on neural networks");

        System.out.println(
                "\n  Total method calls: "
                        + CallTracker.get()
        );

        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║   OPTIMISED SYSTEM — Invalid run      ║");
        System.out.println("╚══════════════════════════════════════╝");

        CallTracker.reset();

        sys.submit("");

        System.out.println(
                "\n  Total method calls: "
                        + CallTracker.get()
        );

        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║   OPTIMISED — Benchmark (1000 runs)   ║");
        System.out.println("╚══════════════════════════════════════╝");

        long total = 0;

        for (int i = 0; i < 1000; i++) {

            CallTracker.reset();

            SubmissionSystem s2 =
                    new SubmissionSystem();

            long t0 = System.nanoTime();

            s2.submit("Test paper data " + i);

            total += System.nanoTime() - t0;
        }

        System.out.println(
                "  Average execution time: "
                        + (total / 1000)
                        + " ns"
        );
    }
}