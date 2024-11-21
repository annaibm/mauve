/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.nio.charset.Charset;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;

public class UTF8Charset
implements Testlet {
    @Override
    public void test(TestHarness h) {
        int first_chunk_size = 4;
        int second_chunk_size = 3;
        byte[] inBytes = new byte[7];
        for (int i = 0; i < inBytes.length; ++i) {
            inBytes[i] = 88;
        }
        ByteBuffer inBuffer = ByteBuffer.wrap(inBytes);
        CharBuffer outBuffer1 = CharBuffer.allocate(4);
        CharBuffer outBuffer2 = CharBuffer.allocate(3);
        Charset utf8Charset = Charset.forName("UTF-8");
        CharsetDecoder decoder = utf8Charset.newDecoder();
        CoderResult coderResult1 = decoder.decode(inBuffer, outBuffer1, false);
        h.check(coderResult1.isOverflow(), "Expected decoder to return overflow status");
        h.check(4 == inBuffer.position(), "Expected input buffer position to be 4, but it is " + inBuffer.position());
        CoderResult coderResult2 = decoder.decode(inBuffer, outBuffer2, false);
        h.check(coderResult2.isUnderflow(), "Expected decoder to return underflow status");
        h.check(7 == inBuffer.position(), "Expected input buffer position to be 7, but it is " + inBuffer.position());
    }
}

