/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.AbstractList;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.AbstractList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Vector;

public class AcuniaAbstractListTest
extends AbstractList
implements Testlet {
    protected TestHarness th;
    private boolean edit = true;
    private boolean didRemoveRange = false;
    private boolean updateMC = false;
    private boolean sleepy = false;
    private int from = -1;
    private int to = -1;
    public Vector v = new Vector();

    @Override
    public void test(TestHarness harness) {
        this.th = harness;
        this.test_get();
        this.test_indexOf();
        this.test_lastIndexOf();
        this.test_add();
        this.test_addAll();
        this.test_clear();
        this.test_remove();
        this.test_removeRange();
        this.test_set();
        this.test_iterator();
        try {
            this.test_listIterator();
        }
        catch (Exception e) {
            this.th.fail("got unwanted exception " + e);
        }
        this.test_subList();
        this.test_hashCode();
        this.test_equals();
    }

    public void test_get() {
        this.th.checkPoint("()");
    }

    public void test_indexOf() {
        this.th.checkPoint("indexOf(java.lang.Object)int");
        AcuniaAbstractListTest eal = new AcuniaAbstractListTest();
        eal.v.add("ab");
        eal.v.add("bc");
        eal.v.add(null);
        eal.v.add("ab");
        eal.v.add("cd");
        eal.v.add(this);
        this.th.check(eal.indexOf(this) == 5, "checking return value -- 1");
        this.th.check(eal.indexOf(null) == 2, "checking return value -- 2");
        this.th.check(eal.indexOf("ab") == 0, "checking return value -- 3");
        this.th.check(eal.indexOf("ab") == 0, "checking return value -- 4");
        this.th.check(eal.indexOf("b") == -1, "checking return value -- 5");
        eal.v.remove(null);
        this.th.check(eal.indexOf(null) == -1, "checking return value -- 6");
        eal.v.remove(this);
        this.th.check(eal.indexOf(this) == -1, "checking return value -- 7");
    }

    public void test_lastIndexOf() {
        this.th.checkPoint("lastIndexOf(java.lang.Object)int");
        AcuniaAbstractListTest eal = new AcuniaAbstractListTest();
        eal.v.add("ab");
        eal.v.add("bc");
        eal.v.add(null);
        eal.v.add("ab");
        eal.v.add(null);
        eal.v.add(this);
        this.th.check(eal.lastIndexOf(this) == 5, "checking return value -- 1");
        this.th.check(eal.lastIndexOf(null) == 4, "checking return value -- 2");
        this.th.check(eal.lastIndexOf("ab") == 3, "checking return value -- 3");
        this.th.check(eal.lastIndexOf("ab") == 3, "checking return value -- 4");
        this.th.check(eal.lastIndexOf("b") == -1, "checking return value -- 5");
        eal.v.remove(4);
        this.th.check(eal.lastIndexOf(null) == 2, "checking return value -- 6");
        eal.v.remove(null);
        this.th.check(eal.lastIndexOf(null) == -1, "checking return value -- 7");
    }

    public void test_add() {
        this.th.checkPoint("add(java.lang.Object)boolean");
        AcuniaAbstractListTest eal = new AcuniaAbstractListTest();
        int mc = eal.getMC();
        this.th.check(eal.add(this), "checking return value -- 1");
        this.th.check(eal.v.get(0) == this, "checking add -- 1");
        this.th.check(eal.add("a"), "checking return value -- 2");
        this.th.check("a".equals(eal.v.get(1)), "checking add -- 2");
        this.th.check(eal.add("b"), "checking return value -- 3");
        this.th.check("b".equals(eal.v.get(2)), "checking add -- 3");
        this.th.check(eal.add(null), "checking return value -- 4");
        this.th.check(eal.v.get(3) == null, "checking add -- 4");
        this.th.check(eal.add(null), "checking return value -- 5");
        this.th.check(eal.v.get(4) == null, "checking add -- 5");
        eal.set_edit(false);
        try {
            eal.add("a");
            this.th.fail("should throw an UnsupportedOperationExeption");
        }
        catch (UnsupportedOperationException uoe) {
            this.th.check(true);
        }
        this.th.checkPoint("add(int,java.lang.Object)void");
        try {
            eal.add(3, "a");
            this.th.fail("should throw an UnsupportedOperationExeption");
        }
        catch (UnsupportedOperationException uoe) {
            this.th.check(true);
        }
    }

    public void test_addAll() {
        this.th.checkPoint("addAll(java.util.Collection)boolean");
        this.th.checkPoint("addAll(int,java.util.Collection)boolean");
        AcuniaAbstractListTest eal = new AcuniaAbstractListTest();
        try {
            eal.addAll(0, null);
            this.th.fail("should throw a NullPointerException");
        }
        catch (NullPointerException ne) {
            this.th.check(true);
        }
        Vector<Object> v = new Vector<Object>();
        this.th.check(!eal.addAll(0, v), "checking returnvalue -- 1");
        this.th.check(eal.size() == 0, "nothing added yet");
        v.add(this);
        v.add(null);
        v.add("a");
        v.add("b");
        v.add("a");
        v.add(null);
        try {
            eal.addAll(-1, v);
            this.th.fail("should throw an IndexOutOfBoundsException -- 1");
        }
        catch (IndexOutOfBoundsException ioobe) {
            this.th.check(true);
        }
        try {
            eal.addAll(1, v);
            this.th.fail("should throw an IndexOutOfBoundsException -- 2");
        }
        catch (IndexOutOfBoundsException ioobe) {
            this.th.check(true);
        }
        this.th.check(eal.addAll(0, v), "checking returnvalue -- 1");
        this.th.check(eal.v.get(0) == this && eal.v.get(1) == null && eal.v.get(5) == null);
        this.th.check(eal.addAll(3, v), "checking returnvalue -- 2");
        this.th.check(eal.v.get(0) == this && "a".equals(eal.v.get(2)) && eal.v.get(3) == this);
        this.th.check(eal.v.get(8) == null && "b".equals(eal.v.get(9)) && eal.v.get(11) == null);
        v = new Vector();
        this.th.check(!eal.addAll(3, v), "checking returnvalue -- 3");
    }

    public void test_clear() {
        this.th.checkPoint("clear()void");
        AcuniaAbstractListTest eal = new AcuniaAbstractListTest();
        eal.set_updateMC(true);
        eal.clear();
        this.th.check(eal.get_dRR(), "check if removeRange was called");
        this.th.check(eal.get_from() == 0 && eal.get_to() == 0);
        eal = new AcuniaAbstractListTest();
        eal.v.add("a");
        eal.v.add("b");
        eal.v.add("c");
        eal.v.add("d");
        eal.clear();
        this.th.check(eal.get_dRR(), "check if removeRange was called");
        this.th.check(eal.get_from() == 0 && eal.get_to() == 4);
        this.th.check(eal.v.size() == 0, "checking if everything is gone");
    }

    public void test_remove() {
        this.th.checkPoint("remove(int)java.lang.Object");
        AcuniaAbstractListTest eal = new AcuniaAbstractListTest();
        eal.set_edit(false);
        eal.v.add("a");
        try {
            eal.remove(0);
            this.th.fail("should throw an UnsupportedOperationException");
        }
        catch (UnsupportedOperationException uoe) {
            this.th.check(true);
        }
    }

    public void test_removeRange() {
        this.th.checkPoint("removeRange(int,int)void");
        AcuniaAbstractListTest eal = new AcuniaAbstractListTest();
        for (int i = 0; i < 20; ++i) {
            eal.v.add("a" + i);
        }
        try {
            eal.removeRange(10, 25);
            this.th.fail("should throw an exception");
        }
        catch (NoSuchElementException e) {
            this.th.check(true);
        }
        Vector v = (Vector)eal.v.clone();
        eal.removeRange(10, 10);
        this.th.check(eal.v.equals(v), "nothing removed -- 1");
        eal.removeRange(9, 10);
        v.remove(9);
        this.th.check(eal.v.equals(v), "one element removed");
        eal.removeRange(5, 7);
        v.remove(5);
        v.remove(5);
        this.th.debug("got v = " + v + ", and eal.v = " + eal.v);
        this.th.check(eal.v.equals(v), "two elements removed");
        eal.removeRange(2, 1);
        this.th.check(eal.v.equals(v), "nothing removed -- 2");
        try {
            eal.removeRange(-1, 5);
            this.th.fail("should throw an exception");
        }
        catch (IndexOutOfBoundsException e) {
            this.th.check(true);
            this.th.debug(e);
        }
    }

    public void test_set() {
        this.th.checkPoint("set(int,java.lang.Object)java.lang.Object");
        AcuniaAbstractListTest eal = new AcuniaAbstractListTest();
        eal.set_edit(false);
        eal.v.add("a");
        try {
            eal.set(0, "b");
            this.th.fail("should throw an UnsupportedOperationException");
        }
        catch (UnsupportedOperationException uoe) {
            this.th.check(true);
        }
    }

    public void test_iterator() {
        this.th.checkPoint("iterator()java.util.Iterator");
        AcuniaAbstractListTest eal = new AcuniaAbstractListTest();
        eal.set_updateMC(true);
        eal.v.add("a");
        eal.v.add("b");
        eal.v.add("c");
        Iterator it = eal.iterator();
        this.th.check(it.hasNext(), "true -- 1");
        this.th.check("a".equals(it.next()), "order is important -- 1");
        this.th.check(it.hasNext(), "true -- 2");
        this.th.check("b".equals(it.next()), "order is important -- 2");
        this.th.check(it.hasNext(), "true -- 3");
        this.th.check("c".equals(it.next()), "order is important -- 3");
        this.th.check(!it.hasNext(), "false -- 4");
        this.th.check(!it.hasNext(), "false -- 5");
        try {
            it.next();
            this.th.fail("should throw a NoSuchElementException");
        }
        catch (NoSuchElementException nse) {
            this.th.check(true);
        }
        eal.add("changed");
        try {
            it.remove();
            this.th.fail("should throw a ConcurrentModificationException -- 1");
        }
        catch (ConcurrentModificationException cme) {
            this.th.check(true, "remove");
        }
        try {
            it.next();
            this.th.fail("should throw a ConcurrentModificationException -- 2");
        }
        catch (ConcurrentModificationException cme) {
            this.th.check(true, "next");
        }
        it = eal.iterator();
        try {
            it.remove();
            this.th.fail("should throw IllegalStateException");
        }
        catch (IllegalStateException ise) {
            this.th.check(true);
        }
        try {
            this.th.debug(eal.v.toString());
            it.next();
            it.hasNext();
            it.remove();
            this.th.check(!eal.v.contains("a") && eal.v.size() == 3, "first element removed");
            it.next();
            it.remove();
            this.th.check(!eal.v.contains("b") && eal.v.size() == 2, "second element removed");
            it.next();
            it.remove();
            this.th.check(!eal.v.contains("c") && eal.v.size() == 1, "third element removed");
            it.next();
            it.remove();
            this.th.check(eal.v.isEmpty(), "all are elements removed");
        }
        catch (Exception e) {
            this.th.fail("got unexpected exception !, got " + e);
        }
    }

    public void test_listIterator() {
        this.th.checkPoint("listIterator()java.util.ListIterator");
        AcuniaAbstractListTest ll = new AcuniaAbstractListTest();
        ll.set_updateMC(true);
        ListIterator<String> li = ll.listIterator();
        try {
            li.next();
            this.th.fail("should throw a NoSuchElementException -- 1");
        }
        catch (NoSuchElementException nsee) {
            this.th.check(true, "caught exeption -- 1");
        }
        try {
            li.previous();
            this.th.fail("should throw a NoSuchElementException -- 2");
        }
        catch (NoSuchElementException nsee) {
            this.th.check(true, "caught exeption -- 2");
        }
        this.th.check(!li.hasNext(), "no elements ... -- 1");
        this.th.check(!li.hasPrevious(), "no elements ... -- 1");
        this.th.check(li.nextIndex(), 0, "nextIndex == 0 -- 1");
        this.th.check(li.previousIndex(), -1, "previousIndex == -1 -- 1");
        li.add("a");
        this.th.check(!li.hasNext(), "no elements ... -- 2");
        this.th.check(li.hasPrevious(), "one element ... -- 2");
        this.th.check(li.nextIndex(), 1, "nextIndex == 1 -- 2");
        this.th.check(li.previousIndex(), 0, "previousIndex == 0 -- 2");
        try {
            li.next();
            this.th.fail("should throw a NoSuchElementException -- 3");
        }
        catch (NoSuchElementException nsee) {
            this.th.check(true, "caught exeption -- 3");
        }
        this.th.check("a".equals(li.previous()), "checking previous element -- 1");
        li.add(null);
        this.th.check(li.previousIndex(), 0, "previousIndex == 0 -- 3");
        this.th.check(li.previous() == null, "checking previous element -- 2");
        this.th.check(li.next() == null, "checking next element -- 1");
        li.add("b");
        this.th.check("a".equals(li.next()), "checking next element -- 2");
        li.add("c");
        try {
            li.set("not");
            this.th.fail("should throw a IllegalStateException -- 1");
        }
        catch (IllegalStateException ise) {
            this.th.check(true, "caught exeption -- 4");
        }
        this.th.check(!ll.contains("not"), "set should not have been executed");
        try {
            li.remove();
            this.th.fail("should throw a IllegalStateException -- 2");
        }
        catch (IllegalStateException ise) {
            this.th.check(true, "caught exeption -- 5");
        }
        this.th.check("c".equals(li.previous()), "checking previous element -- 3");
        li.set("new");
        this.th.check("new".equals(li.next()), "validating set");
        li.set("not");
        li.set("notOK");
        li.remove();
        try {
            li.set("not");
            this.th.fail("should throw a IllegalStateException -- 3");
        }
        catch (IllegalStateException ise) {
            this.th.check(true, "caught exeption -- 6");
        }
        this.th.check(!ll.contains("not"), "set should not have been executed");
        try {
            li.remove();
            this.th.fail("should throw a IllegalStateException -- 4");
        }
        catch (IllegalStateException ise) {
            this.th.check(true, "caught exeption -- 7");
        }
        try {
            li.next();
            this.th.fail("should throw a NoSuchElementException -- 4");
        }
        catch (NoSuchElementException nsee) {
            this.th.check(true, "caught exeption -- 8");
        }
        this.th.check("a", li.previous(), "checking on previous element");
        li.remove();
        try {
            li.set("not");
            this.th.fail("should throw a IllegalStateException -- 5");
        }
        catch (IllegalStateException ise) {
            this.th.check(true, "caught exeption -- 9");
        }
        this.th.check(!ll.contains("not"), "set should not have been executed");
        try {
            li.remove();
            this.th.fail("should throw a IllegalStateException -- 6");
        }
        catch (IllegalStateException ise) {
            this.th.check(true, "caught exeption -- 10");
        }
    }

    public void test_subList() {
        this.th.checkPoint("subList(int,int)List");
    }

    public void test_hashCode() {
        this.th.checkPoint("hashCode()int");
        AcuniaAbstractListTest eal = new AcuniaAbstractListTest();
        this.th.check(eal.hashCode() == 1, "hashCode of empty list is 1");
        int hash2 = 1;
        hash2 = hash2 * 31 + "a".hashCode();
        eal.v.add("a");
        this.th.check(eal.hashCode() == hash2, "checking hashCode algortihm -- 1");
        hash2 = hash2 * 31 + "adg".hashCode();
        eal.v.add("adg");
        this.th.check(eal.hashCode() == hash2, "checking hashCode algortihm -- 2");
        eal.v.add(null);
        this.th.check(eal.hashCode() == (hash2 *= 31), "checking hashCode algortihm -- 3");
        hash2 = hash2 * 31 + this.hashCode();
        eal.v.add(this);
        this.th.check(eal.hashCode() == hash2, "checking hashCode algortihm -- 4");
    }

    public void test_equals() {
        this.th.checkPoint("equals(java.lang.Object)boolean");
        AcuniaAbstractListTest eal = new AcuniaAbstractListTest();
        Vector<Object> v = new Vector<Object>();
        this.th.check(!eal.equals(null), "null is allowed");
        this.th.check(!eal.equals(new Object()), "not equal to an non-List Object");
        this.th.check(eal.equals(v), "equal == true -- 1");
        eal.v.add(null);
        v.add(null);
        this.th.check(eal.equals(v), "equal == true -- 2");
        eal.v.add(this);
        v.add(this);
        this.th.check(eal.equals(v), "equal == true -- 3");
        eal.v.add("a");
        v.add("b");
        this.th.check(!eal.equals(v), "equal != true -- 4");
        eal.v.add("b");
        v.add("a");
        this.th.check(!eal.equals(v), "equal != true -- 5");
        eal.v.remove("a");
        this.th.check(!eal.equals(v), "equal != true -- 5");
    }

    @Override
    public int size() {
        if (this.sleepy) {
            try {
                Thread.sleep(150L);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.v.size();
    }

    @Override
    public Object get(int idx) {
        return this.v.get(idx);
    }

    public int getMC() {
        return this.modCount;
    }

    public void set_edit(boolean b) {
        this.edit = b;
    }

    public void set_sleepy(boolean b) {
        this.sleepy = b;
    }

    public void set_updateMC(boolean b) {
        this.updateMC = b;
    }

    @Override
    public void add(int idx, Object o) {
        if (this.edit) {
            if (this.updateMC) {
                ++this.modCount;
            }
            this.v.add(idx, o);
        } else {
            super.add(idx, o);
        }
    }

    @Override
    public Object remove(int idx) {
        if (this.edit) {
            if (this.updateMC) {
                ++this.modCount;
            }
            return this.v.remove(idx);
        }
        return super.remove(idx);
    }

    @Override
    public Object set(int idx, Object o) {
        if (this.edit) {
            return this.v.set(idx, o);
        }
        return super.set(idx, o);
    }

    @Override
    public void removeRange(int fidx, int tidx) {
        this.didRemoveRange = true;
        this.to = tidx;
        this.from = fidx;
        super.removeRange(fidx, tidx);
    }

    public boolean get_dRR() {
        return this.didRemoveRange;
    }

    public void set_dRR(boolean b) {
        this.didRemoveRange = b;
    }

    public int get_to() {
        return this.to;
    }

    public int get_from() {
        return this.from;
    }
}

