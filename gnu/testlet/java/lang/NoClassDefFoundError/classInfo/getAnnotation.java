/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.NoClassDefFoundError.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

public class getAnnotation
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        NoClassDefFoundError o = new NoClassDefFoundError("NoClassDefFoundError");
        Class<?> c = o.getClass();
        Annotation annotation = c.getAnnotation(Annotation.class);
        harness.check(annotation == null);
        annotation = c.getAnnotation(Documented.class);
        harness.check(annotation == null);
        annotation = c.getAnnotation(Inherited.class);
        harness.check(annotation == null);
        annotation = c.getAnnotation(Retention.class);
        harness.check(annotation == null);
        annotation = c.getAnnotation(Target.class);
        harness.check(annotation == null);
        annotation = c.getAnnotation(Deprecated.class);
        harness.check(annotation == null);
        annotation = c.getAnnotation(Override.class);
        harness.check(annotation == null);
        annotation = c.getAnnotation(SuppressWarnings.class);
        harness.check(annotation == null);
    }
}

