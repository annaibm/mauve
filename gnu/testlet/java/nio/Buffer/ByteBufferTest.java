/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.nio.Buffer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.nio.Buffer.BufferFactory;
import gnu.testlet.java.nio.Buffer.PlainBufferTest;
import gnu.testlet.java.nio.Buffer.WrappedWithOffsetBufferTest;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class ByteBufferTest
implements Testlet {
    @Override
    public void test(TestHarness h) {
        h.debug("Testing ByteBuffer.allocate(int) Buffer");
        new PlainBufferTest().test(h, new BufferFactory(){

            @Override
            public Buffer newInstance() {
                return ByteBuffer.allocate(10);
            }
        });
        h.debug("Testing ByteBuffer.allocateDirect(int) Buffer");
        new PlainBufferTest().test(h, new BufferFactory(){

            @Override
            public Buffer newInstance() {
                return ByteBuffer.allocateDirect(10);
            }
        });
        h.debug("Testing ByteBuffer.wrap(byte[]) Buffer");
        new PlainBufferTest().test(h, new BufferFactory(){

            @Override
            public Buffer newInstance() {
                return ByteBuffer.wrap(new byte[10]);
            }
        });
        h.debug("Testing ByteBuffer.wrap(byte[], int, int) Buffer");
        new WrappedWithOffsetBufferTest().test(h, new BufferFactory(){

            @Override
            public Buffer newInstance() {
                return ByteBuffer.wrap(new byte[20], 10, 10);
            }
        });
    }
}

