/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JMenu;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class getPopUpMenu
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testAdd1(harness);
        this.testAdd2(harness);
        this.testAdd3(harness);
        this.testAdd4(harness);
        this.testAdd5(harness);
        this.testGetMenuComponents(harness);
        this.testInsert(harness);
        this.testIsPopUpMenuVisible(harness);
        this.testRemove1(harness);
        this.testRemove2(harness);
        this.testPopUpMenuVisible(harness);
        this.testSetSelectedHelper(harness);
    }

    public void testAdd1(TestHarness harness) {
        JMenu menu = new JMenu();
        AbstractAction myAction = new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println("MyAction");
            }
        };
        boolean pass = false;
        try {
            menu.add(myAction);
            pass = true;
        }
        catch (NullPointerException nullPointerException2) {
            // empty catch block
        }
        harness.check(pass);
    }

    public void testAdd2(TestHarness harness) {
        JMenu menu = new JMenu();
        MyClass comp = new MyClass();
        boolean pass = false;
        try {
            menu.add(comp);
            pass = true;
        }
        catch (NullPointerException nullPointerException2) {
            // empty catch block
        }
        harness.check(pass);
    }

    public void testAdd3(TestHarness harness) {
        JMenu menu = new JMenu();
        MyClass comp = new MyClass();
        boolean pass = false;
        try {
            menu.add((Component)comp, 0);
            pass = true;
        }
        catch (NullPointerException nullPointerException2) {
            // empty catch block
        }
        harness.check(pass);
    }

    public void testAdd4(TestHarness harness) {
        JMenu menu = new JMenu();
        JMenuItem item = new JMenuItem();
        boolean pass = false;
        try {
            menu.add(item);
            pass = true;
        }
        catch (NullPointerException nullPointerException2) {
            // empty catch block
        }
        harness.check(pass);
    }

    public void testAdd5(TestHarness harness) {
        JMenu menu = new JMenu();
        boolean pass = false;
        try {
            menu.add("String");
            pass = true;
        }
        catch (NullPointerException nullPointerException2) {
            // empty catch block
        }
        harness.check(pass);
    }

    public void testGetMenuComponents(TestHarness harness) {
        JMenu menu = new JMenu();
        boolean pass = true;
        try {
            menu.getMenuComponents();
            pass = true;
        }
        catch (NullPointerException nullPointerException2) {
            // empty catch block
        }
        harness.check(pass);
    }

    public void testInsert(TestHarness harness) {
        JMenu menu = new JMenu();
        JMenuItem item = new JMenuItem();
        boolean pass = false;
        try {
            menu.insert(item, 0);
            pass = true;
        }
        catch (NullPointerException nullPointerException2) {
            // empty catch block
        }
        harness.check(pass);
    }

    public void testIsPopUpMenuVisible(TestHarness harness) {
        JMenu menu = new JMenu();
        boolean pass = false;
        try {
            menu.isPopupMenuVisible();
            pass = true;
        }
        catch (NullPointerException nullPointerException2) {
            // empty catch block
        }
        harness.check(pass);
    }

    public void testRemove1(TestHarness harness) {
        JMenu menu = new JMenu();
        MyClass c = new MyClass();
        boolean pass = false;
        try {
            menu.remove(c);
            pass = true;
        }
        catch (NullPointerException nullPointerException2) {
            // empty catch block
        }
        harness.check(pass);
    }

    public void testRemove2(TestHarness harness) {
        JMenu menu = new JMenu();
        JMenuItem item = new JMenuItem();
        boolean pass = false;
        try {
            menu.remove(item);
            pass = true;
        }
        catch (NullPointerException nullPointerException2) {
            // empty catch block
        }
        harness.check(pass);
    }

    public void testPopUpMenuVisible(TestHarness harness) {
        JMenu menu = new JMenu();
        boolean pass = false;
        try {
            menu.setPopupMenuVisible(true);
            pass = true;
        }
        catch (NullPointerException nullPointerException2) {
            // empty catch block
        }
        harness.check(pass);
    }

    public void testSetSelectedHelper(TestHarness harness) {
        JMenu menu = new JMenu();
        boolean pass = false;
        try {
            menu.setSelected(false);
            pass = true;
        }
        catch (NullPointerException nullPointerException2) {
            // empty catch block
        }
        harness.check(pass);
    }

    public class MyClass
    extends Component {
    }
}

