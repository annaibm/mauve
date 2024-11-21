/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.DataBufferInt;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;

public class getElem
implements Testlet {
    @Override
    public void test(TestHarness h) {
        int[] data = new int[]{-11, -22, -33, -44};
        DataBufferInt buf = new DataBufferInt(new int[][]{data, data}, 2, new int[]{2, 0});
        h.check(((DataBuffer)buf).getElem(0), -33);
        h.check(((DataBuffer)buf).getElem(1), -44);
        h.check(((DataBuffer)buf).getElem(0, 0), -33);
        h.check(((DataBuffer)buf).getElem(0, 1), -44);
        h.check(((DataBuffer)buf).getElem(1, 0), -11);
        h.check(((DataBuffer)buf).getElem(1, 1), -22);
        this.testGetElem1(h);
        this.testGetElem2(h);
    }

    private void testGetElem1(TestHarness harness) {
        harness.checkPoint("getElem(int)");
        int[] source = new int[]{1, 2, 3};
        DataBufferInt b = new DataBufferInt(source, 2);
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
        source = new int[]{1, 2, 3, 4};
        b = new DataBufferInt(source, 2, 1);
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
        int[][] source = new int[][]{{1, 2}, {3, 4}};
        DataBufferInt b = new DataBufferInt(source, 2);
        harness.check(b.getElem(1, 0) == 3);
        harness.check(b.getElem(1, 1) == 4);
        source = new int[][]{{1, 2, 3}, {4, 5, 6}};
        b = new DataBufferInt(source, 2);
        harness.check(b.getElem(1, 2) == 6);
        source = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}};
        b = new DataBufferInt(source, 2, new int[]{1, 2});
        harness.check(b.getElem(1, -2) == 5);
        harness.check(b.getElem(1, -1) == 6);
        harness.check(b.getElem(1, 0) == 7);
        harness.check(b.getElem(1, 1) == 8);
        source[1][2] = 99;
        harness.check(source[1][2] == 99);
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
        DataBufferInt b2 = new DataBufferInt(new int[]{1, 2, 3}, 3);
        harness.check(b2.getElem(0, 1) == 2);
    }
}

