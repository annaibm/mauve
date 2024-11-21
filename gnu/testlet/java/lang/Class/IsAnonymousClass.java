/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Class;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Array;

public class IsAnonymousClass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Class<?> anon = new Object(){

            public String toString() {
                return "Hello!";
            }
        }.getClass();
        Class<?> anonArray = Array.newInstance(anon, 1).getClass();
        harness.check(Integer.TYPE.isAnonymousClass(), false, "Primitive type class");
        harness.check(int[].class.isAnonymousClass(), false, "Primitive type one-dimensional array class");
        harness.check(int[][].class.isAnonymousClass(), false, "Primitive type multi-dimensional array class");
        harness.check(Object[].class.isAnonymousClass(), false, "Object type one-dimensional array class");
        harness.check(Object.class.isAnonymousClass(), false, "Object type class");
        harness.check(InnerClass.class.isAnonymousClass(), false, "Inner class");
        harness.check(anon.isAnonymousClass(), true, "Anonymous class");
        harness.check(anonArray.isAnonymousClass(), false, "Anonymous array class");
    }

    public static class InnerClass {
    }
}

