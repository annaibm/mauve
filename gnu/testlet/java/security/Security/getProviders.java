/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.Security;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.security.InvalidParameterException;
import java.security.Provider;
import java.security.Security;

public class getProviders
implements Testlet {
    Provider tom = new Tom();
    Provider dick = new Dick();
    Provider harry = new Harry();

    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("getProviders(String)");
        this.testNoProviders(harness);
        this.test1Provider(harness);
        this.test2Providers(harness);
        this.test3Providers(harness);
    }

    private void testNoProviders(TestHarness harness) {
        String filter2 = "NoService.NoAlgorithm";
        try {
            harness.check(Security.getProviders(filter2), null);
        }
        catch (Exception x) {
            harness.debug(x);
            harness.fail("testNoProviders.1: " + String.valueOf(x));
        }
    }

    private void test1Provider(TestHarness harness) {
        Provider[] providers;
        Security.addProvider(this.tom);
        String signature = "Security.getProvider(\"tom\")";
        try {
            Provider sameProvider = Security.getProvider("  Tom  ");
            harness.check(sameProvider != null, signature);
        }
        catch (Throwable x) {
            harness.fail(signature);
            harness.debug(x);
        }
        String filter2 = "NoService.NoAlgorithm";
        try {
            harness.check(Security.getProviders(filter2), null);
        }
        catch (Exception x) {
            harness.debug(x);
            harness.fail("test1Provider.2: " + String.valueOf(x));
        }
        filter2 = "CoffeeMaker.Foo";
        try {
            providers = Security.getProviders(filter2);
            if (providers == null || providers.length != 1) {
                harness.fail("Tom : getProviders(\"" + filter2 + "\")");
            } else {
                harness.check(providers[0], this.tom);
            }
        }
        catch (Exception x) {
            harness.debug(x);
            harness.fail("test1Provider.3: " + String.valueOf(x));
        }
        filter2 = "CoffeeMaker.FOO";
        try {
            providers = Security.getProviders(filter2);
            if (providers == null || providers.length != 1) {
                harness.fail("Tom : getProviders(\"" + filter2 + "\")");
            } else {
                harness.check(providers[0], this.tom);
            }
        }
        catch (Exception x) {
            harness.debug(x);
            harness.fail("test1Provider.4: " + String.valueOf(x));
        }
        filter2 = "CoffeeMakerFoo";
        try {
            providers = Security.getProviders(filter2);
            harness.fail("Tom : getProviders(\"" + filter2 + "\")");
        }
        catch (InvalidParameterException x) {
            harness.check(true);
        }
        catch (Exception x) {
            harness.debug(x);
            harness.fail("test1Provider.5: " + String.valueOf(x));
        }
        filter2 = "CoffeeMaker.Bar";
        try {
            providers = Security.getProviders(filter2);
            if (providers == null || providers.length != 1) {
                harness.fail("Tom : getProviders(\"" + filter2 + "\")");
            } else {
                harness.check(providers[0], this.tom);
            }
        }
        catch (Exception x) {
            harness.debug(x);
            harness.fail("test1Provider.6: " + String.valueOf(x));
        }
        filter2 = "CoffeeMaker.WHAT";
        try {
            providers = Security.getProviders(filter2);
            if (providers == null || providers.length != 1) {
                harness.fail("Tom : getProviders(\"" + filter2 + "\")");
            } else {
                harness.check(providers[0], this.tom);
            }
        }
        catch (Exception x) {
            harness.debug(x);
            harness.fail("test1Provider.7: " + String.valueOf(x));
        }
        filter2 = "CoffeeMaker.FOO ImplementedIn:vapourware";
        try {
            providers = Security.getProviders(filter2);
            if (providers == null || providers.length != 1) {
                harness.fail("Tom : getProviders(\"" + filter2 + "\")");
            } else {
                harness.check(providers[0], this.tom);
            }
        }
        catch (Exception x) {
            harness.debug(x);
            harness.fail("test1Provider.8: " + String.valueOf(x));
        }
        filter2 = "CoffeeMaker.FOO minCapacity:150";
        try {
            providers = Security.getProviders(filter2);
            if (providers == null || providers.length != 1) {
                harness.fail("Tom : getProviders(\"" + filter2 + "\")");
            } else {
                harness.check(providers[0], this.tom);
            }
        }
        catch (Exception x) {
            harness.debug(x);
            harness.fail("test1Provider.9: " + String.valueOf(x));
        }
    }

    private void test2Providers(TestHarness harness) {
        Provider[] providers;
        Security.addProvider(this.dick);
        String filter2 = "NoService.NoAlgorithm";
        filter2 = "CoffeeMaker.FOO ImplementedIn:vapourware";
        try {
            providers = Security.getProviders(filter2);
            if (providers == null || providers.length != 2 || providers[0] != this.tom && providers[1] != this.dick) {
                harness.fail("Tom, Dick : getProviders(\"" + filter2 + "\")");
            } else {
                harness.check(true);
            }
        }
        catch (Exception x) {
            harness.debug(x);
            harness.fail("test2Providers.1: " + String.valueOf(x));
        }
        filter2 = "CoffeeMaker.FOO minCapacity:150";
        try {
            providers = Security.getProviders(filter2);
            if (providers == null || providers.length != 2 || providers[0] != this.tom && providers[1] != this.dick) {
                harness.fail("Tom, Dick : getProviders(\"" + filter2 + "\")");
            } else {
                harness.check(true);
            }
        }
        catch (Exception x) {
            harness.debug(x);
            harness.fail("test2Providers.2: " + String.valueOf(x));
        }
    }

    private void test3Providers(TestHarness harness) {
        Provider[] p;
        Security.addProvider(this.harry);
        String filter2 = "NoService.NoAlgorithm";
        filter2 = "CoffeeMaker.FOO ImplementedIn:vapourware";
        try {
            p = Security.getProviders(filter2);
            if (p == null || p.length != 3 || p[0] != this.tom && p[1] != this.dick && p[2] != this.harry) {
                harness.fail("Tom, Dick, Harry : getProviders(\"" + filter2 + "\")");
            } else {
                harness.check(true);
            }
        }
        catch (Exception x) {
            harness.debug(x);
            harness.fail("test3Providers.1: " + String.valueOf(x));
        }
        filter2 = "CoffeeMaker.FOO minCapacity:150";
        try {
            p = Security.getProviders(filter2);
            if (p == null || p.length != 3 || p[0] != this.tom && p[1] != this.dick && p[2] != this.harry) {
                harness.fail("Tom, Dick, Harry : getProviders(\"" + filter2 + "\")");
            } else {
                harness.check(true);
            }
        }
        catch (Exception x) {
            harness.debug(x);
            harness.fail("test3Providers.2: " + String.valueOf(x));
        }
    }

    class Harry
    extends Provider {
        Harry() {
            super("Harry", 3.0, "");
            this.put("CoffeeMaker.Foo", "acme.crypto.FooSpi");
            this.put("CoffeeMaker.Foo ImplementedIn", "Vapourware");
            this.put("CoffeeMaker.Foo MinCapacity", "140");
            this.put("Alg.Alias.CoffeeMaker.bar", "fOO");
            this.put("Alg.Alias.CoffeeMaker.what", "bar");
        }
    }

    class Dick
    extends Provider {
        Dick() {
            super("Dick", 2.0, "");
            this.put("CoffeeMaker.Foo", "acme.crypto.FooSpi");
            this.put("CoffeeMaker.Foo ImplementedIn", "Vapourware");
            this.put("CoffeeMaker.Foo MinCapacity", "120");
            this.put("Alg.Alias.CoffeeMaker.bar", "fOO");
            this.put("Alg.Alias.CoffeeMaker.what", "bar");
        }
    }

    class Tom
    extends Provider {
        Tom() {
            super("Tom", 1.0, "");
            this.put("CoffeeMaker.Foo", "acme.crypto.FooSpi");
            this.put("CoffeeMaker.Foo ImplementedIn", "Vapourware");
            this.put("CoffeeMaker.Foo MinCapacity", "100");
            this.put("Alg.Alias.CoffeeMaker.bar", "fOO");
            this.put("Alg.Alias.CoffeeMaker.what", "bar");
        }
    }
}

