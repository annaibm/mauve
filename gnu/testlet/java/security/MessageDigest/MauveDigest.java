/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.MessageDigest;

import java.security.MessageDigestSpi;

public class MauveDigest
extends MessageDigestSpi {
    private byte[] digest;

    @Override
    public void engineUpdate(byte b) {
        this.digest = new byte[1];
        this.digest[0] = b;
    }

    @Override
    public void engineUpdate(byte[] bs, int off, int len) {
        this.digest = new byte[len];
        System.arraycopy(bs, off, this.digest, 0, len);
    }

    @Override
    public byte[] engineDigest() {
        return this.digest;
    }

    @Override
    public void engineReset() {
        this.digest = new byte[0];
    }
}

