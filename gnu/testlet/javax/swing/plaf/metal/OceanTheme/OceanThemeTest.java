/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.OceanTheme;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.OceanTheme;

public class OceanThemeTest
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TestOceanTheme theme = new TestOceanTheme();
        harness.check(theme.getBlack(), new Color(51, 51, 51));
        harness.check(theme.getControlTextColor(), new Color(51, 51, 51));
        harness.check(theme.getDesktopColor(), Color.WHITE);
        harness.check(theme.getInactiveControlTextColor(), new Color(153, 153, 153));
        harness.check(theme.getMenuDisabledForeground(), new Color(153, 153, 153));
        harness.check(theme.getName(), (Object)"Ocean");
        harness.check(theme.getPrimary1(), new Color(99, 130, 191));
        harness.check(theme.getPrimary2(), new Color(163, 184, 204));
        harness.check(theme.getPrimary3(), new Color(184, 207, 229));
        harness.check(theme.getSecondary1(), new Color(122, 138, 153));
        harness.check(theme.getSecondary2(), new Color(184, 207, 229));
        harness.check(theme.getSecondary3(), new Color(238, 238, 238));
    }

    class TestOceanTheme
    extends OceanTheme {
        TestOceanTheme() {
        }

        @Override
        public ColorUIResource getPrimary1() {
            return super.getPrimary1();
        }

        @Override
        public ColorUIResource getPrimary2() {
            return super.getPrimary2();
        }

        @Override
        public ColorUIResource getPrimary3() {
            return super.getPrimary3();
        }

        @Override
        public ColorUIResource getSecondary1() {
            return super.getSecondary1();
        }

        @Override
        public ColorUIResource getSecondary2() {
            return super.getSecondary2();
        }

        @Override
        public ColorUIResource getSecondary3() {
            return super.getSecondary3();
        }

        @Override
        public ColorUIResource getBlack() {
            return super.getBlack();
        }
    }
}

