/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.imageio.stream.IIOByteBuffer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.imageio.stream.IIOByteBuffer;

public class setData
implements Testlet {
    @Override
    public void test(TestHarness h) {
        byte[] b1 = new byte[]{1, 2, 3};
        byte[] b2 = new byte[]{1, 2, 3};
        IIOByteBuffer buf = new IIOByteBuffer(b1, 0, 1);
        buf.setData(b2);
        h.check(buf.getData() == b2);
        buf.setData(null);
        h.check(buf.getData(), null);
    }
}

