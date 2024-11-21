/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Arc2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Arc2D;

public class setArcType
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Arc2D.Double arc = new Arc2D.Double();
        arc.setArcType(0);
        harness.check(arc.getArcType() == 0);
        arc.setArcType(1);
        harness.check(arc.getArcType() == 1);
        arc.setArcType(2);
        harness.check(arc.getArcType() == 2);
        boolean pass = false;
        try {
            arc.setArcType(99);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

