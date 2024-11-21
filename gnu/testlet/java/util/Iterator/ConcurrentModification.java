/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Iterator;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.WeakHashMap;

public class ConcurrentModification
implements Testlet {
    TestHarness harness;

    @Override
    public void test(TestHarness harness) {
        this.harness = harness;
        this.testMapIterator(new HashMap());
        this.testMapIterator(new TreeMap());
        this.testMapIterator(new Hashtable());
        this.testMapIterator(new LinkedHashMap());
        this.testMapIterator(new IdentityHashMap());
        this.testMapIterator(new WeakHashMap());
        this.testMapIterator(Collections.synchronizedMap(new HashMap()));
        this.testListIterator(new ArrayList());
        this.testListIterator(new Vector());
        this.testListIterator(new LinkedList());
        this.testListIterator(Collections.synchronizedList(new ArrayList()));
        this.testCollectionIterator(new HashSet());
        this.testCollectionIterator(new LinkedHashSet());
        this.testCollectionIterator(new TreeSet());
    }

    void testMapIterator(Map map2) {
        map2.put("1", "value");
        map2.put("2", "value");
        this.testIterator(map2.keySet());
        map2.clear();
        map2.put("1", "value");
        map2.put("2", "value");
        this.testIterator(map2.values());
    }

    void testListIterator(List l) {
        l.add("1");
        l.add("2");
        this.testIterator(l);
        l.clear();
        l.add("1");
        l.add("2");
        l.add("3");
        this.testIterator(l.subList(0, 3));
        l.clear();
        l.add("1");
        l.add("2");
        l.add("3");
        this.testListHasPrevious(l);
    }

    void testCollectionIterator(Collection c) {
        c.add("1");
        c.add("2");
        this.testIterator(c);
    }

    void testIterator(Collection c) {
        Iterator iter2 = c.iterator();
        String element = (String)iter2.next();
        c.remove(element);
        boolean hasNext = false;
        try {
            hasNext = iter2.hasNext();
        }
        catch (ConcurrentModificationException x) {
            this.harness.fail(c.getClass() + ".iterator().hasNext() throws " + x);
            return;
        }
        try {
            element = (String)iter2.next();
        }
        catch (ConcurrentModificationException x) {
            this.harness.check(true);
        }
    }

    void testListHasPrevious(List l) {
        ListIterator iter2 = l.listIterator();
        String element = (String)iter2.next();
        l.remove(element);
        int idx = -1;
        boolean hasPrevious = false;
        try {
            hasPrevious = iter2.hasPrevious();
        }
        catch (ConcurrentModificationException x) {
            this.harness.fail(l.getClass() + ".listIterator().hasPrevious() throws " + x);
            return;
        }
        try {
            idx = iter2.nextIndex();
        }
        catch (ConcurrentModificationException x) {
            this.harness.fail(l.getClass() + ".listIterator().nextIndex() throws " + x);
            return;
        }
        try {
            idx = iter2.previousIndex();
        }
        catch (ConcurrentModificationException x) {
            this.harness.fail(l.getClass() + ".listIterator().previousIndex() throws " + x);
            return;
        }
        try {
            element = (String)iter2.next();
        }
        catch (ConcurrentModificationException x) {
            this.harness.check(true);
        }
    }
}

