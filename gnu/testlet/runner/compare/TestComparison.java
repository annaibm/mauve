/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.runner.compare;

import gnu.testlet.runner.CheckResult;
import gnu.testlet.runner.TestResult;
import gnu.testlet.runner.compare.Comparison;
import gnu.testlet.runner.compare.ComparisonVisitor;
import gnu.testlet.runner.compare.EvolutionType;

public class TestComparison
extends Comparison {
    private final int progression;
    private final CheckResult check;

    public TestComparison(TestResult test, CheckResult check2, int nbProgressedChecks) {
        super(test);
        this.progression = nbProgressedChecks;
        this.check = check2;
    }

    public CheckResult getCheckResult() {
        return this.check;
    }

    @Override
    public int getProgression() {
        return this.progression;
    }

    public EvolutionType getEvolutionType() {
        EvolutionType type = EvolutionType.STAGNATION;
        if (this.getProgression() > 0) {
            type = EvolutionType.PROGRESSION;
        } else if (this.getProgression() < 0) {
            type = EvolutionType.REGRESSION;
        }
        return type;
    }

    @Override
    public void accept(ComparisonVisitor visitor) {
        visitor.visit(this);
    }
}

