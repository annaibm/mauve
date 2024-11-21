/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.ComponentSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.ComponentSampleModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;

public class setPixels
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DataBufferInt db = new DataBufferInt(12);
        int[] pixels = new int[]{11, 22, 33, 44};
        ComponentSampleModel m = new ComponentSampleModel(3, 3, 2, 2, 6, new int[]{0, 1});
        m.setPixels(0, 0, 2, 1, pixels, (DataBuffer)db);
        harness.check(((DataBuffer)db).getElem(0, 0), 11);
        harness.check(((DataBuffer)db).getElem(0, 1), 22);
        harness.check(((DataBuffer)db).getElem(0, 2), 33);
        harness.check(((DataBuffer)db).getElem(0, 3), 44);
        boolean pass = false;
        try {
            m.setPixels(0, 0, 2, 1, (int[])null, (DataBuffer)db);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.setPixels(0, 0, 2, 1, pixels, (DataBuffer)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

