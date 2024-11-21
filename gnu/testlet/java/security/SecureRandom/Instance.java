/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.SecureRandom;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;

public class Instance
extends Provider
implements Testlet {
    static final String NAME = "Mauve-Test-Provider-SecureRandom";
    static final double VERSION = 3.14;
    static final String INFO = "Mauve Info-Test implements MauveSecureRandom";
    TestHarness harness;

    public Instance() {
        super(NAME, 3.14, INFO);
        this.put("SecureRandom.MauveSecureRandom", "gnu.testlet.java.security.SecureRandom.MauveSecureRandom");
        this.put("Alg.Alias.SecureRandom.MauveAlias", "MauveSecureRandom");
    }

    void checkSecureRandom(String name2) {
        this.checkSecureRandom(name2, null);
    }

    void checkSecureRandom(String name2, String provider2) {
        SecureRandom sr;
        String checkPoint = name2 + (provider2 == null ? "" : " " + provider2);
        this.harness.checkPoint(checkPoint);
        try {
            sr = provider2 == null ? SecureRandom.getInstance(name2) : SecureRandom.getInstance(name2, provider2);
        }
        catch (GeneralSecurityException gse) {
            this.harness.fail(checkPoint + " instance caught " + gse);
            return;
        }
        this.harness.check(sr.getProvider(), this);
        byte[] seed = new byte[]{42};
        sr.setSeed(seed);
        byte[] random = new byte[1];
        sr.nextBytes(random);
        this.harness.check(random[0], 42);
    }

    @Override
    public void test(TestHarness h) {
        this.harness = h;
        byte[] seed = new byte[]{42};
        SecureRandom sr = new SecureRandom();
        this.harness.check(sr != null);
        sr = new SecureRandom(seed);
        this.harness.check(sr != null);
        Security.addProvider(this);
        sr = new SecureRandom();
        this.harness.check(sr != null);
        sr = new SecureRandom(seed);
        this.harness.check(sr != null);
        this.checkSecureRandom("MauveSecureRandom");
        this.checkSecureRandom("MAUVESecurerandom");
        this.checkSecureRandom("MauveAlias");
        this.checkSecureRandom("MAUVEALIAS");
        this.checkSecureRandom("MauveSecureRandom", NAME);
        this.checkSecureRandom("MAUVESECURERANDOM", NAME);
        this.checkSecureRandom("MauveAlias", NAME);
        this.checkSecureRandom("MAUVEALIAS", NAME);
    }
}

