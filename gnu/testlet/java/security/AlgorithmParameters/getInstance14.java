/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.AlgorithmParameters;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.security.AlgorithmParameters;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;

public class getInstance14
extends Provider
implements Testlet {
    public getInstance14() {
        super("AlgorithmParameters", 1.0, "");
        this.put("AlgorithmParameters.foo", "gnu.testlet.java.security.AlgorithmParameters.MauveAlgorithm");
        this.put("Alg.Alias.AlgorithmParameters.bar", "foo");
    }

    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("AlgorithmParameters");
        getInstance14 provider2 = this;
        Security.addProvider(provider2);
        AlgorithmParameters spi = null;
        String signature = "getInstance(\"foo\", provider)";
        try {
            spi = AlgorithmParameters.getInstance("foo", provider2);
            harness.check(spi != null, signature);
        }
        catch (NoSuchAlgorithmException x) {
            harness.fail(signature);
            harness.debug(x);
        }
        spi = null;
        signature = "getInstance(\"FOO\", provider)";
        try {
            spi = AlgorithmParameters.getInstance("FOO", provider2);
            harness.check(spi != null, signature);
        }
        catch (NoSuchAlgorithmException x) {
            harness.fail(signature);
            harness.debug(x);
        }
        spi = null;
        signature = "getInstance(\"bar\", provider)";
        try {
            spi = AlgorithmParameters.getInstance("bar", provider2);
            harness.check(spi != null, signature);
        }
        catch (NoSuchAlgorithmException x) {
            harness.fail(signature);
            harness.debug(x);
        }
        spi = null;
        signature = "getInstance(\"BAR\", provider)";
        try {
            spi = AlgorithmParameters.getInstance("BAR", provider2);
            harness.check(spi != null, signature);
        }
        catch (NoSuchAlgorithmException x) {
            harness.fail(signature);
            harness.debug(x);
        }
    }
}

