public class OptimisedMain {
    public static void main(String[] args) throws Exception {

        // ── Valid run ──────────────────────────────────────────────────────
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║  OPTIMISED SYSTEM — Valid run         ║");
        System.out.println("╚══════════════════════════════════════╝");
        CallTracker.reset();
        SubmissionSystem sys = new SubmissionSystem();
        sys.submit("Research paper on neural networks");
        System.out.println("  Total method calls: " + CallTracker.get());

        // ── Invalid run ────────────────────────────────────────────────────
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║  OPTIMISED SYSTEM — Invalid run       ║");
        System.out.println("╚══════════════════════════════════════╝");
        CallTracker.reset();
        sys.submit("");
        System.out.println("  Total method calls: " + CallTracker.get());

        // ── Benchmark — FIX 2: suppress output during timing ───────────────
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║  OPTIMISED — Benchmark (1000 runs)    ║");
        System.out.println("╚══════════════════════════════════════╝");

        PrintStream original = System.out;
        System.setOut(new PrintStream(OutputStream.nullOutputStream())); // silence output

        long total = 0;
        for (int i = 0; i < 1000; i++) {
            SubmissionSystem s = new SubmissionSystem();
            long t0 = System.nanoTime();
            s.submit("Test paper data");
            total += System.nanoTime() - t0;
        }

        System.setOut(original); // restore output
        System.out.println("  Average execution time: " + (total / 1000) + " ns");
    }
}
