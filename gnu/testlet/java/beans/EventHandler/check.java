/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.beans.EventHandler;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.EventHandler;
import java.math.BigInteger;

public class check
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

    public static interface Listener2 {
        public void listen(Event var1);
    }

    public class EventSub
    extends Event {
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
    }

    public static interface Listener {
        public void listen();

        public void listen(Object var1);

        public void listen(String var1);
    }
}

