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
import java.nio.LongBuffer;

public class LongBufferTest
implements Testlet {
    @Override
    public void test(TestHarness h) {
        h.debug("Testing LongBufferTest.allocate(int) Buffer");
        new PlainBufferTest().test(h, new BufferFactory(){

            @Override
            public Buffer newInstance() {
                return LongBuffer.allocate(10);
            }
        });
        h.debug("Testing LongBufferTest.wrap(long[]) Buffer");
        new PlainBufferTest().test(h, new BufferFactory(){

            @Override
            public Buffer newInstance() {
                return LongBuffer.wrap(new long[10]);
            }
        });
        h.debug("Testing LongBufferTest.wrap(long[], int, int) Buffer");
        new WrappedWithOffsetBufferTest().test(h, new BufferFactory(){

            @Override
            public Buffer newInstance() {
                return LongBuffer.wrap(new long[20], 10, 10);
            }
        });
    }
}

