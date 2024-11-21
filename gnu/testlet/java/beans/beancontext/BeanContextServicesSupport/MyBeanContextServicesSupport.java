/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.beans.beancontext.BeanContextServicesSupport;

import java.beans.beancontext.BeanContextServicesListener;
import java.beans.beancontext.BeanContextServicesSupport;

public class MyBeanContextServicesSupport
extends BeanContextServicesSupport {
    public static final BeanContextServicesListener getChildBeanContextServicesListenerX(Object child) {
        return BeanContextServicesSupport.getChildBeanContextServicesListener(child);
    }
}

