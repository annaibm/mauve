/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.color.ColorSpace;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.color.ColorSpace;

public class isCS_sRGB
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(ColorSpace.getInstance(1000).isCS_sRGB());
    }
}

