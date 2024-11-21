/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Collection;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class Test
implements Testlet {
    private TestHarness harness;

    @Override
    public void test(TestHarness harness) {
        this.harness = harness;
        this.testClass(ArrayBlockingQueue.class);
        this.testClass(ArrayDeque.class);
        this.testClass(ArrayList.class);
        this.testClass(ConcurrentLinkedQueue.class);
        this.testClass(ConcurrentSkipListSet.class);
        this.testClass(CopyOnWriteArrayList.class);
        this.testClass(CopyOnWriteArraySet.class);
        this.testClass(DelayQueue.class);
        this.testClass(EnumSet.class);
        this.testClass(HashSet.class);
        this.testClass(LinkedBlockingQueue.class);
        this.testClass(LinkedHashSet.class);
        this.testClass(LinkedList.class);
        this.testClass(PriorityBlockingQueue.class);
        this.testClass(PriorityQueue.class);
        this.testClass(Stack.class);
        this.testClass(SynchronousQueue.class);
        this.testClass(TreeSet.class);
        this.testClass(Vector.class);
    }

    public void testClass(Class<? extends Collection> cls) {
        this.harness.checkPoint(cls.getName());
        Collection result = null;
        try {
            result = cls.newInstance();
        }
        catch (Exception e) {
            this.harness.debug(e);
        }
        if (result != null) {
            this.testRemove(result);
        }
    }

    public void testRemove(Collection coll) {
        Delayed obj = new Delayed(){

            @Override
            public long getDelay(TimeUnit unit) {
                return unit.convert(10L, TimeUnit.MINUTES);
            }

            @Override
            public int compareTo(Delayed o) {
                Long other = o.getDelay(TimeUnit.NANOSECONDS);
                return other.compareTo(this.getDelay(TimeUnit.NANOSECONDS));
            }
        };
        String type = coll.getClass().getName();
        this.harness.check(!coll.remove(obj), "Object is not present in empty " + type);
        boolean result = false;
        try {
            result = coll.remove(null);
        }
        catch (NullPointerException nullPointerException2) {
            // empty catch block
        }
        this.harness.check(!result, "Null is not present in empty " + type);
        if (coll instanceof BlockingQueue && ((BlockingQueue)coll).remainingCapacity() == 0) {
            return;
        }
        coll.add(obj);
        this.harness.check(coll.remove(obj), "Object is present in non-empty " + type);
        result = true;
        try {
            coll.add(null);
            result = coll.remove(null);
        }
        catch (NullPointerException nullPointerException3) {
            // empty catch block
        }
        this.harness.check(result, "Null is present in non-empty " + type);
    }
}

