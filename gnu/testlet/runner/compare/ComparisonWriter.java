/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.runner.compare;

import gnu.testlet.runner.CheckResult;
import gnu.testlet.runner.compare.ClassComparison;
import gnu.testlet.runner.compare.Comparison;
import gnu.testlet.runner.compare.ComparisonVisitor;
import gnu.testlet.runner.compare.EvolutionType;
import gnu.testlet.runner.compare.EvolutionTypeVisitor;
import gnu.testlet.runner.compare.PackageComparison;
import gnu.testlet.runner.compare.RunComparison;
import gnu.testlet.runner.compare.TestComparison;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

public abstract class ComparisonWriter {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void write(RunComparison comp, File output) throws FileNotFoundException {
        try (PrintWriter ps = null;){
            ps = new PrintWriter(new FileOutputStream(output));
            this.write(comp, ps);
        }
    }

    public final void write(RunComparison run, PrintWriter pw) {
        Visitor v = this.createVisitor(pw);
        v.writeBegin();
        v.writeSummary(run);
        this.write(run, pw, v, EvolutionType.REGRESSION, "Regressions");
        this.write(run, pw, v, EvolutionType.PROGRESSION, "Progressions");
        this.write(run, pw, v, EvolutionType.STAGNATION, "Stagnations");
        v.writeEnd();
        pw.flush();
    }

    private void write(RunComparison run, PrintWriter pw, Visitor v, EvolutionType type, String typeLabel) {
        v.setType(type);
        v.setEvolutionLabel(typeLabel);
        v.writeBeginTable();
        run.accept(v);
        v.writeEndTable();
    }

    protected abstract Visitor createVisitor(PrintWriter var1);

    protected static abstract class Visitor
    implements ComparisonVisitor {
        protected final PrintWriter pw;
        protected EvolutionType type;
        protected String evolutionLabel;

        protected Visitor(PrintWriter pw) {
            this.pw = pw;
        }

        public void setType(EvolutionType type) {
            this.type = type;
        }

        public void setEvolutionLabel(String label) {
            this.evolutionLabel = label;
        }

        protected abstract void writeSummary(int var1, int var2, int var3);

        protected abstract void writeSystemProperties(List var1, String var2, String var3);

        private void writeSummary(RunComparison run) {
            EvolutionTypeVisitor evolTypeVisitor = new EvolutionTypeVisitor();
            run.accept(evolTypeVisitor);
            this.writeSummary(evolTypeVisitor.getCounter(EvolutionType.REGRESSION), evolTypeVisitor.getCounter(EvolutionType.PROGRESSION), evolTypeVisitor.getCounter(EvolutionType.STAGNATION));
            this.writeSystemProperties(run.getSystemProperties(), run.getResult1Name(), run.getResult2Name());
        }

        public void writeBegin() {
        }

        public void writeEnd() {
        }

        public void writeBeginTable() {
        }

        public void writeEndTable() {
        }

        @Override
        public final void visit(RunComparison run) {
            if (this.shouldWrite(run)) {
                this.write(Level.RUN, run, true);
            }
        }

        @Override
        public final void visit(PackageComparison pkg) {
            if (this.shouldWrite(pkg)) {
                this.write(Level.PACKAGE, pkg, true);
            }
        }

        @Override
        public final void visit(ClassComparison cls) {
            if (this.shouldWrite(cls)) {
                this.write(Level.CLASS, cls, true);
            }
        }

        @Override
        public final void visit(TestComparison test) {
            if (this.shouldWrite(test)) {
                String result;
                this.write(Level.TEST, test, false);
                CheckResult cr = test.getCheckResult();
                if (cr == null) {
                    result = "<no checkpoint>";
                } else {
                    result = Integer.toString(cr.getNumber()) + ':';
                    result = cr.getCheckPoint() == null ? result + "<no name>" : result + cr.getCheckPoint();
                }
                this.writeCheckResult(result);
                this.writeEndLine();
            }
        }

        protected abstract void writeBeginLine(Level var1);

        protected abstract void writeName(Level var1, String var2);

        protected abstract void writeEndLine();

        protected abstract void writeCheckResult(String var1);

        protected final void writeIndent(Level level) {
            int indent = level.getValue() * 4;
            for (int i = 0; i < indent; ++i) {
                this.pw.append(' ');
            }
        }

        private boolean shouldWrite(Comparison comp) {
            EvolutionTypeVisitor v = new EvolutionTypeVisitor();
            comp.accept(v);
            return v.getCounter(this.type) > 0;
        }

        private void write(Level level, Comparison comp, boolean endLine) {
            this.writeBeginLine(level);
            this.writeName(level, comp.getName());
            if (endLine) {
                this.writeEndLine();
            }
        }
    }

    protected static class Level {
        public static final Level RUN = new Level(0);
        public static final Level PACKAGE = new Level(1);
        public static final Level CLASS = new Level(2);
        public static final Level TEST = new Level(3);
        private static final Level[] VALUES = new Level[]{RUN, PACKAGE, CLASS, TEST};
        public static final Level MAX = VALUES[VALUES.length - 1];
        private final int level;

        public static final Level[] values() {
            return VALUES;
        }

        private Level(int level) {
            this.level = level;
        }

        public int getValue() {
            return this.level;
        }
    }
}

