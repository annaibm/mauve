/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Collections;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class unmodifiableList
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("Empty List");
        ArrayList list1 = new ArrayList();
        this.testList(list1, harness);
        harness.checkPoint("Non-empty List");
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("A");
        list2.add("B");
        list2.add("C");
        this.testList(list2, harness);
        harness.checkPoint("Null List");
        boolean pass = false;
        try {
            Collections.unmodifiableList(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testList(List list2, TestHarness harness) {
        List ulist = Collections.unmodifiableList(list2);
        boolean pass = false;
        try {
            ulist.add("X");
        }
        catch (UnsupportedOperationException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            ulist.add(0, "X");
        }
        catch (UnsupportedOperationException e) {
            pass = true;
        }
        harness.check(pass);
        ArrayList<String> otherList = new ArrayList<String>();
        otherList.add("Z");
        pass = false;
        try {
            ulist.addAll(otherList);
        }
        catch (UnsupportedOperationException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            ulist.clear();
        }
        catch (UnsupportedOperationException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            ulist.remove("X");
        }
        catch (UnsupportedOperationException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            ulist.remove(0);
        }
        catch (UnsupportedOperationException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            ulist.removeAll(otherList);
        }
        catch (UnsupportedOperationException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            ulist.retainAll(otherList);
        }
        catch (UnsupportedOperationException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            ulist.set(0, "X");
        }
        catch (UnsupportedOperationException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

