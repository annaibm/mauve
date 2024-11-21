/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.IndexColorModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import java.awt.image.IndexColorModel;
import java.math.BigInteger;

public class constructors
implements Testlet {
    private static final byte[] R4 = new byte[]{1, 2, 3, 4};
    private static final byte[] G4 = new byte[]{5, 6, 7, 8};
    private static final byte[] B4 = new byte[]{9, 10, 11, 12};
    private static final byte[] A4 = new byte[]{13, 14, 15, 16};
    private static final byte[] CMAP = new byte[]{1, 5, 9, 2, 6, 10, 3, 7, 11, 4, 8, 12};
    private static final int[] CMAP_INT = new int[]{new Color(1, 5, 9).getRGB(), new Color(2, 6, 10).getRGB(), new Color(3, 7, 11).getRGB(), new Color(4, 8, 12).getRGB()};
    private static final byte[] CMAP_WITH_ALPHA = new byte[]{1, 5, 9, 13, 2, 6, 10, 14, 3, 7, 11, 15, 4, 8, 12, 16};
    private static final int[] CMAP_INT_WITH_ALPHA = new int[]{new Color(1, 5, 9, 13).getRGB(), new Color(2, 6, 10, 14).getRGB(), new Color(3, 7, 11, 15).getRGB(), new Color(4, 8, 12, 16).getRGB()};

    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
        this.testConstructor3(harness);
        this.testConstructor4(harness);
        this.testConstructor5(harness);
        this.testConstructor6(harness);
        this.testConstructor7(harness);
    }

    private void testConstructor1(TestHarness harness) {
        harness.checkPoint("IndexColorModel(int, int, byte[], byte[], byte[])");
        IndexColorModel m1 = new IndexColorModel(2, 4, R4, G4, B4);
        harness.check(m1.getTransparency(), 1);
        harness.check(m1.getMapSize(), 4);
        harness.check(m1.getPixelSize(), 2);
        harness.check(m1.getTransparentPixel(), -1);
        harness.check(!m1.hasAlpha());
        harness.check(!m1.isAlphaPremultiplied());
        harness.check(m1.getNumComponents(), 3);
        harness.check(m1.getNumColorComponents(), 3);
        boolean pass = false;
        try {
            new IndexColorModel(0, 4, R4, G4, B4);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            new IndexColorModel(17, 4, R4, G4, B4);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            new IndexColorModel(2, 99, R4, G4, B4);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            new IndexColorModel(2, 4, null, G4, B4);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            new IndexColorModel(2, 4, R4, null, B4);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            new IndexColorModel(2, 4, R4, G4, null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testConstructor2(TestHarness harness) {
        harness.checkPoint("IndexColorModel(int, int, byte[], byte[], byte[], byte[])");
        IndexColorModel m1 = new IndexColorModel(2, 4, R4, G4, B4, A4);
        harness.check(m1.getTransparency(), 3);
        harness.check(m1.getMapSize(), 4);
        harness.check(m1.getPixelSize(), 2);
        harness.check(m1.hasAlpha());
        harness.check(!m1.isAlphaPremultiplied());
        boolean pass = false;
        try {
            new IndexColorModel(0, 4, R4, G4, B4, A4);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            new IndexColorModel(17, 4, R4, G4, B4, A4);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            new IndexColorModel(2, 99, R4, G4, B4, A4);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            new IndexColorModel(2, 4, null, G4, B4, A4);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            new IndexColorModel(2, 4, R4, null, B4, A4);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            new IndexColorModel(2, 4, R4, G4, null, A4);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        IndexColorModel m = new IndexColorModel(2, 4, R4, G4, B4, null);
        harness.check(m.getTransparency(), 1);
    }

    private void testConstructor3(TestHarness harness) {
        harness.checkPoint("IndexColorModel(int, int, byte[], byte[], byte[], int)");
        IndexColorModel m1 = new IndexColorModel(2, 4, R4, G4, B4, 2);
        harness.check(m1.getTransparency(), 2);
        harness.check(m1.getMapSize(), 4);
        harness.check(m1.getPixelSize(), 2);
        harness.check(m1.getTransparentPixel(), 2);
        harness.check(m1.hasAlpha());
        harness.check(!m1.isAlphaPremultiplied());
        boolean pass = false;
        try {
            new IndexColorModel(0, 4, R4, G4, B4, 2);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            new IndexColorModel(17, 4, R4, G4, B4, 2);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            new IndexColorModel(2, 99, R4, G4, B4, 2);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            new IndexColorModel(2, 4, null, G4, B4, 2);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            new IndexColorModel(2, 4, R4, null, B4, 2);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            new IndexColorModel(2, 4, R4, G4, null, 2);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        IndexColorModel m = new IndexColorModel(2, 4, R4, G4, B4, -1);
        harness.check(m.getTransparentPixel(), -1);
        harness.check(m.getTransparency(), 1);
        m = new IndexColorModel(2, 4, R4, G4, B4, -99);
        harness.check(m.getTransparentPixel(), -1);
        harness.check(m.getTransparency(), 1);
        m = new IndexColorModel(2, 4, R4, G4, B4, 4);
        harness.check(m.getTransparentPixel(), -1);
    }

    private void testConstructor4(TestHarness harness) {
        harness.checkPoint("IndexColorModel(int, int, byte[], int, boolean)");
        IndexColorModel m1 = new IndexColorModel(2, 4, CMAP, 0, false);
        harness.check(!m1.isAlphaPremultiplied());
        harness.check(m1.getRed(0), 1);
        harness.check(m1.getRed(1), 2);
        harness.check(m1.getRed(2), 3);
        harness.check(m1.getRed(3), 4);
        harness.check(m1.getGreen(0), 5);
        harness.check(m1.getGreen(1), 6);
        harness.check(m1.getGreen(2), 7);
        harness.check(m1.getGreen(3), 8);
        harness.check(m1.getBlue(0), 9);
        harness.check(m1.getBlue(1), 10);
        harness.check(m1.getBlue(2), 11);
        harness.check(m1.getBlue(3), 12);
        harness.check(m1.getAlpha(0), 255);
        harness.check(m1.getAlpha(1), 255);
        harness.check(m1.getAlpha(2), 255);
        harness.check(m1.getAlpha(3), 255);
        harness.check(!m1.hasAlpha());
        IndexColorModel m2 = new IndexColorModel(2, 4, CMAP_WITH_ALPHA, 0, true);
        harness.check(m2.getRed(0), 1);
        harness.check(m2.getRed(1), 2);
        harness.check(m2.getRed(2), 3);
        harness.check(m2.getRed(3), 4);
        harness.check(m2.getGreen(0), 5);
        harness.check(m2.getGreen(1), 6);
        harness.check(m2.getGreen(2), 7);
        harness.check(m2.getGreen(3), 8);
        harness.check(m2.getBlue(0), 9);
        harness.check(m2.getBlue(1), 10);
        harness.check(m2.getBlue(2), 11);
        harness.check(m2.getBlue(3), 12);
        harness.check(m2.getAlpha(0), 13);
        harness.check(m2.getAlpha(1), 14);
        harness.check(m2.getAlpha(2), 15);
        harness.check(m2.getAlpha(3), 16);
        harness.check(m2.hasAlpha());
        boolean pass = false;
        try {
            new IndexColorModel(0, 4, CMAP, 0, false);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            new IndexColorModel(17, 4, CMAP, 0, false);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            new IndexColorModel(2, 99, CMAP, 0, false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            new IndexColorModel(2, 4, null, 0, false);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testConstructor5(TestHarness harness) {
        harness.checkPoint("IndexColorModel(int, int, byte[], int, boolean, int)");
        IndexColorModel m1 = new IndexColorModel(2, 4, CMAP, 0, false, 1);
        harness.check(m1.getTransparentPixel(), 1);
        harness.check(!m1.isAlphaPremultiplied());
        harness.check(m1.getRed(0), 1);
        harness.check(m1.getRed(1), 2);
        harness.check(m1.getRed(2), 3);
        harness.check(m1.getRed(3), 4);
        harness.check(m1.getGreen(0), 5);
        harness.check(m1.getGreen(1), 6);
        harness.check(m1.getGreen(2), 7);
        harness.check(m1.getGreen(3), 8);
        harness.check(m1.getBlue(0), 9);
        harness.check(m1.getBlue(1), 10);
        harness.check(m1.getBlue(2), 11);
        harness.check(m1.getBlue(3), 12);
        harness.check(m1.getAlpha(0), 255);
        harness.check(m1.getAlpha(1), 0);
        harness.check(m1.getAlpha(2), 255);
        harness.check(m1.getAlpha(3), 255);
        IndexColorModel m2 = new IndexColorModel(2, 4, CMAP_WITH_ALPHA, 0, true, 2);
        harness.check(m2.getRed(0), 1);
        harness.check(m2.getRed(1), 2);
        harness.check(m2.getRed(2), 3);
        harness.check(m2.getRed(3), 4);
        harness.check(m2.getGreen(0), 5);
        harness.check(m2.getGreen(1), 6);
        harness.check(m2.getGreen(2), 7);
        harness.check(m2.getGreen(3), 8);
        harness.check(m2.getBlue(0), 9);
        harness.check(m2.getBlue(1), 10);
        harness.check(m2.getBlue(2), 11);
        harness.check(m2.getBlue(3), 12);
        harness.check(m2.getAlpha(0), 13);
        harness.check(m2.getAlpha(1), 14);
        harness.check(m2.getAlpha(2), 0);
        harness.check(m2.getAlpha(3), 16);
        boolean pass = false;
        try {
            new IndexColorModel(0, 4, CMAP, 0, false, 3);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            new IndexColorModel(17, 4, CMAP, 0, false, 3);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            new IndexColorModel(2, 99, CMAP, 0, false, 3);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            new IndexColorModel(2, 4, null, 0, false, 3);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testConstructor6(TestHarness harness) {
        harness.checkPoint("IndexColorModel(int, int, int[], int, boolean, int, int)");
        IndexColorModel m1 = new IndexColorModel(2, 4, CMAP_INT, 0, false, 1, 0);
        harness.check(m1.getTransferType(), 0);
        harness.check(m1.getTransparentPixel(), 1);
        harness.check(!m1.isAlphaPremultiplied());
        harness.check(m1.getRed(0), 1);
        harness.check(m1.getRed(1), 2);
        harness.check(m1.getRed(2), 3);
        harness.check(m1.getRed(3), 4);
        harness.check(m1.getGreen(0), 5);
        harness.check(m1.getGreen(1), 6);
        harness.check(m1.getGreen(2), 7);
        harness.check(m1.getGreen(3), 8);
        harness.check(m1.getBlue(0), 9);
        harness.check(m1.getBlue(1), 10);
        harness.check(m1.getBlue(2), 11);
        harness.check(m1.getBlue(3), 12);
        harness.check(m1.getAlpha(0), 255);
        harness.check(m1.getAlpha(1), 0);
        harness.check(m1.getAlpha(2), 255);
        harness.check(m1.getAlpha(3), 255);
        IndexColorModel m2 = new IndexColorModel(2, 4, CMAP_INT_WITH_ALPHA, 0, true, 1, 0);
        harness.check(m2.getTransferType(), 0);
        harness.check(m2.getRed(0), 1);
        harness.check(m2.getRed(1), 2);
        harness.check(m2.getRed(2), 3);
        harness.check(m2.getRed(3), 4);
        harness.check(m2.getGreen(0), 5);
        harness.check(m2.getGreen(1), 6);
        harness.check(m2.getGreen(2), 7);
        harness.check(m2.getGreen(3), 8);
        harness.check(m2.getBlue(0), 9);
        harness.check(m2.getBlue(1), 10);
        harness.check(m2.getBlue(2), 11);
        harness.check(m2.getBlue(3), 12);
        harness.check(m2.getAlpha(0), 13);
        harness.check(m2.getAlpha(1), 0);
        harness.check(m2.getAlpha(2), 15);
        harness.check(m2.getAlpha(3), 16);
    }

    private void testConstructor7(TestHarness harness) {
        harness.checkPoint("IndexColorModel(int, int, int[], int, int, BigInteger)");
        IndexColorModel m1 = new IndexColorModel(2, 4, CMAP_INT, 0, 0, new BigInteger("11"));
        harness.check(!m1.isAlphaPremultiplied());
        harness.check(m1.isValid(0));
        harness.check(m1.isValid(1));
        harness.check(!m1.isValid(2));
        harness.check(m1.isValid(3));
    }
}

