/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.ColorUIResource;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import javax.swing.plaf.ColorUIResource;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
        this.testConstructor3(harness);
        this.testConstructor4(harness);
    }

    private void testConstructor1(TestHarness harness) {
        harness.checkPoint("(Color)");
        ColorUIResource c1 = new ColorUIResource(Color.blue);
        harness.check(c1.getRGB() == Color.blue.getRGB());
        boolean pass = false;
        try {
            new ColorUIResource(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testConstructor2(TestHarness harness) {
        harness.checkPoint("(float, float, float)");
        ColorUIResource c = new ColorUIResource(0.2f, 0.4f, 0.6f);
        harness.check(c.getRed(), 51);
        harness.check(c.getGreen(), 102);
        harness.check(c.getBlue(), 153);
        harness.check(c.getAlpha(), 255);
        boolean pass = false;
        try {
            c = new ColorUIResource(-0.2f, 0.4f, 0.6f);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            c = new ColorUIResource(0.2f, -0.4f, 0.6f);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            c = new ColorUIResource(0.2f, 0.4f, -0.6f);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            c = new ColorUIResource(1.2f, 0.4f, 0.6f);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            c = new ColorUIResource(0.2f, 1.4f, 0.6f);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            c = new ColorUIResource(0.2f, 0.4f, 1.6f);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testConstructor3(TestHarness harness) {
        harness.checkPoint("(int)");
        ColorUIResource c = new ColorUIResource(305419896);
        harness.check(c.getRed(), 52);
        harness.check(c.getGreen(), 86);
        harness.check(c.getBlue(), 120);
        harness.check(c.getAlpha(), 255);
    }

    private void testConstructor4(TestHarness harness) {
        harness.checkPoint("(int, int, int)");
        ColorUIResource c = new ColorUIResource(12, 34, 56);
        harness.check(c.getRed(), 12);
        harness.check(c.getGreen(), 34);
        harness.check(c.getBlue(), 56);
        harness.check(c.getAlpha(), 255);
        boolean pass = false;
        try {
            c = new ColorUIResource(-12, 34, 56);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            c = new ColorUIResource(12, -34, 56);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            c = new ColorUIResource(12, 34, -56);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            c = new ColorUIResource(512, 34, 56);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            c = new ColorUIResource(12, 534, 56);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            c = new ColorUIResource(12, 34, 556);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

