/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.ComponentSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.ComponentSampleModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;

public class getDataElements
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DataBufferInt db = new DataBufferInt(12);
        for (int i = 0; i < 12; ++i) {
            ((DataBuffer)db).setElem(i, i);
        }
        ComponentSampleModel m = new ComponentSampleModel(3, 3, 2, 2, 6, new int[]{0, 1});
        Object elements2 = m.getDataElements(0, 0, 2, 1, null, db);
        int[] de = (int[])elements2;
        harness.check(de.length, 4);
        harness.check(de[0], 0);
        harness.check(de[1], 1);
        harness.check(de[2], 2);
        harness.check(de[3], 3);
        int[] result = new int[4];
        de = (int[])m.getDataElements(0, 0, 2, 1, result, db);
        harness.check(de[0], 0);
        harness.check(de[1], 1);
        harness.check(de[2], 2);
        harness.check(de[3], 3);
        harness.check(de == result);
        boolean pass = false;
        try {
            m.getDataElements(0, 0, 2, 1, result, null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

