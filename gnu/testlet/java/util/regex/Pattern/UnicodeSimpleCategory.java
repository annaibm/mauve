/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.regex.Pattern;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class UnicodeSimpleCategory
implements Testlet {
    private TestHarness harness;

    @Override
    public void test(TestHarness harness) {
        try {
            harness.checkPoint("L");
            String r = "(\\p{L}+)(\\p{Lu})(\\p{Ll})(\\p{Lt})(\\p{Lm})(\\p{Lo})(\\p{L}+)";
            String t = "Aa\u01c5\u02b0\u05d0";
            String t3 = t + t + t;
            Matcher m = Pattern.compile(r).matcher(t3);
            harness.check(m.find());
            harness.check(m.group(1), (Object)t);
            harness.check(m.group(2), (Object)"A");
            harness.check(m.group(3), (Object)"a");
            harness.check(m.group(4), (Object)"\u01c5");
            harness.check(m.group(5), (Object)"\u02b0");
            harness.check(m.group(6), (Object)"\u05d0");
            harness.check(m.group(7), (Object)t);
            harness.checkPoint("M");
            r = "(\\p{M}+)(\\p{Mn})(\\p{Mc})(\\p{Me})(\\p{M}+)";
            t = "\u064b\u0903\u20dd";
            t3 = t + t + t;
            m = Pattern.compile(r).matcher(t3);
            harness.check(m.find());
            harness.check(m.group(1), (Object)t);
            harness.check(m.group(2), (Object)"\u064b");
            harness.check(m.group(3), (Object)"\u0903");
            harness.check(m.group(4), (Object)"\u20dd");
            harness.check(m.group(5), (Object)t);
            harness.checkPoint("N");
            r = "(\\p{N}+)(\\p{Nd})(\\p{Nl})(\\p{No})(\\p{N}+)";
            t = "0\u2160\u3289";
            t3 = t + t + t;
            m = Pattern.compile(r).matcher(t3);
            harness.check(m.find());
            harness.check(m.group(1), (Object)t);
            harness.check(m.group(2), (Object)"0");
            harness.check(m.group(3), (Object)"\u2160");
            harness.check(m.group(4), (Object)"\u3289");
            harness.check(m.group(5), (Object)t);
            harness.checkPoint("S");
            r = "(\\p{S}+)(\\p{Sm})(\\p{Sc})(\\p{Sk})(\\p{So})(\\p{S}+)";
            t = "+\u00a5\u00b8\u0482";
            t3 = t + t + t;
            m = Pattern.compile(r).matcher(t3);
            harness.check(m.find());
            harness.check(m.group(1), (Object)t);
            harness.check(m.group(2), (Object)"+");
            harness.check(m.group(3), (Object)"\u00a5");
            harness.check(m.group(4), (Object)"\u00b8");
            harness.check(m.group(5), (Object)"\u0482");
            harness.check(m.group(6), (Object)t);
            harness.checkPoint("P");
            r = "(\\p{P}+)(\\p{Pc})(\\p{Pd})(\\p{Ps})(\\p{Pe})(\\p{Pi})(\\p{Pf})(\\p{Po})(\\p{P}+)";
            t = "_-()\u00ab\u00bb!";
            t3 = t + t + t;
            m = Pattern.compile(r).matcher(t3);
            harness.check(m.find());
            harness.check(m.group(1), (Object)t);
            harness.check(m.group(2), (Object)"_");
            harness.check(m.group(3), (Object)"-");
            harness.check(m.group(4), (Object)"(");
            harness.check(m.group(5), (Object)")");
            harness.check(m.group(6), (Object)"\u00ab");
            harness.check(m.group(7), (Object)"\u00bb");
            harness.check(m.group(8), (Object)"!");
            harness.check(m.group(9), (Object)t);
            harness.checkPoint("Z");
            r = "(\\p{Z}+)(\\p{Zs})(\\p{Zl})(\\p{Zp})(\\p{Z}+)";
            t = " \u2028\u2029";
            t3 = t + t + t;
            m = Pattern.compile(r).matcher(t3);
            harness.check(m.find());
            harness.check(m.group(1), (Object)t);
            harness.check(m.group(2), (Object)" ");
            harness.check(m.group(3), (Object)"\u2028");
            harness.check(m.group(4), (Object)"\u2029");
            harness.check(m.group(5), (Object)t);
            harness.checkPoint("C");
            r = "(\\p{C}+)(\\p{Cc})(\\p{Cf})(\\p{Cs})(\\p{Co})(\\p{C}+)";
            t = "\t\u070f\ud800\ue000";
            t3 = t + t + t;
            m = Pattern.compile(r).matcher(t3);
            harness.check(m.find());
            harness.check(m.group(1), (Object)t);
            harness.check(m.group(2), (Object)"\t");
            harness.check(m.group(3), (Object)"\u070f");
            harness.check(m.group(4), (Object)"\ud800");
            harness.check(m.group(5), (Object)"\ue000");
            harness.check(m.group(6), (Object)t);
        }
        catch (PatternSyntaxException pse) {
            harness.debug(pse);
            harness.check(false, pse.toString());
        }
    }
}

