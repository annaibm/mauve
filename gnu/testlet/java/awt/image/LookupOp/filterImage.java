/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.LookupOp;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.BufferedImage;
import java.awt.image.ByteLookupTable;
import java.awt.image.LookupOp;
import java.awt.image.ShortLookupTable;
import java.awt.image.WritableRaster;

public class filterImage
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testDefaults(harness);
        this.testOneLookup(harness, false);
        this.testOneLookup(harness, true);
        this.testColourLookup(harness, false);
        this.testColourLookup(harness, true);
        this.testAllLookup(harness, false);
        this.testAllLookup(harness, true);
        this.testUndefined(harness);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void testDefaults(TestHarness harness) {
        harness.checkPoint("testDefaults");
        BufferedImage img = new BufferedImage(20, 20, 11);
        byte[] bytes = new byte[]{-86, -69};
        ByteLookupTable t = new ByteLookupTable(0, bytes);
        LookupOp op = new LookupOp(t, null);
        BufferedImage dst = op.filter(img, null);
        harness.check(dst.getType(), op.createCompatibleDestImage(img, null).getType());
        dst = new BufferedImage(20, 20, 11);
        try {
            dst = op.filter(img, dst);
            harness.check(true);
        }
        catch (IllegalArgumentException ex) {
            harness.check(false);
        }
        try {
            op.filter(img, img);
            harness.check(true);
        }
        catch (IllegalArgumentException e) {
            harness.check(false);
        }
        finally {
            img = new BufferedImage(20, 20, 11);
        }
        dst = new BufferedImage(30, 40, 11);
        try {
            op.filter(img, dst);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        dst = new BufferedImage(20, 20, 10);
        try {
            op.filter(img, dst);
            harness.check(true);
        }
        catch (IllegalArgumentException e) {
            harness.check(false);
        }
        dst = new BufferedImage(20, 20, 2);
        try {
            op.filter(img, dst);
            harness.check(true);
            harness.check(img.getType(), 11);
            harness.check(dst.getType(), 2);
        }
        catch (IllegalArgumentException ex) {
            harness.check(false);
        }
    }

    private void testOneLookup(TestHarness harness, boolean premultiply) {
        if (premultiply) {
            harness.checkPoint("testOneLookup with premultiply");
        } else {
            harness.checkPoint("testOneLookup without premultiply");
        }
        BufferedImage img = premultiply ? new BufferedImage(5, 5, 3) : new BufferedImage(5, 5, 2);
        this.createImage(img);
        byte[] bytes = new byte[]{12, 23, 14, 35, 48, 2};
        ByteLookupTable t = new ByteLookupTable(0, bytes);
        LookupOp op = new LookupOp(t, null);
        BufferedImage dst = new BufferedImage(5, 5, 2);
        dst = op.filter(img, dst);
        WritableRaster dest = dst.getRaster();
        harness.check(img.isAlphaPremultiplied(), premultiply);
        harness.check(dst.isAlphaPremultiplied(), false);
        harness.check(dest.getSample(0, 0, 0), 23);
        harness.check(dest.getSample(1, 0, 0), 35);
        harness.check(dest.getSample(2, 0, 0), 23);
        harness.check(dest.getSample(3, 0, 0), 35);
        harness.check(dest.getSample(4, 0, 0), 23);
        harness.check(dest.getSample(0, 1, 0), 48);
        harness.check(dest.getSample(1, 1, 0), 14);
        harness.check(dest.getSample(2, 1, 0), 48);
        harness.check(dest.getSample(3, 1, 0), 14);
        harness.check(dest.getSample(4, 1, 0), 48);
        harness.check(dest.getSample(0, 2, 0), 23);
        harness.check(dest.getSample(1, 2, 0), 35);
        harness.check(dest.getSample(2, 2, 0), 23);
        harness.check(dest.getSample(3, 2, 0), 35);
        harness.check(dest.getSample(4, 2, 0), 23);
        harness.check(dest.getSample(0, 3, 0), 48);
        harness.check(dest.getSample(1, 3, 0), 14);
        harness.check(dest.getSample(2, 3, 0), 48);
        harness.check(dest.getSample(3, 3, 0), 14);
        harness.check(dest.getSample(4, 3, 0), 48);
        harness.check(dest.getSample(0, 4, 0), 23);
        harness.check(dest.getSample(1, 4, 0), 35);
        harness.check(dest.getSample(2, 4, 0), 23);
        harness.check(dest.getSample(3, 4, 0), 35);
        harness.check(dest.getSample(4, 4, 0), 23);
        harness.check(dest.getSample(0, 0, 1), 12);
        harness.check(dest.getSample(1, 0, 1), 48);
        harness.check(dest.getSample(2, 0, 1), 12);
        harness.check(dest.getSample(3, 0, 1), 48);
        harness.check(dest.getSample(4, 0, 1), 12);
        harness.check(dest.getSample(0, 1, 1), 35);
        harness.check(dest.getSample(1, 1, 1), 23);
        harness.check(dest.getSample(2, 1, 1), 35);
        harness.check(dest.getSample(3, 1, 1), 23);
        harness.check(dest.getSample(4, 1, 1), 35);
        harness.check(dest.getSample(0, 2, 1), 12);
        harness.check(dest.getSample(1, 2, 1), 48);
        harness.check(dest.getSample(2, 2, 1), 12);
        harness.check(dest.getSample(3, 2, 1), 48);
        harness.check(dest.getSample(4, 2, 1), 12);
        harness.check(dest.getSample(0, 3, 1), 35);
        harness.check(dest.getSample(1, 3, 1), 23);
        harness.check(dest.getSample(2, 3, 1), 35);
        harness.check(dest.getSample(3, 3, 1), 23);
        harness.check(dest.getSample(4, 3, 1), 35);
        harness.check(dest.getSample(0, 4, 1), 12);
        harness.check(dest.getSample(1, 4, 1), 48);
        harness.check(dest.getSample(2, 4, 1), 12);
        harness.check(dest.getSample(3, 4, 1), 48);
        harness.check(dest.getSample(4, 4, 1), 12);
    }

    private void testColourLookup(TestHarness harness, boolean premultiply) {
        if (premultiply) {
            harness.checkPoint("testColourLookup with premultiply");
        } else {
            harness.checkPoint("testColourLookup without premultiply");
        }
        BufferedImage img = premultiply ? new BufferedImage(5, 5, 3) : new BufferedImage(5, 5, 2);
        this.createImage(img);
        short[][] lutarray = new short[][]{{12, 23, 14, 35, 48, 2}, {112, 123, 114, 135, 148, 102}, {212, 223, 214, 235, 248, 202}};
        ShortLookupTable t = new ShortLookupTable(0, lutarray);
        LookupOp op = new LookupOp(t, null);
        BufferedImage dst = new BufferedImage(5, 5, 2);
        try {
            dst = op.filter(img, dst);
            WritableRaster dest = dst.getRaster();
            harness.check(img.isAlphaPremultiplied(), premultiply);
            harness.check(dst.isAlphaPremultiplied(), false);
            harness.check(dest.getSample(0, 0, 0), 23);
            harness.check(dest.getSample(1, 0, 0), 35);
            harness.check(dest.getSample(2, 0, 0), 23);
            harness.check(dest.getSample(3, 0, 0), 35);
            harness.check(dest.getSample(4, 0, 0), 23);
            harness.check(dest.getSample(0, 1, 0), 48);
            harness.check(dest.getSample(1, 1, 0), 14);
            harness.check(dest.getSample(2, 1, 0), 48);
            harness.check(dest.getSample(3, 1, 0), 14);
            harness.check(dest.getSample(4, 1, 0), 48);
            harness.check(dest.getSample(0, 2, 0), 23);
            harness.check(dest.getSample(1, 2, 0), 35);
            harness.check(dest.getSample(2, 2, 0), 23);
            harness.check(dest.getSample(3, 2, 0), 35);
            harness.check(dest.getSample(4, 2, 0), 23);
            harness.check(dest.getSample(0, 3, 0), 48);
            harness.check(dest.getSample(1, 3, 0), 14);
            harness.check(dest.getSample(2, 3, 0), 48);
            harness.check(dest.getSample(3, 3, 0), 14);
            harness.check(dest.getSample(4, 3, 0), 48);
            harness.check(dest.getSample(0, 4, 0), 23);
            harness.check(dest.getSample(1, 4, 0), 35);
            harness.check(dest.getSample(2, 4, 0), 23);
            harness.check(dest.getSample(3, 4, 0), 35);
            harness.check(dest.getSample(4, 4, 0), 23);
            harness.check(dest.getSample(0, 0, 1), 112);
            harness.check(dest.getSample(1, 0, 1), 148);
            harness.check(dest.getSample(2, 0, 1), 112);
            harness.check(dest.getSample(3, 0, 1), 148);
            harness.check(dest.getSample(4, 0, 1), 112);
            harness.check(dest.getSample(0, 1, 1), 135);
            harness.check(dest.getSample(1, 1, 1), 123);
            harness.check(dest.getSample(2, 1, 1), 135);
            harness.check(dest.getSample(3, 1, 1), 123);
            harness.check(dest.getSample(4, 1, 1), 135);
            harness.check(dest.getSample(0, 2, 1), 112);
            harness.check(dest.getSample(1, 2, 1), 148);
            harness.check(dest.getSample(2, 2, 1), 112);
            harness.check(dest.getSample(3, 2, 1), 148);
            harness.check(dest.getSample(4, 2, 1), 112);
            harness.check(dest.getSample(0, 3, 1), 135);
            harness.check(dest.getSample(1, 3, 1), 123);
            harness.check(dest.getSample(2, 3, 1), 135);
            harness.check(dest.getSample(3, 3, 1), 123);
            harness.check(dest.getSample(4, 3, 1), 135);
            harness.check(dest.getSample(0, 4, 1), 112);
            harness.check(dest.getSample(1, 4, 1), 148);
            harness.check(dest.getSample(2, 4, 1), 112);
            harness.check(dest.getSample(3, 4, 1), 148);
            harness.check(dest.getSample(4, 4, 1), 112);
        }
        catch (IllegalArgumentException ex) {
            harness.debug("Test did not run - this is expected on Sun due to a bug in their implementation, but this message should not show when testing Classpath.");
        }
    }

    private void testAllLookup(TestHarness harness, boolean premultiply) {
        if (premultiply) {
            harness.checkPoint("testAllLookup with premultiply");
        } else {
            harness.checkPoint("testAllLookup without premultiply");
        }
        BufferedImage img = premultiply ? new BufferedImage(5, 5, 3) : new BufferedImage(5, 5, 2);
        this.createImage(img);
        short[][] lutarray = new short[][]{{12, 23, 14, 35, 48, 2}, {112, 123, 114, 135, 148, 102}, {212, 223, 214, 235, 248, 202}, {62, 73, 64, 85, 98, 52}};
        ShortLookupTable t = new ShortLookupTable(0, lutarray);
        LookupOp op = new LookupOp(t, null);
        BufferedImage dst = new BufferedImage(5, 5, 2);
        dst = op.filter(img, dst);
        WritableRaster dest = dst.getRaster();
        harness.check(img.isAlphaPremultiplied(), premultiply);
        harness.check(dst.isAlphaPremultiplied(), false);
        harness.check(dest.getSample(0, 0, 0), 23);
        harness.check(dest.getSample(1, 0, 0), 35);
        harness.check(dest.getSample(2, 0, 0), 23);
        harness.check(dest.getSample(3, 0, 0), 35);
        harness.check(dest.getSample(4, 0, 0), 23);
        harness.check(dest.getSample(0, 1, 0), 48);
        harness.check(dest.getSample(1, 1, 0), 14);
        harness.check(dest.getSample(2, 1, 0), 48);
        harness.check(dest.getSample(3, 1, 0), 14);
        harness.check(dest.getSample(4, 1, 0), 48);
        harness.check(dest.getSample(0, 2, 0), 23);
        harness.check(dest.getSample(1, 2, 0), 35);
        harness.check(dest.getSample(2, 2, 0), 23);
        harness.check(dest.getSample(3, 2, 0), 35);
        harness.check(dest.getSample(4, 2, 0), 23);
        harness.check(dest.getSample(0, 3, 0), 48);
        harness.check(dest.getSample(1, 3, 0), 14);
        harness.check(dest.getSample(2, 3, 0), 48);
        harness.check(dest.getSample(3, 3, 0), 14);
        harness.check(dest.getSample(4, 3, 0), 48);
        harness.check(dest.getSample(0, 4, 0), 23);
        harness.check(dest.getSample(1, 4, 0), 35);
        harness.check(dest.getSample(2, 4, 0), 23);
        harness.check(dest.getSample(3, 4, 0), 35);
        harness.check(dest.getSample(4, 4, 0), 23);
        harness.check(dest.getSample(0, 0, 1), 112);
        harness.check(dest.getSample(1, 0, 1), 148);
        harness.check(dest.getSample(2, 0, 1), 112);
        harness.check(dest.getSample(3, 0, 1), 148);
        harness.check(dest.getSample(4, 0, 1), 112);
        harness.check(dest.getSample(0, 1, 1), 135);
        harness.check(dest.getSample(1, 1, 1), 123);
        harness.check(dest.getSample(2, 1, 1), 135);
        harness.check(dest.getSample(3, 1, 1), 123);
        harness.check(dest.getSample(4, 1, 1), 135);
        harness.check(dest.getSample(0, 2, 1), 112);
        harness.check(dest.getSample(1, 2, 1), 148);
        harness.check(dest.getSample(2, 2, 1), 112);
        harness.check(dest.getSample(3, 2, 1), 148);
        harness.check(dest.getSample(4, 2, 1), 112);
        harness.check(dest.getSample(0, 3, 1), 135);
        harness.check(dest.getSample(1, 3, 1), 123);
        harness.check(dest.getSample(2, 3, 1), 135);
        harness.check(dest.getSample(3, 3, 1), 123);
        harness.check(dest.getSample(4, 3, 1), 135);
        harness.check(dest.getSample(0, 4, 1), 112);
        harness.check(dest.getSample(1, 4, 1), 148);
        harness.check(dest.getSample(2, 4, 1), 112);
        harness.check(dest.getSample(3, 4, 1), 148);
        harness.check(dest.getSample(4, 4, 1), 112);
        harness.check(dest.getSample(0, 0, 2), 214);
        harness.check(dest.getSample(1, 0, 2), 235);
        harness.check(dest.getSample(2, 0, 2), 214);
        harness.check(dest.getSample(3, 0, 2), 235);
        harness.check(dest.getSample(4, 0, 2), 214);
        harness.check(dest.getSample(0, 1, 2), 248);
        harness.check(dest.getSample(1, 1, 2), 214);
        harness.check(dest.getSample(2, 1, 2), 248);
        harness.check(dest.getSample(3, 1, 2), 214);
        harness.check(dest.getSample(4, 1, 2), 248);
        harness.check(dest.getSample(0, 2, 2), 214);
        harness.check(dest.getSample(1, 2, 2), 235);
        harness.check(dest.getSample(2, 2, 2), 214);
        harness.check(dest.getSample(3, 2, 2), 235);
        harness.check(dest.getSample(4, 2, 2), 214);
        harness.check(dest.getSample(0, 3, 2), 248);
        harness.check(dest.getSample(1, 3, 2), 214);
        harness.check(dest.getSample(2, 3, 2), 248);
        harness.check(dest.getSample(3, 3, 2), 214);
        harness.check(dest.getSample(4, 3, 2), 248);
        harness.check(dest.getSample(0, 4, 2), 214);
        harness.check(dest.getSample(1, 4, 2), 235);
        harness.check(dest.getSample(2, 4, 2), 214);
        harness.check(dest.getSample(3, 4, 2), 235);
        harness.check(dest.getSample(4, 4, 2), 214);
        harness.check(dest.getSample(0, 0, 3), 62);
        harness.check(dest.getSample(1, 0, 3), 98);
        harness.check(dest.getSample(2, 0, 3), 62);
        harness.check(dest.getSample(3, 0, 3), 98);
        harness.check(dest.getSample(4, 0, 3), 62);
        harness.check(dest.getSample(0, 1, 3), 85);
        harness.check(dest.getSample(1, 1, 3), 73);
        harness.check(dest.getSample(2, 1, 3), 85);
        harness.check(dest.getSample(3, 1, 3), 73);
        harness.check(dest.getSample(4, 1, 3), 85);
        harness.check(dest.getSample(0, 2, 3), 62);
        harness.check(dest.getSample(1, 2, 3), 98);
        harness.check(dest.getSample(2, 2, 3), 62);
        harness.check(dest.getSample(3, 2, 3), 98);
        harness.check(dest.getSample(4, 2, 3), 62);
        harness.check(dest.getSample(0, 3, 3), 85);
        harness.check(dest.getSample(1, 3, 3), 73);
        harness.check(dest.getSample(2, 3, 3), 85);
        harness.check(dest.getSample(3, 3, 3), 73);
        harness.check(dest.getSample(4, 3, 3), 85);
        harness.check(dest.getSample(0, 4, 3), 62);
        harness.check(dest.getSample(1, 4, 3), 98);
        harness.check(dest.getSample(2, 4, 3), 62);
        harness.check(dest.getSample(3, 4, 3), 98);
        harness.check(dest.getSample(4, 4, 3), 62);
    }

    private void testUndefined(TestHarness harness) {
        harness.checkPoint("testUndefined");
        BufferedImage img = new BufferedImage(5, 5, 2);
        WritableRaster r = img.getRaster();
        r.setSample(1, 1, 0, 20);
        short[] lutarray = new short[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
        ShortLookupTable t = new ShortLookupTable(0, lutarray);
        LookupOp op = new LookupOp(t, null);
        try {
            op.filter(img, null);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            harness.check(true);
        }
        byte[] bytes = new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
        ByteLookupTable t2 = new ByteLookupTable(0, bytes);
        op = new LookupOp(t2, null);
        try {
            op.filter(img, null);
            harness.check(true);
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            harness.check(true);
        }
        r.setSample(1, 1, 0, 5);
        r.setSample(1, 1, 1, 4);
        r.setSample(1, 1, 2, 3);
        r.setSample(1, 1, 3, 2);
        BufferedImage dst = new BufferedImage(5, 5, 11);
        try {
            op.filter(img, dst);
            harness.check(true);
        }
        catch (IllegalArgumentException ex) {
            harness.check(false);
        }
        img = new BufferedImage(5, 5, 11);
        r = img.getRaster();
        r.setSample(1, 1, 0, 5);
        dst = new BufferedImage(5, 5, 2);
        try {
            op.filter(img, dst);
            harness.check(true);
        }
        catch (IllegalArgumentException ex) {
            harness.check(false);
        }
    }

    private void createImage(BufferedImage img) {
        WritableRaster r = img.getRaster();
        for (int i = 0; i < r.getHeight(); ++i) {
            for (int j = 0; j < r.getWidth(); ++j) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        r.setSample(j, i, 0, 1);
                        r.setSample(j, i, 1, 0);
                        r.setSample(j, i, 2, 2);
                        r.setSample(j, i, 3, 0);
                        continue;
                    }
                    r.setSample(j, i, 0, 3);
                    r.setSample(j, i, 1, 4);
                    r.setSample(j, i, 2, 3);
                    r.setSample(j, i, 3, 4);
                    continue;
                }
                if (j % 2 == 0) {
                    r.setSample(j, i, 0, 4);
                    r.setSample(j, i, 1, 3);
                    r.setSample(j, i, 2, 4);
                    r.setSample(j, i, 3, 3);
                    continue;
                }
                r.setSample(j, i, 0, 2);
                r.setSample(j, i, 1, 1);
                r.setSample(j, i, 2, 2);
                r.setSample(j, i, 3, 1);
            }
        }
    }
}

