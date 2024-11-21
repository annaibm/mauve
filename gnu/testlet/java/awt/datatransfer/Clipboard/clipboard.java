/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.datatransfer.Clipboard;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

public class clipboard
extends Clipboard
implements Testlet,
Transferable,
ClipboardOwner {
    private boolean lostOwnerCalled = false;
    private Clipboard lostOwnerClipboard = null;
    private Transferable lostOwnerTransferable = null;

    public clipboard() {
        super("mauve");
    }

    private clipboard(String name2) {
        super(name2);
    }

    @Override
    public void test(TestHarness harness) {
        harness.check(this.getName(), (Object)"mauve");
        harness.check(this.contents, null);
        harness.check(this.getContents(null), this.contents);
        harness.check(this.owner, null);
        this.setContents(this, this);
        harness.check(this.contents, this);
        harness.check(this.getContents(null), this.contents);
        harness.check(this.owner, this);
        harness.check(this.lostOwnerCalled, false);
        clipboard cp2 = new clipboard("dummy2");
        this.setContents(cp2, cp2);
        harness.check(this.lostOwnerCalled, true);
        harness.check(this.contents, cp2);
        harness.check(this.getContents(null), this.contents);
        harness.check(this.owner, cp2);
        harness.check(this.lostOwnerClipboard, this);
        harness.check(this.lostOwnerTransferable, this);
        this.lostOwnerCalled = false;
        this.setContents(this, this);
        harness.check(this.lostOwnerCalled, false);
        harness.check(this.contents, this);
        harness.check(this.getContents(null), this.contents);
        harness.check(this.owner, this);
        this.setContents(cp2, this);
        harness.check(this.lostOwnerCalled, false);
        harness.check(this.contents, cp2);
        harness.check(this.getContents(null), this.contents);
        harness.check(this.owner, this);
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[0];
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor2) {
        return false;
    }

    @Override
    public Object getTransferData(DataFlavor flavor2) {
        return null;
    }

    @Override
    public void lostOwnership(Clipboard clipboard2, Transferable contents) {
        this.lostOwnerCalled = true;
        this.lostOwnerClipboard = clipboard2;
        this.lostOwnerTransferable = contents;
    }

    public String toString() {
        return "[name=" + this.getName() + "]";
    }
}

