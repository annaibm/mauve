/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Package.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Field;

public class getField
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String[] fieldsThatShouldExist_jdk6 = new String[]{};
        String[] fieldsThatShouldExist_jdk7 = new String[]{};
        String[] fieldsThatShouldExist = this.getJavaVersion() < 7 ? fieldsThatShouldExist_jdk6 : fieldsThatShouldExist_jdk7;
        Package o = Package.getPackage("java.lang");
        Class<?> c = o.getClass();
        for (String fieldThatShouldExists : fieldsThatShouldExist) {
            try {
                Field field = c.getField(fieldThatShouldExists);
                harness.check(field != null);
                String fieldName = field.getName();
                harness.check(fieldName != null);
                harness.check(fieldName, (Object)fieldThatShouldExists);
            }
            catch (Exception e) {
                harness.check(false);
            }
        }
    }

    protected int getJavaVersion() {
        String javaVersionStr = System.getProperty("java.version");
        String[] parts = javaVersionStr.split("\\.");
        return Integer.parseInt(parts[1]);
    }
}

