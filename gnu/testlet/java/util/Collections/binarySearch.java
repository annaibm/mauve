/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Collections;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class binarySearch
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("ArrayList");
        this.genericTest(new ArrayList(), harness);
        harness.checkPoint("LinkedList");
        this.genericTest(new LinkedList(), harness);
        harness.checkPoint("Vector");
        this.genericTest(new Vector(), harness);
        harness.checkPoint("10447");
        this.testBug10447(harness);
        harness.checkPoint("Compare Order");
        this.testCompareOrder(new ArrayList(), harness);
        this.testCompareOrder(new LinkedList(), harness);
    }

    private void testCompareOrder(List list2, TestHarness harness) {
        final boolean[] result = new boolean[]{false, false};
        list2.add(new Comparable(){

            public int compareTo(Object obj) {
                result[0] = true;
                return -1;
            }
        });
        Collections.binarySearch(list2, new Comparable(){

            public int compareTo(Object obj) {
                result[1] = true;
                return -1;
            }
        });
        harness.check(result[0] && !result[1]);
        final Object obj1 = new Object();
        final Object obj2 = new Object();
        list2.clear();
        list2.add(obj1);
        result[0] = false;
        Collections.binarySearch(list2, obj2, new Comparator(){

            public int compare(Object o1, Object o2) {
                result[0] = o1 == obj1 && o2 == obj2;
                return -1;
            }
        });
        harness.check(result[0]);
    }

    private void genericTest(List list2, TestHarness harness) {
        list2.clear();
        int index = Collections.binarySearch(list2, "A");
        harness.check(index, -1);
        list2.add("B");
        index = Collections.binarySearch(list2, "B");
        harness.check(index, 0);
        index = Collections.binarySearch(list2, "A");
        harness.check(index, -1);
        index = Collections.binarySearch(list2, "C");
        harness.check(index, -2);
        list2.add("D");
        index = Collections.binarySearch(list2, "A");
        harness.check(index, -1);
        index = Collections.binarySearch(list2, "B");
        harness.check(index, 0);
        index = Collections.binarySearch(list2, "C");
        harness.check(index, -2);
        index = Collections.binarySearch(list2, "D");
        harness.check(index, 1);
        index = Collections.binarySearch(list2, "E");
        harness.check(index, -3);
        list2.add("F");
        index = Collections.binarySearch(list2, "A");
        harness.check(index, -1);
        index = Collections.binarySearch(list2, "B");
        harness.check(index, 0);
        index = Collections.binarySearch(list2, "C");
        harness.check(index, -2);
        index = Collections.binarySearch(list2, "D");
        harness.check(index, 1);
        index = Collections.binarySearch(list2, "E");
        harness.check(index, -3);
        index = Collections.binarySearch(list2, "F");
        harness.check(index, 2);
        index = Collections.binarySearch(list2, "G");
        harness.check(index, -4);
        this.fillList(list2, 1024);
        index = Collections.binarySearch(list2, "00000");
        harness.check(index, 0);
        index = Collections.binarySearch(list2, "00123");
        harness.check(index, 123);
        index = Collections.binarySearch(list2, "00511");
        harness.check(index, 511);
        index = Collections.binarySearch(list2, "00512");
        harness.check(index, 512);
        index = Collections.binarySearch(list2, "00513");
        harness.check(index, 513);
        index = Collections.binarySearch(list2, "00789");
        harness.check(index, 789);
        index = Collections.binarySearch(list2, "01023");
        harness.check(index, 1023);
        index = Collections.binarySearch(list2, "01024");
        harness.check(index, -1025);
        this.fillList(list2, 12345);
        index = Collections.binarySearch(list2, "00000");
        harness.check(index, 0);
        index = Collections.binarySearch(list2, "00123");
        harness.check(index, 123);
        index = Collections.binarySearch(list2, "00511");
        harness.check(index, 511);
        index = Collections.binarySearch(list2, "00512");
        harness.check(index, 512);
        index = Collections.binarySearch(list2, "00513");
        harness.check(index, 513);
        index = Collections.binarySearch(list2, "00789");
        harness.check(index, 789);
        index = Collections.binarySearch(list2, "01023");
        harness.check(index, 1023);
        index = Collections.binarySearch(list2, "12345");
        harness.check(index, -12346);
    }

    private void fillList(List list2, int itemCount) {
        list2.clear();
        for (int i = 0; i < itemCount; ++i) {
            String s = String.valueOf(i);
            list2.add("00000".substring(s.length()) + s);
        }
    }

    private void testBug10447(TestHarness harness) {
        LinkedList<String> list2 = new LinkedList<String>();
        list2.add("A");
        list2.add("B");
        list2.add("C");
        list2.add("D");
        list2.add("E");
        list2.add("F");
        list2.add("G");
        list2.add("H");
        list2.add("I");
        list2.add("J");
        list2.add("K");
        list2.add("L");
        list2.add("M");
        list2.add("N");
        list2.add("O");
        list2.add("P");
        int i = Collections.binarySearch(list2, "E");
        harness.check(i, 4);
        list2.add("Q");
        i = Collections.binarySearch(list2, "E");
        harness.check(i, 4);
        ArrayList<String> list22 = new ArrayList<String>();
        list22.add("A");
        list22.add("B");
        list22.add("C");
        list22.add("D");
        list22.add("E");
        list22.add("F");
        list22.add("G");
        list22.add("H");
        list22.add("I");
        list22.add("J");
        list22.add("K");
        list22.add("L");
        list22.add("M");
        list22.add("N");
        list22.add("O");
        list22.add("P");
        i = Collections.binarySearch(list22, "E");
        harness.check(i, 4);
        list22.add("Q");
        i = Collections.binarySearch(list22, "E");
        harness.check(i, 4);
    }
}

