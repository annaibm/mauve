/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.NoSuchMethodException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

public class isAnnotationPresent
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        NoSuchMethodException o = new NoSuchMethodException("java.lang.NoSuchMethodException");
        Class<?> c = o.getClass();
        harness.check(!c.isAnnotationPresent(Annotation.class));
        harness.check(!c.isAnnotationPresent(Documented.class));
        harness.check(!c.isAnnotationPresent(Inherited.class));
        harness.check(!c.isAnnotationPresent(Retention.class));
        harness.check(!c.isAnnotationPresent(Target.class));
        harness.check(!c.isAnnotationPresent(Deprecated.class));
        harness.check(!c.isAnnotationPresent(Override.class));
        harness.check(!c.isAnnotationPresent(SuppressWarnings.class));
    }
}

