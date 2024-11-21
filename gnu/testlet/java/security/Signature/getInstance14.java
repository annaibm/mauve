/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.Signature;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;

public class getInstance14
extends Provider
implements Testlet {
    public getInstance14() {
        super("self", 1.0, "");
        this.put("Signature.foo", "gnu.testlet.java.security.Signature.MauveSignature");
        this.put("Alg.Alias.Signature.bar", "foo");
    }

    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("KeyPairGenerator");
        getInstance14 provider2 = new getInstance14();
        Security.addProvider(provider2);
        Signature spi = null;
        String signature = "getInstance(\"foo\", provider)";
        try {
            spi = Signature.getInstance("foo", provider2);
            harness.check(spi != null, signature);
        }
        catch (NoSuchAlgorithmException x) {
            harness.fail(signature);
            harness.debug(x);
        }
        spi = null;
        signature = "getInstance(\"FOO\", provider)";
        try {
            spi = Signature.getInstance("FOO", provider2);
            harness.check(spi != null, signature);
        }
        catch (NoSuchAlgorithmException x) {
            harness.fail(signature);
            harness.debug(x);
        }
        spi = null;
        signature = "getInstance(\"bar\", provider)";
        try {
            spi = Signature.getInstance("bar", provider2);
            harness.check(spi != null, signature);
        }
        catch (NoSuchAlgorithmException x) {
            harness.fail(signature);
            harness.debug(x);
        }
        spi = null;
        signature = "getInstance(\"BAR\", provider)";
        try {
            spi = Signature.getInstance("BAR", provider2);
            harness.check(spi != null, signature);
        }
        catch (NoSuchAlgorithmException x) {
            harness.fail(signature);
            harness.debug(x);
        }
    }
}

