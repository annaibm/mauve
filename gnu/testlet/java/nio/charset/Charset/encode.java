/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.nio.charset.Charset;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class encode
implements Testlet {
    private void checkByteBuffer(TestHarness h, ByteBuffer bb, int capacity2, int position2, int limit) {
        h.check(bb != null, "Byte buffer is null");
        h.check(bb.capacity(), capacity2, "Wrong capacity in byte buffer");
        h.check(bb.limit(), limit, "Wrong limit in byte buffer");
    }

    private void checkCharBuffer(TestHarness h, CharBuffer cb, int capacity2, int position2, int limit) {
        h.check(cb != null, "Char buffer is null");
        h.check(cb.capacity(), capacity2, "Wrong capacity in char buffer");
        h.check(cb.position(), position2, "Wrong position in char buffer");
        h.check(cb.limit(), limit, "Wrong limit in char buffer");
    }

    @Override
    public void test(TestHarness h) {
        Charset cs1 = Charset.forName("UTF-16");
        Charset cs2 = Charset.forName("US-ASCII");
        CharBuffer cb = CharBuffer.wrap("Hello World! Hello World! Hello World!");
        ByteBuffer bb = cs1.encode(cb);
        this.checkByteBuffer(h, bb, 152, 0, 78);
        this.checkCharBuffer(h, cb, 38, 38, 38);
        bb = cs2.encode(cb);
        this.checkByteBuffer(h, bb, 0, 0, 0);
    }
}

