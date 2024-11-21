/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.UIManager;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.UIManager;

public class getCrossPlatformLookAndFeelClassName
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(UIManager.getCrossPlatformLookAndFeelClassName(), (Object)"javax.swing.plaf.metal.MetalLookAndFeel");
    }
}

