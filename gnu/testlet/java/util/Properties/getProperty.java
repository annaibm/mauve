/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Properties;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Properties;

public class getProperty
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Properties1 p1 = new Properties1();
        p1.setProperty("key", "value");
        p1.called = false;
        p1.getProperty("key", "default");
        harness.check(p1.called, true, "getProperty(String, String) calls getProperty(String)");
        Properties2 p2 = new Properties2();
        p2.setProperty("key", "value");
        p2.called = false;
        p2.getProperty("key");
        harness.check(p2.called, false, "getProperty(String) does not call getProperty(String, String)");
        Properties3 p3 = new Properties3();
        p3.setProperty("key", "value");
        try {
            p3.getProperty("key", "def");
            harness.check(true, "overriding getProperty(String, String) must not  lead to inifinite recursion.");
        }
        catch (Throwable ex) {
            harness.fail("overriding getProperty(String, String) must not  lead to inifinite recursion.");
        }
    }

    static class Properties3
    extends Properties {
        Properties3() {
        }

        @Override
        public String getProperty(String key, String def) {
            return this.getProperty(key + "." + def);
        }
    }

    static class Properties2
    extends Properties {
        boolean called = false;

        Properties2() {
        }

        @Override
        public String getProperty(String key, String def) {
            this.called = true;
            return super.getProperty(key, def);
        }
    }

    static class Properties1
    extends Properties {
        boolean called = false;

        Properties1() {
        }

        @Override
        public String getProperty(String key) {
            this.called = true;
            return super.getProperty(key);
        }
    }
}

