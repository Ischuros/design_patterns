package behavioral.visitor;

import java.time.Instant;

public record ReportB(String incidentName, String personInCharge,
                      Instant date) implements IReport {

    @Override
    public void accept(IExportVisitor visitor) {
        visitor.visitReportB(this);
    }

    @Override
    public Instant getDate() {
        return date;
    }

    @Override
    public String getTitle() {
        return incidentName;
    }
}
