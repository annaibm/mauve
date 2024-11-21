/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.event.EventListenerList;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.EventListener;
import javax.swing.event.EventListenerList;

public class remove
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        EventListenerList ell = new EventListenerList();
        L l1 = new L();
        L l2 = new L();
        ell.add(EventListener.class, l1);
        ell.add(L.class, l2);
        ell.remove(EventListener.class, l1);
        Object[] list2 = ell.getListenerList();
        harness.check(list2.length, 2);
        harness.check(list2[0] == L.class);
        harness.check(list2[1] == l2);
        ell.remove(EventListener.class, l2);
        list2 = ell.getListenerList();
        harness.check(list2.length, 2);
        Exception caught = null;
        try {
            ell.remove(null, l2);
        }
        catch (Exception ex) {
            caught = ex;
        }
        harness.check(caught instanceof NullPointerException);
        caught = null;
        try {
            ell.remove(EventListener.class, null);
        }
        catch (Exception ex) {
            caught = ex;
        }
        harness.check(caught, null);
        caught = null;
        try {
            ell.remove(null, null);
        }
        catch (Exception ex) {
            caught = ex;
        }
        harness.check(caught, null);
        list2 = ell.getListenerList();
        harness.check(list2.length, 2);
        harness.check(list2[0], L.class);
        harness.check(list2[1] == l2);
        ell = new EventListenerList();
        ell.add(L.class, l2);
        ell.add(L.class, l2);
        ell.remove(L.class, l2);
        harness.check(ell.getListenerList().length, 2);
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

