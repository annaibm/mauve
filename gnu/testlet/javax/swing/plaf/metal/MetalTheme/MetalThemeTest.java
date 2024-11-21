/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalTheme;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.metal.MetalTheme;

public class MetalThemeTest
extends MetalTheme
implements Testlet {
    ColorUIResource primary1 = new ColorUIResource(1, 0, 0);
    ColorUIResource primary2 = new ColorUIResource(2, 0, 0);
    ColorUIResource primary3 = new ColorUIResource(3, 0, 0);
    ColorUIResource secondary1 = new ColorUIResource(4, 0, 0);
    ColorUIResource secondary2 = new ColorUIResource(5, 0, 0);
    ColorUIResource secondary3 = new ColorUIResource(6, 0, 0);

    private void check(TestHarness h, ColorUIResource color, int index) {
        h.check(color.getRed(), index, "wrong color returned");
    }

    @Override
    public void test(TestHarness h) {
        this.check(h, this.getAcceleratorForeground(), 1);
        this.check(h, this.getAcceleratorSelectedForeground(), 0);
        this.check(h, this.getBlack(), 0);
        this.check(h, this.getControl(), 6);
        this.check(h, this.getControlDarkShadow(), 4);
        this.check(h, this.getControlDisabled(), 5);
        this.check(h, this.getControlHighlight(), 255);
        this.check(h, this.getControlInfo(), 0);
        this.check(h, this.getControlShadow(), 5);
        this.check(h, this.getControlTextColor(), 0);
        this.check(h, this.getDesktopColor(), 2);
        this.check(h, this.getFocusColor(), 2);
        this.check(h, this.getHighlightedTextColor(), 0);
        this.check(h, this.getInactiveControlTextColor(), 5);
        this.check(h, this.getInactiveSystemTextColor(), 5);
        this.check(h, this.getMenuBackground(), 6);
        this.check(h, this.getMenuDisabledForeground(), 5);
        this.check(h, this.getMenuForeground(), 0);
        this.check(h, this.getMenuSelectedBackground(), 2);
        this.check(h, this.getMenuSelectedForeground(), 0);
        this.check(h, this.getPrimaryControl(), 3);
        this.check(h, this.getPrimaryControlDarkShadow(), 1);
        this.check(h, this.getPrimaryControlHighlight(), 255);
        this.check(h, this.getPrimaryControlInfo(), 0);
        this.check(h, this.getPrimaryControlShadow(), 2);
        this.check(h, this.getSeparatorBackground(), 255);
        this.check(h, this.getSeparatorForeground(), 1);
        this.check(h, this.getSystemTextColor(), 0);
        this.check(h, this.getTextHighlightColor(), 3);
        this.check(h, this.getUserTextColor(), 0);
        this.check(h, this.getWhite(), 255);
        this.check(h, this.getWindowBackground(), 255);
        this.check(h, this.getWindowTitleBackground(), 3);
        this.check(h, this.getWindowTitleForeground(), 0);
        this.check(h, this.getWindowTitleInactiveBackground(), 6);
        this.check(h, this.getWindowTitleInactiveForeground(), 0);
    }

    @Override
    public ColorUIResource getPrimary1() {
        return this.primary1;
    }

    @Override
    public ColorUIResource getPrimary2() {
        return this.primary2;
    }

    @Override
    public ColorUIResource getPrimary3() {
        return this.primary3;
    }

    @Override
    public ColorUIResource getSecondary1() {
        return this.secondary1;
    }

    @Override
    public ColorUIResource getSecondary2() {
        return this.secondary2;
    }

    @Override
    public ColorUIResource getSecondary3() {
        return this.secondary3;
    }

    @Override
    public String getName() {
        return "mauve testcase";
    }

    @Override
    public FontUIResource getControlTextFont() {
        return null;
    }

    @Override
    public FontUIResource getMenuTextFont() {
        return null;
    }

    @Override
    public FontUIResource getSubTextFont() {
        return null;
    }

    @Override
    public FontUIResource getSystemTextFont() {
        return null;
    }

    @Override
    public FontUIResource getUserTextFont() {
        return null;
    }

    @Override
    public FontUIResource getWindowTitleFont() {
        return null;
    }
}

