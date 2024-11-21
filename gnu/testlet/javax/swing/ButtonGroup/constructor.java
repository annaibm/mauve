/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.ButtonGroup;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.ButtonGroup;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ButtonGroup bg = new ButtonGroup();
        harness.check(bg.getButtonCount(), 0);
        harness.check(bg.getSelection(), null);
    }
}

