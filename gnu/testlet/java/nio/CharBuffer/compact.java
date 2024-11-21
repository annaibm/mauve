/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.nio.CharBuffer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class compact
implements Testlet {
    @Override
    public void test(TestHarness h) {
        CharBuffer buffer = CharBuffer.allocate(10);
        buffer.position(0);
        buffer.limit(3);
        buffer.compact();
        h.check(buffer.position(), 3, "position after compact()");
        h.check(buffer.limit(), 10, "limit after compact()");
        ByteBuffer bb = ByteBuffer.allocate(200);
        buffer = bb.asCharBuffer();
        buffer.position(0);
        buffer.limit(3);
        buffer.compact();
        h.check(buffer.position(), 3, "position after compact()");
        h.check(buffer.limit(), 100, "limit after compact()");
    }
}

