/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.AlgorithmParameters;

import java.io.IOException;
import java.security.AlgorithmParametersSpi;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;

public class MauveAlgorithm
extends AlgorithmParametersSpi {
    @Override
    protected void engineInit(AlgorithmParameterSpec paramSpec) throws InvalidParameterSpecException {
    }

    @Override
    protected void engineInit(byte[] params) throws IOException {
    }

    @Override
    protected void engineInit(byte[] params, String format2) throws IOException {
    }

    protected AlgorithmParameterSpec engineGetParameterSpec(Class paramSpec) throws InvalidParameterSpecException {
        return null;
    }

    @Override
    protected byte[] engineGetEncoded() throws IOException {
        return new byte[0];
    }

    @Override
    protected byte[] engineGetEncoded(String format2) throws IOException {
        return new byte[0];
    }

    @Override
    protected String engineToString() {
        return null;
    }
}

