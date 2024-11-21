/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.List;

import gnu.testlet.TestHarness;
import java.util.List;

public class subList {
    static List createListInstance(Class listClass, TestHarness harness) {
        List result = null;
        try {
            result = (List)listClass.newInstance();
            return result;
        }
        catch (Exception e) {
            harness.debug(e);
            return null;
        }
    }

    public static void testAll(Class listClass, TestHarness harness) {
        subList.testEmptyList(listClass, harness);
        subList.testABCD(listClass, harness);
        subList.testAdd(listClass, harness);
        subList.testClear(listClass, harness);
        subList.testRemove(listClass, harness);
        subList.testSet(listClass, harness);
        subList.testSubSubList(listClass, harness);
    }

    public static void testEmptyList(Class listClass, TestHarness harness) {
        List list2 = subList.createListInstance(listClass, harness);
        List sub = list2.subList(0, 0);
        harness.check(sub.isEmpty());
    }

    public static void testABCD(Class listClass, TestHarness harness) {
        List list2 = subList.createListInstance(listClass, harness);
        list2.add("A");
        list2.add("B");
        list2.add("C");
        list2.add("D");
        List sub = list2.subList(2, 2);
        harness.check(sub.isEmpty());
        sub = list2.subList(1, 2);
        harness.check(sub.get(0).equals("B"));
        harness.check(sub.size(), 1);
        sub = list2.subList(1, 4);
        harness.check(sub.size(), 3);
        sub = list2.subList(4, 4);
        harness.check(sub.isEmpty());
        boolean pass = false;
        try {
            sub = list2.subList(2, 1);
        }
        catch (IndexOutOfBoundsException e) {
            pass = true;
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            sub = list2.subList(-1, 1);
        }
        catch (IndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            sub = list2.subList(1, 5);
        }
        catch (IndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public static void testAdd(Class listClass, TestHarness harness) {
        List list2 = subList.createListInstance(listClass, harness);
        list2.add("A");
        list2.add("B");
        list2.add("C");
        list2.add("D");
        List<String> sub = list2.subList(0, 0);
        sub.add("1");
        harness.check(list2.get(0).equals("1"));
        harness.check(list2.size(), 5);
        sub = list2.subList(1, 2);
        sub.add("2");
        harness.check(list2.get(0).equals("1"));
        harness.check(list2.get(1).equals("A"));
        harness.check(list2.get(2).equals("2"));
        harness.check(list2.get(3).equals("B"));
        harness.check(list2.size(), 6);
    }

    public static void testClear(Class listClass, TestHarness harness) {
        List list2 = subList.createListInstance(listClass, harness);
        list2.add("A");
        list2.add("B");
        list2.add("C");
        list2.add("D");
        List sub = list2.subList(0, 0);
        sub.clear();
        harness.check(list2.size(), 4);
        sub = list2.subList(1, 2);
        sub.clear();
        harness.check(list2.get(0).equals("A"));
        harness.check(list2.get(1).equals("C"));
        harness.check(list2.size(), 3);
        sub = list2.subList(0, list2.size());
        sub.clear();
        harness.check(list2.isEmpty());
    }

    public static void testRemove(Class listClass, TestHarness harness) {
        List list2 = subList.createListInstance(listClass, harness);
        list2.add("A");
        list2.add("B");
        list2.add("C");
        list2.add("D");
        List sub = list2.subList(1, 2);
        sub.remove("B");
        harness.check(list2.get(0).equals("A"));
        harness.check(list2.get(1).equals("C"));
        harness.check(list2.size(), 3);
    }

    public static void testSet(Class listClass, TestHarness harness) {
        List list2 = subList.createListInstance(listClass, harness);
        list2.add("A");
        list2.add("B");
        list2.add("C");
        list2.add("D");
        List<String> sub = list2.subList(1, 2);
        sub.set(0, "X");
        harness.check(list2.get(0).equals("A"));
        harness.check(list2.get(1).equals("X"));
        harness.check(list2.get(2).equals("C"));
        harness.check(list2.size(), 4);
    }

    public static void testSubSubList(Class listClass, TestHarness harness) {
        List list2 = subList.createListInstance(listClass, harness);
        list2.add("A");
        list2.add("B");
        list2.add("C");
        list2.add("D");
        List sub1 = list2.subList(0, 4);
        List<String> sub2 = sub1.subList(1, 3);
        sub2.add("X");
        harness.check(sub1.get(1).equals("B"));
        harness.check(sub1.get(2).equals("C"));
        harness.check(sub1.get(3).equals("X"));
        harness.check(list2.get(0).equals("A"));
        harness.check(list2.get(1).equals("B"));
        harness.check(list2.get(2).equals("C"));
        harness.check(list2.get(3).equals("X"));
        harness.check(list2.get(4).equals("D"));
    }
}

