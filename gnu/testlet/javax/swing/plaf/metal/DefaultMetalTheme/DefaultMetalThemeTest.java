/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.DefaultMetalTheme;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;

public class DefaultMetalThemeTest
extends DefaultMetalTheme
implements Testlet {
    private void check(TestHarness h, ColorUIResource color, int r, int g, int b) {
        h.check(color.getRed(), r, "red color component");
        h.check(color.getGreen(), g, "green color component");
        h.check(color.getBlue(), b, "blue color component");
    }

    @Override
    public void test(TestHarness h) {
        h.check(this.getName(), "Steel", "name of theme");
        this.check(h, this.getPrimary1(), 102, 102, 153);
        this.check(h, this.getPrimary2(), 153, 153, 204);
        this.check(h, this.getPrimary3(), 204, 204, 255);
        this.check(h, this.getSecondary1(), 102, 102, 102);
        this.check(h, this.getSecondary2(), 153, 153, 153);
        this.check(h, this.getSecondary3(), 204, 204, 204);
    }
}

