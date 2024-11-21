/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.ColorClass;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;

public class brighter
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        for (int i = 0; i <= 3; ++i) {
            for (int j = 0; j <= 255; ++j) {
                for (int k = 0; k <= 255; ++k) {
                    Color c = new Color(i, j, k);
                    Color c2 = c.brighter();
                    int value2 = c.getRGB();
                    int[] colors = new int[]{(value2 & 0xFF0000) >> 16, (value2 & 0xFF00) >> 8, value2 & 0xFF};
                    if (colors[0] == 0 && colors[1] == 0 && colors[2] == 0) {
                        colors[0] = 3;
                        colors[1] = 3;
                        colors[2] = 3;
                    } else {
                        for (int index = 0; index < 3; ++index) {
                            if (colors[index] > 2) {
                                colors[index] = (int)Math.min(255.0f, (float)colors[index] / 0.7f);
                            }
                            if (colors[index] != 1 && colors[index] != 2) continue;
                            colors[index] = 4;
                        }
                    }
                    harness.check(c2.getRed(), colors[0]);
                    harness.check(c2.getBlue(), colors[2]);
                    harness.check(c2.getGreen(), colors[1]);
                }
            }
        }
    }
}

