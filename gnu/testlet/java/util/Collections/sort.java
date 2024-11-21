/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Collections;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class sort
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testMethod1(harness);
        this.testMethod2(harness);
    }

    public void testMethod1(TestHarness harness) {
        harness.checkPoint("(List)");
        ArrayList<Object> list2 = new ArrayList<Object>();
        boolean pass = true;
        try {
            Collections.sort(list2);
        }
        catch (Exception e) {
            pass = false;
        }
        harness.check(pass);
        list2 = new ArrayList();
        list2.add("A");
        Collections.sort(list2);
        harness.check(list2.size(), 1);
        harness.check(list2.get(0), (Object)"A");
        list2 = new ArrayList();
        list2.add("B");
        list2.add("A");
        Collections.sort(list2);
        harness.check(list2.size(), 2);
        harness.check(list2.get(0), (Object)"A");
        harness.check(list2.get(1), (Object)"B");
        list2 = new ArrayList();
        list2.add("B");
        list2.add("A");
        list2.add("C");
        Collections.sort(list2);
        harness.check(list2.size(), 3);
        harness.check(list2.get(0), (Object)"A");
        harness.check(list2.get(1), (Object)"B");
        harness.check(list2.get(2), (Object)"C");
        pass = false;
        try {
            list2 = new ArrayList();
            list2.add("B");
            list2.add("A");
            list2.add(null);
            Collections.sort(list2);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        Integer obj1 = new Integer(9500);
        Integer obj2 = new Integer(9600);
        Integer obj3 = new Integer(9500);
        Integer obj4 = new Integer(9600);
        list2 = new ArrayList();
        list2.add(obj1);
        list2.add(obj2);
        list2.add(obj3);
        list2.add(obj4);
        Collections.sort(list2);
        harness.check(list2.size(), 4);
        harness.check(list2.get(0), obj1);
        harness.check(list2.get(1), obj3);
        harness.check(list2.get(2), obj2);
        harness.check(list2.get(3), obj4);
        pass = false;
        try {
            Collections.sort(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void testMethod2(TestHarness harness) {
        harness.checkPoint("(List, Comparator)");
        ArrayList<Object> list2 = new ArrayList<Object>();
        MyComparator comparator = new MyComparator();
        boolean pass = true;
        try {
            Collections.sort(list2, comparator);
        }
        catch (Exception e) {
            pass = false;
        }
        harness.check(pass);
        list2 = new ArrayList();
        list2.add("A");
        Collections.sort(list2, comparator);
        harness.check(list2.size(), 1);
        harness.check(list2.get(0), (Object)"A");
        list2 = new ArrayList();
        list2.add("B");
        list2.add("A");
        Collections.sort(list2, comparator);
        harness.check(list2.size(), 2);
        harness.check(list2.get(0), (Object)"B");
        harness.check(list2.get(1), (Object)"A");
        list2 = new ArrayList();
        list2.add("B");
        list2.add("A");
        list2.add("C");
        Collections.sort(list2, comparator);
        harness.check(list2.size(), 3);
        harness.check(list2.get(0), (Object)"C");
        harness.check(list2.get(1), (Object)"B");
        harness.check(list2.get(2), (Object)"A");
        pass = false;
        try {
            list2 = new ArrayList();
            list2.add("B");
            list2.add("A");
            list2.add(null);
            Collections.sort(list2, comparator);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        Integer obj1 = new Integer(9500);
        Integer obj2 = new Integer(9600);
        Integer obj3 = new Integer(9500);
        Integer obj4 = new Integer(9600);
        list2 = new ArrayList();
        list2.add(obj1);
        list2.add(obj2);
        list2.add(obj3);
        list2.add(obj4);
        Collections.sort(list2, comparator);
        harness.check(list2.size(), 4);
        harness.check(list2.get(0), obj2);
        harness.check(list2.get(1), obj4);
        harness.check(list2.get(2), obj1);
        harness.check(list2.get(3), obj3);
        pass = false;
        try {
            Collections.sort(null, comparator);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = true;
        try {
            Collections.sort(new ArrayList(), null);
        }
        catch (NullPointerException e) {
            pass = false;
        }
        harness.check(pass);
    }

    static class MyComparator
    implements Comparator {
        MyComparator() {
        }

        public int compare(Object obj0, Object obj1) {
            Comparable c0 = (Comparable)obj0;
            Comparable c1 = (Comparable)obj1;
            return -c0.compareTo(c1);
        }
    }
}

