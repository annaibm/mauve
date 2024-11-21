/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.ComponentSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.ComponentSampleModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;

public class setSamples
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DataBufferInt db = new DataBufferInt(12);
        int[] samples = new int[]{11, 22};
        ComponentSampleModel m = new ComponentSampleModel(3, 3, 2, 2, 6, new int[]{0, 1});
        m.setSamples(1, 0, 2, 1, 1, samples, (DataBuffer)db);
        harness.check(((DataBuffer)db).getElem(0, 3), 11);
        harness.check(((DataBuffer)db).getElem(0, 5), 22);
        boolean pass = false;
        try {
            m.setSamples(1, 0, 2, 1, 1, samples, (DataBuffer)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

