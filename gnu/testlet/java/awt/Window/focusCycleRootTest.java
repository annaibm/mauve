/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Window;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Frame;
import java.awt.Window;

public class focusCycleRootTest
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Frame f = new Frame();
        Window w = new Window(f);
        harness.check(w.getFocusCycleRootAncestor() == null);
        harness.check(w.isFocusCycleRoot());
        w.setFocusCycleRoot(false);
        harness.check(w.isFocusCycleRoot());
    }
}

