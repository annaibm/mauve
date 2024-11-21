/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalLookAndFeel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class getWindowTitleFont
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
        FontUIResource f = MetalLookAndFeel.getWindowTitleFont();
        harness.check(f, new FontUIResource("Dialog", 1, 12));
        MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme(){

            @Override
            public FontUIResource getWindowTitleFont() {
                return new FontUIResource("Dialog", 0, 99);
            }
        });
        f = MetalLookAndFeel.getWindowTitleFont();
        harness.check(f, new FontUIResource("Dialog", 0, 99));
        MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
    }
}

