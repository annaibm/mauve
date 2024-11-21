/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.String.classInfo;

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
        testedDeclaredFields_jdk6.put("private final char[] java.lang.String.value", "value");
        testedDeclaredFields_jdk6.put("private final int java.lang.String.offset", "offset");
        testedDeclaredFields_jdk6.put("private final int java.lang.String.count", "count");
        testedDeclaredFields_jdk6.put("private int java.lang.String.hash", "hash");
        testedDeclaredFields_jdk6.put("private static final long java.lang.String.serialVersionUID", "serialVersionUID");
        testedDeclaredFields_jdk6.put("private static final java.io.ObjectStreamField[] java.lang.String.serialPersistentFields", "serialPersistentFields");
        testedDeclaredFields_jdk6.put("public static final java.util.Comparator java.lang.String.CASE_INSENSITIVE_ORDER", "CASE_INSENSITIVE_ORDER");
        testedDeclaredFields_jdk7.put("private final char[] java.lang.String.value", "value");
        testedDeclaredFields_jdk7.put("private int java.lang.String.hash", "hash");
        testedDeclaredFields_jdk7.put("private static final long java.lang.String.serialVersionUID", "serialVersionUID");
        testedDeclaredFields_jdk7.put("private static final java.io.ObjectStreamField[] java.lang.String.serialPersistentFields", "serialPersistentFields");
        testedDeclaredFields_jdk7.put("public static final java.util.Comparator java.lang.String.CASE_INSENSITIVE_ORDER", "CASE_INSENSITIVE_ORDER");
        testedDeclaredFields_jdk7.put("private static final int java.lang.String.HASHING_SEED", "HASHING_SEED");
        testedDeclaredFields_jdk7.put("private transient int java.lang.String.hash32", "hash32");
        String o = new String();
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

