/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Thread;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class name
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Thread current2 = Thread.currentThread();
        harness.check(current2.getName() != null, "Every Thread has a non-null name");
        Thread t = new Thread("Test-Thread");
        harness.check(t.getName().equals("Test-Thread"), "Create thread with name");
        t.setName("Test-Thread-NewName");
        harness.check(t.getName().equals("Test-Thread-NewName"), "Setting new for Thread");
        t.start();
        t.setName("Test-Thread-NewName-Started");
        harness.check(t.getName().equals("Test-Thread-NewName-Started"), "Setting new name for started Thread");
        boolean null_exception = false;
        try {
            new Thread((String)null);
        }
        catch (NullPointerException npe) {
            null_exception = true;
        }
        harness.check(null_exception, "Cannot create Thread with null name");
        t = new Thread();
        String name2 = t.getName();
        harness.check(name2 != null, "New Thread has non-null name");
        null_exception = false;
        try {
            t.setName(null);
        }
        catch (NullPointerException npe) {
            null_exception = true;
        }
        harness.check(null_exception, "Cannot set Thread name to null");
        harness.check(t.getName().equals(name2), "Setting Thread name to null doesn't change name");
    }
}

