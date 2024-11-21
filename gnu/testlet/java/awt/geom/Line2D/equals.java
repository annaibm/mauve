/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Line2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Line2D;

public class equals
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Line2D.Double line1 = new Line2D.Double(1.0, 2.0, 3.0, 4.0);
        Line2D.Double line2 = new Line2D.Double(1.0, 2.0, 3.0, 4.0);
        harness.check(!line1.equals(line2));
    }
}

