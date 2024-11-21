/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.BasicStroke;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.BasicStroke;

public class equals
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        BasicStroke s1 = new BasicStroke();
        BasicStroke s2 = new BasicStroke();
        harness.check(s1.equals(s2));
        s1 = new BasicStroke(2.0f);
        harness.check(!s1.equals(s2));
        s2 = new BasicStroke(2.0f);
        harness.check(s1.equals(s2));
        s1 = new BasicStroke(3.0f, 0, 0);
        harness.check(!s1.equals(s2));
        s2 = new BasicStroke(3.0f, 0, 0);
        harness.check(s1.equals(s2));
        s1 = new BasicStroke(3.0f, 0, 1);
        harness.check(!s1.equals(s2));
        s2 = new BasicStroke(3.0f, 0, 1);
        harness.check(s1.equals(s2));
        s1 = new BasicStroke(3.0f, 0, 1, 15.0f);
        harness.check(!s1.equals(s2));
        s2 = new BasicStroke(3.0f, 0, 1, 15.0f);
        harness.check(s1.equals(s2));
        s1 = new BasicStroke(3.0f, 0, 1, 15.0f, new float[]{1.0f, 2.0f}, 0.0f);
        harness.check(!s1.equals(s2));
        s2 = new BasicStroke(3.0f, 0, 1, 15.0f, new float[]{1.0f, 2.0f}, 0.0f);
        harness.check(s1.equals(s2));
        s1 = new BasicStroke(3.0f, 0, 1, 15.0f, new float[]{1.0f, 2.0f}, 1.0f);
        harness.check(!s1.equals(s2));
        s2 = new BasicStroke(3.0f, 0, 1, 15.0f, new float[]{1.0f, 2.0f}, 1.0f);
        harness.check(s1.equals(s2));
    }
}

