/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.dnd;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceContext;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.dnd.InvalidDnDOperationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DnDTest
implements Testlet {
    TestHarness harness;
    Robot r;
    boolean unsuccessful;
    boolean dragGestRec;
    boolean dragEnter;
    boolean dragEnterTar;
    boolean dragOver;
    boolean dragOverTar;
    boolean drop;
    boolean finished;
    boolean actionPerformed;
    boolean dragExit;
    boolean dropActionChanged;
    boolean dragExitTar;
    boolean dropActionChangedTar;

    @Override
    public synchronized void test(TestHarness h) {
        this.harness = h;
        this.r = this.harness.createRobot();
        new MainClass("");
    }

    class DragLabel
    extends Label
    implements DragGestureListener,
    DragSourceListener {
        private DragSource ds;

        public DragLabel(String s, int alignment) {
            super(s, alignment);
            this.ds = DragSource.getDefaultDragSource();
            int action = 3;
            this.ds.createDefaultDragGestureRecognizer(this, action, this);
        }

        @Override
        public void dragGestureRecognized(DragGestureEvent e) {
            try {
                StringSelection t = new StringSelection(this.getText());
                e.startDrag(DragSource.DefaultCopyNoDrop, t, this);
                DnDTest.this.dragGestRec = true;
            }
            catch (InvalidDnDOperationException e2) {
                DnDTest.this.unsuccessful = true;
            }
        }

        @Override
        public void dragDropEnd(DragSourceDropEvent e) {
            if (!e.getDropSuccess()) {
                DnDTest.this.unsuccessful = true;
                return;
            }
            int action = e.getDropAction();
            if ((action & 2) != 0) {
                this.setText("");
            }
            DnDTest.this.finished = true;
        }

        @Override
        public void dragEnter(DragSourceDragEvent e) {
            DnDTest.this.dragEnterTar = true;
            DragSourceContext ctx = e.getDragSourceContext();
            int action = e.getDropAction();
            if ((action & 1) != 0) {
                ctx.setCursor(DragSource.DefaultCopyDrop);
            } else {
                ctx.setCursor(DragSource.DefaultCopyNoDrop);
            }
        }

        @Override
        public void dragExit(DragSourceEvent e) {
            DnDTest.this.dragExitTar = true;
        }

        @Override
        public void dragOver(DragSourceDragEvent e) {
            DnDTest.this.dragOverTar = true;
        }

        @Override
        public void dropActionChanged(DragSourceDragEvent e) {
            DnDTest.this.dropActionChangedTar = true;
        }
    }

    class MainClass
    extends Frame
    implements ActionListener,
    DropTargetListener {
        MouseThread mt;
        int start;
        int end;
        DragLabel source;
        Button target;

        public MainClass(String title) {
            super(title);
            this.source = new DragLabel("Drag and drop me to the following Button", 1);
            this.target = new Button();
            this.source.setForeground(Color.red);
            this.add((Component)this.source, "North");
            this.target.addActionListener(this);
            this.add((Component)this.target, "South");
            new DropTarget(this.target, 3, this);
            this.setSize(205, 100);
            this.setVisible(true);
            DnDTest.this.r.waitForIdle();
            DnDTest.this.r.delay(1000);
            this.doDnD();
            DnDTest.this.r.delay(3000);
            DnDTest.this.harness.check(!DnDTest.this.unsuccessful);
            DnDTest.this.harness.check(DnDTest.this.finished);
            DnDTest.this.harness.check(DnDTest.this.dragGestRec);
            DnDTest.this.harness.check(DnDTest.this.dragEnter);
            DnDTest.this.harness.check(DnDTest.this.dragEnterTar);
            DnDTest.this.harness.check(DnDTest.this.dragOver);
            DnDTest.this.harness.check(DnDTest.this.dragOverTar);
            DnDTest.this.harness.check(DnDTest.this.drop);
            DnDTest.this.harness.check(!DnDTest.this.actionPerformed);
            DnDTest.this.harness.check(!DnDTest.this.dragExit);
            DnDTest.this.harness.check(!DnDTest.this.dropActionChanged);
            DnDTest.this.harness.check(!DnDTest.this.dragExitTar);
            DnDTest.this.harness.check(!DnDTest.this.dropActionChangedTar);
        }

        void doDnD() {
            Point sLoc = this.source.getLocationOnScreen();
            Rectangle sSize = this.source.getBounds();
            Point tLoc = this.target.getLocationOnScreen();
            Rectangle tSize = this.target.getBounds();
            DnDTest.this.r.mouseMove(sLoc.x + sSize.width / 2, sLoc.y + sSize.height / 2);
            DnDTest.this.r.mousePress(16);
            DnDTest.this.r.mouseRelease(16);
            DnDTest.this.r.delay(1000);
            DnDTest.this.r.mousePress(16);
            DnDTest.this.r.delay(1000);
            DnDTest.this.r.mouseMove(tLoc.x + tSize.width / 2, tLoc.y + tSize.height / 2);
            this.start = tLoc.y + tSize.height / 2;
            this.end = this.start + 5;
            this.mt = new MouseThread();
            this.mt.start();
            DnDTest.this.r.delay(1000);
            this.mt.shouldStop = true;
            DnDTest.this.r.mouseRelease(16);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Button b = (Button)e.getSource();
            b.setLabel("");
            this.source.setText("Drag and drop me to the following Button");
            DnDTest.this.actionPerformed = true;
        }

        @Override
        public void dragEnter(DropTargetDragEvent e) {
            DnDTest.this.dragEnter = true;
        }

        @Override
        public void dragExit(DropTargetEvent e) {
            DnDTest.this.dragExit = true;
        }

        @Override
        public void dragOver(DropTargetDragEvent e) {
            DnDTest.this.dragOver = true;
        }

        @Override
        public void drop(DropTargetDropEvent e) {
            DnDTest.this.drop = true;
            try {
                Transferable t = e.getTransferable();
                if (e.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                    e.acceptDrop(e.getDropAction());
                    String s = (String)t.getTransferData(DataFlavor.stringFlavor);
                    this.target.setLabel(s);
                    e.dropComplete(true);
                } else {
                    DnDTest.this.unsuccessful = true;
                    e.rejectDrop();
                }
            }
            catch (IOException e2) {
                DnDTest.this.unsuccessful = true;
            }
            catch (UnsupportedFlavorException e2) {
                DnDTest.this.unsuccessful = true;
            }
        }

        @Override
        public void dropActionChanged(DropTargetDragEvent e) {
            DnDTest.this.dropActionChanged = true;
        }

        class MouseThread
        extends Thread {
            public boolean shouldStop;

            MouseThread() {
            }

            @Override
            public void run() {
                try {
                    this.shouldStop = false;
                    Robot robot = new Robot();
                    do {
                        int i;
                        for (i = MainClass.this.start; i < MainClass.this.end && !this.shouldStop; ++i) {
                            robot.mouseMove(150, i);
                            MouseThread.yield();
                        }
                        for (i = MainClass.this.end; i > MainClass.this.start && !this.shouldStop; --i) {
                            robot.mouseMove(150, i);
                            MouseThread.yield();
                        }
                    } while (!this.shouldStop);
                }
                catch (Exception e) {
                    DnDTest.this.unsuccessful = true;
                }
            }
        }
    }
}

