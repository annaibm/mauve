/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.beans.EventHandler;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.event.WindowListener;
import java.beans.EventHandler;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;

public class check14c
implements Testlet {
    private boolean calledSetter;

    @Override
    public void test(TestHarness harness) {
        Listener l = EventHandler.create(Listener.class, this, "targetMethod");
        boolean correctException = false;
        try {
            l.listen();
        }
        catch (Exception e) {
            correctException = e.getClass() == RuntimeException.class;
        }
        harness.check(correctException, true, "missing target method");
        Listener2 l2 = EventHandler.create(Listener2.class, this, "targetMethod2", "booleanValue");
        correctException = false;
        try {
            l2.listen(new Event());
        }
        catch (Exception re) {
            correctException = re.getClass() == RuntimeException.class;
        }
        harness.check(correctException, true, "missing property target method");
        l2 = EventHandler.create(Listener2.class, this, "targetMethod2", "getSelf.getSelf.intValue");
        correctException = false;
        try {
            l2.listen(new Event());
        }
        catch (Exception e) {
            correctException = e.getClass() == RuntimeException.class;
        }
        harness.check(correctException, true);
        l2 = EventHandler.create(Listener2.class, this, "not important", "getSelf.self.getSelf.self.HellBrokeOut", null);
        correctException = false;
        try {
            l2.listen(new EventSub());
        }
        catch (Exception e) {
            correctException = e.getClass() == RuntimeException.class;
        }
        harness.check(correctException, true, "missing property");
        l2 = EventHandler.create(Listener2.class, this, "eventProperty");
        correctException = false;
        try {
            l2.listen(new Event());
        }
        catch (Exception e) {
            correctException = e.getClass() == RuntimeException.class;
        }
        harness.check(correctException, true, "action is method");
        l2 = EventHandler.create(Listener2.class, this, "erroneousTargetMethod");
        correctException = false;
        boolean correctException2 = false;
        try {
            l2.listen(new Event());
        }
        catch (Exception e) {
            correctException = e.getClass() == RuntimeException.class;
            correctException2 = e.getCause().getClass() == PersonalException.class;
        }
        harness.check(correctException, true, "erroneous target method");
        harness.check(correctException2, true);
        l2 = EventHandler.create(Listener2.class, this, "not important", "erroneousProperty");
        correctException = false;
        correctException2 = false;
        boolean correctException3 = false;
        try {
            l2.listen(new EventSub());
        }
        catch (Exception e) {
            correctException = e.getClass() == RuntimeException.class;
            correctException2 = e.getCause().getClass() == InvocationTargetException.class;
            correctException3 = e.getCause().getCause().getClass() == PersonalException.class;
        }
        harness.check(correctException, true, "erroneous property");
        harness.check(correctException2, true);
        harness.check(correctException3, true);
        correctException = false;
        harness.checkPoint("wrong arguments");
        try {
            EventHandler.create(null, harness, "bla", "foo", "baz");
        }
        catch (Exception e) {
            correctException = e.getClass() == NullPointerException.class;
        }
        harness.check(correctException, true);
        correctException = false;
        try {
            WindowListener e = EventHandler.create(WindowListener.class, null, "bla", "foo", "windowClosing");
        }
        catch (Exception e) {
            correctException = e.getClass() == NullPointerException.class;
        }
        harness.check(correctException, true);
        correctException = false;
    }

    void targetMethod() {
    }

    public void targetMethod2() {
    }

    public void setEventProperty(Event e) {
    }

    public void erroneousTargetMethod() throws PersonalException {
        throw new PersonalException();
    }

    public static interface Listener2 {
        public void listen(Event var1);
    }

    static class PersonalException
    extends Exception {
        PersonalException() {
        }
    }

    public class EventSub
    extends Event {
        public void getErroneousProperty() throws PersonalException {
            throw new PersonalException();
        }
    }

    public class Event {
        public boolean isBooleanValue() {
            return true;
        }

        public BigInteger getBigValue() {
            return new BigInteger("903281390123809123");
        }

        public int getIntValue() {
            return -559038737;
        }

        public Event getSelf() {
            return this;
        }
    }

    public static interface Listener {
        public void listen();

        public void listen(Object var1);

        public void listen(String var1);
    }
}

