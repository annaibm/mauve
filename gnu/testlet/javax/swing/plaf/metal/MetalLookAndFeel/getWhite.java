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

public class getWhite
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
        ColorUIResource white = MetalLookAndFeel.getWhite();
        harness.check(white, new ColorUIResource(Color.white));
        MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme(){

            @Override
            public ColorUIResource getWhite() {
                return new ColorUIResource(Color.red);
            }
        });
        white = MetalLookAndFeel.getWhite();
        harness.check(white, new ColorUIResource(Color.red));
        MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
    }
}

