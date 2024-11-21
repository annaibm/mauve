/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.font.NumericShaper;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.font.NumericShaper;

public class Basic
implements Testlet {
    public String xform(String input) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < input.length(); ++i) {
            char c = input.charAt(i);
            if (c < ' ' || c > '\u007f') {
                result.append("\\u").append(Integer.toHexString(c));
                continue;
            }
            result.append(c);
        }
        return result.toString();
    }

    public void testOne(TestHarness harness, String input, NumericShaper shaper, String expected, int context) {
        char[] chars = input.toCharArray();
        if (context == -1) {
            shaper.shape(chars, 0, chars.length);
        } else {
            shaper.shape(chars, 0, chars.length, context);
        }
        harness.check(this.xform(new String(chars)), (Object)this.xform(expected));
    }

    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("non-contextual");
        NumericShaper nonc = NumericShaper.getShaper(16384);
        harness.check(!nonc.isContextual());
        this.testOne(harness, "abc 0123", nonc, "abc \u0f20\u0f21\u0f22\u0f23", -1);
        this.testOne(harness, "abc 0123", nonc, "abc \u0f20\u0f21\u0f22\u0f23", 16);
        nonc = NumericShaper.getShaper(65536);
        this.testOne(harness, "abc 0123", nonc, "abc 0\u1369\u136a\u136b", -1);
        this.testOne(harness, "abc 0123", nonc, "abc 0\u1369\u136a\u136b", 4);
        harness.checkPoint("contextual");
        NumericShaper contextualI = NumericShaper.getContextualShaper(196608);
        NumericShaper contextualE = NumericShaper.getContextualShaper(196608, 1);
        harness.check(contextualE.equals(contextualI));
        harness.check(contextualE.isContextual());
        this.testOne(harness, "45", contextualE, "45", -1);
        this.testOne(harness, "45", contextualE, "\u17e4\u17e5", 131072);
        this.testOne(harness, "45", contextualE, "45", 2);
        this.testOne(harness, "45", contextualE, "\u136c\u136d", 65536);
        this.testOne(harness, "45 \u134d 045 \u1782 045", contextualI, "45 \u134d 0\u136c\u136d \u1782 \u17e0\u17e4\u17e5", -1);
        harness.checkPoint("arabic");
        NumericShaper arabic = NumericShaper.getContextualShaper(6);
        this.testOne(harness, "\u062b 1", arabic, "\u062b \u06f1", -1);
        this.testOne(harness, "1", arabic, "\u06f1", 4);
    }
}

