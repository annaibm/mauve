/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.Utilities;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Font;
import java.awt.FontMetrics;
import javax.swing.text.Segment;
import javax.swing.text.Utilities;

public class getTabbedTextOffset
implements Testlet {
    static FontMetrics fm = new TestFontMetrics();
    static Segment s = getTabbedTextOffset.createSegment("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");

    @Override
    public void test(TestHarness harness) {
        int i;
        int endX = 50;
        harness.checkPoint("without rounding");
        for (i = 0; i <= endX; ++i) {
            harness.check(getTabbedTextOffset.calculate(i, false), getTabbedTextOffset.expectWithoutRounding(i));
        }
        harness.checkPoint("with rounding");
        for (i = 0; i <= endX; ++i) {
            harness.check(getTabbedTextOffset.calculate(i, true), getTabbedTextOffset.expectWithRounding(i));
        }
        harness.checkPoint("with rounding (implicit)");
        for (i = 0; i <= endX; ++i) {
            harness.check(getTabbedTextOffset.calculate(i), getTabbedTextOffset.expectWithRounding(i));
        }
    }

    static int calculate(int index) {
        return Utilities.getTabbedTextOffset(s, fm, 0, index, null, 0);
    }

    static int calculate(int index, boolean round) {
        return Utilities.getTabbedTextOffset(s, fm, 0, index, null, 0, round);
    }

    static int expectWithoutRounding(int index) {
        return index / 10;
    }

    static int expectWithRounding(int index) {
        return (index + 5) / 10;
    }

    static Segment createSegment(String foo) {
        return new Segment(foo.toCharArray(), 0, foo.length());
    }

    static class TestFontMetrics
    extends FontMetrics {
        public TestFontMetrics() {
            super(new Font(null, 0, 10));
        }

        @Override
        public int getAscent() {
            return 10;
        }

        @Override
        public int getLeading() {
            return 10;
        }

        @Override
        public int getMaxAdvance() {
            return 10;
        }

        @Override
        public int charWidth(char ch) {
            return 10;
        }

        @Override
        public int charsWidth(char[] a, int offs, int len) {
            return len * 10;
        }
    }
}

