/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.ByteLookupTable;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.ByteLookupTable;

public class lookupPixel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testInt(harness);
        this.testByte(harness);
        this.testFailure(harness);
    }

    private void testInt(TestHarness harness) {
        harness.checkPoint("(int[], int[])");
        byte[] data = new byte[]{105, 104, 103, 102, 101, 100};
        ByteLookupTable t = new ByteLookupTable(100, data);
        int[] src = new int[]{100};
        int[] dst = t.lookupPixel(src, null);
        harness.check(dst[0], 105);
        src = new int[]{101};
        dst = new int[]{0};
        dst = t.lookupPixel(src, dst);
        harness.check(dst[0], 104);
        src = new int[]{100, 101, 102};
        try {
            dst = t.lookupPixel(src, null);
            harness.check(dst[0], 105);
            harness.check(dst[1], 104);
            harness.check(dst[2], 103);
        }
        catch (Exception e) {
            harness.check(false);
            harness.debug(e);
        }
        src = new int[]{102, 103, 104};
        dst = new int[]{0, 0, 0};
        try {
            dst = t.lookupPixel(src, dst);
            harness.check(dst[0], 103);
            harness.check(dst[1], 102);
            harness.check(dst[2], 101);
        }
        catch (Exception e) {
            harness.check(false);
            harness.debug(e);
        }
        byte[][] data2 = new byte[][]{{105, 104, 103, 102, 101, 100}, {115, 114, 113, 112, 111, 110}, {125, 124, 123, 122, 121, 120}};
        ByteLookupTable t2 = new ByteLookupTable(100, data2);
        int[] src2 = new int[]{100, 101, 102};
        dst = t2.lookupPixel(src2, null);
        harness.check(dst[0], 105);
        harness.check(dst[1], 114);
        harness.check(dst[2], 123);
        src2 = new int[]{103, 104, 105};
        dst = new int[]{0, 0, 0};
        dst = t2.lookupPixel(src2, dst);
        harness.check(dst[0], 102);
        harness.check(dst[1], 111);
        harness.check(dst[2], 120);
        byte[][] data3 = new byte[][]{{105, 104, 103, 102, 101, 100}, {115, 114, 113, 112, 111, 110}};
        ByteLookupTable t3 = new ByteLookupTable(100, data3);
        src = new int[]{100};
        dst = t3.lookupPixel(src, null);
        harness.check(dst[0], 105);
        src = new int[]{101};
        dst = new int[]{0};
        dst = t3.lookupPixel(src, dst);
        harness.check(dst[0], 104);
        try {
            dst = t3.lookupPixel(src2, null);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        dst = new int[3];
        try {
            dst = t3.lookupPixel(src2, dst);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
    }

    private void testByte(TestHarness harness) {
        harness.checkPoint("(byte[], byte[])");
        byte[] data = new byte[]{105, 104, 103, 102, 101, 100};
        ByteLookupTable t = new ByteLookupTable(100, data);
        byte[] src = new byte[]{100};
        byte[] dst = t.lookupPixel(src, (byte[])null);
        harness.check(dst[0], 105);
        src = new byte[]{101};
        dst = new byte[]{0};
        dst = t.lookupPixel(src, dst);
        harness.check(dst[0], 104);
        src = new byte[]{100, 101, 102};
        try {
            dst = t.lookupPixel(src, (byte[])null);
            harness.check(dst[0], 105);
            harness.check(dst[1], 104);
            harness.check(dst[2], 103);
        }
        catch (Exception e) {
            harness.check(false);
            harness.debug(e);
        }
        src = new byte[]{102, 103, 104};
        dst = new byte[]{0, 0, 0};
        try {
            dst = t.lookupPixel(src, dst);
            harness.check(dst[0], 103);
            harness.check(dst[1], 102);
            harness.check(dst[2], 101);
        }
        catch (Exception e) {
            harness.check(false);
            harness.debug(e);
        }
        byte[][] data2 = new byte[][]{{105, 104, 103, 102, 101, 100}, {115, 114, 113, 112, 111, 110}, {125, 124, 123, 122, 121, 120}};
        ByteLookupTable t2 = new ByteLookupTable(100, data2);
        byte[] src2 = new byte[]{100, 101, 102};
        dst = t2.lookupPixel(src2, (byte[])null);
        harness.check(dst[0], 105);
        harness.check(dst[1], 114);
        harness.check(dst[2], 123);
        src2 = new byte[]{103, 104, 105};
        dst = new byte[]{0, 0, 0};
        dst = t2.lookupPixel(src2, dst);
        harness.check(dst[0], 102);
        harness.check(dst[1], 111);
        harness.check(dst[2], 120);
        byte[][] data3 = new byte[][]{{105, 104, 103, 102, 101, 100}, {115, 114, 113, 112, 111, 110}};
        ByteLookupTable t3 = new ByteLookupTable(100, data3);
        src = new byte[]{100};
        dst = t3.lookupPixel(src, (byte[])null);
        harness.check(dst[0], 105);
        src = new byte[]{101};
        dst = new byte[1];
        dst = t3.lookupPixel(src, dst);
        harness.check(dst[0], 104);
        try {
            dst = t3.lookupPixel(src2, (byte[])null);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        dst = new byte[3];
        try {
            dst = t3.lookupPixel(src2, dst);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
    }

    private void testFailure(TestHarness harness) {
        Object[] src;
        harness.checkPoint("not in table");
        byte[] data = new byte[]{105, 104, 103, 102, 101, 100};
        ByteLookupTable t = new ByteLookupTable(100, data);
        try {
            src = new int[]{100, 102, 101, 120};
            t.lookupPixel((int[])src, null);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            harness.check(true);
        }
        try {
            src = new byte[]{120};
            t.lookupPixel((byte[])src, (byte[])null);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            harness.check(true);
        }
    }
}

