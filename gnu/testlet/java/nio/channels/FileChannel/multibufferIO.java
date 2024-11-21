/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.nio.channels.FileChannel;

import gnu.testlet.Testlet;
import gnu.testlet.java.nio.channels.FileChannel.multidirectbufferIO;
import java.nio.ByteBuffer;

public class multibufferIO
extends multidirectbufferIO
implements Testlet {
    private void initBuffer(ByteBuffer[] bs, byte[] data) {
        for (int i = 0; i < bs.length; ++i) {
            bs[i] = ByteBuffer.wrap(data);
        }
    }
}

