package behavioral.visitor;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {
        final ReportA reportA = new ReportA("Lucas", Instant.now(), "My awesome report A");
        final ReportB reportB = new ReportB("Awful crash", "Suzanne", Instant.now().minus(1, ChronoUnit.DAYS));

        new XMLExporter().export(reportA, reportB);
    }
}
