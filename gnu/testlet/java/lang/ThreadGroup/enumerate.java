/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.ThreadGroup;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class enumerate
extends Thread
implements Testlet {
    public enumerate(ThreadGroup g, String name2) {
        super(g, name2);
    }

    public enumerate() {
    }

    @Override
    public void test(TestHarness harness) {
        ThreadGroup here = Thread.currentThread().getThreadGroup();
        ThreadGroup group = new ThreadGroup(here, "enumtestgroup");
        ThreadGroup group2 = new ThreadGroup(group, "enumsubgroup");
        enumerate e = new enumerate(group, "name1");
        e = new enumerate(group2, "name2");
        int thread_count = group.activeCount() + 10;
        Thread[] thread_list = new Thread[thread_count];
        thread_count = group.enumerate(thread_list, true);
        harness.check(thread_count, 0);
    }
}

