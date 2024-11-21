/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.runner.compare;

import gnu.testlet.runner.compare.ComparisonWriter;
import java.io.PrintWriter;
import java.util.List;

public class TextComparisonWriter
extends ComparisonWriter {
    @Override
    protected ComparisonWriter.Visitor createVisitor(PrintWriter pw) {
        return new TextVisitor(pw);
    }

    protected static class TextVisitor
    extends ComparisonWriter.Visitor {
        private TextVisitor(PrintWriter pw) {
            super(pw);
        }

        @Override
        protected void writeSummary(int nbRegressions, int nbProgressions, int nbStagnations) {
            this.pw.append(Integer.toString(nbRegressions)).append(" regressions. ");
            this.pw.append(Integer.toString(nbProgressions)).append(" progressions. ");
            this.pw.append(Integer.toString(nbStagnations)).append(" stagnations.\n");
        }

        @Override
        protected void writeSystemProperties(List systemProperties, String result1Name, String result2Name) {
            this.pw.append("\nSystem properties\n");
            this.pw.append("Name\t").append(result1Name).append('\t').append(result2Name).append('\n');
            int i = 0;
            while (i < systemProperties.size()) {
                this.pw.append((String)systemProperties.get(i++)).append('\t');
                this.pw.append((String)systemProperties.get(i++)).append('\t');
                this.pw.append((String)systemProperties.get(i++)).append('\n');
            }
        }

        @Override
        public void writeBeginTable() {
            this.pw.append("\n").append(this.evolutionLabel).append("\n");
        }

        @Override
        protected void writeBeginLine(ComparisonWriter.Level level) {
            this.writeIndent(level);
        }

        @Override
        protected void writeName(ComparisonWriter.Level level, String name2) {
            this.pw.append(name2).append('\t');
        }

        @Override
        protected void writeEndLine() {
            this.pw.append('\n');
        }

        @Override
        protected void writeCheckResult(String result) {
            this.pw.append('\t').append(result);
        }
    }
}

