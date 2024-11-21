/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalLookAndFeel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class setCurrentTheme
implements Testlet {
    @Override
    public void test(TestHarness h) {
        DefaultMetalTheme theme = new DefaultMetalTheme();
        MetalLookAndFeel.setCurrentTheme(theme);
        MetalLookAndFeel laf = new MetalLookAndFeel();
        Color c1 = laf.getDefaults().getColor("Button.background");
        h.check(c1, theme.getControl());
        MetalLookAndFeel.setCurrentTheme(new TestTheme());
        c1 = laf.getDefaults().getColor("Button.background");
        h.check(c1, Color.red);
        MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
    }

    class TestTheme
    extends DefaultMetalTheme {
        TestTheme() {
        }

        @Override
        protected ColorUIResource getSecondary3() {
            return new ColorUIResource(Color.red);
        }
    }
}

