/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Class;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isArray
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.checkClass(harness, "java.lang.Boolean", false);
        this.checkClass(harness, "java.lang.Character", false);
        this.checkClass(harness, "java.lang.Byte", false);
        this.checkClass(harness, "java.lang.Short", false);
        this.checkClass(harness, "java.lang.Integer", false);
        this.checkClass(harness, "java.lang.Long", false);
        this.checkClass(harness, "java.lang.Float", false);
        this.checkClass(harness, "java.lang.Double", false);
        this.checkClass(harness, "java.lang.Object", false);
        this.checkClass(harness, "[Z", true);
        this.checkClass(harness, "[C", true);
        this.checkClass(harness, "[B", true);
        this.checkClass(harness, "[S", true);
        this.checkClass(harness, "[I", true);
        this.checkClass(harness, "[J", true);
        this.checkClass(harness, "[F", true);
        this.checkClass(harness, "[D", true);
        this.checkClass(harness, "[Ljava.lang.Object;", true);
        this.checkClass(harness, "[[Z", true);
        this.checkClass(harness, "[[C", true);
        this.checkClass(harness, "[[B", true);
        this.checkClass(harness, "[[S", true);
        this.checkClass(harness, "[[I", true);
        this.checkClass(harness, "[[J", true);
        this.checkClass(harness, "[[F", true);
        this.checkClass(harness, "[[D", true);
        this.checkClass(harness, "[[Ljava.lang.Object;", true);
        this.checkClass(harness, "[[[Z", true);
        this.checkClass(harness, "[[[C", true);
        this.checkClass(harness, "[[[B", true);
        this.checkClass(harness, "[[[S", true);
        this.checkClass(harness, "[[[I", true);
        this.checkClass(harness, "[[[J", true);
        this.checkClass(harness, "[[[F", true);
        this.checkClass(harness, "[[[D", true);
        this.checkClass(harness, "[[[Ljava.lang.Object;", true);
    }

    public void checkClass(TestHarness harness, String className, boolean isArray2) {
        try {
            Class<?> c = Class.forName(className);
            harness.check(c.isArray() == isArray2);
        }
        catch (Exception e) {
            e.printStackTrace();
            harness.check(false);
        }
    }
}

