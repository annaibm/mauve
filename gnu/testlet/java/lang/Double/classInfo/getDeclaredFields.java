/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Double.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Field;
import java.util.HashMap;

public class getDeclaredFields
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        HashMap<String, String> testedDeclaredFields = null;
        HashMap<String, String> testedDeclaredFields_jdk6 = new HashMap<String, String>();
        HashMap<String, String> testedDeclaredFields_jdk7 = new HashMap<String, String>();
        testedDeclaredFields_jdk6.put("public static final double java.lang.Double.POSITIVE_INFINITY", "POSITIVE_INFINITY");
        testedDeclaredFields_jdk6.put("public static final double java.lang.Double.NEGATIVE_INFINITY", "NEGATIVE_INFINITY");
        testedDeclaredFields_jdk6.put("public static final double java.lang.Double.NaN", "NaN");
        testedDeclaredFields_jdk6.put("public static final double java.lang.Double.MAX_VALUE", "MAX_VALUE");
        testedDeclaredFields_jdk6.put("public static final double java.lang.Double.MIN_NORMAL", "MIN_NORMAL");
        testedDeclaredFields_jdk6.put("public static final double java.lang.Double.MIN_VALUE", "MIN_VALUE");
        testedDeclaredFields_jdk6.put("public static final int java.lang.Double.MAX_EXPONENT", "MAX_EXPONENT");
        testedDeclaredFields_jdk6.put("public static final int java.lang.Double.MIN_EXPONENT", "MIN_EXPONENT");
        testedDeclaredFields_jdk6.put("public static final int java.lang.Double.SIZE", "SIZE");
        testedDeclaredFields_jdk6.put("public static final java.lang.Class java.lang.Double.TYPE", "TYPE");
        testedDeclaredFields_jdk6.put("private final double java.lang.Double.value", "value");
        testedDeclaredFields_jdk6.put("private static final long java.lang.Double.serialVersionUID", "serialVersionUID");
        testedDeclaredFields_jdk7.put("public static final double java.lang.Double.POSITIVE_INFINITY", "POSITIVE_INFINITY");
        testedDeclaredFields_jdk7.put("public static final double java.lang.Double.NEGATIVE_INFINITY", "NEGATIVE_INFINITY");
        testedDeclaredFields_jdk7.put("public static final double java.lang.Double.NaN", "NaN");
        testedDeclaredFields_jdk7.put("public static final double java.lang.Double.MAX_VALUE", "MAX_VALUE");
        testedDeclaredFields_jdk7.put("public static final double java.lang.Double.MIN_NORMAL", "MIN_NORMAL");
        testedDeclaredFields_jdk7.put("public static final double java.lang.Double.MIN_VALUE", "MIN_VALUE");
        testedDeclaredFields_jdk7.put("public static final int java.lang.Double.MAX_EXPONENT", "MAX_EXPONENT");
        testedDeclaredFields_jdk7.put("public static final int java.lang.Double.MIN_EXPONENT", "MIN_EXPONENT");
        testedDeclaredFields_jdk7.put("public static final int java.lang.Double.SIZE", "SIZE");
        testedDeclaredFields_jdk7.put("public static final java.lang.Class java.lang.Double.TYPE", "TYPE");
        testedDeclaredFields_jdk7.put("private final double java.lang.Double.value", "value");
        testedDeclaredFields_jdk7.put("private static final long java.lang.Double.serialVersionUID", "serialVersionUID");
        Double o = new Double(42.0);
        Class<?> c = o.getClass();
        testedDeclaredFields = this.getJavaVersion() < 7 ? testedDeclaredFields_jdk6 : testedDeclaredFields_jdk7;
        Field[] declaredFields = c.getDeclaredFields();
        int expectedNumberOfDeclaredFields = testedDeclaredFields.size();
        harness.check(declaredFields.length, expectedNumberOfDeclaredFields);
        for (Field declaredField : declaredFields) {
            String fieldName = declaredField.getName();
            String fieldString = declaredField.toString();
            harness.check(testedDeclaredFields.containsKey(fieldString));
            harness.check(testedDeclaredFields.get(fieldString), (Object)fieldName);
        }
    }

    protected int getJavaVersion() {
        String javaVersionStr = System.getProperty("java.version");
        String[] parts = javaVersionStr.split("\\.");
        return Integer.parseInt(parts[1]);
    }
}

