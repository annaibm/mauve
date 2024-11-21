/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.SimpleAttributeSet;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.SimpleAttributeSet;

public class EMPTY
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("EMPTY");
        harness.check(SimpleAttributeSet.EMPTY.getAttributeCount(), 0);
        harness.check(SimpleAttributeSet.EMPTY.getResolveParent(), null);
        harness.check(SimpleAttributeSet.EMPTY instanceof SimpleAttributeSet, false);
    }
}

