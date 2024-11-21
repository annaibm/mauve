/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.ColorClass;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;

public class constants
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("lowercase color names");
        harness.check(Color.black.equals(new Color(0, 0, 0)));
        harness.check(Color.blue.equals(new Color(0, 0, 255)));
        harness.check(Color.cyan.equals(new Color(0, 255, 255)));
        harness.check(Color.darkGray.equals(new Color(64, 64, 64)));
        harness.check(Color.gray.equals(new Color(128, 128, 128)));
        harness.check(Color.green.equals(new Color(0, 255, 0)));
        harness.check(Color.lightGray.equals(new Color(192, 192, 192)));
        harness.check(Color.magenta.equals(new Color(255, 0, 255)));
        harness.check(Color.orange.equals(new Color(255, 200, 0)));
        harness.check(Color.pink.equals(new Color(255, 175, 175)));
        harness.check(Color.red.equals(new Color(255, 0, 0)));
        harness.check(Color.white.equals(new Color(255, 255, 255)));
        harness.check(Color.yellow.equals(new Color(255, 255, 0)));
        harness.checkPoint("uppercase color names");
        harness.check(Color.BLACK.equals(new Color(0, 0, 0)));
        harness.check(Color.BLUE.equals(new Color(0, 0, 255)));
        harness.check(Color.CYAN.equals(new Color(0, 255, 255)));
        harness.check(Color.DARK_GRAY.equals(new Color(64, 64, 64)));
        harness.check(Color.GRAY.equals(new Color(128, 128, 128)));
        harness.check(Color.GREEN.equals(new Color(0, 255, 0)));
        harness.check(Color.LIGHT_GRAY.equals(new Color(192, 192, 192)));
        harness.check(Color.MAGENTA.equals(new Color(255, 0, 255)));
        harness.check(Color.ORANGE.equals(new Color(255, 200, 0)));
        harness.check(Color.PINK.equals(new Color(255, 175, 175)));
        harness.check(Color.RED.equals(new Color(255, 0, 0)));
        harness.check(Color.WHITE.equals(new Color(255, 255, 255)));
        harness.check(Color.YELLOW.equals(new Color(255, 255, 0)));
    }
}

