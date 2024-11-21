/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.undo.StateEdit;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Hashtable;
import javax.swing.undo.StateEdit;
import javax.swing.undo.StateEditable;

public class undo
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Person p = new Person();
        p.setName("Daniel Dandelion");
        StateEdit edit = new StateEdit(p, "Name Change");
        harness.check(p.getName(), (Object)"Daniel Dandelion");
        p.setName("Rose Rosenholz");
        edit.end();
        harness.check(p.getName(), (Object)"Rose Rosenholz");
        edit.undo();
        harness.check(p.getName(), (Object)"Daniel Dandelion");
        edit.redo();
        harness.check(p.getName(), (Object)"Rose Rosenholz");
    }

    private static class Person
    implements StateEditable {
        private String name;

        private Person() {
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name2) {
            this.name = name2;
        }

        public void restoreState(Hashtable h) {
            if (h.containsKey("name")) {
                this.setName((String)h.get("name"));
            }
        }

        public void storeState(Hashtable h) {
            h.put("name", this.name);
        }
    }
}

