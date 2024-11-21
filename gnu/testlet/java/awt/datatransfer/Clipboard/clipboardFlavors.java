/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.datatransfer.Clipboard;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.FlavorEvent;
import java.awt.datatransfer.FlavorListener;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class clipboardFlavors
extends Clipboard
implements Testlet,
Transferable,
ClipboardOwner,
FlavorListener {
    private DataFlavor[] transferDataFlavors;
    private boolean lostOwnerCalled = false;
    private Clipboard lostOwnerClipboard = null;
    private Transferable lostOwnerTransferable = null;
    private boolean flavorChangedCalled = false;
    private FlavorEvent flavorChangedEvent = null;

    public clipboardFlavors() {
        super("mauve");
    }

    private clipboardFlavors(String name2) {
        super(name2);
    }

    private clipboardFlavors(String[] mimeTypes) throws ClassNotFoundException {
        this("mimeTypes.startingwith[" + mimeTypes[0] + "]");
        this.transferDataFlavors = new DataFlavor[mimeTypes.length];
        for (int i = 0; i < mimeTypes.length; ++i) {
            this.transferDataFlavors[i] = new DataFlavor(mimeTypes[i]);
        }
    }

    @Override
    public void test(TestHarness harness) {
        try {
            Object o;
            Object o2;
            harness.checkPoint("empty");
            DataFlavor[] flavors = this.getAvailableDataFlavors();
            harness.check(flavors != null);
            harness.check(flavors.length, 0);
            harness.check(this.isDataFlavorAvailable(DataFlavor.imageFlavor), false);
            boolean exception_thrown = false;
            try {
                Object o3 = this.getData(DataFlavor.imageFlavor);
                harness.debug("got data: " + o3);
            }
            catch (UnsupportedFlavorException ufe) {
                exception_thrown = true;
            }
            harness.check(exception_thrown);
            FlavorListener[] listeners = this.getFlavorListeners();
            harness.check(listeners != null);
            harness.check(listeners.length, 0);
            harness.checkPoint("Add self listener");
            this.addFlavorListener(this);
            listeners = this.getFlavorListeners();
            harness.check(listeners.length, 1);
            harness.check(listeners[0], this);
            harness.checkPoint("Remove null listener");
            this.removeFlavorListener(null);
            listeners = this.getFlavorListeners();
            harness.check(listeners.length, 1);
            harness.check(listeners[0], this);
            harness.checkPoint("Remove non-existing listener");
            this.removeFlavorListener(new clipboardFlavors("dummy-to-remove"));
            listeners = this.getFlavorListeners();
            harness.check(listeners.length, 1);
            harness.check(listeners[0], this);
            harness.checkPoint("Remove self");
            this.removeFlavorListener(this);
            listeners = this.getFlavorListeners();
            harness.check(listeners != null);
            harness.check(listeners.length, 0);
            harness.checkPoint("Remove self again");
            this.removeFlavorListener(this);
            listeners = this.getFlavorListeners();
            harness.check(listeners != null);
            harness.check(listeners.length, 0);
            harness.checkPoint("put in data");
            this.setContents(new clipboardFlavors(new String[]{"x/z", "q/w"}), this);
            this.addFlavorListener(this);
            flavors = this.getAvailableDataFlavors();
            harness.check(flavors != null);
            harness.check(flavors.length, 2);
            harness.check(flavors[0].getMimeType().equals("x/z") || flavors[1].getMimeType().equals("x/z"));
            harness.check(flavors[0].getMimeType().equals("q/w") || flavors[1].getMimeType().equals("q/w"));
            harness.check(this.isDataFlavorAvailable(DataFlavor.imageFlavor), false);
            harness.check(this.isDataFlavorAvailable(new DataFlavor("x/z")));
            harness.check(this.isDataFlavorAvailable(new DataFlavor("q/w")));
            exception_thrown = false;
            try {
                o2 = this.getData(DataFlavor.imageFlavor);
                harness.debug("got data: " + o2);
            }
            catch (UnsupportedFlavorException ufe) {
                exception_thrown = true;
            }
            harness.check(exception_thrown);
            harness.check(this.getData(new DataFlavor("x/z")), (Object)"x/z");
            harness.check(this.getData(new DataFlavor("q/w")), (Object)"q/w");
            harness.checkPoint("change contents");
            this.setContents(new clipboardFlavors(new String[]{"a/b"}), this);
            harness.check(this.flavorChangedCalled);
            harness.check(this.flavorChangedEvent != null);
            harness.check(this.flavorChangedEvent.getSource(), this);
            flavors = this.getAvailableDataFlavors();
            harness.check(flavors != null);
            harness.check(flavors.length, 1);
            harness.check(this.isDataFlavorAvailable(DataFlavor.imageFlavor), false);
            harness.check(this.isDataFlavorAvailable(new DataFlavor("x/z")), false);
            harness.check(this.isDataFlavorAvailable(new DataFlavor("q/w")), false);
            harness.check(this.isDataFlavorAvailable(new DataFlavor("a/b")));
            exception_thrown = false;
            try {
                o2 = this.getData(DataFlavor.imageFlavor);
                harness.debug("got data: " + o2);
            }
            catch (UnsupportedFlavorException ufe) {
                exception_thrown = true;
            }
            harness.check(exception_thrown);
            exception_thrown = false;
            try {
                o2 = this.getData(new DataFlavor("x/z"));
                harness.debug("got data: " + o2);
            }
            catch (UnsupportedFlavorException ufe) {
                exception_thrown = true;
            }
            harness.check(exception_thrown);
            exception_thrown = false;
            try {
                o2 = this.getData(new DataFlavor("q/w"));
                harness.debug("got data: " + o2);
            }
            catch (UnsupportedFlavorException ufe) {
                exception_thrown = true;
            }
            harness.check(exception_thrown);
            harness.check(this.getData(new DataFlavor("a/b")), (Object)"a/b");
            harness.checkPoint("other listener");
            this.flavorChangedCalled = false;
            this.flavorChangedEvent = null;
            clipboardFlavors cf2 = new clipboardFlavors("cf2");
            this.addFlavorListener(cf2);
            this.setContents(new clipboardFlavors(new String[]{"a/b", "z/x"}), this);
            harness.check(this.flavorChangedCalled);
            harness.check(this.flavorChangedEvent != null);
            harness.check(this.flavorChangedEvent.getSource(), this);
            harness.check(cf2.flavorChangedCalled);
            harness.check(cf2.flavorChangedEvent != null);
            harness.check(cf2.flavorChangedEvent.getSource(), this);
            flavors = this.getAvailableDataFlavors();
            harness.check(flavors != null);
            harness.check(flavors.length, 2);
            harness.check(flavors[0].getMimeType().equals("a/b") || flavors[1].getMimeType().equals("a/b"));
            harness.check(flavors[0].getMimeType().equals("z/x") || flavors[1].getMimeType().equals("z/x"));
            harness.check(this.isDataFlavorAvailable(DataFlavor.imageFlavor), false);
            harness.check(this.isDataFlavorAvailable(new DataFlavor("x/z")), false);
            harness.check(this.isDataFlavorAvailable(new DataFlavor("q/w")), false);
            harness.check(this.isDataFlavorAvailable(new DataFlavor("a/b")));
            harness.check(this.isDataFlavorAvailable(new DataFlavor("z/x")));
            exception_thrown = false;
            try {
                o = this.getData(DataFlavor.imageFlavor);
                harness.debug("got data: " + o);
            }
            catch (UnsupportedFlavorException ufe) {
                exception_thrown = true;
            }
            harness.check(exception_thrown);
            exception_thrown = false;
            try {
                o = this.getData(new DataFlavor("x/z"));
                harness.debug("got data: " + o);
            }
            catch (UnsupportedFlavorException ufe) {
                exception_thrown = true;
            }
            harness.check(exception_thrown);
            exception_thrown = false;
            try {
                o = this.getData(new DataFlavor("q/w"));
                harness.debug("got data: " + o);
            }
            catch (UnsupportedFlavorException ufe) {
                exception_thrown = true;
            }
            harness.check(exception_thrown);
            harness.check(this.getData(new DataFlavor("a/b")), (Object)"a/b");
            harness.check(this.getData(new DataFlavor("z/x")), (Object)"z/x");
        }
        catch (IOException ioe) {
            harness.debug(ioe);
            harness.check(false, ioe.toString());
        }
        catch (ClassNotFoundException cnfe) {
            harness.debug(cnfe);
            harness.check(false, cnfe.toString());
        }
        catch (UnsupportedFlavorException ufe) {
            harness.debug(ufe);
            harness.check(false, ufe.toString());
        }
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return this.transferDataFlavors;
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor2) {
        for (int i = 0; i < this.transferDataFlavors.length; ++i) {
            if (!flavor2.equals(this.transferDataFlavors[i])) continue;
            return true;
        }
        return false;
    }

    @Override
    public Object getTransferData(DataFlavor flavor2) throws UnsupportedFlavorException {
        if (this.isDataFlavorSupported(flavor2)) {
            return flavor2.getMimeType();
        }
        throw new UnsupportedFlavorException(flavor2);
    }

    @Override
    public void lostOwnership(Clipboard clipboard2, Transferable contents) {
        this.lostOwnerCalled = true;
        this.lostOwnerClipboard = clipboard2;
        this.lostOwnerTransferable = contents;
    }

    @Override
    public void flavorsChanged(FlavorEvent event) {
        this.flavorChangedCalled = true;
        this.flavorChangedEvent = event;
    }

    public String toString() {
        return "[name=" + this.getName() + "]";
    }
}

