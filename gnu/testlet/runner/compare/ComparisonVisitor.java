/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.runner.compare;

import gnu.testlet.runner.compare.ClassComparison;
import gnu.testlet.runner.compare.PackageComparison;
import gnu.testlet.runner.compare.RunComparison;
import gnu.testlet.runner.compare.TestComparison;

public interface ComparisonVisitor {
    public void visit(RunComparison var1);

    public void visit(PackageComparison var1);

    public void visit(ClassComparison var1);

    public void visit(TestComparison var1);
}

