/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.AbstractCollection;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;

public class toString
implements Testlet,
Comparator {
    @Override
    public void test(TestHarness harness) {
        this.testCollection(new LinkedList(), harness);
        this.testCollection(new ArrayList(), harness);
        this.testCollection(new Vector(), harness);
        this.testCollection(new Stack(), harness);
        this.testCollection(new HashSet(), harness);
        this.testCollection(new LinkedHashSet(), harness);
        this.testCollection(new TreeSet(this), harness);
    }

    private void testCollection(Collection c, TestHarness h) {
        h.checkPoint(c.getClass().getName());
        c.add(new Integer(123));
        c.add(c);
        c.add("abc");
        String s = c.toString();
        h.debug(s);
        h.check(s.indexOf("123") != -1);
        h.check(s.indexOf("abc") != -1);
    }

    public int compare(Object o1, Object o2) {
        return String.valueOf(o1).compareTo(String.valueOf(o2));
    }

    @Override
    public boolean equals(Object o) {
        return o == this;
    }
}

