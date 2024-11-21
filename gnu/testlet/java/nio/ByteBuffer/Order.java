/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.nio.ByteBuffer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Order
implements Testlet {
    @Override
    public void test(TestHarness h) {
        ByteBuffer buf = ByteBuffer.allocate(4);
        h.check(buf.order(ByteOrder.BIG_ENDIAN), buf, "buf.order(ByteOrder.BIG_ENDIAN)");
        h.check(buf.order(), ByteOrder.BIG_ENDIAN, "order() == ByteOrder.BIG_ENDIAN");
        buf.putInt(287454020);
        h.check(buf.order(ByteOrder.LITTLE_ENDIAN), buf, "buf.order(ByteOrder.LITTLE_ENDIAN)");
        h.check(buf.order(), ByteOrder.LITTLE_ENDIAN, "order() == ByteOrder.LITTLE_ENDIAN");
        buf.rewind();
        h.check(buf.getInt(), 1144201745, "get()");
    }
}

