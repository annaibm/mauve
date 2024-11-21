/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.TransferHandler;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import javax.swing.JComponent;
import javax.swing.TransferHandler;
import junit.framework.TestCase;

public class exportToClipboard
extends TestCase {
    int sourceActions;
    JComponent exportDoneSource;
    Transferable exportDoneTransferable;
    int exportDoneAction;
    ClipboardOwner clipboardOwner;
    private TransferHandler transferHandler;
    private JComponent component;
    private Clipboard clipboard;

    @Override
    public void setUp() {
        this.transferHandler = new TestTransferHandler("testProperty");
        this.component = new TestComponent();
        this.clipboard = new TestClipboard();
        this.exportDoneAction = -1;
        this.exportDoneSource = null;
        this.exportDoneTransferable = null;
        this.clipboardOwner = null;
    }

    @Override
    public void tearDown() {
        this.transferHandler = null;
        this.component = null;
        this.clipboard = null;
        this.exportDoneAction = -1;
        this.exportDoneSource = null;
        this.exportDoneTransferable = null;
        this.clipboardOwner = null;
    }

    public void testIntersectingSourceActions() {
        this.sourceActions = 1;
        this.transferHandler.exportToClipboard(this.component, this.clipboard, 2);
        exportToClipboard.assertNull(this.clipboard.getContents(this));
        exportToClipboard.assertEquals(this.component, this.exportDoneSource);
        exportToClipboard.assertNull(this.exportDoneTransferable);
        exportToClipboard.assertEquals(0, this.exportDoneAction);
    }

    public void testMissingGetter() {
        this.component = new JComponent(){};
        this.sourceActions = 1;
        this.transferHandler.exportToClipboard(this.component, this.clipboard, 1);
        exportToClipboard.assertNull(this.clipboard.getContents(this));
        exportToClipboard.assertEquals(this.component, this.exportDoneSource);
        exportToClipboard.assertNull(this.exportDoneTransferable);
        exportToClipboard.assertEquals(0, this.exportDoneAction);
    }

    public void testNormalTransfer() {
        this.sourceActions = 1;
        this.transferHandler.exportToClipboard(this.component, this.clipboard, 1);
        exportToClipboard.assertEquals(this.component, this.exportDoneSource);
        exportToClipboard.assertNotNull(this.exportDoneTransferable);
        exportToClipboard.assertSame(this.exportDoneTransferable, this.clipboard.getContents(this));
        try {
            DataFlavor flavor2 = new DataFlavor("application/x-java-jvm-local-objectref; class=java.lang.String");
            exportToClipboard.assertEquals((Object)"HelloWorld", this.exportDoneTransferable.getTransferData(flavor2));
        }
        catch (Exception ex) {
            ex.printStackTrace();
            exportToClipboard.fail(ex.getMessage());
        }
        exportToClipboard.assertEquals(1, this.exportDoneAction);
        exportToClipboard.assertNull(this.clipboardOwner);
    }

    public void testIllegalStateException() {
        this.sourceActions = 1;
        this.clipboard = new Clipboard("DEFAULT"){

            @Override
            public void setContents(Transferable t, ClipboardOwner o) {
                throw new IllegalStateException();
            }
        };
        try {
            this.transferHandler.exportToClipboard(this.component, this.clipboard, 1);
            exportToClipboard.fail("IllegalStateException must be thrown");
        }
        catch (IllegalStateException illegalStateException2) {
            // empty catch block
        }
        exportToClipboard.assertEquals(this.component, this.exportDoneSource);
        exportToClipboard.assertNotNull(this.exportDoneTransferable);
        exportToClipboard.assertEquals(0, this.exportDoneAction);
    }

    public class TestComponent
    extends JComponent {
        public String getTestProperty() {
            return "HelloWorld";
        }
    }

    private class TestTransferHandler
    extends TransferHandler {
        TestTransferHandler(String prop) {
            super(prop);
        }

        @Override
        public void exportDone(JComponent c, Transferable t, int a) {
            exportToClipboard.this.exportDoneSource = c;
            exportToClipboard.this.exportDoneTransferable = t;
            exportToClipboard.this.exportDoneAction = a;
        }

        @Override
        public int getSourceActions(JComponent c) {
            return exportToClipboard.this.sourceActions;
        }
    }

    private class TestClipboard
    extends Clipboard {
        TestClipboard() {
            super("DEFAULT");
        }

        @Override
        public void setContents(Transferable t, ClipboardOwner o) {
            super.setContents(t, o);
            exportToClipboard.this.clipboardOwner = o;
        }
    }
}

