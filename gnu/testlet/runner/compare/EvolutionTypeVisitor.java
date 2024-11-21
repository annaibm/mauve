/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.runner.compare;

import gnu.testlet.runner.compare.ClassComparison;
import gnu.testlet.runner.compare.ComparisonVisitor;
import gnu.testlet.runner.compare.EvolutionType;
import gnu.testlet.runner.compare.PackageComparison;
import gnu.testlet.runner.compare.RunComparison;
import gnu.testlet.runner.compare.TestComparison;

public class EvolutionTypeVisitor
implements ComparisonVisitor {
    private final int[] counters = new int[EvolutionType.values().length];

    public int getCounter(EvolutionType type) {
        return this.counters[type.ordinal()];
    }

    @Override
    public void visit(RunComparison run) {
    }

    @Override
    public void visit(PackageComparison pkg) {
    }

    @Override
    public void visit(ClassComparison cls) {
    }

    @Override
    public void visit(TestComparison test) {
        int n = test.getEvolutionType().ordinal();
        this.counters[n] = this.counters[n] + 1;
    }
}

