/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.BufferedInputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ZeroRead
extends InputStream
implements Testlet {
    @Override
    public int read() throws IOException {
        throw new IOException();
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        if (len == 0) {
            return 0;
        }
        throw new IOException();
    }

    @Override
    public void test(TestHarness harness) {
        try {
            BufferedInputStream bis = new BufferedInputStream(this);
            harness.check(bis.read(new byte[0], 0, 0) == 0);
        }
        catch (IOException e) {
            harness.debug(e);
            harness.check(false);
        }
    }
}

