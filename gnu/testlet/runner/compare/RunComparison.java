/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.runner.compare;

import gnu.testlet.runner.CheckResult;
import gnu.testlet.runner.ClassResult;
import gnu.testlet.runner.PackageResult;
import gnu.testlet.runner.RunResult;
import gnu.testlet.runner.TestResult;
import gnu.testlet.runner.compare.ClassComparison;
import gnu.testlet.runner.compare.Comparison;
import gnu.testlet.runner.compare.ComparisonVisitor;
import gnu.testlet.runner.compare.PackageComparison;
import gnu.testlet.runner.compare.TestComparison;
import java.util.ArrayList;
import java.util.List;

public class RunComparison
extends Comparison {
    private final List systemProperties = new ArrayList();
    private final String result1Name;
    private final String result2Name;

    RunComparison(RunResult result1, RunResult result2) {
        super(new RunResult("Comparison of '" + result1.getName() + "' and '" + result2.getName() + "'"));
        this.result1Name = result1.getName();
        this.result2Name = result2.getName();
    }

    public void setProgression(PackageResult pkg, ClassResult cls, TestResult test, CheckResult check2, int nbProgressedChecks) {
        Comparison classComp;
        Comparison pc = this.get(pkg.getName());
        if (pc == null) {
            pc = new PackageComparison(pkg);
            this.add(pc);
        }
        if ((classComp = pc.get(cls.getName())) == null) {
            classComp = new ClassComparison(cls);
            pc.add(classComp);
        }
        classComp.add(new TestComparison(test, check2, nbProgressedChecks));
    }

    @Override
    public void accept(ComparisonVisitor visitor) {
        visitor.visit(this);
        this.acceptChildren(visitor);
    }

    public void addSystemProperty(String name2, String value1, String value2) {
        this.systemProperties.add(name2);
        this.systemProperties.add(value1);
        this.systemProperties.add(value2);
    }

    public List getSystemProperties() {
        return this.systemProperties;
    }

    public String getResult1Name() {
        return this.result1Name;
    }

    public String getResult2Name() {
        return this.result2Name;
    }
}

