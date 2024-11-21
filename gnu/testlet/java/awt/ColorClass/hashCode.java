/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.ColorClass;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;

public class hashCode
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Color c1 = new Color(1, 2, 3);
        Color c2 = new Color(1, 2, 3);
        harness.check(c1.hashCode() == c2.hashCode());
        harness.check(Color.black.hashCode() == new Color(0, 0, 0).hashCode());
        harness.check(Color.white.hashCode() == new Color(255, 255, 255).hashCode());
        this.thoroughTest(harness);
    }

    private void thoroughTest(TestHarness harness) {
        for (int red = 0; red < 256; red += 8) {
            for (int green = 0; green < 256; green += 8) {
                for (int blue = 0; blue < 256; blue += 8) {
                    Color c1 = new Color(red, green, blue);
                    Color c2 = new Color(red, green, blue);
                    harness.check(c1.hashCode() == c2.hashCode());
                }
            }
        }
    }
}

