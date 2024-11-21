/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.StreamTokenizer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;

public class misc
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        StringReader sr = new StringReader("LineOne\nSecond/Line\n?Question?3.14\nAxyz");
        StreamTokenizer st = new StreamTokenizer(sr);
        st.eolIsSignificant(true);
        st.ordinaryChar(47);
        st.lowerCaseMode(true);
        try {
            int tt = st.nextToken();
            harness.check(st.lineno(), 1, "lineno()");
            harness.check(st.sval, "lineone", "lowerCaseMode()");
            tt = st.nextToken();
            harness.check(tt, 10, "eolIsSignificant()");
            tt = st.nextToken();
            tt = st.nextToken();
            st.lowerCaseMode(false);
            tt = st.nextToken();
            harness.check(st.sval, "Line", "ordinaryChar()");
            st.pushBack();
            tt = st.nextToken();
            harness.check(st.sval, "Line", "pushBack()");
            st.quoteChar(63);
            tt = st.nextToken();
            tt = st.nextToken();
            harness.check(st.ttype, 63, "ttype field");
            harness.check(st.sval, "Question", "quoteChar()");
            st.parseNumbers();
            tt = st.nextToken();
            harness.check(tt, -2, "TT_NUMBER");
            harness.check(st.nval > 3.1399 && st.nval < 3.1401, "parseNumbers()");
            harness.debug("'3.14' came out " + st.nval);
            st.ordinaryChars(65, 67);
            tt = st.nextToken();
            harness.check(st.nextToken(), 65, "ordinaryChars()");
            st.resetSyntax();
            harness.check(st.nextToken(), 120, "resetSyntax()");
        }
        catch (IOException e) {
            harness.debug(e);
            harness.fail("Unexpected Exception caught");
        }
    }
}

