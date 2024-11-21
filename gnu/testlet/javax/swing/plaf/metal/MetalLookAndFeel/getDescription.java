/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalLookAndFeel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class getDescription
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(new MetalLookAndFeel().getDescription(), (Object)"The Java(tm) Look and Feel");
    }
}

