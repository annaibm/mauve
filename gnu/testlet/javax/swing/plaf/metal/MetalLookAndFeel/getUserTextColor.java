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

public class getUserTextColor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
        ColorUIResource c = MetalLookAndFeel.getUserTextColor();
        harness.check(c, new ColorUIResource(Color.black));
        MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme(){

            @Override
            public ColorUIResource getUserTextColor() {
                return new ColorUIResource(Color.red);
            }
        });
        c = MetalLookAndFeel.getUserTextColor();
        harness.check(c, new ColorUIResource(Color.red));
        MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
    }
}

