/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Class;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class reflect2
implements Testlet {
    private TestHarness harness;
    private Class help;
    private Class help2;
    private Class help_inner;
    private Class help2_inner;
    private Class help2_inner_inner;

    public Class getClass(String name2) {
        try {
            return Class.forName(name2);
        }
        catch (Throwable ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void test_getClasses() {
        this.harness.checkPoint("getClasses");
        Class<?>[] inner2 = new Object().getClass().getClasses();
        this.harness.check(inner2.length == 0);
        inner2 = this.help.getClasses();
        this.harness.check(inner2.length == 1 && inner2[0].equals(this.help_inner));
        inner2 = this.help2.getClasses();
        this.harness.check(inner2.length == 3);
        inner2 = this.help_inner.getClasses();
        this.harness.check(inner2.length == 0);
        inner2 = this.help2_inner.getClasses();
        this.harness.check(inner2.length == 1 && inner2[0].equals(this.help2_inner_inner));
        inner2 = this.help2_inner_inner.getClasses();
        this.harness.check(inner2.length == 0);
    }

    public void test_getDeclaringClass() {
        this.harness.checkPoint("getDeclaringClass");
        Class<?> outer = this.help.getDeclaringClass();
        this.harness.check(outer == null);
        outer = this.help2.getDeclaringClass();
        this.harness.check(outer == null);
        outer = this.help_inner.getDeclaringClass();
        this.harness.check(outer != null && outer.equals(this.help));
        outer = this.help2_inner.getDeclaringClass();
        this.harness.check(outer != null && outer.equals(this.help2));
        outer = this.help2_inner_inner.getDeclaringClass();
        this.harness.check(outer != null && outer.equals(this.help2_inner));
    }

    public void test_getDeclaredClasses() {
        this.harness.checkPoint("getDeclaredClasses");
        Class<?>[] inner2 = this.help.getDeclaredClasses();
        this.harness.check(inner2.length == 1 && inner2[0].equals(this.help_inner));
        inner2 = this.help2.getDeclaredClasses();
        this.harness.check(inner2.length == 8);
        inner2 = this.help2_inner.getDeclaredClasses();
        this.harness.check(inner2.length == 1 && inner2[0].equals(this.help2_inner_inner));
        inner2 = this.help2_inner_inner.getDeclaredClasses();
        this.harness.check(inner2.length == 0);
    }

    @Override
    public void test(TestHarness harness) {
        this.harness = harness;
        this.help = this.getClass("gnu.testlet.java.lang.Class.rf_help");
        this.help2 = this.getClass("gnu.testlet.java.lang.Class.rf2_help");
        this.help_inner = this.getClass("gnu.testlet.java.lang.Class.rf_help$inner");
        this.help2_inner = this.getClass("gnu.testlet.java.lang.Class.rf2_help$inner_class_1");
        this.help2_inner_inner = this.getClass("gnu.testlet.java.lang.Class.rf2_help$inner_class_1$inner_inner_class_1");
        this.test_getClasses();
        this.test_getDeclaringClass();
        this.test_getDeclaredClasses();
    }
}

