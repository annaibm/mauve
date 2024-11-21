/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.FlatteningPathIterator;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.FlatteningPathIterator;
import java.awt.geom.PathIterator;

public class getWindingRule
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        FlatteningPathIterator fpi = new FlatteningPathIterator(new TestPathIterator(0), 2.0);
        harness.check(fpi.getWindingRule(), 0);
        fpi = new FlatteningPathIterator(new TestPathIterator(1), 23.0);
        harness.check(fpi.getWindingRule(), 1);
    }

    private static class TestPathIterator
    implements PathIterator {
        int rule;

        public TestPathIterator(int rule) {
            this.rule = rule;
        }

        @Override
        public int getWindingRule() {
            return this.rule;
        }

        @Override
        public boolean isDone() {
            return true;
        }

        @Override
        public int currentSegment(float[] f) {
            throw new IllegalStateException();
        }

        @Override
        public int currentSegment(double[] d) {
            throw new IllegalStateException();
        }

        @Override
        public void next() {
            throw new IllegalStateException();
        }
    }
}

