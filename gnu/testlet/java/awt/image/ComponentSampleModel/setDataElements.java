/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.ComponentSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.ComponentSampleModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;

public class setDataElements
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DataBufferInt db = new DataBufferInt(12);
        int[] pixel = new int[]{11, 22};
        ComponentSampleModel m = new ComponentSampleModel(3, 3, 2, 2, 6, new int[]{0, 1});
        m.setDataElements(1, 1, pixel, db);
        harness.check(((DataBuffer)db).getElem(0, 8), 11);
        harness.check(((DataBuffer)db).getElem(0, 9), 22);
        boolean pass = false;
        try {
            m.setDataElements(1, 1, "???", db);
        }
        catch (ClassCastException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.setDataElements(1, 1, null, db);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.setDataElements(1, 1, pixel, null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

