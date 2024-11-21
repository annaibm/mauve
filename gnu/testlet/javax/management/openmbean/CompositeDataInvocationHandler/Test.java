/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.management.openmbean.CompositeDataInvocationHandler;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.management.openmbean.CompositeDataInvocationHandler.Person;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Calendar;
import java.util.HashMap;
import javax.management.openmbean.CompositeDataInvocationHandler;
import javax.management.openmbean.CompositeDataSupport;
import javax.management.openmbean.CompositeType;
import javax.management.openmbean.OpenDataException;
import javax.management.openmbean.OpenType;
import javax.management.openmbean.SimpleType;

public class Test
implements Testlet {
    @Override
    public void test(TestHarness h) {
        try {
            CompositeType type = new CompositeType("Person", "A person", new String[]{"name", "Birthday", "alive"}, new String[]{"name", "birthday", "death status"}, new OpenType[]{SimpleType.STRING, SimpleType.DATE, SimpleType.BOOLEAN});
            HashMap<String, Object> map2 = new HashMap<String, Object>();
            Calendar cal = Calendar.getInstance();
            cal.set(1982, 11, 31);
            map2.put("name", "Andrew");
            map2.put("Birthday", cal.getTime());
            map2.put("alive", true);
            CompositeDataSupport data = new CompositeDataSupport(type, map2);
            Person p = (Person)Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, (InvocationHandler)new CompositeDataInvocationHandler(data));
            h.checkPoint("Accessor tests");
            h.check(p.getName(), (Object)"Andrew");
            h.check(p.getBirthday(), cal.getTime());
            h.check(p.isAlive(), true);
            h.check(p.equals(p), "Reflection test");
            h.check(p.equals(p), "Consistency test");
            Person p2 = (Person)Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, (InvocationHandler)new CompositeDataInvocationHandler(data));
            h.check(p.equals(p2), "Equality over creation test");
            h.check(p2.equals(p), "Symmetric test");
            Person p3 = (Person)Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, (InvocationHandler)new CompositeDataInvocationHandler(data));
            h.check(p2.equals(p2), "Second equality over creation test");
            h.check(p.equals(p3), "Transitivity test");
            h.check(!p.equals(null), "Null test");
            h.check(p.hashCode(), p.hashCode(), "Hashcode reflection test");
            h.check(p.hashCode(), p.hashCode(), "Hashcode consistency test");
            h.check(p.hashCode(), p2.hashCode(), "Hashcode equality over creation test");
            h.check(p2.hashCode(), p3.hashCode(), "Hashcode second equality over creation test");
            h.check(p.hashCode(), p3.hashCode(), "Hashcode transitivity test");
        }
        catch (OpenDataException e) {
            h.debug(e);
        }
    }
}

