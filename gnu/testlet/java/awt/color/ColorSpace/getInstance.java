/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.color.ColorSpace;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.color.ColorSpace;

public class getInstance
implements Testlet {
    @Override
    public void test(TestHarness h) {
        this.test_CS_sRGB(h);
        this.test_CS_CIEXYZ(h);
        this.test_CS_PYCC(h);
        this.test_CS_GRAY(h);
        this.test_CS_LINEAR_RGB(h);
        this.test_TYPE_GRAY(h);
    }

    public void test_CS_sRGB(TestHarness h) {
        h.checkPoint("CS_sRGB");
        ColorSpace cs = ColorSpace.getInstance(1000);
        h.check(cs.getType(), 5);
        h.check(cs.getNumComponents(), 3);
        getInstance.checkEpsilon(h, cs.getMinValue(0), 0.0f);
        getInstance.checkEpsilon(h, cs.getMaxValue(0), 1.0f);
        getInstance.checkEpsilon(h, cs.getMinValue(1), 0.0f);
        getInstance.checkEpsilon(h, cs.getMaxValue(1), 1.0f);
        getInstance.checkEpsilon(h, cs.getMinValue(2), 0.0f);
        getInstance.checkEpsilon(h, cs.getMaxValue(2), 1.0f);
    }

    public void test_CS_CIEXYZ(TestHarness h) {
        h.checkPoint("CS_CIEXYZ");
        ColorSpace cs = ColorSpace.getInstance(1001);
        h.check(cs.getType(), 0);
        h.check(cs.getNumComponents(), 3);
        getInstance.checkEpsilon(h, cs.getMinValue(0), 0.0f);
        getInstance.checkEpsilon(h, cs.getMaxValue(0), 2.0f);
        getInstance.checkEpsilon(h, cs.getMinValue(1), 0.0f);
        getInstance.checkEpsilon(h, cs.getMaxValue(1), 2.0f);
        getInstance.checkEpsilon(h, cs.getMinValue(2), 0.0f);
        getInstance.checkEpsilon(h, cs.getMaxValue(2), 2.0f);
    }

    public void test_CS_PYCC(TestHarness h) {
        h.checkPoint("CS_PYCC");
        ColorSpace cs = ColorSpace.getInstance(1002);
        h.check(cs.getType(), 13);
        h.check(cs.getNumComponents(), 3);
        getInstance.checkEpsilon(h, cs.getMinValue(0), 0.0f);
        getInstance.checkEpsilon(h, cs.getMaxValue(0), 1.0f);
        getInstance.checkEpsilon(h, cs.getMinValue(1), 0.0f);
        getInstance.checkEpsilon(h, cs.getMaxValue(1), 1.0f);
        getInstance.checkEpsilon(h, cs.getMinValue(2), 0.0f);
        getInstance.checkEpsilon(h, cs.getMaxValue(2), 1.0f);
    }

    public void test_CS_GRAY(TestHarness h) {
        h.checkPoint("CS_GRAY");
        ColorSpace cs = ColorSpace.getInstance(1003);
        h.check(cs.getType(), 6);
        h.check(cs.getNumComponents(), 1);
        h.check(cs.getMinValue(0), 0.0);
        h.check(cs.getMaxValue(0), 1.0);
    }

    public void test_CS_LINEAR_RGB(TestHarness h) {
        h.checkPoint("CS_LINEAR_RGB");
        ColorSpace cs = ColorSpace.getInstance(1004);
        h.check(cs.getType(), 5);
        h.check(cs.getNumComponents(), 3);
        getInstance.checkEpsilon(h, cs.getMinValue(0), 0.0f);
        getInstance.checkEpsilon(h, cs.getMaxValue(0), 1.0f);
        getInstance.checkEpsilon(h, cs.getMinValue(1), 0.0f);
        getInstance.checkEpsilon(h, cs.getMaxValue(1), 1.0f);
        getInstance.checkEpsilon(h, cs.getMinValue(2), 0.0f);
        getInstance.checkEpsilon(h, cs.getMaxValue(2), 1.0f);
    }

    public void test_TYPE_GRAY(TestHarness h) {
        Exception caught = null;
        h.checkPoint("TYPE_GRAY");
        try {
            ColorSpace.getInstance(6);
        }
        catch (Exception ex) {
            caught = ex;
        }
        h.check(caught instanceof IllegalArgumentException);
    }

    private static void checkEpsilon(TestHarness h, float value2, float expected) {
        if (Math.abs(value2 - expected) < 0.001f) {
            h.check(true);
        } else {
            h.check(value2, expected);
        }
    }
}

