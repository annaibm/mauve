/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.StreamTokenizer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;

public class WordWhiteChars
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        StreamTokenizer st = new StreamTokenizer(new StringReader("foo bar,baz"));
        st.wordChars(0, 255);
        st.whitespaceChars(32, 32);
        st.whitespaceChars(44, 44);
        try {
            harness.check(st.nextToken(), -3);
            harness.check(st.sval, (Object)"foo");
            harness.check(st.nextToken(), -3);
            harness.check(st.sval, (Object)"bar");
            harness.check(st.nextToken(), -3);
            harness.check(st.sval, (Object)"baz");
            harness.check(st.nextToken(), -1);
        }
        catch (IOException ioe) {
            harness.fail(ioe.toString());
        }
    }
}

