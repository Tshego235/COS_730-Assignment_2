import java.util.*;
import java.io.*;

public class BaselineMain {
    public static void main(String[] args) throws Exception {

        // ── Valid run ──────────────────────────────────────────────────────
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║  BASELINE SYSTEM — Valid run          ║");
        System.out.println("╚══════════════════════════════════════╝");
        CallTracker.reset();
        SubmissionController ctrl = new SubmissionController();
        ctrl.submit("Research paper on neural networks");
        System.out.println("  Total method calls: " + CallTracker.get());

        // ── Invalid run ────────────────────────────────────────────────────
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║  BASELINE SYSTEM — Invalid run        ║");
        System.out.println("╚══════════════════════════════════════╝");
        CallTracker.reset();
        ctrl.submit("");
        System.out.println("  Total method calls: " + CallTracker.get());

        // ── Benchmark — output suppressed during timing ────────────────────
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║  BASELINE — Benchmark (1000 runs)     ║");
        System.out.println("╚══════════════════════════════════════╝");

        PrintStream original = System.out;
        System.setOut(new PrintStream(OutputStream.nullOutputStream())); // silence output

        long total = 0;
        for (int i = 0; i < 1000; i++) {
            SubmissionController c = new SubmissionController();
            long t0 = System.nanoTime();
            c.submit("Test paper data");
            total += System.nanoTime() - t0;
        }

        System.setOut(original); // restore output
        System.out.println("  Average execution time: " + (total / 1000) + " ns");
    }
}
