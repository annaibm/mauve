/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.DataBufferByte;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.DataBufferByte;

public class getDataType
implements Testlet {
    @Override
    public void test(TestHarness h) {
        h.check(new DataBufferByte(5).getDataType(), 0);
    }
}

