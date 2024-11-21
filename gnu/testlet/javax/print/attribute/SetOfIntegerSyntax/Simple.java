/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.print.attribute.SetOfIntegerSyntax;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.print.attribute.SetOfIntegerSyntax;

public class Simple
extends SetOfIntegerSyntax
implements Testlet {
    public Simple() {
        super(3);
    }

    public Simple(int lowerBound, int upperBound) {
        super(lowerBound, upperBound);
    }

    public Simple(int member) {
        super(member);
    }

    public Simple(int[][] members) {
        super(members);
    }

    public Simple(String s) {
        super(s);
    }

    @Override
    public void test(TestHarness harness) {
        Simple single = new Simple(5);
        Simple range2 = new Simple(new int[][]{{1, 5}});
        Simple rangeTwo = new Simple(new int[][]{{1, 5}, {10, 12}});
        harness.checkPoint("single-value equals");
        harness.check(new Simple(5), single);
        harness.check(new Simple(new int[][]{{5}}), single);
        harness.check(new Simple(new int[][]{{1, 0}, {5, 5}}), single);
        harness.check(new Simple("5"), single);
        harness.check(new Simple("1-0,5"), single);
        harness.check(new Simple("5,1:0,5"), single);
        harness.checkPoint("single-range equals");
        harness.check(new Simple(new int[][]{{1, 5}}), range2);
        harness.check(new Simple("1-5"), range2);
        harness.check(new Simple("1:5,5-1"), range2);
        harness.check(new Simple("1-3,1-5"), range2);
        harness.check(new Simple("1-5,1-3"), range2);
        harness.check(new Simple("1-3,2-5"), range2);
        harness.check(new Simple("1-3,4-5"), range2);
        harness.check(new Simple("4-5,1-3"), range2);
        harness.check(new Simple(1, 5), range2);
        harness.checkPoint("two-range equals");
        harness.check(new Simple(new int[][]{{10, 12}, {1, 5}}), rangeTwo);
        harness.check(new Simple("1-3,2-5,10,11:12"), rangeTwo);
        harness.checkPoint("next");
        harness.check(single.next(0), 5);
        harness.check(single.next(5), -1);
        harness.check(single.next(38), -1);
        harness.check(range2.next(0), 1);
        harness.check(range2.next(1), 2);
        harness.check(range2.next(4), 5);
        harness.check(range2.next(5), -1);
        harness.check(rangeTwo.next(5), 10);
        harness.checkPoint("hashCode");
        harness.check(single.hashCode(), 10);
        harness.check(range2.hashCode(), 6);
        harness.checkPoint("toString");
        harness.check(single.toString(), (Object)"5");
        harness.check(range2.toString(), (Object)"1-5");
        harness.check(rangeTwo.toString(), (Object)"1-5,10-12");
        harness.checkPoint("contains");
        harness.check(single.contains(5));
        harness.check(range2.contains(2));
        harness.check(rangeTwo.contains(12));
        harness.check(single.contains(6), false);
        harness.check(range2.contains(6), false);
        harness.check(rangeTwo.contains(8), false);
        harness.checkPoint("constructors");
        try {
            new Simple((String)null);
            harness.check(true);
        }
        catch (NullPointerException e) {
            harness.check(false);
        }
        try {
            new Simple((int[][])null);
            harness.check(true);
        }
        catch (NullPointerException e) {
            harness.check(false);
        }
        try {
            new Simple(new int[][]{{1, 5}, null});
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        try {
            new Simple(new int[][]{null});
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        try {
            new Simple(new int[][]{{1, 2, 3}});
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            new Simple(new int[][]{{-1, 2}});
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            new Simple(14, 12);
            harness.check(true);
        }
        catch (NullPointerException e) {
            harness.check(false);
        }
        harness.checkPoint("normalization");
        harness.check(new Simple("17- 99,1:3,12").toString(), (Object)"1-3,12,17-99");
        harness.check(new Simple("17- 99,19-20,14-18").toString(), (Object)"14-99");
    }
}

