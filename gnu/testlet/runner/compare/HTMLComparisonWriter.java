/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.runner.compare;

import gnu.testlet.runner.XMLReportWriter;
import gnu.testlet.runner.compare.ComparisonWriter;
import gnu.testlet.runner.compare.EvolutionType;
import java.io.PrintWriter;
import java.util.List;

public class HTMLComparisonWriter
extends ComparisonWriter {
    @Override
    protected ComparisonWriter.Visitor createVisitor(PrintWriter pw) {
        return new HTMLVisitor(pw);
    }

    protected static class HTMLVisitor
    extends ComparisonWriter.Visitor {
        private HTMLVisitor(PrintWriter pw) {
            super(pw);
        }

        @Override
        protected void writeSummary(int nbRegressions, int nbProgressions, int nbStagnations) {
            this.pw.append("<h2>Summary</h2>");
            this.appendLink(nbRegressions, EvolutionType.REGRESSION, " regressions. ");
            this.appendLink(nbProgressions, EvolutionType.PROGRESSION, " progressions. ");
            this.appendLink(nbStagnations, EvolutionType.STAGNATION, " stagnations. ");
        }

        @Override
        protected void writeSystemProperties(List systemProperties, String result1Name, String result2Name) {
            this.pw.append("<br/><h2>System properties</h2><br/>");
            this.pw.append("<table border=\"1\" cellspacing=\"1\" cellpadding=\"1\"><tr>");
            this.writeCell("th", 0, 1, "Name");
            this.writeCell("th", 0, 1, result1Name);
            this.writeCell("th", 0, 1, result2Name);
            this.pw.append("</tr>\n");
            int i = 0;
            while (i < systemProperties.size()) {
                this.pw.append("<tr>");
                this.writeCell("td", 0, 1, (String)systemProperties.get(i++));
                this.writeCell("td", 0, 1, (String)systemProperties.get(i++));
                this.writeCell("td", 0, 1, (String)systemProperties.get(i++));
                this.pw.append("</tr>");
            }
            this.pw.append("</table><br/>");
        }

        private void appendLink(int value2, EvolutionType type, String label) {
            this.pw.append("<a href=\"#").append(type.toString()).append("\">");
            this.pw.append(Integer.toString(value2)).append(label);
            this.pw.append("</a>").append("&nbsp;&nbsp;&nbsp;");
        }

        @Override
        public void writeBegin() {
            this.pw.append("<html><head></head><body>");
        }

        @Override
        public void writeEnd() {
            this.pw.append("</body></html>\n");
        }

        @Override
        public void writeBeginTable() {
            this.pw.append("<br/><h2 id=\"").append(this.type.toString()).append("\">");
            this.pw.append(this.evolutionLabel);
            this.pw.append("</h2><br/>");
            this.pw.append("<table border=\"1\" cellspacing=\"1\" cellpadding=\"1\"><tr>");
            this.writeCell("th", 0, ComparisonWriter.Level.values().length, "Name");
            this.writeCell("th", 0, 1, "Last reached checkpoint");
            this.pw.append("</tr>\n");
        }

        @Override
        public void writeEndTable() {
            this.pw.append("\n</table>");
        }

        @Override
        protected void writeBeginLine(ComparisonWriter.Level level) {
            this.writeIndent(level);
            this.pw.write("<tr>");
        }

        @Override
        protected void writeName(ComparisonWriter.Level level, String name2) {
            this.writeCell("td", level.getValue(), 1 + ComparisonWriter.Level.MAX.getValue() - level.getValue(), name2);
        }

        @Override
        protected void writeEndLine() {
            this.pw.write("</tr>\n");
        }

        @Override
        protected void writeCheckResult(String result) {
            this.writeCell("td", 0, 1, result);
        }

        private void writeCell(String tag, int nbColumnsBefore, int columnSpan, String value2) {
            this.writeCell(tag, nbColumnsBefore, columnSpan, value2, null);
        }

        private void writeCell(String tag, int nbColumnsBefore, int columnSpan, String value2, String style) {
            this.writeCell(tag, nbColumnsBefore, columnSpan, value2, style, null);
        }

        private void writeCell(String tag, int nbColumnsBefore, int columnSpan, String value2, String style, String bgColor) {
            for (int i = 0; i < nbColumnsBefore; ++i) {
                this.pw.append("<").append(tag).append(" width=\"30px\"></").append(tag).append(">");
            }
            this.pw.append("<").append(tag);
            if (style != null) {
                this.pw.append(" style=\"").append(style).append('\"');
            }
            if (columnSpan > 1) {
                this.pw.append(" colspan=\"").append(Integer.toString(columnSpan)).append('\"');
            }
            if (bgColor != null) {
                this.pw.append(" bgcolor=\"").append(bgColor).append('\"');
            }
            this.pw.append('>');
            this.pw.append(XMLReportWriter.protect(value2));
            this.pw.append("</").append(tag).append(">");
        }
    }
}

