/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.beans.Introspector.foo.info;

import gnu.testlet.java.beans.Introspector.foo.TestSubject;
import java.beans.BeanDescriptor;
import java.beans.SimpleBeanInfo;

public class TestSubjectBeanInfo
extends SimpleBeanInfo {
    private BeanDescriptor bd = new BeanDescriptor(TestSubject.class);

    public TestSubjectBeanInfo() {
        this.bd.setName("FOO TestSubject");
    }

    @Override
    public BeanDescriptor getBeanDescriptor() {
        return this.bd;
    }
}

