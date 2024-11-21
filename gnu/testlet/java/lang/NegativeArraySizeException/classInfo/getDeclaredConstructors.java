/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.NegativeArraySizeException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Constructor;
import java.util.HashMap;

public class getDeclaredConstructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        HashMap<String, String> testedDeclaredConstructors = null;
        HashMap<String, String> testedDeclaredConstructors_jdk6 = new HashMap<String, String>();
        HashMap<String, String> testedDeclaredConstructors_jdk7 = new HashMap<String, String>();
        testedDeclaredConstructors_jdk6.put("public java.lang.NegativeArraySizeException()", "java.lang.NegativeArraySizeException");
        testedDeclaredConstructors_jdk6.put("public java.lang.NegativeArraySizeException(java.lang.String)", "java.lang.NegativeArraySizeException");
        testedDeclaredConstructors_jdk7.put("public java.lang.NegativeArraySizeException()", "java.lang.NegativeArraySizeException");
        testedDeclaredConstructors_jdk7.put("public java.lang.NegativeArraySizeException(java.lang.String)", "java.lang.NegativeArraySizeException");
        NegativeArraySizeException o = new NegativeArraySizeException("java.lang.NegativeArraySizeException");
        Class<?> c = o.getClass();
        testedDeclaredConstructors = this.getJavaVersion() < 7 ? testedDeclaredConstructors_jdk6 : testedDeclaredConstructors_jdk7;
        Constructor<?>[] declaredConstructors = c.getDeclaredConstructors();
        int expectedNumberOfConstructors = testedDeclaredConstructors.size();
        harness.check(declaredConstructors.length, expectedNumberOfConstructors);
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            String constructorName = declaredConstructor.getName();
            String constructorString2 = declaredConstructor.toString().replaceAll(" native ", " ");
            harness.check(testedDeclaredConstructors.containsKey(constructorString2));
            harness.check(testedDeclaredConstructors.get(constructorString2), (Object)constructorName);
        }
    }

    protected int getJavaVersion() {
        String javaVersionStr = System.getProperty("java.version");
        String[] parts = javaVersionStr.split("\\.");
        return Integer.parseInt(parts[1]);
    }
}

