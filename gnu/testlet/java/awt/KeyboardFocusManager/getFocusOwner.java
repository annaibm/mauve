/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.KeyboardFocusManager;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.awt.KeyboardFocusManager.TestKeyboardFocusManager;
import java.awt.Component;

public class getFocusOwner
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test01(harness);
    }

    private void test01(TestHarness h) {
        Component c1 = new Component(){};
        Component c2 = new Component(){};
        TestKeyboardFocusManager kfm = new TestKeyboardFocusManager();
        kfm.setGlobalFocusOwner(null);
        kfm.setGlobalPermanentFocusOwner(null);
        h.check(kfm.getFocusOwner(), null);
        kfm.setGlobalFocusOwner(c1);
        kfm.setGlobalPermanentFocusOwner(null);
        h.check(kfm.getFocusOwner(), c1);
        kfm.setGlobalFocusOwner(null);
        kfm.setGlobalPermanentFocusOwner(c2);
        h.check(kfm.getFocusOwner(), null);
        kfm.setGlobalFocusOwner(c1);
        kfm.setGlobalPermanentFocusOwner(c2);
        h.check(kfm.getFocusOwner(), c1);
    }
}

