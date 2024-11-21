/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.GeneralPath;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class contains
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("GeneralPath 1");
        GeneralPath p = new GeneralPath(1);
        p.moveTo(0.0f, 0.0f);
        p.lineTo(1.0f, 2.0f);
        p.lineTo(2.0f, 0.0f);
        harness.check(p.contains(0.0, 0.0));
        harness.check(!p.contains(0.0, 1.0));
        harness.check(p.contains(1.0, 0.0));
        harness.check(p.contains(1.0, 1.0));
        harness.check(!p.contains(1.0, 2.0));
        harness.check(!p.contains(2.0, 0.0));
        harness.check(!p.contains(2.0, 1.0));
        harness.checkPoint("GeneralPath 2");
        p = new GeneralPath(1);
        p.moveTo(0.0f, 0.0f);
        p.lineTo(0.0f, 5.0f);
        p.lineTo(5.0f, 5.0f);
        p.lineTo(5.0f, 1.0f);
        p.lineTo(2.0f, 1.0f);
        p.lineTo(2.0f, 3.0f);
        p.lineTo(3.0f, 3.0f);
        p.lineTo(3.0f, 2.0f);
        p.lineTo(4.0f, 2.0f);
        p.lineTo(4.0f, 4.0f);
        p.lineTo(1.0f, 4.0f);
        p.lineTo(1.0f, 0.0f);
        harness.check(p.contains(0.0, 0.0));
        harness.check(!p.contains(0.0, 5.0));
        harness.check(!p.contains(5.0, 5.0));
        harness.check(!p.contains(5.0, 1.0));
        harness.check(p.contains(2.0, 1.0));
        harness.check(!p.contains(2.0, 3.0));
        harness.check(!p.contains(3.0, 3.0));
        harness.check(!p.contains(3.0, 2.0));
        harness.check(p.contains(4.0, 2.0));
        harness.check(p.contains(4.0, 4.0));
        harness.check(p.contains(1.0, 4.0));
        harness.check(!p.contains(1.0, 0.0));
        harness.check(!p.contains(-0.5, 2.5));
        harness.check(p.contains(0.5, 2.5));
        harness.check(!p.contains(1.5, 2.5));
        harness.check(p.contains(2.5, 2.5));
        harness.check(!p.contains(3.5, 2.5));
        harness.check(p.contains(4.5, 2.5));
        harness.check(!p.contains(5.5, 2.5));
        harness.checkPoint("Null argument checks");
        this.testNullArguments(harness);
    }

    private void testNullArguments(TestHarness harness) {
        boolean pass = false;
        GeneralPath p = new GeneralPath();
        try {
            p.contains((Point2D)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            p.contains((Point2D)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            p.contains((Rectangle2D)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

