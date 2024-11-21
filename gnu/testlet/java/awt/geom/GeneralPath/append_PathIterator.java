/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.GeneralPath;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.GeneralPath;
import java.awt.geom.IllegalPathStateException;
import java.awt.geom.Line2D;
import java.awt.geom.PathIterator;

public class append_PathIterator
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test_notConnecting(harness);
        this.test_connecting(harness);
        this.test_empty(harness);
    }

    public void test_notConnecting(TestHarness harness) {
        harness.checkPoint("notConnecting");
        double[] c = new double[6];
        PathIterator piter = new PathIterator(){
            int i = 0;

            @Override
            public int getWindingRule() {
                return 0;
            }

            @Override
            public boolean isDone() {
                return this.i >= 7;
            }

            @Override
            public void next() {
                ++this.i;
            }

            @Override
            public int currentSegment(float[] c) {
                double[] d = new double[c.length];
                int r = this.currentSegment(d);
                for (int i = 0; i < d.length; ++i) {
                    c[i] = (float)d[i];
                }
                return r;
            }

            @Override
            public int currentSegment(double[] c) {
                switch (this.i) {
                    case 0: {
                        c[0] = 10.0;
                        c[1] = 11.0;
                        return 0;
                    }
                    case 1: {
                        c[0] = 20.0;
                        c[1] = 21.0;
                        return 1;
                    }
                    case 2: {
                        c[0] = 30.0;
                        c[1] = 31.0;
                        c[2] = 32.0;
                        c[3] = 33.0;
                        return 2;
                    }
                    case 3: {
                        c[0] = 40.0;
                        c[1] = 41.0;
                        c[2] = 42.0;
                        c[3] = 43.0;
                        c[4] = 44.0;
                        c[5] = 45.0;
                        return 3;
                    }
                    case 4: {
                        return 4;
                    }
                    case 5: {
                        c[0] = 50.0;
                        c[1] = 51.0;
                        return 0;
                    }
                    case 6: {
                        c[0] = 60.0;
                        c[1] = 61.0;
                        return 1;
                    }
                }
                throw new IllegalPathStateException();
            }
        };
        GeneralPath path = new GeneralPath(1);
        path.append(piter, false);
        harness.check(path.getWindingRule(), 1);
        PathIterator resPiter = path.getPathIterator(null);
        harness.check(!resPiter.isDone());
        harness.check(resPiter.currentSegment(c), 0);
        harness.check(c[0], 10.0);
        harness.check(c[1], 11.0);
        resPiter.next();
        harness.check(!resPiter.isDone());
        harness.check(resPiter.currentSegment(c), 1);
        harness.check(c[0], 20.0);
        harness.check(c[1], 21.0);
        resPiter.next();
        harness.check(!resPiter.isDone());
        harness.check(resPiter.currentSegment(c), 2);
        harness.check(c[0], 30.0);
        harness.check(c[1], 31.0);
        harness.check(c[2], 32.0);
        harness.check(c[3], 33.0);
        resPiter.next();
        harness.check(!resPiter.isDone());
        harness.check(resPiter.currentSegment(c), 3);
        harness.check(c[0], 40.0);
        harness.check(c[1], 41.0);
        harness.check(c[2], 42.0);
        harness.check(c[3], 43.0);
        harness.check(c[4], 44.0);
        harness.check(c[5], 45.0);
        resPiter.next();
        harness.check(!resPiter.isDone());
        harness.check(resPiter.currentSegment(c), 4);
        resPiter.next();
        harness.check(!resPiter.isDone());
        harness.check(resPiter.currentSegment(c), 0);
        harness.check(c[0], 50.0);
        harness.check(c[1], 51.0);
        resPiter.next();
        harness.check(!resPiter.isDone());
        harness.check(resPiter.currentSegment(c), 1);
        harness.check(c[0], 60.0);
        harness.check(c[1], 61.0);
        resPiter.next();
        harness.check(resPiter.isDone());
        harness.check(piter.isDone());
    }

    public void test_connecting(TestHarness harness) {
        float[] c = new float[6];
        harness.checkPoint("connecting");
        GeneralPath path = new GeneralPath();
        path.moveTo(10.0f, 11.0f);
        path.append(new Line2D.Double(20.0, 21.0, 30.0, 31.0).getPathIterator(null), true);
        PathIterator pit = path.getPathIterator(null);
        harness.check(!pit.isDone());
        harness.check(pit.currentSegment(c), 0);
        harness.check(c[0], 10.0);
        harness.check(c[1], 11.0);
        pit.next();
        harness.check(!pit.isDone());
        harness.check(pit.currentSegment(c), 1);
        harness.check(c[0], 20.0);
        harness.check(c[1], 21.0);
        pit.next();
        harness.check(!pit.isDone());
        harness.check(pit.currentSegment(c), 1);
        harness.check(c[0], 30.0);
        harness.check(c[1], 31.0);
        pit.next();
        harness.check(pit.isDone());
    }

    public void test_empty(TestHarness harness) {
        harness.checkPoint("empty");
        GeneralPath path = new GeneralPath();
        path.append(new EmptyPathIterator(), false);
        harness.check(path.getPathIterator(null).isDone());
        path.append(new EmptyPathIterator(), true);
        harness.check(path.getPathIterator(null).isDone());
    }

    private static class EmptyPathIterator
    implements PathIterator {
        private EmptyPathIterator() {
        }

        @Override
        public int getWindingRule() {
            return 0;
        }

        @Override
        public boolean isDone() {
            return true;
        }

        @Override
        public void next() {
            throw new IllegalPathStateException();
        }

        @Override
        public int currentSegment(float[] c) {
            throw new IllegalPathStateException();
        }

        @Override
        public int currentSegment(double[] c) {
            throw new IllegalPathStateException();
        }
    }
}

