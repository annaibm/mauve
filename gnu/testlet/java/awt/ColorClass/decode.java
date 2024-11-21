/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.ColorClass;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;

public class decode
implements Testlet {
    private void checkColorDecode(TestHarness harness, String str, int red, int green, int blue) {
        Color c = Color.decode(str);
        harness.check(c.getRed(), red);
        harness.check(c.getGreen(), green);
        harness.check(c.getBlue(), blue);
    }

    @Override
    public void test(TestHarness harness) {
        this.checkColorDecode(harness, "0x0", 0, 0, 0);
        this.checkColorDecode(harness, "0X0", 0, 0, 0);
        this.checkColorDecode(harness, "#0", 0, 0, 0);
        this.checkColorDecode(harness, "0x010203", 1, 2, 3);
        this.checkColorDecode(harness, "0X010203", 1, 2, 3);
        this.checkColorDecode(harness, "#010203", 1, 2, 3);
        this.checkColorDecode(harness, "0xffffff", 255, 255, 255);
        this.checkColorDecode(harness, "0Xffffff", 255, 255, 255);
        this.checkColorDecode(harness, "#ffffff", 255, 255, 255);
        this.checkColorDecode(harness, "-0x0", 0, 0, 0);
        this.checkColorDecode(harness, "-0X0", 0, 0, 0);
        this.checkColorDecode(harness, "-#0", 0, 0, 0);
        this.checkColorDecode(harness, "-0x1", 255, 255, 255);
        this.checkColorDecode(harness, "-0X1", 255, 255, 255);
        this.checkColorDecode(harness, "-#1", 255, 255, 255);
        this.checkColorDecode(harness, "-0xffffff", 0, 0, 1);
        this.checkColorDecode(harness, "-0Xffffff", 0, 0, 1);
        this.checkColorDecode(harness, "-#ffffff", 0, 0, 1);
        this.checkColorDecode(harness, "0", 0, 0, 0);
        this.checkColorDecode(harness, "255", 0, 0, 255);
        this.checkColorDecode(harness, "256", 0, 1, 0);
        this.checkColorDecode(harness, "65535", 0, 255, 255);
        this.checkColorDecode(harness, "65536", 1, 0, 0);
        this.checkColorDecode(harness, "16777215", 255, 255, 255);
        this.checkColorDecode(harness, "-16777215", 0, 0, 1);
        this.checkColorDecode(harness, "-1", 255, 255, 255);
        this.checkColorDecode(harness, "00", 0, 0, 0);
        this.checkColorDecode(harness, "0777", 0, 1, 255);
        this.checkColorDecode(harness, "077777777", 255, 255, 255);
        this.checkColorDecode(harness, "-01", 255, 255, 255);
        boolean pass = false;
        try {
            Color.decode(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            Color.decode("XYZ");
        }
        catch (NumberFormatException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            Color.decode("0778");
        }
        catch (NumberFormatException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

