/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Double.classInfo;

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
        testedFields_jdk6.put("public static final double java.lang.Double.POSITIVE_INFINITY", "POSITIVE_INFINITY");
        testedFields_jdk6.put("public static final double java.lang.Double.NEGATIVE_INFINITY", "NEGATIVE_INFINITY");
        testedFields_jdk6.put("public static final double java.lang.Double.NaN", "NaN");
        testedFields_jdk6.put("public static final double java.lang.Double.MAX_VALUE", "MAX_VALUE");
        testedFields_jdk6.put("public static final double java.lang.Double.MIN_NORMAL", "MIN_NORMAL");
        testedFields_jdk6.put("public static final double java.lang.Double.MIN_VALUE", "MIN_VALUE");
        testedFields_jdk6.put("public static final int java.lang.Double.MAX_EXPONENT", "MAX_EXPONENT");
        testedFields_jdk6.put("public static final int java.lang.Double.MIN_EXPONENT", "MIN_EXPONENT");
        testedFields_jdk6.put("public static final int java.lang.Double.SIZE", "SIZE");
        testedFields_jdk6.put("public static final java.lang.Class java.lang.Double.TYPE", "TYPE");
        testedFields_jdk7.put("public static final double java.lang.Double.POSITIVE_INFINITY", "POSITIVE_INFINITY");
        testedFields_jdk7.put("public static final double java.lang.Double.NEGATIVE_INFINITY", "NEGATIVE_INFINITY");
        testedFields_jdk7.put("public static final double java.lang.Double.NaN", "NaN");
        testedFields_jdk7.put("public static final double java.lang.Double.MAX_VALUE", "MAX_VALUE");
        testedFields_jdk7.put("public static final double java.lang.Double.MIN_NORMAL", "MIN_NORMAL");
        testedFields_jdk7.put("public static final double java.lang.Double.MIN_VALUE", "MIN_VALUE");
        testedFields_jdk7.put("public static final int java.lang.Double.MAX_EXPONENT", "MAX_EXPONENT");
        testedFields_jdk7.put("public static final int java.lang.Double.MIN_EXPONENT", "MIN_EXPONENT");
        testedFields_jdk7.put("public static final int java.lang.Double.SIZE", "SIZE");
        testedFields_jdk7.put("public static final java.lang.Class java.lang.Double.TYPE", "TYPE");
        Double o = new Double(42.0);
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

