/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.beans.beancontext.BeanContextSupport;

import java.beans.PropertyChangeListener;
import java.beans.VetoableChangeListener;
import java.beans.Visibility;
import java.beans.beancontext.BeanContextChild;
import java.beans.beancontext.BeanContextMembershipListener;
import java.beans.beancontext.BeanContextSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;

public class MyBeanContextSupport
extends BeanContextSupport {
    public static BeanContextChild getChildBeanContextChildX(Object child) {
        return BeanContextSupport.getChildBeanContextChild(child);
    }

    public static BeanContextMembershipListener getChildBeanContextMembershipListenerX(Object child) {
        return BeanContextSupport.getChildBeanContextMembershipListener(child);
    }

    public static PropertyChangeListener getChildPropertyChangeListenerX(Object child) {
        return BeanContextSupport.getChildPropertyChangeListener(child);
    }

    public static Serializable getChildSerializableX(Object child) {
        return BeanContextSupport.getChildSerializable(child);
    }

    public static VetoableChangeListener getChildVetoableChangeListenerX(Object child) {
        return BeanContextSupport.getChildVetoableChangeListener(child);
    }

    public static Visibility getChildVisibilityX(Object child) {
        return BeanContextSupport.getChildVisibility(child);
    }

    protected void deserializeX(ObjectInputStream ois, Collection coll) throws IOException, ClassNotFoundException {
        super.deserialize(ois, coll);
    }

    protected void serializeX(ObjectOutputStream oos, Collection coll) throws IOException {
        super.serialize(oos, coll);
    }
}

