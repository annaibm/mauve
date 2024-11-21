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

public class getAcceleratorForeground
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultMetalTheme theme = new DefaultMetalTheme();
        MetalLookAndFeel.setCurrentTheme(theme);
        ColorUIResource c = MetalLookAndFeel.getAcceleratorForeground();
        harness.check(c, theme.getAcceleratorForeground());
        MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme(){

            @Override
            public ColorUIResource getAcceleratorForeground() {
                return new ColorUIResource(Color.red);
            }
        });
        c = MetalLookAndFeel.getAcceleratorForeground();
        harness.check(c, new ColorUIResource(Color.red));
        MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
    }
}

