/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.Signature;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;

public class Instance
extends Provider
implements Testlet {
    static final String NAME = "Mauve-Test-Provider-Signature";
    static final double VERSION = 3.14;
    static final String INFO = "Mauve Info-Test implements MauveSignature";
    TestHarness harness;

    public Instance() {
        super(NAME, 3.14, INFO);
        this.put("Signature.MauveSignature", "gnu.testlet.java.security.Signature.MauveSignature");
        this.put("Alg.Alias.Signature.MauveAlias", "MauveSignature");
    }

    void checkSignature(String name2) {
        this.checkSignature(name2, null);
    }

    void checkSignature(String name2, String provider2) {
        Signature s;
        String checkPoint = name2 + (provider2 == null ? "" : " " + provider2);
        this.harness.checkPoint(checkPoint);
        try {
            s = provider2 == null ? Signature.getInstance(name2) : Signature.getInstance(name2, provider2);
        }
        catch (GeneralSecurityException gse) {
            this.harness.fail(checkPoint + " instance caught " + gse);
            return;
        }
        this.harness.check(s.getAlgorithm(), (Object)name2);
        this.harness.check(s.getProvider(), this);
        try {
            s.initSign(null);
            s.update((byte)6);
            byte[] sign = s.sign();
            this.harness.check(sign[0], 6);
            s.initVerify((PublicKey)null);
            byte[] message = new byte[]{0, 1, 2, 3};
            s.update(message);
            this.harness.check(s.verify(message));
        }
        catch (GeneralSecurityException gse) {
            this.harness.fail(checkPoint + " dummy caught " + gse);
        }
    }

    @Override
    public void test(TestHarness h) {
        this.harness = h;
        Security.addProvider(this);
        this.checkSignature("MauveSignature");
        this.checkSignature("MAUVESignature");
        this.checkSignature("MauveAlias");
        this.checkSignature("MAUVEALIAS");
        this.checkSignature("MauveSignature", NAME);
        this.checkSignature("MAUVESIGNATURE", NAME);
        this.checkSignature("MauveAlias", NAME);
        this.checkSignature("MAUVEALIAS", NAME);
    }
}

