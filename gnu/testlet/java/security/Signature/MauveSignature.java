/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.Signature;

import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.SignatureSpi;

public class MauveSignature
extends SignatureSpi {
    private byte[] signature;

    @Override
    public Object engineGetParameter(String p) throws InvalidParameterException {
        throw new InvalidParameterException();
    }

    @Override
    public void engineSetParameter(String p, Object o) throws InvalidParameterException {
        throw new InvalidParameterException();
    }

    @Override
    public boolean engineVerify(byte[] sig) throws SignatureException {
        return sig.length > 2;
    }

    @Override
    public byte[] engineSign() throws SignatureException {
        return this.signature;
    }

    @Override
    public void engineUpdate(byte b) {
        this.signature = new byte[1];
        this.signature[0] = b;
    }

    @Override
    public void engineUpdate(byte[] bs, int off, int len) {
        this.signature = new byte[len];
        System.arraycopy(bs, off, this.signature, 0, len);
    }

    @Override
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
    }

    @Override
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
    }
}

