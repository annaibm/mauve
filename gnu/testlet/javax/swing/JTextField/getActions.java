/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JTextField;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.Action;
import javax.swing.JTextField;
import javax.swing.text.TextAction;

public class getActions
implements Testlet {
    private void checkForAction(TestHarness h, Action[] actions, String name2) {
        boolean found = false;
        for (int i = 0; i < actions.length; ++i) {
            if (!((TextAction)actions[i]).getValue("Name").equals(name2)) continue;
            found = true;
            break;
        }
        h.check(found, name2);
    }

    @Override
    public void test(TestHarness h) {
        JTextField textField = new JTextField();
        Action[] actions = textField.getActions();
        h.check(actions != null, "actions != null");
        h.check(actions.length, 54, "number of actions");
        this.checkForAction(h, actions, "caret-backward");
        this.checkForAction(h, actions, "caret-begin-line");
        this.checkForAction(h, actions, "caret-end-line");
        this.checkForAction(h, actions, "caret-forward");
        this.checkForAction(h, actions, "caret-next-word");
        this.checkForAction(h, actions, "caret-previous-word");
        this.checkForAction(h, actions, "copy-to-clipboard");
        this.checkForAction(h, actions, "cut-to-clipboard");
        this.checkForAction(h, actions, "delete-next");
        this.checkForAction(h, actions, "delete-previous");
        this.checkForAction(h, actions, "notify-field-accept");
        this.checkForAction(h, actions, "paste-from-clipboard");
        this.checkForAction(h, actions, "select-all");
        this.checkForAction(h, actions, "selection-backward");
        this.checkForAction(h, actions, "selection-begin");
        this.checkForAction(h, actions, "selection-begin-line");
        this.checkForAction(h, actions, "selection-begin-word");
        this.checkForAction(h, actions, "selection-end");
        this.checkForAction(h, actions, "selection-end-line");
        this.checkForAction(h, actions, "selection-end-word");
        this.checkForAction(h, actions, "selection-forward");
        this.checkForAction(h, actions, "selection-next-word");
        this.checkForAction(h, actions, "selection-previous-word");
        this.checkForAction(h, actions, "toggle-componentOrientation");
        this.checkForAction(h, actions, "unselect");
        this.checkForAction(h, actions, "beep");
        this.checkForAction(h, actions, "caret-begin");
        this.checkForAction(h, actions, "caret-begin-paragraph");
        this.checkForAction(h, actions, "caret-begin-word");
        this.checkForAction(h, actions, "caret-down");
        this.checkForAction(h, actions, "caret-end");
        this.checkForAction(h, actions, "caret-end-paragraph");
        this.checkForAction(h, actions, "caret-end-word");
        this.checkForAction(h, actions, "caret-up");
        this.checkForAction(h, actions, "default-typed");
        this.checkForAction(h, actions, "dump-model");
        this.checkForAction(h, actions, "insert-break");
        this.checkForAction(h, actions, "insert-content");
        this.checkForAction(h, actions, "insert-tab");
        this.checkForAction(h, actions, "page-down");
        this.checkForAction(h, actions, "page-up");
        this.checkForAction(h, actions, "selection-begin-paragraph");
        this.checkForAction(h, actions, "selection-down");
        this.checkForAction(h, actions, "selection-end-paragraph");
        this.checkForAction(h, actions, "selection-page-down");
        this.checkForAction(h, actions, "selection-page-left");
        this.checkForAction(h, actions, "selection-page-right");
        this.checkForAction(h, actions, "selection-page-up");
        this.checkForAction(h, actions, "selection-up");
        this.checkForAction(h, actions, "select-line");
        this.checkForAction(h, actions, "select-paragraph");
        this.checkForAction(h, actions, "select-word");
        this.checkForAction(h, actions, "set-read-only");
        this.checkForAction(h, actions, "set-writable");
    }
}

