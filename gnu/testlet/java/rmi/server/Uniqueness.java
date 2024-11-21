/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.rmi.server;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.rmi.server.UID;
import java.util.HashSet;

public class Uniqueness
implements Testlet {
    static int complete = 0;

    @Override
    public void test(TestHarness harness) {
        TesterThread[] tt = new TesterThread[20];
        for (int i = 0; i < tt.length; ++i) {
            tt[i] = new TesterThread();
            tt[i].start();
        }
        do {
            try {
                Thread.currentThread();
                Thread.sleep(200L);
            }
            catch (InterruptedException i) {
                // empty catch block
            }
        } while (complete < tt.length);
        HashSet<UID> ids = new HashSet<UID>();
        for (int i = 0; i < tt.length; ++i) {
            for (int j = 0; j < tt[i].result.length; ++j) {
                UID id = tt[i].result[j];
                if (ids.contains(id)) {
                    harness.fail("Duplicate ID " + id);
                    continue;
                }
                ids.add(id);
            }
        }
    }

    static class TesterThread
    extends Thread {
        UID[] result;

        TesterThread() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void run() {
            this.result = new UID[200];
            for (int i = 0; i < this.result.length; ++i) {
                this.result[i] = new UID();
            }
            Class<Uniqueness> clazz = Uniqueness.class;
            synchronized (Uniqueness.class) {
                ++complete;
                // ** MonitorExit[var1_2] (shouldn't be in output)
                return;
            }
        }
    }
}

