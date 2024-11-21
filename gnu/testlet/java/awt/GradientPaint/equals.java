/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.GradientPaint;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import java.awt.GradientPaint;

public class equals
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        GradientPaint gp1 = new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue);
        GradientPaint gp2 = new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue);
        harness.check(!gp1.equals(gp2));
    }
}

