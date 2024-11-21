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
import java.nio.CharBuffer;

public class CharBufferTest
implements Testlet {
    @Override
    public void test(TestHarness h) {
        h.debug("Testing CharBufferTest.allocate(int) Buffer");
        new PlainBufferTest().test(h, new BufferFactory(){

            @Override
            public Buffer newInstance() {
                return CharBuffer.allocate(10);
            }
        });
        h.debug("Testing CharBufferTest.wrap(char[]) Buffer");
        new PlainBufferTest().test(h, new BufferFactory(){

            @Override
            public Buffer newInstance() {
                return CharBuffer.wrap(new char[10]);
            }
        });
        h.debug("Testing CharBufferTest.wrap(char[], int, int) Buffer");
        new WrappedWithOffsetBufferTest().test(h, new BufferFactory(){

            @Override
            public Buffer newInstance() {
                return CharBuffer.wrap(new char[20], 10, 10);
            }
        });
    }
}

