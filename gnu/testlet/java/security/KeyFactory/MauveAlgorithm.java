/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.KeyFactory;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public class MauveAlgorithm
extends KeyFactorySpi {
    @Override
    protected PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        return null;
    }

    @Override
    protected PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        return null;
    }

    protected KeySpec engineGetKeySpec(Key key, Class keySpec) throws InvalidKeySpecException {
        return null;
    }

    @Override
    protected Key engineTranslateKey(Key key) throws InvalidKeyException {
        return null;
    }
}

