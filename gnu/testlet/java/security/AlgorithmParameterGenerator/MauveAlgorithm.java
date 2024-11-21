/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.AlgorithmParameterGenerator;

import java.security.AlgorithmParameterGeneratorSpi;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

public class MauveAlgorithm
extends AlgorithmParameterGeneratorSpi {
    @Override
    protected void engineInit(int size2, SecureRandom random) {
    }

    @Override
    protected void engineInit(AlgorithmParameterSpec genParamSpec, SecureRandom random) throws InvalidAlgorithmParameterException {
    }

    @Override
    protected AlgorithmParameters engineGenerateParameters() {
        return null;
    }
}

