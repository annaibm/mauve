/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.ColorClass;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import java.awt.color.ColorSpace;

public class constructors
implements Testlet {
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
        harness.checkPoint("(ColorSpace, float[], float)");
        Color c = new Color(ColorSpace.getInstance(1000), new float[]{0.2f, 0.4f, 0.6f}, 0.8f);
        harness.check(c.getRed(), 51);
        harness.check(c.getGreen(), 102);
        harness.check(c.getBlue(), 153);
        harness.check(c.getAlpha(), 204);
        boolean pass = false;
        try {
            c = new Color(null, new float[]{0.2f, 0.4f, 0.6f}, 0.8f);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testConstructor2(TestHarness harness) {
        harness.checkPoint("(float, float, float)");
        Color c = new Color(0.2f, 0.4f, 0.6f);
        harness.check(c.getRed(), 51);
        harness.check(c.getGreen(), 102);
        harness.check(c.getBlue(), 153);
        harness.check(c.getAlpha(), 255);
        boolean pass = false;
        try {
            c = new Color(-0.2f, 0.4f, 0.6f);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            c = new Color(0.2f, -0.4f, 0.6f);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            c = new Color(0.2f, 0.4f, -0.6f);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            c = new Color(1.2f, 0.4f, 0.6f);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            c = new Color(0.2f, 1.4f, 0.6f);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            c = new Color(0.2f, 0.4f, 1.6f);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testConstructor3(TestHarness harness) {
        harness.checkPoint("(float, float, float, float)");
        Color c = new Color(0.2f, 0.4f, 0.6f, 0.8f);
        harness.check(c.getRed(), 51);
        harness.check(c.getGreen(), 102);
        harness.check(c.getBlue(), 153);
        harness.check(c.getAlpha(), 204);
        boolean pass = false;
        try {
            c = new Color(-0.2f, 0.4f, 0.6f, 0.8f);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            c = new Color(0.2f, -0.4f, 0.6f, 0.8f);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            c = new Color(0.2f, 0.4f, -0.6f, 0.8f);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            c = new Color(0.2f, 0.4f, 0.6f, -0.8f);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            c = new Color(1.2f, 0.4f, 0.6f, 0.8f);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            c = new Color(0.2f, 1.4f, 0.6f, 0.8f);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            c = new Color(0.2f, 0.4f, 1.6f, 0.8f);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            c = new Color(0.2f, 0.4f, 0.6f, 1.8f);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testConstructor4(TestHarness harness) {
        harness.checkPoint("(int)");
        Color c = new Color(305419896);
        harness.check(c.getRed(), 52);
        harness.check(c.getGreen(), 86);
        harness.check(c.getBlue(), 120);
        harness.check(c.getAlpha(), 255);
    }

    private void testConstructor5(TestHarness harness) {
        harness.checkPoint("(int, boolean)");
        Color c = new Color(305419896, false);
        harness.check(c.getRed(), 52);
        harness.check(c.getGreen(), 86);
        harness.check(c.getBlue(), 120);
        harness.check(c.getAlpha(), 255);
        c = new Color(305419896, true);
        harness.check(c.getRed(), 52);
        harness.check(c.getGreen(), 86);
        harness.check(c.getBlue(), 120);
        harness.check(c.getAlpha(), 18);
    }

    private void testConstructor6(TestHarness harness) {
        harness.checkPoint("(int, int, int)");
        Color c = new Color(12, 34, 56);
        harness.check(c.getRed(), 12);
        harness.check(c.getGreen(), 34);
        harness.check(c.getBlue(), 56);
        harness.check(c.getAlpha(), 255);
        boolean pass = false;
        try {
            c = new Color(-12, 34, 56);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            c = new Color(12, -34, 56);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            c = new Color(12, 34, -56);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            c = new Color(512, 34, 56);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            c = new Color(12, 534, 56);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            c = new Color(12, 34, 556);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testConstructor7(TestHarness harness) {
        harness.checkPoint("(int, int, int, int)");
        Color c = new Color(12, 34, 56, 78);
        harness.check(c.getRed(), 12);
        harness.check(c.getGreen(), 34);
        harness.check(c.getBlue(), 56);
        harness.check(c.getAlpha(), 78);
        boolean pass = false;
        try {
            c = new Color(-12, 34, 56, 78);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            c = new Color(12, -34, 56, 78);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            c = new Color(12, 34, -56, 78);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            c = new Color(12, 34, 56, -78);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            c = new Color(512, 34, 56, 78);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            c = new Color(12, 534, 56, 78);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            c = new Color(12, 34, 556, 78);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            c = new Color(12, 34, 56, 578);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

