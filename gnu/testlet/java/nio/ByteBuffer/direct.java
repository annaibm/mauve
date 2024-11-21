/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.nio.ByteBuffer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class direct
implements Testlet {
    @Override
    public void test(TestHarness h) {
        ByteBuffer bb = ByteBuffer.allocate(1024);
        h.check(!bb.isDirect(), "non-direct byte buffer");
        IntBuffer ib = bb.asIntBuffer();
        h.check(!ib.isDirect(), "int buffer view on non-direct byte buffer");
        bb = ByteBuffer.allocateDirect(1024);
        h.check(bb.isDirect(), "direct byte buffer");
        ib = bb.asIntBuffer();
        h.check(ib.isDirect(), "int buffer view on direct byte buffer");
    }
}

