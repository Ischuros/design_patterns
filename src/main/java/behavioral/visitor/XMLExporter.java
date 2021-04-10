package behavioral.visitor;

import org.apache.log4j.Logger;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.Locale;

public class XMLExporter implements IExportVisitor {

    public void export(IReport... reports) {
        Arrays.stream(reports).forEach(r -> r.accept(this));
    }

    private String export(IReport report) {
        return "XML Export : title=\"" + report.getTitle() + "\" date=\"" + DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(Locale.FRANCE).withZone(ZoneId.systemDefault()).format(report.getDate()) + "\"";
    }

    @Override
    public void visitReportA(ReportA reportA) {
        final String log = export(reportA) + " author=\"" + reportA.author() + "\"";
        Logger.getLogger(XMLExporter.class).debug(log);
    }

    @Override
    public void visitReportB(ReportB reportB) {
        final String log = export(reportB) + " person in charge of the incident=\"" + reportB.personInCharge() + "\"";
        Logger.getLogger(XMLExporter.class).debug(log);
    }
}
