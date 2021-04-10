package behavioral.visitor;

import java.time.Instant;

public record ReportA(String author, Instant date, String title) implements IReport {

    @Override
    public void accept(IExportVisitor visitor) {
        visitor.visitReportA(this);
    }

    @Override
    public Instant getDate() {
        return date;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
