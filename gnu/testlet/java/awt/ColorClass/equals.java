/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.ColorClass;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;

public class equals
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Color c1 = new Color(1, 2, 3);
        Color c2 = new Color(1, 2, 3);
        harness.check(c1.equals(c2));
        harness.check(c2.equals(c1));
        c1 = new Color(1, 2, 3, 4);
        harness.check(!c1.equals(c2));
        c2 = new Color(1, 2, 3, 4);
        harness.check(c1.equals(c2));
        c1 = new Color(5, 2, 3, 4);
        harness.check(!c1.equals(c2));
        c2 = new Color(5, 2, 3, 4);
        harness.check(c1.equals(c2));
        c1 = new Color(5, 6, 3, 4);
        harness.check(!c1.equals(c2));
        c2 = new Color(5, 6, 3, 4);
        harness.check(c1.equals(c2));
        c1 = new Color(5, 6, 7, 4);
        harness.check(!c1.equals(c2));
        c2 = new Color(5, 6, 7, 4);
        harness.check(c1.equals(c2));
        c1 = new Color(5, 6, 7, 8);
        harness.check(!c1.equals(c2));
        c2 = new Color(5, 6, 7, 8);
        harness.check(c1.equals(c2));
        harness.check(!c1.equals(null));
        harness.check(!c1.equals("XYZ"));
    }
}

