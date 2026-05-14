public class BaselineMain {

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║   BASELINE SYSTEM — Valid run         ║");
        System.out.println("╚══════════════════════════════════════╝");

        CallTracker.reset();

        SubmissionController ctrl =
                new SubmissionController();

        ctrl.submit("Research paper on neural networks");

        System.out.println("\n  Total method calls: "
                + CallTracker.get());

        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║   BASELINE SYSTEM — Invalid run       ║");
        System.out.println("╚══════════════════════════════════════╝");

        CallTracker.reset();

        ctrl.submit("");

        System.out.println("\n  Total method calls: "
                + CallTracker.get());

        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║   BASELINE — Benchmark (1000 runs)    ║");
        System.out.println("╚══════════════════════════════════════╝");

        long total = 0;

        for (int i = 0; i < 1000; i++) {

            CallTracker.reset();

            SubmissionController c2 =
                    new SubmissionController();

            long t0 = System.nanoTime();

            c2.submit("Test paper data " + i);

            total += System.nanoTime() - t0;
        }

        System.out.println("  Average execution time: "
                + (total / 1000) + " ns");
    }
}