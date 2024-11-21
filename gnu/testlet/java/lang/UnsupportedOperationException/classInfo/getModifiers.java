/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.UnsupportedOperationException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Modifier;

public class getModifiers
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        UnsupportedOperationException o = new UnsupportedOperationException("java.lang.UnsupportedOperationException");
        Class<?> c = o.getClass();
        int modifiers2 = c.getModifiers();
        harness.check(Modifier.isPublic(modifiers2));
        harness.check(!Modifier.isPrivate(modifiers2));
        harness.check(!Modifier.isProtected(modifiers2));
        harness.check(!Modifier.isAbstract(modifiers2));
        harness.check(!Modifier.isFinal(modifiers2));
        harness.check(!Modifier.isInterface(modifiers2));
        harness.check(!Modifier.isNative(modifiers2));
        harness.check(!Modifier.isStatic(modifiers2));
        harness.check(!Modifier.isStrict(modifiers2));
        harness.check(!Modifier.isSynchronized(modifiers2));
        harness.check(!Modifier.isTransient(modifiers2));
        harness.check(!Modifier.isVolatile(modifiers2));
    }
}

