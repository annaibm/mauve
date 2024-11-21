/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.imageio.stream.IIOByteBuffer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.imageio.stream.IIOByteBuffer;

public class setLength
implements Testlet {
    @Override
    public void test(TestHarness h) {
        byte[] b1 = new byte[]{1, 2, 3};
        IIOByteBuffer buf = new IIOByteBuffer(b1, 0, 1);
        buf.setLength(2);
        h.check(buf.getLength(), 2);
        buf.setLength(99);
        h.check(buf.getLength(), 99);
        buf.setLength(-42);
        h.check(buf.getLength(), -42);
    }
}

