/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.AlgorithmParameterGenerator;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.security.AlgorithmParameterGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;

public class getInstance14
extends Provider
implements Testlet {
    public getInstance14() {
        super("AlgorithmParameterGenerator", 1.0, "");
        this.put("AlgorithmParameterGenerator.foo", "gnu.testlet.java.security.AlgorithmParameterGenerator.MauveAlgorithm");
        this.put("Alg.Alias.AlgorithmParameterGenerator.bar", "foo");
    }

    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("AlgorithmParameterGenerator");
        getInstance14 provider2 = this;
        Security.addProvider(provider2);
        AlgorithmParameterGenerator spi = null;
        String signature = "getInstance(\"foo\", provider)";
        try {
            spi = AlgorithmParameterGenerator.getInstance("foo", provider2);
            harness.check(spi != null, signature);
        }
        catch (NoSuchAlgorithmException x) {
            harness.fail(signature);
            harness.debug(x);
        }
        spi = null;
        signature = "getInstance(\"FOO\", provider)";
        try {
            spi = AlgorithmParameterGenerator.getInstance("FOO", provider2);
            harness.check(spi != null, signature);
        }
        catch (NoSuchAlgorithmException x) {
            harness.fail(signature);
            harness.debug(x);
        }
        spi = null;
        signature = "getInstance(\"bar\", provider)";
        try {
            spi = AlgorithmParameterGenerator.getInstance("bar", provider2);
            harness.check(spi != null, signature);
        }
        catch (NoSuchAlgorithmException x) {
            harness.fail(signature);
            harness.debug(x);
        }
        spi = null;
        signature = "getInstance(\"BAR\", provider)";
        try {
            spi = AlgorithmParameterGenerator.getInstance("BAR", provider2);
            harness.check(spi != null, signature);
        }
        catch (NoSuchAlgorithmException x) {
            harness.fail(signature);
            harness.debug(x);
        }
    }
}

