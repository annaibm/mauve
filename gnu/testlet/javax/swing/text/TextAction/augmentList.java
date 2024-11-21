/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.TextAction;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.text.TextAction;

public class augmentList
implements Testlet {
    @Override
    public void test(TestHarness h) {
        Action[] result = null;
        Action[] empty = new TextAction[]{};
        TextAction[] nullArray = new TextAction[]{null, null};
        Action[] data = new TextAction[]{new TestAction("test 1"), new TestAction("test 2")};
        boolean ok = false;
        try {
            result = TextAction.augmentList(null, null);
        }
        catch (NullPointerException e) {
            ok = true;
        }
        catch (Exception e) {
            // empty catch block
        }
        h.check(ok, "invalid arguments");
        ok = false;
        try {
            result = TextAction.augmentList(empty, null);
        }
        catch (NullPointerException e) {
            ok = true;
        }
        catch (Exception e) {
            // empty catch block
        }
        h.check(ok, "invalid arguments");
        ok = false;
        try {
            result = TextAction.augmentList(null, empty);
        }
        catch (NullPointerException e) {
            ok = true;
        }
        catch (Exception exception) {
            // empty catch block
        }
        h.check(ok, "invalid arguments");
        ok = false;
        try {
            result = TextAction.augmentList(empty, empty);
            ok = true;
        }
        catch (Exception exception) {
            // empty catch block
        }
        h.check(ok, "invalid arguments");
        h.check(result.length, 0, "invalid array length");
        ok = false;
        try {
            result = TextAction.augmentList(data, data);
            ok = true;
        }
        catch (Exception exception) {
            // empty catch block
        }
        h.check(ok, "arguments");
        h.check(result.length, 2, "array length");
        h.check(result[0] == data[0] || result[0] == data[1], "content");
        h.check(result[1] == data[0] || result[1] == data[1], "content");
        h.check(result[0] != result[1], "content");
    }

    private class TestAction
    extends TextAction {
        public TestAction(String name2) {
            super(name2);
        }

        @Override
        public void actionPerformed(ActionEvent event) {
        }
    }
}

