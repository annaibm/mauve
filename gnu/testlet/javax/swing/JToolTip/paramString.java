/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JToolTip;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JToolTip.MyJToolTip;

public class paramString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyJToolTip tt = new MyJToolTip();
        harness.check(tt.paramString() != null);
    }
}

