/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.RescaleOp;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.awt.image.WritableRaster;

public class filterImage
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.simpleTests(harness);
        this.test1(harness);
        this.test2(harness);
        this.test3(harness);
        this.testMismatch(harness);
    }

    private void simpleTests(TestHarness harness) {
        harness.checkPoint("filter(BufferedImage)");
        BufferedImage img = new BufferedImage(20, 20, 11);
        WritableRaster r = img.getRaster();
        r.setSample(1, 1, 0, 150);
        RescaleOp op = new RescaleOp(1.0f, 1.0f, null);
        try {
            op.filter(img, img);
            harness.check(true);
        }
        catch (IllegalArgumentException e) {
            harness.check(false);
        }
        BufferedImage dst = new BufferedImage(20, 20, 1);
        try {
            op.filter(img, dst);
            harness.check(true);
        }
        catch (IllegalArgumentException e) {
            harness.check(false);
        }
        dst = new BufferedImage(30, 40, 11);
        try {
            op.filter(img, dst);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        dst = op.filter(img, null);
        harness.check(dst.getType(), op.createCompatibleDestImage(img, null).getType());
        img.getRaster().setSample(1, 1, 0, 1500);
        op = new RescaleOp(100.0f, 0.0f, null);
        dst = op.filter(img, null);
        double maxValue = Math.pow(2.0, img.getColorModel().getComponentSize(0)) - 1.0;
        harness.check((double)dst.getRaster().getSample(1, 1, 0), maxValue);
        op = new RescaleOp(1.0f, -2000.0f, null);
        dst = op.filter(img, null);
        harness.check(dst.getRaster().getSample(1, 1, 0), 0);
    }

    private void test1(TestHarness harness) {
        harness.checkPoint("filter(BufferedImage) with one scaling factor");
        BufferedImage img = new BufferedImage(20, 20, 2);
        WritableRaster r = img.getRaster();
        r.setSample(1, 1, 0, 150);
        r.setSample(1, 1, 1, 160);
        r.setSample(1, 1, 2, 175);
        r.setSample(1, 1, 3, 195);
        r.setSample(1, 3, 0, 45);
        r.setSample(1, 3, 1, 60);
        r.setSample(1, 3, 2, 70);
        r.setSample(1, 3, 3, 90);
        RescaleOp op = new RescaleOp(0.75f, 25.0f, null);
        BufferedImage dst = op.filter(img, null);
        WritableRaster dest = dst.getRaster();
        harness.check(dest.getSample(1, 1, 0), 137);
        harness.check(dest.getSample(1, 1, 1), 145);
        harness.check(dest.getSample(1, 3, 0), 58);
        harness.check(dest.getSample(1, 3, 1), 70);
    }

    private void test2(TestHarness harness) {
        harness.checkPoint("filter(BufferedImage) with num factors == num color components");
        BufferedImage img = new BufferedImage(20, 20, 2);
        WritableRaster r = img.getRaster();
        r.setSample(1, 1, 0, 10);
        r.setSample(1, 1, 1, 20);
        r.setSample(1, 1, 2, 35);
        r.setSample(1, 1, 3, 40);
        r.setSample(1, 3, 0, 45);
        r.setSample(1, 3, 1, 60);
        r.setSample(1, 3, 2, 70);
        r.setSample(1, 3, 3, 90);
        RescaleOp op = new RescaleOp(new float[]{0.75f, 2.5f, 1.0f}, new float[]{25.0f, 2.0f, 1.5f}, null);
        try {
            BufferedImage dst = op.filter(img, null);
            WritableRaster dest = dst.getRaster();
            harness.check(dest.getSample(1, 1, 0), 32);
            harness.check(dest.getSample(1, 1, 1), 52);
            harness.check(dest.getSample(1, 3, 0), 58);
            harness.check(dest.getSample(1, 3, 1), 152);
            harness.check(dest.getSample(1, 1, 2), 36);
            harness.check(dest.getSample(1, 1, 3), 40);
            harness.check(dest.getSample(1, 3, 2), 71);
            harness.check(dest.getSample(1, 3, 3), 90);
        }
        catch (IllegalArgumentException ex) {
            harness.debug("Test did not run - this is expected on Sun due to a bug in their implementation, but this message should not show when testing Classpath.");
        }
    }

    private void test3(TestHarness harness) {
        harness.checkPoint("filter(BufferedImage) with num factors == num components");
        BufferedImage img = new BufferedImage(20, 20, 2);
        WritableRaster r = img.getRaster();
        r.setSample(1, 1, 0, 10);
        r.setSample(1, 1, 1, 20);
        r.setSample(1, 1, 2, 35);
        r.setSample(1, 1, 3, 40);
        r.setSample(1, 3, 0, 45);
        r.setSample(1, 3, 1, 60);
        r.setSample(1, 3, 2, 70);
        r.setSample(1, 3, 3, 90);
        RescaleOp op = new RescaleOp(new float[]{0.75f, 2.5f, -1.0f, 0.0f}, new float[]{25.0f, 2.0f, 1.0f, 0.0f}, null);
        BufferedImage dst = op.filter(img, null);
        WritableRaster dest = dst.getRaster();
        harness.check(dest.getSample(1, 1, 0), 32);
        harness.check(dest.getSample(1, 1, 1), 52);
        harness.check(dest.getSample(1, 1, 2), 0);
        harness.check(dest.getSample(1, 1, 3), 0);
        harness.check(dest.getSample(1, 3, 0), 58);
        harness.check(dest.getSample(1, 3, 1), 152);
        harness.check(dest.getSample(1, 3, 2), 0);
        harness.check(dest.getSample(1, 3, 3), 0);
    }

    private void testMismatch(TestHarness harness) {
        WritableRaster dest;
        BufferedImage dst;
        harness.checkPoint("filter(BufferedImage) with mismatched arrays");
        BufferedImage img = new BufferedImage(20, 20, 2);
        WritableRaster r = img.getRaster();
        r.setSample(1, 1, 0, 10);
        r.setSample(1, 1, 1, 20);
        r.setSample(1, 1, 2, 35);
        r.setSample(1, 1, 3, 40);
        r.setSample(1, 3, 0, 45);
        r.setSample(1, 3, 1, 60);
        r.setSample(1, 3, 2, 70);
        r.setSample(1, 3, 3, 90);
        RescaleOp op = new RescaleOp(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, new float[]{1.0f, 2.0f}, null);
        try {
            op.filter(img, null);
            harness.check(false);
        }
        catch (IllegalArgumentException ex) {
            harness.check(true);
        }
        op = new RescaleOp(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, new float[]{1.0f}, null);
        try {
            dst = op.filter(img, null);
            dest = dst.getRaster();
            harness.check(dest.getSample(1, 1, 0), 11);
            harness.check(dest.getSample(1, 1, 1), 21);
            harness.check(dest.getSample(1, 3, 0), 46);
            harness.check(dest.getSample(1, 3, 1), 61);
        }
        catch (IllegalArgumentException ex) {
            harness.check(false);
        }
        op = new RescaleOp(new float[]{0.5f}, new float[]{2.0f, 3.0f, 4.0f, 5.0f}, null);
        try {
            dst = op.filter(img, null);
            dest = dst.getRaster();
            harness.check(dest.getSample(1, 1, 0), 7);
            harness.check(dest.getSample(1, 1, 1), 12);
            harness.check(dest.getSample(1, 3, 0), 24);
            harness.check(dest.getSample(1, 3, 1), 32);
        }
        catch (IllegalArgumentException ex) {
            harness.check(false);
        }
    }
}

