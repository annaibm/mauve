/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Stack;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.EmptyStackException;
import java.util.Stack;

public class AcuniaStackTest
implements Testlet {
    protected TestHarness th;

    @Override
    public void test(TestHarness harness) {
        this.th = harness;
        this.test_empty();
        this.test_peek();
        this.test_pop();
        this.test_push();
        this.test_search();
    }

    public void test_empty() {
        this.th.checkPoint("empty()boolean");
        Stack<AcuniaStackTest> s = new Stack<AcuniaStackTest>();
        this.th.check(s.empty(), "a new stack is empty");
        s.push(this);
        this.th.check(!s.empty(), "this stack is not empty");
        s.pop();
        this.th.check(s.empty(), "the stack is empty now");
    }

    public void test_peek() {
        this.th.checkPoint("peek()java.lang.Object");
        Stack<String> s = new Stack<String>();
        try {
            s.peek();
            this.th.fail("should throw EmptyStackException");
        }
        catch (EmptyStackException ee) {
            this.th.check(true);
        }
        s.add("a");
        s.add("b");
        s.add("c");
        this.th.check("c".equals(s.peek()), "top element is c, but got:" + s.peek());
        s.add(null);
        this.th.check(s.peek() == null, "top element is null");
    }

    public void test_pop() {
        this.th.checkPoint("pop()java.lang.Object");
        Stack<String> s = new Stack<String>();
        try {
            s.pop();
            this.th.fail("should throw EmptyStackException -- 1");
        }
        catch (EmptyStackException ee) {
            this.th.check(true);
        }
        s.add("a");
        s.add("b");
        s.add("c");
        this.th.check("c".equals(s.pop()), "popped element is c");
        this.th.check(!s.contains("c"), "element should be removed -- 1");
        s.add(null);
        this.th.check(s.pop() == null, "popped element is null");
        this.th.check(!s.contains("c"), "element should be removed -- 2");
        this.th.check("b".equals(s.pop()), "popped element is b");
        this.th.check(!s.contains("b"), "element should be removed -- 3");
        this.th.check("a".equals(s.pop()), "popped element is a");
        this.th.check(!s.contains("a"), "element should be removed -- 4");
        try {
            s.pop();
            this.th.fail("should throw EmptyStackException -- 2");
        }
        catch (EmptyStackException ee) {
            this.th.check(true);
        }
    }

    public void test_push() {
        this.th.checkPoint("push(java.lang.Object)java.lang.Object");
        Stack<String> s = new Stack<String>();
        this.th.check("c".equals(s.push("c")), "pushed element is c");
        this.th.check(s.contains("c"), "element should be added -- 1");
        this.th.check("b".equals(s.push("b")), "pushed element is b");
        this.th.check(s.contains("b"), "element should be added -- 2");
        this.th.check("a".equals(s.push("a")), "pushed element is a");
        this.th.check(s.contains("a"), "element should be added -- 3");
        this.th.check(s.push(null) == null, "null is allowed");
        this.th.check(s.lastElement() == null, "added on the last place");
        this.th.check(s.toString().equals("[c, b, a, null]"), "got:" + s.toString());
    }

    public void test_search() {
        this.th.checkPoint("search(java.lang.Object)int");
        Stack<String> s = new Stack<String>();
        try {
            this.th.check(s.search("a") == -1, "empty stack should'n cause problems -- 1");
            this.th.check(s.search(null) == -1, "empty stack should'n cause problems -- 2");
        }
        catch (Exception e) {
            this.th.fail("got unwanted Exception:" + e);
        }
        s.add("a");
        s.add("b");
        s.add("c");
        s.add("a");
        s.add("a");
        s.add(null);
        s.add(null);
        s.add("top");
        this.th.check(s.search("a") == 4, "checking position -- 1");
        this.th.check(s.search("b") == 7, "checking position -- 2");
        this.th.check(s.search("c") == 6, "checking position -- 3");
        this.th.check(s.search("top") == 1, "checking position -- 4");
        this.th.check(s.search(null) == 2, "checking position -- 5");
        this.th.check(s.search("ab") == -1, "checking position -- 6");
        s.pop();
        s.pop();
        s.pop();
        this.th.check(s.search("a") == 1, "checking position -- 7");
        this.th.check(s.search(null) == -1, "checking position -- 8");
    }
}

