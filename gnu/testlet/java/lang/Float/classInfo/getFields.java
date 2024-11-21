/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Float.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Field;
import java.util.HashMap;

public class getFields
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        HashMap<String, String> testedFields = null;
        HashMap<String, String> testedFields_jdk6 = new HashMap<String, String>();
        HashMap<String, String> testedFields_jdk7 = new HashMap<String, String>();
        testedFields_jdk6.put("public static final float java.lang.Float.POSITIVE_INFINITY", "POSITIVE_INFINITY");
        testedFields_jdk6.put("public static final float java.lang.Float.NEGATIVE_INFINITY", "NEGATIVE_INFINITY");
        testedFields_jdk6.put("public static final float java.lang.Float.NaN", "NaN");
        testedFields_jdk6.put("public static final float java.lang.Float.MAX_VALUE", "MAX_VALUE");
        testedFields_jdk6.put("public static final float java.lang.Float.MIN_NORMAL", "MIN_NORMAL");
        testedFields_jdk6.put("public static final float java.lang.Float.MIN_VALUE", "MIN_VALUE");
        testedFields_jdk6.put("public static final int java.lang.Float.MAX_EXPONENT", "MAX_EXPONENT");
        testedFields_jdk6.put("public static final int java.lang.Float.MIN_EXPONENT", "MIN_EXPONENT");
        testedFields_jdk6.put("public static final int java.lang.Float.SIZE", "SIZE");
        testedFields_jdk6.put("public static final java.lang.Class java.lang.Float.TYPE", "TYPE");
        testedFields_jdk7.put("public static final float java.lang.Float.POSITIVE_INFINITY", "POSITIVE_INFINITY");
        testedFields_jdk7.put("public static final float java.lang.Float.NEGATIVE_INFINITY", "NEGATIVE_INFINITY");
        testedFields_jdk7.put("public static final float java.lang.Float.NaN", "NaN");
        testedFields_jdk7.put("public static final float java.lang.Float.MAX_VALUE", "MAX_VALUE");
        testedFields_jdk7.put("public static final float java.lang.Float.MIN_NORMAL", "MIN_NORMAL");
        testedFields_jdk7.put("public static final float java.lang.Float.MIN_VALUE", "MIN_VALUE");
        testedFields_jdk7.put("public static final int java.lang.Float.MAX_EXPONENT", "MAX_EXPONENT");
        testedFields_jdk7.put("public static final int java.lang.Float.MIN_EXPONENT", "MIN_EXPONENT");
        testedFields_jdk7.put("public static final int java.lang.Float.SIZE", "SIZE");
        testedFields_jdk7.put("public static final java.lang.Class java.lang.Float.TYPE", "TYPE");
        Float o = new Float(42.0f);
        Class<?> c = o.getClass();
        testedFields = this.getJavaVersion() < 7 ? testedFields_jdk6 : testedFields_jdk7;
        Field[] fields = c.getFields();
        int expectedNumberOfFields = testedFields.size();
        harness.check(fields.length, expectedNumberOfFields);
        for (Field field : fields) {
            String fieldName = field.getName();
            String fieldString = field.toString();
            harness.check(testedFields.containsKey(fieldString));
            harness.check(testedFields.get(fieldString), (Object)fieldName);
        }
    }

    protected int getJavaVersion() {
        String javaVersionStr = System.getProperty("java.version");
        String[] parts = javaVersionStr.split("\\.");
        return Integer.parseInt(parts[1]);
    }
}

