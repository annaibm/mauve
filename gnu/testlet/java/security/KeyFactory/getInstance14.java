/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.KeyFactory;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;

public class getInstance14
extends Provider
implements Testlet {
    public getInstance14() {
        super("KeyFactory", 1.0, "");
        this.put("KeyFactory.foo", "gnu.testlet.java.security.KeyFactory.MauveAlgorithm");
        this.put("Alg.Alias.KeyFactory.bar", "foo");
    }

    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("KeyFactory");
        getInstance14 provider2 = this;
        Security.addProvider(provider2);
        KeyFactory spi = null;
        String signature = "getInstance(\"foo\", provider)";
        try {
            spi = KeyFactory.getInstance("foo", provider2);
            harness.check(spi != null, signature);
        }
        catch (NoSuchAlgorithmException x) {
            harness.fail(signature);
            harness.debug(x);
        }
        spi = null;
        signature = "getInstance(\"FOO\", provider)";
        try {
            spi = KeyFactory.getInstance("FOO", provider2);
            harness.check(spi != null, signature);
        }
        catch (NoSuchAlgorithmException x) {
            harness.fail(signature);
            harness.debug(x);
        }
        spi = null;
        signature = "getInstance(\"bar\", provider)";
        try {
            spi = KeyFactory.getInstance("bar", provider2);
            harness.check(spi != null, signature);
        }
        catch (NoSuchAlgorithmException x) {
            harness.fail(signature);
            harness.debug(x);
        }
        spi = null;
        signature = "getInstance(\"BAR\", provider)";
        try {
            spi = KeyFactory.getInstance("BAR", provider2);
            harness.check(spi != null, signature);
        }
        catch (NoSuchAlgorithmException x) {
            harness.fail(signature);
            harness.debug(x);
        }
    }
}

