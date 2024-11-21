/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.accessibility.AccessibleContext;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.accessibility.AccessibleContext.TestAccessibleContext;

public class getAccessibleRelationSet
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TestAccessibleContext ctx = new TestAccessibleContext();
        harness.check(ctx.getAccessibleRelationSet() != null);
        harness.check(ctx.getAccessibleRelationSet().size(), 0);
    }
}

