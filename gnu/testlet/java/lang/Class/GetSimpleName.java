/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Class;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Array;

public class GetSimpleName
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Class<?> anon = new Object(){

            public String toString() {
                return "Hello!";
            }
        }.getClass();
        Class<?> anonArray = Array.newInstance(anon, 1).getClass();
        harness.check(Integer.TYPE.getSimpleName(), "int", "Primitive type class");
        harness.check(int[].class.getSimpleName(), "int[]", "Primitive type one-dimensional array class");
        harness.check(int[][].class.getSimpleName(), "int[][]", "Primitive type multi-dimensional array class");
        harness.check(Object[].class.getSimpleName(), "Object[]", "Object type one-dimensional array class");
        harness.check(Object.class.getSimpleName(), "Object", "Object type class");
        harness.check(InnerClass.class.getSimpleName(), "InnerClass", "Inner class");
        harness.check(anon.getSimpleName(), "", "Anonymous class");
        harness.check(anonArray.getSimpleName(), "[]", "Anonymous array class");
    }

    public static class InnerClass {
    }
}

