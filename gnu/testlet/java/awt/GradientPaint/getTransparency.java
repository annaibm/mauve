/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.GradientPaint;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import java.awt.GradientPaint;

public class getTransparency
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        GradientPaint gp = new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue);
        harness.check(gp.getTransparency(), 1);
        gp = new GradientPaint(1.0f, 2.0f, new Color(1, 2, 3, 4), 3.0f, 4.0f, Color.blue);
        harness.check(gp.getTransparency(), 3);
        gp = new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, new Color(1, 2, 3, 4));
        harness.check(gp.getTransparency(), 3);
    }
}

