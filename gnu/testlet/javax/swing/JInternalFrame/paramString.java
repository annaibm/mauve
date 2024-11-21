/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JInternalFrame;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JInternalFrame.MyJInternalFrame;

public class paramString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyJInternalFrame f = new MyJInternalFrame("F1");
        harness.check(f.paramString().endsWith(",title=F1"));
    }
}

