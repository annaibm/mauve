/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComponent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JComponent.MyJLabel;

public class getFont
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyJLabel label = new MyJLabel("Test");
        harness.check(label.getFont(), null);
    }
}

