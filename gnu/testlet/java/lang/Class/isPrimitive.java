/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Class;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isPrimitive
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(Boolean.TYPE.isPrimitive(), true);
        harness.check(Character.TYPE.isPrimitive(), true);
        harness.check(Byte.TYPE.isPrimitive(), true);
        harness.check(Short.TYPE.isPrimitive(), true);
        harness.check(Integer.TYPE.isPrimitive(), true);
        harness.check(Long.TYPE.isPrimitive(), true);
        harness.check(Float.TYPE.isPrimitive(), true);
        harness.check(Double.TYPE.isPrimitive(), true);
        harness.check(Void.TYPE.isPrimitive(), true);
        this.checkClass(harness, "java.lang.Boolean", false);
        this.checkClass(harness, "java.lang.Character", false);
        this.checkClass(harness, "java.lang.Byte", false);
        this.checkClass(harness, "java.lang.Short", false);
        this.checkClass(harness, "java.lang.Integer", false);
        this.checkClass(harness, "java.lang.Long", false);
        this.checkClass(harness, "java.lang.Float", false);
        this.checkClass(harness, "java.lang.Double", false);
        this.checkClass(harness, "java.lang.Object", false);
        this.checkClass(harness, "[Z", false);
        this.checkClass(harness, "[C", false);
        this.checkClass(harness, "[B", false);
        this.checkClass(harness, "[S", false);
        this.checkClass(harness, "[I", false);
        this.checkClass(harness, "[J", false);
        this.checkClass(harness, "[F", false);
        this.checkClass(harness, "[D", false);
        this.checkClass(harness, "[Ljava.lang.Object;", false);
        this.checkClass(harness, "[[Z", false);
        this.checkClass(harness, "[[C", false);
        this.checkClass(harness, "[[B", false);
        this.checkClass(harness, "[[S", false);
        this.checkClass(harness, "[[I", false);
        this.checkClass(harness, "[[J", false);
        this.checkClass(harness, "[[F", false);
        this.checkClass(harness, "[[D", false);
        this.checkClass(harness, "[[Ljava.lang.Object;", false);
        this.checkClass(harness, "[[[Z", false);
        this.checkClass(harness, "[[[C", false);
        this.checkClass(harness, "[[[B", false);
        this.checkClass(harness, "[[[S", false);
        this.checkClass(harness, "[[[I", false);
        this.checkClass(harness, "[[[J", false);
        this.checkClass(harness, "[[[F", false);
        this.checkClass(harness, "[[[D", false);
        this.checkClass(harness, "[[[Ljava.lang.Object;", false);
    }

    public void checkClass(TestHarness harness, String className, boolean isPrimitive2) {
        try {
            Class<?> c = Class.forName(className);
            harness.check(c.isPrimitive() == isPrimitive2);
        }
        catch (Exception e) {
            e.printStackTrace();
            harness.check(false);
        }
    }
}

