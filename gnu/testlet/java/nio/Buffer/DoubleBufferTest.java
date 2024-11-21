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
import java.nio.DoubleBuffer;

public class DoubleBufferTest
implements Testlet {
    @Override
    public void test(TestHarness h) {
        h.debug("Testing DoubleBufferTest.allocate(int) Buffer");
        new PlainBufferTest().test(h, new BufferFactory(){

            @Override
            public Buffer newInstance() {
                return DoubleBuffer.allocate(10);
            }
        });
        h.debug("Testing DoubleBufferTest.wrap(double[]) Buffer");
        new PlainBufferTest().test(h, new BufferFactory(){

            @Override
            public Buffer newInstance() {
                return DoubleBuffer.wrap(new double[10]);
            }
        });
        h.debug("Testing DoubleBufferTest.wrap(double[], int, int) Buffer");
        new WrappedWithOffsetBufferTest().test(h, new BufferFactory(){

            @Override
            public Buffer newInstance() {
                return DoubleBuffer.wrap(new double[20], 10, 10);
            }
        });
    }
}

