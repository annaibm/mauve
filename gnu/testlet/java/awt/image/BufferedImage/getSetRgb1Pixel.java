/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.BufferedImage;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class getSetRgb1Pixel
implements Testlet {
    @Override
    public void test(TestHarness h) {
        this.testType(h, 5, "TYPE_3BYTE_BGR");
        this.testType(h, 6, "TYPE_4BYTE_ABGR");
        this.testType(h, 7, "TYPE_4BYTE_ABGR_PRE");
        this.testType(h, 2, "TYPE_INT_ARGB");
        this.testType(h, 3, "TYPE_INT_ARGB_PRE");
        this.testType(h, 4, "TYPE_INT_BGR");
        this.testType(h, 1, "TYPE_INT_RGB");
    }

    public void testType(TestHarness h, int type, String typeName) {
        int j;
        int i;
        int w = 10;
        BufferedImage b = new BufferedImage(w, w, type);
        Color[][] colors = new Color[w][];
        for (int i2 = 0; i2 < colors.length; ++i2) {
            colors[i2] = new Color[w];
            for (int j2 = 0; j2 < colors[i2].length; ++j2) {
                colors[i2][j2] = new Color((int)(Math.random() * 255.0), (int)(Math.random() * 255.0), (int)(Math.random() * 255.0));
                b.setRGB(i2, j2, colors[i2][j2].getRGB());
            }
        }
        BufferedImage cloned = new BufferedImage(w, w, type);
        b.copyData(cloned.getRaster());
        for (i = 0; i < colors.length; ++i) {
            for (j = 0; j < colors[i].length; ++j) {
                if (!colors[i][j].equals(new Color(b.getRGB(i, j)))) {
                    h.fail("Failed " + typeName + ", " + colors[i][j] + " v " + new Color(b.getRGB(i, j)));
                    return;
                }
                int blue = Color.blue.getRGB();
                b.setRGB(i, j, blue);
                if (b.getRGB(i, j) == blue) continue;
                h.fail("Failed " + typeName + " when resetting into blue " + blue + " v " + b.getRGB(i, j));
                return;
            }
        }
        for (i = 0; i < colors.length; ++i) {
            for (j = 0; j < colors[i].length; ++j) {
                if (colors[i][j].equals(new Color(cloned.getRGB(i, j)))) continue;
                h.fail("Failed " + typeName + " on cloned image");
                return;
            }
        }
    }
}

