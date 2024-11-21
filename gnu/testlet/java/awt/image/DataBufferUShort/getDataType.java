/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.DataBufferUShort;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.DataBufferUShort;

public class getDataType
implements Testlet {
    @Override
    public void test(TestHarness h) {
        h.check(new DataBufferUShort(5).getDataType(), 1);
    }
}

