/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.ComponentSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.ComponentSampleModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;

public class getPixels
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DataBufferInt db = new DataBufferInt(12);
        for (int i = 0; i < 12; ++i) {
            ((DataBuffer)db).setElem(i, i);
        }
        ComponentSampleModel m = new ComponentSampleModel(3, 3, 2, 2, 6, new int[]{0, 1});
        int[] pixels = m.getPixels(1, 0, 2, 1, (int[])null, (DataBuffer)db);
        harness.check(pixels.length, 4);
        harness.check(pixels[0], 2);
        harness.check(pixels[1], 3);
        harness.check(pixels[2], 4);
        harness.check(pixels[3], 5);
        int[] result = new int[4];
        pixels = m.getPixels(1, 1, 2, 1, result, (DataBuffer)db);
        harness.check(pixels[0], 8);
        harness.check(pixels[1], 9);
        harness.check(pixels[2], 10);
        harness.check(pixels[3], 11);
        harness.check(pixels == result);
        boolean pass = false;
        try {
            m.getPixels(1, 1, 2, 1, result, (DataBuffer)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

