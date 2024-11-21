/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.ColorClass;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;

public class getRed
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Color c = new Color(1, 2, 3);
        harness.check(c.getRed(), 1);
        c = new Color(243, 244, 245);
        harness.check(c.getRed(), 243);
        this.thoroughTest(harness);
    }

    private void thoroughTest(TestHarness harness) {
        for (int red = 0; red < 256; red += 8) {
            for (int green = 0; green < 256; green += 8) {
                for (int blue = 0; blue < 256; blue += 8) {
                    Color c = new Color(red, green, blue);
                    harness.check(c.getRed(), red);
                }
            }
        }
    }
}

