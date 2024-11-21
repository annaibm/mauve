/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.BufferedOutputStream;

import java.io.InterruptedIOException;
import java.io.OutputStream;

public class helper
extends OutputStream {
    int count;
    int stop;

    public helper(int size2) {
        this.stop = size2;
    }

    private void update(int howmuch) throws InterruptedIOException {
        if (this.count + howmuch > this.stop) {
            InterruptedIOException ioe = new InterruptedIOException();
            ioe.bytesTransferred = this.stop - this.count;
            this.count = this.stop;
            throw ioe;
        }
        this.count += howmuch;
    }

    @Override
    public void write(int b) throws InterruptedIOException {
        this.update(1);
    }

    @Override
    public void write(byte[] b, int off, int len) throws InterruptedIOException {
        if (off < 0 || len < 0 || off + len > b.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.update(len);
    }
}

