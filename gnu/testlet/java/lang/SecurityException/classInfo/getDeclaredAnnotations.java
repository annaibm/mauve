/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.SecurityException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.annotation.Annotation;
import java.util.ArrayList;

public class getDeclaredAnnotations
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String[] annotationsThatShouldExists;
        SecurityException o = new SecurityException("java.lang.SecurityException");
        Class<?> c = o.getClass();
        String[] annotationsThatShouldExists_jdk6 = new String[]{};
        String[] annotationsThatShouldExists_jdk7 = new String[]{};
        Annotation[] annotations = c.getDeclaredAnnotations();
        ArrayList<String> annotationsAsString = new ArrayList<String>();
        for (Annotation annotation : annotations) {
            annotationsAsString.add(annotation.toString());
        }
        for (String annotationThatShouldExists : annotationsThatShouldExists = this.getJavaVersion() < 7 ? annotationsThatShouldExists_jdk6 : annotationsThatShouldExists_jdk7) {
            harness.check(annotationsAsString.contains(annotationThatShouldExists));
        }
    }

    protected int getJavaVersion() {
        String javaVersionStr = System.getProperty("java.version");
        String[] parts = javaVersionStr.split("\\.");
        return Integer.parseInt(parts[1]);
    }
}

