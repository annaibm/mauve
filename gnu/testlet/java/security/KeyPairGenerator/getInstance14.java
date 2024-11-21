/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.KeyPairGenerator;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;

public class getInstance14
extends Provider
implements Testlet {
    public getInstance14() {
        super("KeyPairGenerator", 1.0, "");
        this.put("KeyPairGenerator.foo", "gnu.testlet.java.security.KeyPairGenerator.MauveAlgorithm");
        this.put("Alg.Alias.KeyPairGenerator.bar", "foo");
    }

    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("KeyPairGenerator");
        getInstance14 provider2 = this;
        Security.addProvider(provider2);
        KeyPairGenerator spi = null;
        String signature = "getInstance(\"foo\", provider)";
        try {
            spi = KeyPairGenerator.getInstance("foo", provider2);
            harness.check(spi != null, signature);
        }
        catch (NoSuchAlgorithmException x) {
            harness.fail(signature);
            harness.debug(x);
        }
        spi = null;
        signature = "getInstance(\"FOO\", provider)";
        try {
            spi = KeyPairGenerator.getInstance("FOO", provider2);
            harness.check(spi != null, signature);
        }
        catch (NoSuchAlgorithmException x) {
            harness.fail(signature);
            harness.debug(x);
        }
        spi = null;
        signature = "getInstance(\"bar\", provider)";
        try {
            spi = KeyPairGenerator.getInstance("bar", provider2);
            harness.check(spi != null, signature);
        }
        catch (NoSuchAlgorithmException x) {
            harness.fail(signature);
            harness.debug(x);
        }
        spi = null;
        signature = "getInstance(\"BAR\", provider)";
        try {
            spi = KeyPairGenerator.getInstance("BAR", provider2);
            harness.check(spi != null, signature);
        }
        catch (NoSuchAlgorithmException x) {
            harness.fail(signature);
            harness.debug(x);
        }
        Security.removeProvider("KeyPairGenerator");
    }
}

