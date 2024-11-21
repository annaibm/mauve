/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.CollationElementIterator;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.CollationElementIterator;
import java.text.RuleBasedCollator;

public class jdk11
implements Testlet {
    String JDK_1_4_EN_US_RULES = "='\u200b'=\u200c=\u200d=\u200e=\u200f=\u0000 =\u0001 =\u0002 =\u0003 =\u0004=\u0005 =\u0006 =\u0007 =\b ='\t'='\u000b' =\u000e=\u000f ='\u0010' =\u0011 =\u0012 =\u0013=\u0014 =\u0015 =\u0016 =\u0017 =\u0018=\u0019 =\u001a =\u001b =\u001c =\u001d=\u001e =\u001f =\u007f=\u0080 =\u0081 =\u0082 =\u0083 =\u0084 =\u0085=\u0086 =\u0087 =\u0088 =\u0089 =\u008a =\u008b=\u008c =\u008d =\u008e =\u008f =\u0090 =\u0091=\u0092 =\u0093 =\u0094 =\u0095 =\u0096 =\u0097=\u0098 =\u0099 =\u009a =\u009b =\u009c =\u009d=\u009e =\u009f;' ';'\u00a0';'\u2000';'\u2001';'\u2002';'\u2003';'\u2004';'\u2005';'\u2006';'\u2007';'\u2008';'\u2009';'\u200a';'\u3000';'\ufeff';'\r' ;'\t' ;'\n';'\f';'\u000b';\u0301;\u0300;\u0306;\u0302;\u030c;\u030a;\u030d;\u0308;\u030b;\u0303;\u0307;\u0304;\u0337;\u0327;\u0328;\u0323;\u0332;\u0305;\u0309;\u030e;\u030f;\u0310;\u0311;\u0312;\u0313;\u0314;\u0315;\u0316;\u0317;\u0318;\u0319;\u031a;\u031b;\u031c;\u031d;\u031e;\u031f;\u0320;\u0321;\u0322;\u0324;\u0325;\u0326;\u0329;\u032a;\u032b;\u032c;\u032d;\u032e;\u032f;\u0330;\u0331;\u0333;\u0334;\u0335;\u0336;\u0338;\u0339;\u033a;\u033b;\u033c;\u033d;\u033e;\u033f;\u0342;\u0344;\u0345;\u0360;\u0361;\u0483;\u0484;\u0485;\u0486;\u20d0;\u20d1;\u20d2;\u20d3;\u20d4;\u20d5;\u20d6;\u20d7;\u20d8;\u20d9;\u20da;\u20db;\u20dc;\u20dd;\u20de;\u20df;\u20e0;\u20e1,'-';\u00ad;\u2010;\u2011;\u2012;\u2013;\u2014;\u2015;\u2212<'_'<\u00af<','<';'<':'<'!'<\u00a1<'?'<\u00bf<'/'<'.'<\u00b4<'`'<'^'<\u00a8<'~'<\u00b7<\u00b8<'''<'\"'<\u00ab<\u00bb<'('<')'<'['<']'<'{'<'}'<\u00a7<\u00b6<\u00a9<\u00ae<'@'<\u00a4<\u0e3f<\u00a2<\u20a1<\u20a2<'$'<\u20ab<\u20ac<\u20a3<\u20a4<\u20a5<\u20a6<\u20a7<\u00a3<\u20a8<\u20aa<\u20a9<\u00a5<'*'<'\\'<'&'<'#'<'%'<'+'<\u00b1<\u00f7<\u00d7<'<'<'='<'>'<\u00ac<'|'<\u00a6<\u00b0<\u00b5<0<1<2<3<4<5<6<7<8<9<\u00bc<\u00bd<\u00be<a,A<b,B<c,C<d,D<\u00f0,\u00d0<e,E<f,F<g,G<h,H<i,I<j,J<k,K<l,L<m,M<n,N<o,O<p,P<q,Q<r,R<s, S & SS,\u00df<t,T& TH, \u00de &TH, \u00fe <u,U<v,V<w,W<x,X<y,Y<z,Z&AE,\u00c6&AE,\u00e6&OE,\u0152&OE,\u0153";
    private static final int PRIMARY = 1;
    private static final int SECONDARY = 2;
    private static final int TERTIARY = 3;
    private static final int NONE = 4;
    private static TestHarness harness = null;

    static void checkOrder(CollationElementIterator iterator, int count, int order, String tag) {
        try {
            int key = iterator.next();
            int[] prev = new int[]{key, CollationElementIterator.primaryOrder(key), CollationElementIterator.secondaryOrder(key), CollationElementIterator.tertiaryOrder(key)};
            harness.debug("first = {" + prev[0] + ", " + prev[1] + ", " + prev[2] + ", " + prev[3] + "}");
            harness.check(key != -1, "first " + tag);
            int i = 1;
            while ((key = iterator.next()) != -1) {
                int[] next2 = new int[]{key, CollationElementIterator.primaryOrder(key), CollationElementIterator.secondaryOrder(key), CollationElementIterator.tertiaryOrder(key)};
                harness.debug("next (" + ++i + ") = {" + next2[0] + ", " + next2[1] + ", " + next2[2] + ", " + next2[3] + "}");
                harness.check(next2[0] > prev[0], "next() " + i + " " + tag);
                if (order == 1) {
                    harness.check(next2[1] > prev[1], "no primary difference " + i + " " + tag);
                } else if (order == 2) {
                    harness.check(next2[1] > prev[1] || next2[1] == prev[1] && next2[2] > prev[2], "no secondary difference" + i + " " + tag);
                } else if (order == 3) {
                    harness.check(next2[1] > prev[1] || next2[1] == prev[1] && next2[2] > prev[2] || next2[1] == prev[1] && next2[2] == prev[2] && next2[3] > prev[3], "no tertiary difference" + i + " " + tag);
                }
                prev = next2;
            }
            if (count != i) {
                harness.debug("count is " + count + ", i is " + i);
            }
            harness.check(count == i, "wrong number of keys " + tag);
        }
        catch (Throwable t) {
            harness.debug(t);
            harness.fail("CollationElementIterator with localeName");
        }
    }

    static void checkEquiv(CollationElementIterator iterator, String[] sets, int order, String tag) {
        try {
            for (int i = 0; i < sets.length; ++i) {
                iterator.setText(sets[i]);
                int key = iterator.next();
                int[] prev = new int[]{key, CollationElementIterator.primaryOrder(key), CollationElementIterator.secondaryOrder(key), CollationElementIterator.tertiaryOrder(key)};
                harness.debug("first = {" + prev[0] + ", " + prev[1] + ", " + prev[2] + ", " + prev[3] + "}");
                harness.check(key != -1, "first " + tag);
                int j = 1;
                while ((key = iterator.next()) != -1) {
                    int[] next2 = new int[]{key, CollationElementIterator.primaryOrder(key), CollationElementIterator.secondaryOrder(key), CollationElementIterator.tertiaryOrder(key)};
                    harness.debug("next (" + i + ", " + ++j + ") = {" + next2[0] + ", " + next2[1] + ", " + next2[2] + ", " + next2[3] + "}");
                    if (order == 1) {
                        harness.check(next2[1] > prev[1], "not primary ordered " + i + ", " + j + " " + tag);
                    } else if (order == 2) {
                        harness.check(next2[1] == prev[1] && next2[2] > prev[2], "not secondary ordered" + i + ", " + j + " " + tag);
                    } else if (order == 3) {
                        harness.check(next2[1] == prev[1] && next2[2] == prev[2] && next2[3] > prev[3], "not tertiary ordered" + i + ", " + j + " " + tag);
                    } else if (order == 4) {
                        harness.check(next2[1] == prev[1], "keys not equal");
                    }
                    prev = next2;
                }
                if (sets[i].length() != j) {
                    harness.debug("length[" + i + "] is " + sets[i].length() + ", j is " + j);
                }
                harness.check(sets[i].length() == j, "wrong number of keys (" + j + ") " + tag);
            }
        }
        catch (Throwable t) {
            harness.debug(t);
            harness.fail("CollationElementIterator with localeName");
        }
    }

    @Override
    public void test(TestHarness harness) {
        String[] TEST_STRINGS = new String[]{"X", "12", "abcdefghijklmnopqrstuvwxyz", "0123456789", " _,;:!?/.`^~'\"()[]{}@$*\\&#%+<=>|A", "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ"};
        int[] TEST_ORDERS = new int[]{1, 1, 1, 1, 1, 3};
        String[][] TEST_STRINGS2 = new String[][]{{"aA", "bB", "cC", "dD", "eE", "fF", "gG", "hH", "iI", "jJ", "kK", "lL", "mM", "nN", "oO", "pP", "qQ", "rR", "sS", "tT", "uU", "vV", "wW", "xX", "yY", "zZ"}};
        int[] TEST_ORDERS2 = new int[]{3};
        jdk11.harness = harness;
        try {
            int i;
            harness.check(-1, -1, "NULLORDER");
            RuleBasedCollator en_USCollator = new RuleBasedCollator(this.JDK_1_4_EN_US_RULES);
            CollationElementIterator iterator = en_USCollator.getCollationElementIterator("abcdefg");
            jdk11.checkOrder(iterator, 7, 1, "initial test");
            harness.checkPoint("reset()");
            iterator.reset();
            jdk11.checkOrder(iterator, 7, 1, "initial test after reset()");
            iterator = en_USCollator.getCollationElementIterator("");
            harness.check(iterator.next(), -1, "next()");
            for (i = 0; i < TEST_STRINGS.length; ++i) {
                iterator = en_USCollator.getCollationElementIterator(TEST_STRINGS[i]);
                jdk11.checkOrder(iterator, TEST_STRINGS[i].length(), TEST_ORDERS[i], "test string #" + i);
            }
            for (i = 0; i < TEST_STRINGS2.length; ++i) {
                jdk11.checkEquiv(iterator, TEST_STRINGS2[i], TEST_ORDERS2[i], "test set #" + i);
            }
        }
        catch (Throwable t) {
            harness.debug(t);
            harness.fail("CollationElementIterator");
        }
    }
}

