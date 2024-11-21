/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.MessageDigest;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;

public class Instance
extends Provider
implements Testlet {
    static final String NAME = "Mauve-Test-Provider-Digest";
    static final double VERSION = 3.14;
    static final String INFO = "Mauve Info-Test implements MauveDigest";
    TestHarness harness;

    public Instance() {
        super(NAME, 3.14, INFO);
        this.put("MessageDigest.MauveDigest", "gnu.testlet.java.security.MessageDigest.MauveDigest");
        this.put("Alg.Alias.MessageDigest.MauveAlias", "MauveDigest");
    }

    void checkDigest(String name2) {
        this.checkDigest(name2, null);
    }

    void checkDigest(String name2, String provider2) {
        MessageDigest d;
        String checkPoint = name2 + (provider2 == null ? "" : " " + provider2);
        this.harness.checkPoint(checkPoint);
        try {
            d = provider2 == null ? MessageDigest.getInstance(name2) : MessageDigest.getInstance(name2, provider2);
        }
        catch (GeneralSecurityException gse) {
            this.harness.fail(checkPoint + " caught " + gse);
            return;
        }
        this.harness.check(d.getAlgorithm(), (Object)name2);
        this.harness.check(d.getProvider(), this);
        d.reset();
        byte[] digest = d.digest();
        this.harness.check(digest.length, 0);
        byte[] message = new byte[]{0, 1, 2, 3};
        digest = d.digest(message);
        this.harness.check(MessageDigest.isEqual(digest, message));
        d.update((byte)6);
        byte[] bs = d.digest();
        this.harness.check(bs[0], 6);
    }

    @Override
    public void test(TestHarness h) {
        this.harness = h;
        Security.addProvider(this);
        this.checkDigest("MauveDigest");
        this.checkDigest("MAUVEDIGEST");
        this.checkDigest("MauveAlias");
        this.checkDigest("MAUVEALIAS");
        this.checkDigest("MauveDigest", NAME);
        this.checkDigest("MAUVEDIGEST", NAME);
        this.checkDigest("MauveAlias", NAME);
        this.checkDigest("MAUVEALIAS", NAME);
    }
}

