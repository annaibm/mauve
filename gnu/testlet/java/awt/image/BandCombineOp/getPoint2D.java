/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.BandCombineOp;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Point2D;
import java.awt.image.BandCombineOp;

public class getPoint2D
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("getPoint2D");
        float[][] matrix = new float[][]{{2.0f, 7.0f}};
        BandCombineOp op = new BandCombineOp(matrix, null);
        Point2D dest = null;
        dest = op.getPoint2D(new Point2D.Double(3.0, 3.0), dest);
        harness.check(dest, new Point2D.Double(3.0, 3.0));
    }
}

