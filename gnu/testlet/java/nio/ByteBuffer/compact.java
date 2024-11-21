/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.nio.ByteBuffer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.nio.ByteBuffer;

public class compact
implements Testlet {
    @Override
    public void test(TestHarness h) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.position(0);
        buffer.limit(3);
        buffer.compact();
        h.check(buffer.position(), 3, "position after compact()");
        h.check(buffer.limit(), 10, "limit after compact()");
        buffer = ByteBuffer.allocateDirect(10);
        buffer.position(0);
        buffer.limit(3);
        buffer.compact();
        h.check(buffer.position(), 3, "position after compact()");
        h.check(buffer.limit(), 10, "limit after compact()");
    }
}

