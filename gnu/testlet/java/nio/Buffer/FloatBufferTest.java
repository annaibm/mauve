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
import java.nio.FloatBuffer;

public class FloatBufferTest
implements Testlet {
    @Override
    public void test(TestHarness h) {
        h.debug("Testing FloatBufferTest.allocate(int) Buffer");
        new PlainBufferTest().test(h, new BufferFactory(){

            @Override
            public Buffer newInstance() {
                return FloatBuffer.allocate(10);
            }
        });
        h.debug("Testing FloatBufferTest.wrap(float[]) Buffer");
        new PlainBufferTest().test(h, new BufferFactory(){

            @Override
            public Buffer newInstance() {
                return FloatBuffer.wrap(new float[10]);
            }
        });
        h.debug("Testing FloatBufferTest.wrap(float[], int, int) Buffer");
        new WrappedWithOffsetBufferTest().test(h, new BufferFactory(){

            @Override
            public Buffer newInstance() {
                return FloatBuffer.wrap(new float[20], 10, 10);
            }
        });
    }
}

