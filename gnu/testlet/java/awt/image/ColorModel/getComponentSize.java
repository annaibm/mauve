/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.ColorModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.ColorModel;

public class getComponentSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
    }

    public void test1(TestHarness harness) {
        harness.checkPoint("()");
        ColorModel rgb = ColorModel.getRGBdefault();
        int[] sizes = rgb.getComponentSize();
        harness.check(sizes.length, 4);
        harness.check(sizes[0], 8);
        harness.check(sizes[1], 8);
        harness.check(sizes[2], 8);
        harness.check(sizes[3], 8);
    }

    public void test2(TestHarness harness) {
        harness.checkPoint("(int)");
        ColorModel rgb = ColorModel.getRGBdefault();
        harness.check(rgb.getComponentSize(0), 8);
        harness.check(rgb.getComponentSize(1), 8);
        harness.check(rgb.getComponentSize(2), 8);
        harness.check(rgb.getComponentSize(3), 8);
        boolean pass = false;
        try {
            rgb.getComponentSize(-1);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            rgb.getComponentSize(4);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

