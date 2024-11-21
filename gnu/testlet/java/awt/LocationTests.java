/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt;

import gnu.testlet.TestHarness;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Robot;

public class LocationTests {
    public static void checkColor(TestHarness h, Color a, Color b, boolean match) {
        if (match) {
            h.check(a.getRed() == b.getRed() && a.getGreen() == b.getGreen() && a.getBlue() == b.getBlue());
        } else {
            h.check(a.getRed() != b.getRed() || a.getGreen() != b.getGreen() || a.getBlue() != b.getBlue());
        }
    }

    public static void checkRectangleOuterColors(TestHarness h, Robot r, Rectangle rect, Color comp, boolean match) {
        Color c = r.getPixelColor(rect.x - 1, rect.y);
        LocationTests.checkColor(h, c, comp, match);
        r.getPixelColor(rect.x, rect.y - 1);
        LocationTests.checkColor(h, c, comp, match);
        r.getPixelColor(rect.x + rect.width - 1 + 1, rect.y);
        LocationTests.checkColor(h, c, comp, match);
        r.getPixelColor(rect.x + rect.width - 1, rect.y - 1);
        LocationTests.checkColor(h, c, comp, match);
        r.getPixelColor(rect.x - 1, rect.y + rect.height - 1);
        LocationTests.checkColor(h, c, comp, match);
        r.getPixelColor(rect.x, rect.y + rect.height - 1 + 1);
        LocationTests.checkColor(h, c, comp, match);
        r.getPixelColor(rect.x + rect.width - 1 + 1, rect.y + rect.height - 1);
        LocationTests.checkColor(h, c, comp, match);
        r.getPixelColor(rect.x + rect.width - 1, rect.y + rect.height - 1 + 1);
        LocationTests.checkColor(h, c, comp, match);
    }

    public static void checkRectangleCornerColors(TestHarness h, Robot r, Rectangle rect, Color comp, boolean match) {
        Color c = r.getPixelColor(rect.x, rect.y);
        LocationTests.checkColor(h, c, comp, match);
        c = r.getPixelColor(rect.x + rect.width - 1, rect.y);
        LocationTests.checkColor(h, c, comp, match);
        c = r.getPixelColor(rect.x, rect.y + rect.height - 1);
        LocationTests.checkColor(h, c, comp, match);
        c = r.getPixelColor(rect.x + rect.width - 1, rect.y + rect.height - 1);
        LocationTests.checkColor(h, c, comp, match);
    }
}

