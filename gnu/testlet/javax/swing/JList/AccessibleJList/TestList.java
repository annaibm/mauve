/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JList.AccessibleJList;

import javax.accessibility.AccessibleContext;
import javax.swing.JList;

public class TestList
extends JList {
    public TestList() {
    }

    public TestList(Object[] values2) {
        super(values2);
    }

    @Override
    public AccessibleContext getAccessibleContext() {
        return new AccessibleTestList();
    }

    public class AccessibleTestList
    extends JList.AccessibleJList {
        public AccessibleTestList() {
            super(TestList.this);
        }
    }
}

