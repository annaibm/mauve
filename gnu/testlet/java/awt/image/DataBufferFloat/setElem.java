/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.DataBufferFloat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.DataBufferFloat;

public class setElem
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testSetElem1(harness);
        this.testSetElem2(harness);
    }

    private void testSetElem1(TestHarness harness) {
        harness.checkPoint("setElem(int, int)");
        float[] source = new float[]{1.0f, 2.0f};
        DataBufferFloat b = new DataBufferFloat(source, 2);
        b.setElem(1, 99);
        harness.check(b.getElem(1) == 99);
        harness.check(source[1] == 99.0f);
        source = new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f};
        b = new DataBufferFloat(source, 4, 1);
        harness.check(b.getElem(1) == 3);
        b.setElem(1, 99);
        harness.check(b.getElem(1) == 99);
        harness.check(source[2] == 99.0f);
        boolean pass = false;
        try {
            b.setElem(-2, 99);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            b.setElem(4, 99);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testSetElem2(TestHarness harness) {
        harness.checkPoint("setElem(int, int, int)");
        float[][] source = new float[][]{{1.0f, 2.0f}, {3.0f, 4.0f}};
        DataBufferFloat b = new DataBufferFloat(source, 2);
        b.setElem(1, 1, 99);
        harness.check(b.getElem(1, 1) == 99);
        harness.check(source[1][1] == 99.0f);
        boolean pass = false;
        try {
            b.setElem(-1, 1, 99);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            b.setElem(2, 1, 99);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

