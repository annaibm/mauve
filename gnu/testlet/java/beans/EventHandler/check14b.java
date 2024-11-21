/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.beans.EventHandler;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.EventHandler;
import java.math.BigInteger;

public class check14b
implements Testlet {
    private boolean noArgMethodCalled;
    private boolean objectArgMethodCalled;
    private boolean stringArgMethodCalled;
    private boolean numberArgMethodCalled;
    private boolean calledSetter;

    @Override
    public void test(TestHarness harness) {
        Listener l = EventHandler.create(Listener.class, this, "targetMethod");
        l.listen();
        harness.check(this.noArgMethodCalled, true, "prefer no arg method");
        harness.check(this.objectArgMethodCalled, false);
        harness.check(this.stringArgMethodCalled, false);
        this.stringArgMethodCalled = false;
        this.objectArgMethodCalled = false;
        this.noArgMethodCalled = false;
        l.listen(new Object());
        harness.check(this.noArgMethodCalled, true, "prefer no arg method (Object given)");
        harness.check(this.objectArgMethodCalled, false);
        harness.check(this.stringArgMethodCalled, false);
        this.stringArgMethodCalled = false;
        this.objectArgMethodCalled = false;
        this.noArgMethodCalled = false;
        l.listen("GNU!");
        harness.check(this.noArgMethodCalled, true, "prefer no arg method (String given)");
        harness.check(this.objectArgMethodCalled, false);
        harness.check(this.stringArgMethodCalled, false);
        this.stringArgMethodCalled = false;
        this.objectArgMethodCalled = false;
        this.noArgMethodCalled = false;
        Listener2 l2 = EventHandler.create(Listener2.class, this, "value", "booleanValue", null);
        l2.listen(new Event());
        harness.check(this.calledSetter, true, "setter invoked as property");
        this.calledSetter = false;
        l2.listen(new EventSub());
        harness.check(this.calledSetter, true);
        this.calledSetter = false;
        l2 = EventHandler.create(Listener2.class, this, "setValue", "booleanValue", null);
        l2.listen(new Event());
        harness.check(this.calledSetter, true, "setter invoked as method");
        harness.checkPoint("replacement for BigInteger property");
        l2 = EventHandler.create(Listener2.class, this, "targetValue", "bigValue", null);
        l2.listen(new Event());
        harness.check(this.noArgMethodCalled, false);
        harness.check(this.objectArgMethodCalled, true);
        harness.check(this.stringArgMethodCalled, false);
        this.stringArgMethodCalled = false;
        this.objectArgMethodCalled = false;
        this.noArgMethodCalled = false;
        harness.checkPoint("replacement for boolean property");
        l2 = EventHandler.create(Listener2.class, this, "targetValue", "booleanValue", null);
        l2.listen(new Event());
        harness.check(this.noArgMethodCalled, false);
        harness.check(this.objectArgMethodCalled, true);
        harness.check(this.stringArgMethodCalled, false);
        this.stringArgMethodCalled = false;
        this.objectArgMethodCalled = false;
        this.noArgMethodCalled = false;
        harness.checkPoint("replacement for integer property");
        l2 = EventHandler.create(Listener2.class, this, "numberValue", "intValue", null);
        l2.listen(new Event());
        harness.check(this.noArgMethodCalled, false);
        harness.check(this.objectArgMethodCalled, false);
        harness.check(this.numberArgMethodCalled, true);
        harness.check(this.stringArgMethodCalled, false);
        this.numberArgMethodCalled = false;
        this.stringArgMethodCalled = false;
        this.objectArgMethodCalled = false;
        this.noArgMethodCalled = false;
        harness.checkPoint("replacement for BigInteger method");
        l2 = EventHandler.create(Listener2.class, this, "setTargetValue", "bigValue", null);
        l2.listen(new Event());
        harness.check(this.noArgMethodCalled, false);
        harness.check(this.objectArgMethodCalled, true);
        harness.check(this.stringArgMethodCalled, false);
        this.stringArgMethodCalled = false;
        this.objectArgMethodCalled = false;
        this.noArgMethodCalled = false;
        harness.checkPoint("replacement for boolean method");
        l2 = EventHandler.create(Listener2.class, this, "setTargetValue", "booleanValue", null);
        l2.listen(new Event());
        harness.check(this.noArgMethodCalled, false);
        harness.check(this.objectArgMethodCalled, true);
        harness.check(this.stringArgMethodCalled, false);
        this.stringArgMethodCalled = false;
        this.objectArgMethodCalled = false;
        this.noArgMethodCalled = false;
        harness.checkPoint("replacement for integer method");
        l2 = EventHandler.create(Listener2.class, this, "setNumberValue", "intValue", null);
        l2.listen(new Event());
        harness.check(this.noArgMethodCalled, false);
        harness.check(this.objectArgMethodCalled, false);
        harness.check(this.numberArgMethodCalled, true);
        harness.check(this.stringArgMethodCalled, false);
        this.numberArgMethodCalled = false;
        this.stringArgMethodCalled = false;
        this.objectArgMethodCalled = false;
        this.noArgMethodCalled = false;
        harness.checkPoint("property as method names");
        l2 = EventHandler.create(Listener2.class, this, "setNumberValue", "getSelf.getIntValue", null);
        boolean exceptionThrown = false;
        try {
            l2.listen(new EventSub());
        }
        catch (Exception e) {
            exceptionThrown = true;
        }
        harness.check(exceptionThrown, false);
        harness.check(this.noArgMethodCalled, false);
        harness.check(this.objectArgMethodCalled, false);
        harness.check(this.numberArgMethodCalled, true);
        harness.check(this.stringArgMethodCalled, false);
        this.numberArgMethodCalled = false;
        this.stringArgMethodCalled = false;
        this.objectArgMethodCalled = false;
        this.noArgMethodCalled = false;
        harness.checkPoint("property and method names");
        l2 = EventHandler.create(Listener2.class, this, "setNumberValue", "self.getSelf.self.getSelf.intValue", null);
        exceptionThrown = false;
        try {
            l2.listen(new EventSub());
        }
        catch (Exception e) {
            exceptionThrown = true;
        }
        harness.check(exceptionThrown, false);
        harness.check(this.noArgMethodCalled, false);
        harness.check(this.objectArgMethodCalled, false);
        harness.check(this.numberArgMethodCalled, true);
        harness.check(this.stringArgMethodCalled, false);
        this.numberArgMethodCalled = false;
        this.stringArgMethodCalled = false;
        this.objectArgMethodCalled = false;
        this.noArgMethodCalled = false;
        harness.checkPoint("name ambiguity preference");
        l2 = EventHandler.create(Listener2.class, this, "setNumberValue", "getSelf.intValue", null);
        EventSub event = new EventSub();
        l2.listen(event);
        harness.check(event.property, true);
        harness.check(event.method, false);
        harness.checkPoint("primitive to wrapper");
        this.calledSetter = false;
        l2 = EventHandler.create(Listener2.class, this, "integerValue", "intValue");
        l2.listen(new EventSub());
        harness.check(this.calledSetter, true);
        this.calledSetter = false;
        l2 = EventHandler.create(Listener2.class, this, "setIntegerValue", "intValue");
        l2.listen(new EventSub());
        harness.check(this.calledSetter, true);
        this.calledSetter = false;
        l2 = EventHandler.create(Listener2.class, this, "setIntegerValue", "getIntValue");
        l2.listen(new EventSub());
        harness.check(this.calledSetter, true);
        this.calledSetter = false;
        l2 = EventHandler.create(Listener2.class, this, "integerValue", "getIntValue");
        l2.listen(new EventSub());
        harness.check(this.calledSetter, true);
        this.calledSetter = false;
        harness.checkPoint("wrapper to primitive");
        l2 = EventHandler.create(Listener2.class, this, "intValue", "integerValue");
        l2.listen(new EventSub());
        harness.check(this.calledSetter, true);
        this.calledSetter = false;
        l2 = EventHandler.create(Listener2.class, this, "setIntValue", "integerValue");
        l2.listen(new EventSub());
        harness.check(this.calledSetter, true);
        this.calledSetter = false;
        l2 = EventHandler.create(Listener2.class, this, "setIntValue", "getIntegerValue");
        l2.listen(new EventSub());
        harness.check(this.calledSetter, true);
        this.calledSetter = false;
        l2 = EventHandler.create(Listener2.class, this, "intValue", "getIntegerValue");
        l2.listen(new EventSub());
        harness.check(this.calledSetter, true);
        this.calledSetter = false;
    }

    public void targetMethod() {
        this.noArgMethodCalled = true;
    }

    public void targetMethod(Object o) {
        this.objectArgMethodCalled = true;
    }

    public void targetMethod(String m) {
        this.stringArgMethodCalled = true;
    }

    public void setTargetValue() {
        this.noArgMethodCalled = true;
    }

    public void setTargetValue(Object o) {
        this.objectArgMethodCalled = true;
    }

    public void setTargetValue(String m) {
        this.stringArgMethodCalled = true;
    }

    public void setNumberValue() {
        this.noArgMethodCalled = true;
    }

    public void setNumberValue(Object o) {
        this.objectArgMethodCalled = true;
    }

    public void setNumberValue(Number n) {
        this.numberArgMethodCalled = true;
    }

    public void setNumberValue(String m) {
        this.stringArgMethodCalled = true;
    }

    public void setValue(boolean arg) {
        this.calledSetter = arg;
    }

    public void setIntegerValue(Integer value2) {
        this.calledSetter = true;
    }

    public void setIntValue(int value2) {
        this.calledSetter = true;
    }

    public static interface Listener2 {
        public void listen(Event var1);
    }

    public class EventSub
    extends Event {
        boolean method;
        boolean property;

        public EventSub() {
            this.method = false;
            this.property = false;
        }

        public EventSub getSelf() {
            this.method = true;
            return this;
        }

        public EventSub getGetSelf() {
            this.property = true;
            return this;
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

        public Integer getIntegerValue() {
            return new Integer(-559038737);
        }
    }

    public static interface Listener {
        public void listen();

        public void listen(Object var1);

        public void listen(String var1);
    }
}

