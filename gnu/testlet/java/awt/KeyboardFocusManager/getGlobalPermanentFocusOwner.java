/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.KeyboardFocusManager;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.awt.KeyboardFocusManager.TestKeyboardFocusManager;
import java.awt.Component;
import java.awt.KeyboardFocusManager;

public class getGlobalPermanentFocusOwner
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test01(harness);
    }

    private void test01(TestHarness h) {
        Component c1 = new Component(){};
        Component c2 = new Component(){};
        TestKeyboardFocusManager kfm = new TestKeyboardFocusManager();
        KeyboardFocusManager.setCurrentKeyboardFocusManager(kfm);
        kfm.setGlobalFocusOwner(null);
        kfm.setGlobalPermanentFocusOwner(null);
        h.check(kfm.getGlobalPermanentFocusOwner(), null);
        kfm.setGlobalFocusOwner(c1);
        kfm.setGlobalPermanentFocusOwner(null);
        h.check(kfm.getGlobalPermanentFocusOwner(), null);
        kfm.setGlobalFocusOwner(null);
        kfm.setGlobalPermanentFocusOwner(c2);
        h.check(kfm.getGlobalPermanentFocusOwner(), c2);
        kfm.setGlobalFocusOwner(c1);
        kfm.setGlobalPermanentFocusOwner(c2);
        h.check(kfm.getGlobalPermanentFocusOwner(), c2);
    }
}

