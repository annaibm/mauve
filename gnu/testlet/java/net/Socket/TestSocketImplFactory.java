/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.Socket;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.net.SocketImpl;
import java.net.SocketImplFactory;

public class TestSocketImplFactory
implements SocketImplFactory {
    private Constructor implConstructor = null;

    public TestSocketImplFactory() {
        Object impl = null;
        try {
            Class<?> sic = Class.forName("java.net.SocketImpl");
            Socket s = new Socket();
            Field[] fields = s.getClass().getDeclaredFields();
            for (int i = 0; impl == null && i < fields.length; ++i) {
                Field f = fields[i];
                Class<?> fc = f.getType();
                if (!sic.isAssignableFrom(fc)) continue;
                f.setAccessible(true);
                impl = (SocketImpl)f.get(s);
            }
        }
        catch (IllegalAccessException iae) {
            InternalError e = new InternalError("Unable to get default SocketImpl " + iae);
            e.initCause(iae);
            throw e;
        }
        catch (ClassNotFoundException cnf) {
            InternalError e = new InternalError("Unable to get default SocketImpl " + cnf);
            e.initCause(cnf);
            throw e;
        }
        if (impl == null) {
            throw new InternalError("Couldn't determine default SocketImpl");
        }
        Constructor<?>[] cons = impl.getClass().getDeclaredConstructors();
        for (int i = 0; this.implConstructor == null && i < cons.length; ++i) {
            Constructor<?> c = cons[i];
            if (c.getParameterTypes().length != 0) continue;
            this.implConstructor = c;
        }
        if (this.implConstructor == null) {
            throw new InternalError("Couldn't get SocketImpl Constructor");
        }
        this.implConstructor.setAccessible(true);
    }

    @Override
    public SocketImpl createSocketImpl() {
        try {
            return (SocketImpl)this.implConstructor.newInstance(new Object[0]);
        }
        catch (InstantiationException ie) {
            ie.printStackTrace();
            return null;
        }
        catch (IllegalAccessException iae) {
            iae.printStackTrace();
            return null;
        }
        catch (InvocationTargetException ite) {
            ite.printStackTrace();
            return null;
        }
    }
}

