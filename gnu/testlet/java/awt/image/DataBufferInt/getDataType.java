/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.DataBufferInt;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.DataBufferInt;

public class getDataType
implements Testlet {
    @Override
    public void test(TestHarness h) {
        h.check(new DataBufferInt(5).getDataType(), 3);
    }
}

