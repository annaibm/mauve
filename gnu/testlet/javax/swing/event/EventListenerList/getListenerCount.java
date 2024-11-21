/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.event.EventListenerList;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.EventListener;
import javax.swing.event.EventListenerList;

public class getListenerCount
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        EventListenerList ell = new EventListenerList();
        L1 l1 = new L1();
        L2 l2 = new L2();
        L3 l3_1 = new L3();
        L3 l3_2 = new L3();
        harness.check(ell.getListenerCount(), 0);
        harness.check(ell.getListenerCount(L1.class), 0);
        harness.check(ell.getListenerCount(null), 0);
        harness.check(ell.getListenerCount(String.class), 0);
        ell.add(L1.class, l1);
        ell.add(L2.class, l2);
        ell.add(L1.class, l3_1);
        ell.add(L3.class, l3_2);
        harness.check(ell.getListenerCount(), 4);
        harness.check(ell.getListenerCount(L1.class), 2);
        harness.check(ell.getListenerCount(L2.class), 1);
        harness.check(ell.getListenerCount(L3.class), 1);
    }

    private static class L3
    extends L1 {
        private L3() {
        }
    }

    private static class L2
    extends L1 {
        private L2() {
        }
    }

    private static class L1
    implements EventListener {
        private L1() {
        }
    }
}

