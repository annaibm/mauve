/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.Annotation;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.Annotation;

public class Test
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Annotation a = new Annotation("FOOBAR");
        harness.debug(a.toString());
        harness.check(a.getValue(), (Object)"FOOBAR");
    }
}

