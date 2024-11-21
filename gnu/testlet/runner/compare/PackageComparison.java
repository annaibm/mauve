/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.runner.compare;

import gnu.testlet.runner.PackageResult;
import gnu.testlet.runner.compare.Comparison;
import gnu.testlet.runner.compare.ComparisonVisitor;

public class PackageComparison
extends Comparison {
    PackageComparison(PackageResult result) {
        super(result);
    }

    @Override
    public void accept(ComparisonVisitor visitor) {
        visitor.visit(this);
        this.acceptChildren(visitor);
    }
}

