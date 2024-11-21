/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.DataBufferFloat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferFloat;

public class getElem
implements Testlet {
    @Override
    public void test(TestHarness h) {
        float[] data = new float[]{1.1f, -2.2f, 3.3f, -4.4f};
        DataBufferFloat buf = new DataBufferFloat(new float[][]{data, data}, 2, new int[]{2, 0});
        h.check(((DataBuffer)buf).getElem(0), 3);
        h.check(((DataBuffer)buf).getElem(1), -4);
        h.check(((DataBuffer)buf).getElem(0, 0), 3);
        h.check(((DataBuffer)buf).getElem(0, 1), -4);
        h.check(((DataBuffer)buf).getElem(1, 0), 1);
        h.check(((DataBuffer)buf).getElem(1, 1), -2);
        this.testGetElem1(h);
        this.testGetElem2(h);
    }

    private void testGetElem1(TestHarness harness) {
        harness.checkPoint("getElem(int)");
        float[] source = new float[]{1.0f, 2.0f, 3.0f};
        DataBufferFloat b = new DataBufferFloat(source, 2);
        harness.check(b.getElem(0) == 1);
        harness.check(b.getElem(1) == 2);
        harness.check(b.getElem(2) == 3);
        boolean pass = false;
        try {
            b.getElem(-1);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            b.getElem(3);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        source = new float[]{1.0f, 2.0f, 3.0f, 4.0f};
        b = new DataBufferFloat(source, 2, 1);
        harness.check(b.getElem(-1) == 1);
        harness.check(b.getElem(0) == 2);
        harness.check(b.getElem(1) == 3);
        harness.check(b.getElem(2) == 4);
        pass = false;
        try {
            b.getElem(3);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            b.getElem(-2);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testGetElem2(TestHarness harness) {
        harness.checkPoint("getElem(int, int)");
        float[][] source = new float[][]{{1.0f, 2.0f}, {3.0f, 4.0f}};
        DataBufferFloat b = new DataBufferFloat(source, 2);
        harness.check(b.getElem(1, 0) == 3);
        harness.check(b.getElem(1, 1) == 4);
        source = new float[][]{{1.0f, 2.0f, 3.0f}, {4.0f, 5.0f, 6.0f}};
        b = new DataBufferFloat(source, 2);
        harness.check(b.getElem(1, 2) == 6);
        source = new float[][]{{1.0f, 2.0f, 3.0f, 4.0f}, {5.0f, 6.0f, 7.0f, 8.0f}};
        b = new DataBufferFloat(source, 2, new int[]{1, 2});
        harness.check(b.getElem(1, -2) == 5);
        harness.check(b.getElem(1, -1) == 6);
        harness.check(b.getElem(1, 0) == 7);
        harness.check(b.getElem(1, 1) == 8);
        source[1][2] = 99.0f;
        harness.check(source[1][2] == 99.0f);
        harness.check(b.getElem(1, 0) == 99);
        boolean pass = true;
        try {
            b.getElem(-1, 0);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            b.getElem(2, 0);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = true;
        try {
            b.getElem(0, -2);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            b.getElem(1, 5);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        DataBufferFloat b2 = new DataBufferFloat(new float[]{1.0f, 2.0f, 3.0f}, 3);
        harness.check(b2.getElem(0, 1) == 2);
    }
}

