/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalCheckBoxUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.plaf.metal.MetalCheckBoxUI;

public class getPropertyPrefix
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MetalCheckBoxUI ui = new MetalCheckBoxUI();
        harness.check(ui.getPropertyPrefix(), (Object)"CheckBox.");
    }
}

