/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.TreeSet;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class basic
implements Testlet {
    TreeSet set = new TreeSet();

    void checkContent(Set forSet, String content, TestHarness h, String note) {
        StringBuffer b = new StringBuffer();
        Iterator iter2 = forSet.iterator();
        while (iter2.hasNext()) {
            b.append(iter2.next());
        }
        h.check(b.toString(), content, note);
    }

    void checkContent(String content, TestHarness h, String note) {
        this.checkContent(this.set, content, h, note);
    }

    TreeSet getSet(String content) {
        TreeSet<String> t = new TreeSet<String>();
        for (int i = 0; i < content.length(); ++i) {
            t.add("" + content.charAt(i));
        }
        return t;
    }

    public void test_clone(TestHarness harness) {
        TreeSet t = this.getSet("abcdef");
        this.set = (TreeSet)t.clone();
        this.checkContent("abcdef", harness, "clone");
    }

    public void test_add(TestHarness harness) {
        this.set = this.getSet("bcdabcddabbccaabbccadbcdababbcdabcxabcxccda");
        this.checkContent("abcdx", harness, "add");
        harness.check(this.set.size(), 5, "size");
        harness.check(this.set.first(), "a", "first");
        harness.check(this.set.last(), "x", "last");
        harness.check(this.set.comparator() == null, "null comparator expected");
    }

    public void test_addAll(TestHarness harness) {
        this.set = this.getSet("dac");
        TreeSet t = this.getSet("xay");
        this.set.addAll(t);
        this.checkContent("acdxy", harness, "addAll");
    }

    public void test_contains(TestHarness harness) {
        String t = "abcdefghij";
        this.set = this.getSet(t);
        for (int i = 0; i < t.length(); ++i) {
            String s = t.substring(i, i + 1);
            harness.check(this.set.contains(s), "must contain '" + s + "'");
        }
        harness.check(!this.set.contains("aa"), "must not contain 'aa'");
    }

    public void test_remove(TestHarness harness) {
        String t = "abcdefghij";
        this.set = this.getSet(t);
        for (int i = 0; i < t.length(); ++i) {
            String s = t.substring(i, i + 1);
            this.set.remove(s);
            if (!this.set.contains(s)) continue;
            harness.fail("Contains '" + s + "' after removing. ");
        }
        harness.check(this.set.size(), 0, "non zero size after removing all elements");
        harness.check(this.set.isEmpty(), "non empty when it should be");
    }

    public void test_clear(TestHarness harness) {
        this.set = this.getSet("a");
        this.set.clear();
        harness.check(this.set.size(), 0, "clear");
    }

    public void test_subsets(TestHarness harness) {
        String content = "abcdefghijklmn";
        this.set = this.getSet(content);
        for (int i = 0; i < content.length() - 1; ++i) {
            String s = content.substring(i, i + 1);
            this.checkContent(this.set.headSet(s), content.substring(0, i), harness, "headSet");
            this.checkContent(this.set.tailSet(s), content.substring(i), harness, "tailSet");
            this.checkContent(this.set.subSet(s, "n"), content.substring(i, content.length() - 1), harness, "subset");
        }
    }

    @Override
    public void test(TestHarness harness) {
        this.test_clone(harness);
        this.test_add(harness);
        this.test_addAll(harness);
        this.test_contains(harness);
        this.test_remove(harness);
        this.test_clear(harness);
        this.test_subsets(harness);
    }
}

