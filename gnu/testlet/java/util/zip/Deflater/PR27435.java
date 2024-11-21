/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.zip.Deflater;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.zip.Deflater;

public class PR27435
implements Testlet {
    public static final int BUFFER_SIZE = 0x500000;

    @Override
    public void test(TestHarness harness) {
        byte[] inputBytes = new byte[0x500000];
        byte[] compressedData = new byte[0x500000];
        for (int a = 0; a < inputBytes.length; ++a) {
            inputBytes[a] = 1;
        }
        Deflater deflater = new Deflater(1);
        deflater.setInput(inputBytes);
        deflater.finish();
        deflater.deflate(compressedData);
        harness.check(true);
    }
}

