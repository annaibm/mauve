/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.event.EventListenerList;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.EventListener;
import javax.swing.event.EventListenerList;

public class add
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        EventListenerList ell = new EventListenerList();
        L l1 = new L();
        L l2 = new L();
        ell.add(EventListener.class, l1);
        Object[] list2 = ell.getListenerList();
        harness.check(list2.length, 2);
        harness.check(list2[0], EventListener.class);
        harness.check(list2[1] == l1);
        ell.add(L.class, l2);
        list2 = ell.getListenerList();
        harness.check(list2.length, 4);
        harness.check(list2[0], EventListener.class);
        harness.check(list2[1] == l1);
        harness.check(list2[2], L.class);
        harness.check(list2[3] == l2);
        ell = new EventListenerList();
        Exception caught = null;
        try {
            ell.add(L.class, null);
        }
        catch (Exception ex) {
            caught = ex;
        }
        harness.check(caught, null);
        harness.check(ell.getListenerCount(), 0);
        caught = null;
        try {
            ell.add(null, new L());
        }
        catch (Exception ex) {
            caught = ex;
        }
        harness.check(caught != null);
        harness.check(ell.getListenerCount(), 0);
        caught = null;
        try {
            ell.add(L.class, new L2());
        }
        catch (Exception ex) {
            caught = ex;
        }
        harness.check(caught instanceof IllegalArgumentException);
        ell.add(L.class, l1);
        ell.add(L.class, l1);
        harness.check(ell.getListenerCount(), 2);
    }

    private static class L2
    implements EventListener {
        private L2() {
        }
    }

    private static class L
    implements EventListener {
        private L() {
        }
    }
}

