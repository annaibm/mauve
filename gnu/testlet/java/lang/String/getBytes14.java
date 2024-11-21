/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.String;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.lang.String.getBytes13;

public class getBytes14
extends getBytes13
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("getBytes14");
        this.test1Encoding(harness, "US-ASCII", "abc", ABC1);
        this.test1Encoding(harness, "windows-1252", "abc", ABC1);
        this.test1Encoding(harness, "ISO-8859-1", "abc", ABC1);
        this.test1Encoding(harness, "ISO-8859-15", "abc", ABC1);
        this.test1Encoding(harness, "ISO8859_15", "abc", ABC1);
        this.test1Encoding(harness, "UTF-8", "abc", ABC1);
        this.test1Encoding(harness, "UTF-16BE", "abc", ABC3);
        this.test1Encoding(harness, "UTF-16LE", "abc", ABC5);
    }
}

