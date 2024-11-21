/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.imageio.stream.IIOByteBuffer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.imageio.stream.IIOByteBuffer;

public class setOffset
implements Testlet {
    @Override
    public void test(TestHarness h) {
        byte[] b1 = new byte[]{1, 2, 3};
        IIOByteBuffer buf = new IIOByteBuffer(b1, 0, 1);
        buf.setOffset(1);
        h.check(buf.getOffset(), 1);
        buf.setOffset(99);
        h.check(buf.getOffset(), 99);
        buf.setOffset(-42);
        h.check(buf.getOffset(), -42);
    }
}

