/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.logging.LogRecord;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.ListResourceBundle;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class setResourceBundle
implements Testlet {
    @Override
    public void test(TestHarness th) {
        LogRecord rec = new LogRecord(Level.CONFIG, "foo");
        TestResourceBundle testBundle = new TestResourceBundle();
        th.check(rec.getResourceBundle(), null);
        rec.setResourceBundle(testBundle);
        th.check(rec.getResourceBundle() == testBundle);
        rec.setResourceBundle(null);
        th.check(rec.getResourceBundle(), null);
    }

    public static class TestResourceBundle
    extends ListResourceBundle {
        private final Object[][] contents = new Object[][]{{"test1", "foo-bar-baz"}, {"test2", "the single parameter is {0}"}, {"test3", "the two parameters are {0} and {1}"}};

        @Override
        protected Object[][] getContents() {
            return this.contents;
        }
    }
}

