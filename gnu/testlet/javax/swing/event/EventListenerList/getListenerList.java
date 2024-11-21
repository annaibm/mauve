/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.event.EventListenerList;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.EventListener;
import javax.swing.event.EventListenerList;

public class getListenerList
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        EventListenerList ell = new EventListenerList();
        L l1 = new L();
        L l2 = new L();
        Object[] list2 = ell.getListenerList();
        harness.check(list2.length, 0);
        ell.add(EventListener.class, l1);
        ell.add(L.class, l2);
        list2 = ell.getListenerList();
        harness.check(list2.length, 4);
        harness.check(list2[0] == EventListener.class);
        harness.check(list2[1] == l1);
        harness.check(list2[2] == L.class);
        harness.check(list2[3] == l2);
        harness.check(ell.getListenerList() == list2);
        ell.remove(EventListener.class, l1);
        list2 = ell.getListenerList();
        harness.check(list2.length, 2);
        harness.check(list2[0] == L.class);
        harness.check(list2[1] == l2);
    }

    private static class L
    implements EventListener {
        private L() {
        }
    }
}

