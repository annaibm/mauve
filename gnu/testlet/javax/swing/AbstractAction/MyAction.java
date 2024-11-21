/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.AbstractAction;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Icon;

public class MyAction
extends AbstractAction {
    public MyAction() {
    }

    public MyAction(String name2) {
        super(name2);
    }

    public MyAction(String name2, Icon icon) {
        super(name2, icon);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

