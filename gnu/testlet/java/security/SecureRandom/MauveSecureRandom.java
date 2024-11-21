/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.SecureRandom;

import java.security.SecureRandomSpi;

public class MauveSecureRandom
extends SecureRandomSpi {
    private byte[] seed;

    @Override
    protected void engineSetSeed(byte[] seed) {
        this.seed = seed;
    }

    @Override
    public void engineNextBytes(byte[] random) {
        for (int i = 0; i < random.length; ++i) {
            random[i] = this.seed[i];
        }
    }

    @Override
    public byte[] engineGenerateSeed(int n) {
        return this.seed;
    }
}

