/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.runner.compare;

import gnu.testlet.runner.ClassResult;
import gnu.testlet.runner.compare.Comparison;
import gnu.testlet.runner.compare.ComparisonVisitor;

public class ClassComparison
extends Comparison {
    ClassComparison(ClassResult result) {
        super(result);
    }

    @Override
    public void accept(ComparisonVisitor visitor) {
        visitor.visit(this);
        this.acceptChildren(visitor);
    }
}

