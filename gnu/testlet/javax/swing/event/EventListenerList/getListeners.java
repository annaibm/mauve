/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.event.EventListenerList;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.EventListener;
import javax.swing.event.EventListenerList;

public class getListeners
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        EventListenerList ell = new EventListenerList();
        L1 l1a = new L1();
        L1 l1b = new L1();
        L2 l2 = new L2();
        L3 l3 = new L3();
        ell.add(EventListener.class, l1a);
        ell.add(L2.class, l2);
        ell.add(L3.class, l3);
        ell.add(L1.class, l1b);
        EventListener[] list2 = ell.getListeners(L1.class);
        harness.check(list2.length, 1);
        harness.check(list2[0] == l1b);
        harness.check(list2.getClass().getComponentType(), L1.class);
        list2 = ell.getListeners(L2.class);
        harness.check(list2.length, 1);
        harness.check(list2[0] == l2);
        harness.check(list2.getClass().getComponentType(), L2.class);
        list2 = ell.getListeners(L3.class);
        harness.check(list2.length, 1);
        harness.check(list2[0] == l3);
        harness.check(list2.getClass().getComponentType(), L3.class);
        list2 = ell.getListeners(EventListener.class);
        harness.check(list2.length, 1);
        harness.check(list2[0] == l1a);
        harness.check(list2.getClass().getComponentType(), EventListener.class);
        harness.check(((L4[])ell.getListeners(L4.class)).length, 0);
        Exception caught = null;
        try {
            ell.getListeners(null);
        }
        catch (Exception ex) {
            caught = ex;
        }
        harness.check(caught instanceof NullPointerException);
    }

    private static class L4
    implements EventListener {
        private L4() {
        }
    }

    private static class L3
    extends L2 {
        private L3() {
        }
    }

    private static class L2
    implements EventListener {
        private L2() {
        }
    }

    private static class L1
    implements EventListener {
        private L1() {
        }
    }
}

