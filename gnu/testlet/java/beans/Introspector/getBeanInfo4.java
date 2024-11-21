/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.beans.Introspector;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.beans.Introspector.bar.TestSubject;
import java.beans.BeanDescriptor;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;

public class getBeanInfo4
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Introspector.setBeanInfoSearchPath(new String[]{"gnu.testlet.java.beans.Introspector.foo.info", "gnu.testlet.java.beans.Introspector.bar.info"});
        BeanInfo bi = null;
        boolean failed = false;
        Class klazz = TestSubject.class;
        try {
            bi = Introspector.getBeanInfo(klazz);
        }
        catch (IntrospectionException ie) {
            failed = true;
        }
        harness.checkPoint("BAR variant");
        harness.check(failed, false);
        BeanDescriptor bd = bi.getBeanDescriptor();
        harness.check(bd.getName(), (Object)"BAR TestSubject");
        harness.check(bd.getBeanClass(), TestSubject.class);
        failed = false;
        klazz = gnu.testlet.java.beans.Introspector.foo.TestSubject.class;
        try {
            bi = Introspector.getBeanInfo(klazz);
        }
        catch (IntrospectionException ie) {
            failed = true;
        }
        harness.checkPoint("FOO variant");
        harness.check(failed, false);
        bd = bi.getBeanDescriptor();
        harness.check(bd.getName(), (Object)"FOO TestSubject");
        harness.check(bd.getBeanClass(), gnu.testlet.java.beans.Introspector.foo.TestSubject.class);
    }
}

