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
import java.nio.IntBuffer;

public class IntBufferTest
implements Testlet {
    @Override
    public void test(TestHarness h) {
        h.debug("Testing IntBufferTest.allocate(int) Buffer");
        new PlainBufferTest().test(h, new BufferFactory(){

            @Override
            public Buffer newInstance() {
                return IntBuffer.allocate(10);
            }
        });
        h.debug("Testing IntBufferTest.wrap(int[]) Buffer");
        new PlainBufferTest().test(h, new BufferFactory(){

            @Override
            public Buffer newInstance() {
                return IntBuffer.wrap(new int[10]);
            }
        });
        h.debug("Testing IntBufferTest.wrap(int[], int, int) Buffer");
        new WrappedWithOffsetBufferTest().test(h, new BufferFactory(){

            @Override
            public Buffer newInstance() {
                return IntBuffer.wrap(new int[20], 10, 10);
            }
        });
    }
}

