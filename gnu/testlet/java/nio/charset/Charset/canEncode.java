/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.nio.charset.Charset;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

public class canEncode
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        CharsetEncoder enc = Charset.forName("US-ASCII").newEncoder();
        harness.check(!enc.canEncode('\u00e4'));
    }
}

