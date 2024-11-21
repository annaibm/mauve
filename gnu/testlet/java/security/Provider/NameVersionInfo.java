/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.Provider;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.security.Provider;

public class NameVersionInfo
extends Provider
implements Testlet {
    static final String NAME = "Mauve-Test-Provider";
    static final double VERSION = 3.14;
    static final String INFO = "Mauve Info-Test";

    public NameVersionInfo() {
        super(NAME, 3.14, INFO);
    }

    @Override
    public void test(TestHarness harness) {
        harness.check(this.getName(), (Object)NAME);
        harness.check(this.getVersion(), 3.14);
        harness.check(this.getInfo(), (Object)INFO);
    }
}

