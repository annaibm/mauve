/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.event.EventListenerList;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.EventListener;
import javax.swing.event.EventListenerList;

public class toString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        EventListenerList ell = new EventListenerList();
        ell.add(EventListener.class, new L1());
        ell.add(L2.class, new L2());
        harness.check(ell.toString(), (Object)"EventListenerList: 2 listeners:  type java.util.EventListener listener l-one type gnu.testlet.javax.swing.event.EventListenerList.toString$L2 listener l-two");
    }

    private static class L2
    implements EventListener {
        private L2() {
        }

        public String toString() {
            return "l-two";
        }
    }

    private static class L1
    implements EventListener {
        private L1() {
        }

        public String toString() {
            return "l-one";
        }
    }
}

