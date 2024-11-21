/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Class;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.security.Identity;

public class isAnnotationPresent
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Class<Class> c1 = Class.class;
        harness.check(!c1.isAnnotationPresent(Annotation.class));
        Class<Identity> c2 = Identity.class;
        harness.check(!c2.isAnnotationPresent(Annotation.class));
        harness.check(!c2.isAnnotationPresent(Documented.class));
        harness.check(c2.isAnnotationPresent(Deprecated.class));
    }
}

