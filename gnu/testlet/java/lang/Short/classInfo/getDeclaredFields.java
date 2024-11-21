/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Short.classInfo;

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
        testedDeclaredFields_jdk6.put("public static final short java.lang.Short.MIN_VALUE", "MIN_VALUE");
        testedDeclaredFields_jdk6.put("public static final short java.lang.Short.MAX_VALUE", "MAX_VALUE");
        testedDeclaredFields_jdk6.put("public static final java.lang.Class java.lang.Short.TYPE", "TYPE");
        testedDeclaredFields_jdk6.put("private final short java.lang.Short.value", "value");
        testedDeclaredFields_jdk6.put("public static final int java.lang.Short.SIZE", "SIZE");
        testedDeclaredFields_jdk6.put("private static final long java.lang.Short.serialVersionUID", "serialVersionUID");
        testedDeclaredFields_jdk7.put("public static final short java.lang.Short.MIN_VALUE", "MIN_VALUE");
        testedDeclaredFields_jdk7.put("public static final short java.lang.Short.MAX_VALUE", "MAX_VALUE");
        testedDeclaredFields_jdk7.put("public static final java.lang.Class java.lang.Short.TYPE", "TYPE");
        testedDeclaredFields_jdk7.put("private final short java.lang.Short.value", "value");
        testedDeclaredFields_jdk7.put("public static final int java.lang.Short.SIZE", "SIZE");
        testedDeclaredFields_jdk7.put("private static final long java.lang.Short.serialVersionUID", "serialVersionUID");
        Short o = new Short("42");
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

