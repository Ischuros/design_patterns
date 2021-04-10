package behavioral.visitor;

import java.time.Instant;

public interface IReport {

    void accept(IExportVisitor visitor);

    Instant getDate();

    String getTitle();
}
