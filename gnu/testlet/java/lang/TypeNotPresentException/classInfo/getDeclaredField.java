/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.TypeNotPresentException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Field;

public class getDeclaredField
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String[] fieldsThatShouldExist_jdk6 = new String[]{"typeName"};
        String[] fieldsThatShouldExist_jdk7 = new String[]{"serialVersionUID", "typeName"};
        String[] fieldsThatShouldExist = this.getJavaVersion() < 7 ? fieldsThatShouldExist_jdk6 : fieldsThatShouldExist_jdk7;
        TypeNotPresentException o = new TypeNotPresentException("java.lang.TypeNotPresentException", new Throwable());
        Class<?> c = o.getClass();
        for (String fieldThatShouldExists : fieldsThatShouldExist) {
            try {
                Field field = c.getDeclaredField(fieldThatShouldExists);
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

