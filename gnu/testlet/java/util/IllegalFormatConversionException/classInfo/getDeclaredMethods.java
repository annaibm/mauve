/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.IllegalFormatConversionException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.IllegalFormatConversionException;

public class getDeclaredMethods
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        HashMap<String, String> testedDeclaredMethods = null;
        HashMap<String, String> testedDeclaredMethods_jdk6 = new HashMap<String, String>();
        HashMap<String, String> testedDeclaredMethods_jdk7 = new HashMap<String, String>();
        testedDeclaredMethods_jdk6.put("public java.lang.String java.util.IllegalFormatConversionException.getMessage()", "getMessage");
        testedDeclaredMethods_jdk6.put("public char java.util.IllegalFormatConversionException.getConversion()", "getConversion");
        testedDeclaredMethods_jdk6.put("public java.lang.Class java.util.IllegalFormatConversionException.getArgumentClass()", "getArgumentClass");
        testedDeclaredMethods_jdk7.put("public java.lang.String java.util.IllegalFormatConversionException.getMessage()", "getMessage");
        testedDeclaredMethods_jdk7.put("public char java.util.IllegalFormatConversionException.getConversion()", "getConversion");
        testedDeclaredMethods_jdk7.put("public java.lang.Class java.util.IllegalFormatConversionException.getArgumentClass()", "getArgumentClass");
        IllegalFormatConversionException o = new IllegalFormatConversionException('a', Character.class);
        Class<?> c = o.getClass();
        testedDeclaredMethods = this.getJavaVersion() < 7 ? testedDeclaredMethods_jdk6 : testedDeclaredMethods_jdk7;
        Method[] declaredMethods = c.getDeclaredMethods();
        int expectedNumberOfDeclaredMethods = testedDeclaredMethods.size();
        harness.check(declaredMethods.length, expectedNumberOfDeclaredMethods);
        for (Method declaredMethod : declaredMethods) {
            String methodName = declaredMethod.getName();
            String methodString = declaredMethod.toString().replaceAll(" native ", " ");
            harness.check(testedDeclaredMethods.containsKey(methodString));
            harness.check(testedDeclaredMethods.get(methodString), (Object)methodName);
        }
    }

    protected int getJavaVersion() {
        String javaVersionStr = System.getProperty("java.version");
        String[] parts = javaVersionStr.split("\\.");
        return Integer.parseInt(parts[1]);
    }
}

