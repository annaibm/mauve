/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.DataBufferShort;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.DataBufferShort;

public class getDataType
implements Testlet {
    @Override
    public void test(TestHarness h) {
        h.check(new DataBufferShort(5).getDataType(), 2);
    }
}

