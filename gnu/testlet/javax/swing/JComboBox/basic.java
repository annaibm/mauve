/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComboBox;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Container;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class basic
implements Testlet,
ActionListener,
ItemListener {
    static String COMMAND = "mauve";
    static String UNASSIGNED = "<unassigned>";
    String command = UNASSIGNED;
    StringBuffer stateChangeEvents = new StringBuffer();

    @Override
    public void test(TestHarness harness) {
        JComboBox box = this.createBox(harness);
        this.testSelectionByIndex(harness, box);
        this.testSelectionByName(harness, box);
        this.testItemRemoving(harness, box);
        this.testAddingItems(harness, box);
        this.testTogglingVisibility(harness);
    }

    private void testAddingItems(TestHarness harness, JComboBox box) {
        harness.checkPoint("Adding items");
        box.addItem("x");
        box.addItem("y");
        harness.check(box.getItemCount(), 2, "adding items");
        harness.check(box.getItemAt(0), "x", "adding items");
        harness.check(box.getItemAt(1), "y", "adding items");
    }

    private void testItemRemoving(TestHarness harness, JComboBox box) {
        harness.checkPoint("Removing items");
        box.removeItem("b");
        harness.check(box.getItemCount(), 2, "removing by name");
        harness.check((String)box.getItemAt(0) + (String)box.getItemAt(1), "ac", "removing by name");
        box.removeItemAt(0);
        harness.check(box.getItemCount(), 1, "removing by index");
        harness.check(box.getItemAt(0), "c", "removing by index");
        box.removeAllItems();
        harness.check(box.getItemCount(), 0, "Removing all items.");
    }

    private JComboBox createBox(TestHarness harness) {
        harness.checkPoint("Creating");
        String[] array = new String[]{"a", "b", "c"};
        JComboBox<String> box = new JComboBox<String>(array);
        box.addActionListener(this);
        box.addItemListener(this);
        box.setActionCommand(COMMAND);
        harness.check(box.getActionCommand(), COMMAND, "action command");
        harness.check(box.getItemCount(), 3, "item count");
        this.testGetItemAt(harness, array, box);
        return box;
    }

    private void testGetItemAt(TestHarness harness, String[] array, JComboBox box) {
        harness.checkPoint("getItemAt");
        for (int i = 0; i < array.length; ++i) {
            harness.check(box.getItemAt(i).toString(), array[i], "getItemAt(" + i + ") " + array[i] + "!=" + box.getItemAt(i));
        }
    }

    private void testSelectionByName(TestHarness harness, JComboBox box) {
        harness.checkPoint("s.b.n");
        this.command = UNASSIGNED;
        this.stateChangeEvents.setLength(0);
        box.setSelectedItem("a");
        harness.check(this.command, (Object)COMMAND);
        harness.check(box.getSelectedIndex(), 0, "selected index in s.b.n");
        harness.check(box.getSelectedItem(), "a", "selected item in s.b.n");
        harness.check(this.stateChangeEvents.toString(), " -c +a", "item events in s.b.i " + this.stateChangeEvents);
    }

    private void testSelectionByIndex(TestHarness harness, JComboBox box) {
        harness.checkPoint("s.b.i");
        this.command = UNASSIGNED;
        this.stateChangeEvents.setLength(0);
        box.setSelectedIndex(1);
        harness.check(this.command, COMMAND, "action listener in s.b.i");
        harness.check(box.getSelectedIndex(), 1, "selected index in s.b.i.");
        harness.check(box.getSelectedItem(), "b", "selected item in s.b.i.");
        for (int i = 0; i < 3; ++i) {
            box.setSelectedIndex(i);
        }
        String events = this.stateChangeEvents.toString();
        harness.check(events.startsWith(" -a"), "Missing event on deselecting the default item. Bug in 1.3, fixed in 1.4.");
        harness.check(events, " -a +b -b +a -a +b -b +c", "item events in s.b.i " + this.stateChangeEvents);
        this.command = UNASSIGNED;
    }

    private void testTogglingVisibility(TestHarness harness) {
        JFrame frame = new JFrame();
        frame.setSize(200, 100);
        Container contentPane = frame.getContentPane();
        JComboBox<String> box = new JComboBox<String>();
        box.addItem("123");
        box.addItem("aaa");
        box.addItem("abc");
        contentPane.add(box, "South");
        frame.show();
        harness.check(!box.isPopupVisible());
        Robot r = harness.createRobot();
        r.waitForIdle();
        r.delay(100);
        r.mouseMove(box.getLocationOnScreen().x + box.getSize().width / 2, box.getLocationOnScreen().y + box.getSize().height / 2);
        r.waitForIdle();
        r.delay(100);
        r.mousePress(16);
        r.mouseRelease(16);
        r.waitForIdle();
        r.delay(100);
        harness.check(box.isPopupVisible());
        r.waitForIdle();
        r.delay(100);
        r.mousePress(16);
        r.mouseRelease(16);
        r.waitForIdle();
        r.delay(100);
        harness.check(!box.isPopupVisible());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.command = e.getActionCommand();
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        if (ie.getStateChange() == 1) {
            this.stateChangeEvents.append(" +" + ie.getItem());
        } else {
            this.stateChangeEvents.append(" -" + ie.getItem());
        }
    }
}

