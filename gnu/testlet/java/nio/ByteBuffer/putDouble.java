/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.nio.ByteBuffer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.nio.ByteBuffer;

public class putDouble
implements Testlet {
    private TestHarness h;

    @Override
    public void test(TestHarness h) {
        ByteBuffer b = ByteBuffer.allocate(8);
        long doubleBits = 9221120237041090567L;
        double d = Double.longBitsToDouble(doubleBits);
        System.out.println(Double.isNaN(d));
        b.putDouble(d);
        h.check(doubleBits == Double.doubleToRawLongBits(b.getDouble(0)));
        b.putDouble(0, 1.5);
        h.check(1.5 == b.getDouble(0));
    }
}

