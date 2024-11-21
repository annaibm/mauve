/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.RescaleOp;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.RescaleOp;

public class getNumFactors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("getNumFactors");
        RescaleOp op = new RescaleOp(1.5f, 2.3f, null);
        harness.check(op.getNumFactors(), 1);
        op = new RescaleOp(new float[]{1.5f}, new float[]{2.3f}, null);
        harness.check(op.getNumFactors(), 1);
        op = new RescaleOp(new float[]{1.5f, 2.5f}, new float[]{2.3f, 6.6f}, null);
        harness.check(op.getNumFactors(), 2);
        op = new RescaleOp(new float[]{1.5f, 2.2f, 3.7f}, new float[]{2.3f, 2.3f, 2.3f}, null);
        harness.check(op.getNumFactors(), 3);
        op = new RescaleOp(new float[0], new float[0], null);
        harness.check(op.getNumFactors(), 0);
        op = new RescaleOp(new float[]{1.0f, 2.0f, 3.0f}, new float[]{1.0f}, null);
        harness.check(op.getNumFactors(), 1);
        op = new RescaleOp(new float[]{1.0f}, new float[]{1.0f, 2.0f, 3.0f}, null);
        harness.check(op.getNumFactors(), 1);
        op = new RescaleOp(new float[]{1.0f, 2.0f}, new float[]{1.0f, 2.0f, 3.0f}, null);
        harness.check(op.getNumFactors(), 2);
        op = new RescaleOp(new float[]{1.0f, 2.0f, 3.0f}, new float[]{1.0f, 2.0f}, null);
        harness.check(op.getNumFactors(), 2);
    }
}

