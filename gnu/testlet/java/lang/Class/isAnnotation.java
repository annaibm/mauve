/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Class;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

public class isAnnotation
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Class<Class> c1 = Class.class;
        harness.check(!c1.isAnnotation());
        Class<Annotation> c2 = Annotation.class;
        harness.check(!c2.isAnnotation());
        Class<Documented> c3 = Documented.class;
        harness.check(c3.isAnnotation());
        Class<Inherited> c4 = Inherited.class;
        harness.check(c4.isAnnotation());
        Class<Retention> c5 = Retention.class;
        harness.check(c5.isAnnotation());
        Class<Target> c6 = Target.class;
        harness.check(c6.isAnnotation());
    }
}

