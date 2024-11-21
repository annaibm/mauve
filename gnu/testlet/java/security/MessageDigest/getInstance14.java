/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.MessageDigest;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;

public class getInstance14
extends Provider
implements Testlet {
    public getInstance14() {
        super("MessageDigest", 1.0, "");
        this.put("MessageDigest.foo", "gnu.testlet.java.security.MessageDigest.MauveDigest");
        this.put("Alg.Alias.MessageDigest.bar", "foo");
    }

    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("MessageDigest");
        getInstance14 provider2 = this;
        Security.addProvider(provider2);
        MessageDigest spi = null;
        String signature = "getInstance(\"foo\", \"  MessageDigest  \")";
        try {
            spi = MessageDigest.getInstance("foo", "  MessageDigest  ");
            harness.check(spi != null, signature);
        }
        catch (GeneralSecurityException x) {
            harness.fail(signature);
            harness.debug(x);
        }
        spi = null;
        signature = "getInstance(\"foo\", provider)";
        try {
            spi = MessageDigest.getInstance("foo", provider2);
            harness.check(spi != null, signature);
        }
        catch (NoSuchAlgorithmException x) {
            harness.fail(signature);
            harness.debug(x);
        }
        spi = null;
        signature = "getInstance(\"  foo  \", provider)";
        try {
            spi = MessageDigest.getInstance("  foo  ", provider2);
            harness.check(spi != null, signature);
        }
        catch (NoSuchAlgorithmException x) {
            harness.fail(signature);
            harness.debug(x);
        }
        spi = null;
        signature = "getInstance(\"FOO\", provider)";
        try {
            spi = MessageDigest.getInstance("FOO", provider2);
            harness.check(spi != null, signature);
        }
        catch (NoSuchAlgorithmException x) {
            harness.fail(signature);
            harness.debug(x);
        }
        spi = null;
        signature = "getInstance(\"bar\", provider)";
        try {
            spi = MessageDigest.getInstance("bar", provider2);
            harness.check(spi != null, signature);
        }
        catch (NoSuchAlgorithmException x) {
            harness.fail(signature);
            harness.debug(x);
        }
        spi = null;
        signature = "getInstance(\"BAR\", provider)";
        try {
            spi = MessageDigest.getInstance("BAR", provider2);
            harness.check(spi != null, signature);
        }
        catch (NoSuchAlgorithmException x) {
            harness.fail(signature);
            harness.debug(x);
        }
    }
}

