/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.SimpleAttributeSet;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.SimpleAttributeSet;

public class equals
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("equals()");
        SimpleAttributeSet s = new SimpleAttributeSet();
        harness.check(s.equals(SimpleAttributeSet.EMPTY), true);
        harness.check(SimpleAttributeSet.EMPTY.equals(s), true);
        harness.check(s.equals(null), false);
        harness.check(s.equals("XYZ"), false);
    }
}

