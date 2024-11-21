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
import java.nio.ShortBuffer;

public class ShortBufferTest
implements Testlet {
    @Override
    public void test(TestHarness h) {
        h.debug("Testing ShortBufferTest.allocate(int) Buffer");
        new PlainBufferTest().test(h, new BufferFactory(){

            @Override
            public Buffer newInstance() {
                return ShortBuffer.allocate(10);
            }
        });
        h.debug("Testing ShortBufferTest.wrap(short[]) Buffer");
        new PlainBufferTest().test(h, new BufferFactory(){

            @Override
            public Buffer newInstance() {
                return ShortBuffer.wrap(new short[10]);
            }
        });
        h.debug("Testing ShortBufferTest.wrap(short[], int, int) Buffer");
        new WrappedWithOffsetBufferTest().test(h, new BufferFactory(){

            @Override
            public Buffer newInstance() {
                return ShortBuffer.wrap(new short[20], 10, 10);
            }
        });
    }
}

