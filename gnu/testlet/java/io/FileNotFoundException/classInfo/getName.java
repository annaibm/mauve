/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.FileNotFoundException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.FileNotFoundException;

public class getName
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        FileNotFoundException o = new FileNotFoundException("filename");
        Class<?> c = o.getClass();
        harness.check(c.getName(), (Object)"java.io.FileNotFoundException");
    }
}

