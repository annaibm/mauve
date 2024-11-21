/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.ClassLoader;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class Resources
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("Resource loading");
        System.out.println(this.getClass().getClassLoader());
        try {
            this.getClass().getClassLoader().getResource("gnu/testlet/java/lang/ClassLoader/Resources.class").getFile();
            harness.check(true);
        }
        catch (Exception e) {
            harness.fail("Class resource should exist");
        }
        try {
            this.getClass().getClassLoader().getResource("gnu/testlet/java/lang/ClassLoader/").getFile();
            harness.check(true);
        }
        catch (Exception e) {
            harness.fail("Class directory should exist");
        }
        try {
            this.getClass().getClassLoader().getResource("gnu/testlet/java/lang/ClassLoader").getFile();
            harness.check(true);
        }
        catch (Exception e) {
            harness.fail("Class directory should exist");
        }
    }
}

