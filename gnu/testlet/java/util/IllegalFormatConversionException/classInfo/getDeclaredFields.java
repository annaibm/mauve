/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.IllegalFormatConversionException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.IllegalFormatConversionException;

public class getDeclaredFields
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        HashMap<String, String> testedDeclaredFields = null;
        HashMap<String, String> testedDeclaredFields_jdk6 = new HashMap<String, String>();
        HashMap<String, String> testedDeclaredFields_jdk7 = new HashMap<String, String>();
        testedDeclaredFields_jdk6.put("private static final long java.util.IllegalFormatConversionException.serialVersionUID", "serialVersionUID");
        testedDeclaredFields_jdk6.put("private char java.util.IllegalFormatConversionException.c", "c");
        testedDeclaredFields_jdk6.put("private java.lang.Class java.util.IllegalFormatConversionException.arg", "arg");
        testedDeclaredFields_jdk7.put("private static final long java.util.IllegalFormatConversionException.serialVersionUID", "serialVersionUID");
        testedDeclaredFields_jdk7.put("private char java.util.IllegalFormatConversionException.c", "c");
        testedDeclaredFields_jdk7.put("private java.lang.Class java.util.IllegalFormatConversionException.arg", "arg");
        IllegalFormatConversionException o = new IllegalFormatConversionException('a', Character.class);
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

