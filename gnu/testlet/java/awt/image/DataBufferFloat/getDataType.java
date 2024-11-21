/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.DataBufferFloat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.DataBufferFloat;

public class getDataType
implements Testlet {
    @Override
    public void test(TestHarness h) {
        h.check(new DataBufferFloat(5).getDataType(), 4);
    }
}

