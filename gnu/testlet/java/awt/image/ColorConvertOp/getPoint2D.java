/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.ColorConvertOp;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.color.ColorSpace;
import java.awt.geom.Point2D;
import java.awt.image.ColorConvertOp;

public class getPoint2D
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("getPoint2D");
        ColorConvertOp op = new ColorConvertOp(ColorSpace.getInstance(1000), null);
        Point2D dest = null;
        dest = op.getPoint2D(new Point2D.Double(3.0, 3.0), dest);
        harness.check(dest, new Point2D.Double(3.0, 3.0));
    }
}

