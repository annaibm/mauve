/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.beans.EventHandler;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.EventHandler;
import java.lang.reflect.Method;

public class check14
implements Testlet {
    public static int x = 0;
    public boolean called;

    @Override
    public void test(TestHarness harness) {
        Target target = new Target();
        Event ev = new Event();
        EventHandler eh = new EventHandler(target, "action", "a.c.b", "listen1");
        harness.check(eh.getAction() == "action", "Check basic settings");
        harness.check(eh.getEventPropertyName() == "a.c.b");
        harness.check(eh.getListenerMethodName() == "listen1");
        harness.check(eh.getTarget() == target);
        Method listen1 = null;
        Method listen2 = null;
        try {
            listen1 = Listener.class.getMethod("listen1", Event.class);
            listen2 = Listener.class.getMethod("listen2", Event.class);
        }
        catch (Exception e) {
            harness.fail("No listener methods - test is broken");
        }
        harness.check(!target.flag, "Test invoke");
        try {
            eh.invoke(null, listen1, new Object[]{ev});
        }
        catch (Exception e) {
            harness.fail("Invoke listen1 failed " + e.toString());
        }
        harness.check(target.flag, "Invoke listen1 test");
        target.reset();
        try {
            eh.invoke(null, listen2, new Object[]{ev});
        }
        catch (Exception e) {
            harness.fail("Invoke listen2 failed " + e.toString());
        }
        harness.check(!target.flag, "Invoke listen2 test");
        target.reset();
        Listener o1 = EventHandler.create(Listener.class, target, "action", "");
        try {
            o1.listen1(ev);
        }
        catch (Exception e) {
            harness.fail("Invoke listen1 failed " + e.toString());
        }
        harness.check(target.flag, "Test null event property");
        target.reset();
        try {
            o1.listen2(ev);
        }
        catch (Exception e) {
            harness.fail("Invoke listen1 failed " + e.toString());
        }
        harness.check(target.flag);
        harness.check(target.str == "yes");
        target.reset();
        Listener2 l2 = EventHandler.create(Listener2.class, target, "action1");
        l2.listen1();
        harness.check(target.flag, true, "no argument listener method");
        target.reset();
        l2.listen2();
        harness.check(target.flag, true);
        target.reset();
        Listener o2 = EventHandler.create(Listener.class, target, "action1");
        o2.listen1(ev);
        harness.check(target.flag, "Test action with no parameter");
        harness.check(target.str == null);
        target.reset();
        o2.listen2(ev);
        harness.check(target.flag);
        harness.check(target.str == null);
        target.reset();
        Listener o3 = EventHandler.create(Listener.class, target, "action", "a.c.d");
        o3.listen1(ev);
        harness.check(!target.flag, "Test null listener");
        harness.check(target.str == "yes");
        target.reset();
        o3.listen2(ev);
        harness.check(!target.flag, "Test null listener");
        harness.check(target.str == "yes");
        target.reset();
        Listener o4 = EventHandler.create(Listener.class, target, "action", "a.c.d", "listen2");
        o4.listen1(ev);
        harness.check(!target.flag, "Test full, ignore listen1");
        harness.check(target.str == null);
        target.reset();
        o4.listen2(ev);
        harness.check(!target.flag, "Test full, invoke listen2");
        harness.check(target.str == "yes");
        target.reset();
        Listener o5 = EventHandler.create(Listener.class, target, "action");
        Class<?>[] ifs = o5.getClass().getInterfaces();
        boolean found = false;
        for (int i = 0; i < ifs.length; ++i) {
            if (ifs[i] != Listener.class) continue;
            found = true;
        }
        harness.check(found, "Proxy implements Listener");
    }

    public void targetMethod() {
        this.called = true;
    }

    public static interface Listener2 {
        public void listen1();

        public void listen2();
    }

    public static interface Listener {
        public void listen1(Event var1);

        public void listen2(Event var1);
    }

    public class Event {
        public Object getA() {
            return this;
        }

        public boolean isB() {
            return true;
        }

        public Object getC() {
            return this;
        }

        public String getD() {
            return "yes";
        }
    }

    public class Target {
        public boolean flag = false;
        public String str = null;

        public void reset() {
            this.flag = false;
            this.str = null;
        }

        public void action1() {
            this.flag = true;
        }

        public void action(Event e) {
            this.str = e.getD();
            this.flag = e.isB();
        }

        public void setAction(boolean b) {
            this.flag = b;
        }

        public void setAction(String s) {
            this.str = s;
        }

        public void setEventProperty(Event e) {
            this.str = e.getD();
            this.flag = e.isB();
        }
    }
}

