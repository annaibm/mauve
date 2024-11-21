/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.ComponentSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.ComponentSampleModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;

public class getSamples
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DataBufferInt db = new DataBufferInt(12);
        for (int i = 0; i < 12; ++i) {
            ((DataBuffer)db).setElem(i, i);
        }
        ComponentSampleModel m = new ComponentSampleModel(3, 3, 2, 2, 6, new int[]{0, 1});
        int[] samples = m.getSamples(0, 1, 2, 1, 0, (int[])null, (DataBuffer)db);
        harness.check(samples.length, 2);
        harness.check(samples[0], 6);
        harness.check(samples[1], 8);
        int[] result = new int[2];
        samples = m.getSamples(0, 1, 2, 1, 1, result, (DataBuffer)db);
        harness.check(samples.length, 2);
        harness.check(samples[0], 7);
        harness.check(samples[1], 9);
        harness.check(samples == result);
        boolean pass = false;
        try {
            m.getSamples(0, 1, 2, 1, 1, result, (DataBuffer)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

