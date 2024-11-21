/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.TransferHandler;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import javax.swing.JComponent;
import javax.swing.TransferHandler;
import junit.framework.TestCase;

public class createTransferable
extends TestCase {
    private TestTransferHandler transferHandler;
    private JComponent component;

    @Override
    public void setUp() {
        this.component = new TestComponent();
        this.transferHandler = new TestTransferHandler("testProperty");
    }

    @Override
    public void tearDown() {
        this.component = null;
        this.transferHandler = null;
    }

    public void testNullProperty() {
        this.transferHandler = new TestTransferHandler(null);
        Transferable transferable = this.transferHandler.createTransferable(this.component);
        createTransferable.assertNull(transferable);
    }

    public void testMissingGetter() {
        this.component = new JComponent(){
            String value;

            public void setTestProperty(String val) {
                this.value = val;
            }
        };
        Transferable transferable = this.transferHandler.createTransferable(this.component);
        createTransferable.assertNull(transferable);
    }

    public void testMissingSetter() {
        this.component = new JComponent(){
            String value;

            public String getTestProperty() {
                return this.value;
            }
        };
        Transferable transferable = this.transferHandler.createTransferable(this.component);
        createTransferable.assertNotNull(transferable);
    }

    public void testAllOk() {
        Transferable transferable = this.transferHandler.createTransferable(this.component);
        createTransferable.assertNotNull(transferable);
    }

    public void testTransferableTransferFlavors() {
        Transferable transferable = this.transferHandler.createTransferable(this.component);
        DataFlavor[] flavors = transferable.getTransferDataFlavors();
        createTransferable.assertEquals(1, flavors.length);
        createTransferable.assertEquals("application/x-java-jvm-local-objectref; class=java.lang.String", flavors[0].getMimeType());
    }

    public void testTransferableDataFlavorSupported() {
        Transferable transferable = this.transferHandler.createTransferable(this.component);
        try {
            DataFlavor flavor2 = new DataFlavor("xyz/x-java-jvm-local-objectref; class=java.lang.String");
            createTransferable.assertFalse(transferable.isDataFlavorSupported(flavor2));
            flavor2 = new DataFlavor("application/x-java-remote-object; class=java.lang.String");
            createTransferable.assertFalse(transferable.isDataFlavorSupported(flavor2));
            flavor2 = new DataFlavor("application/x-java-jvm-local-objectref; class=java.lang.Integer");
            createTransferable.assertFalse(transferable.isDataFlavorSupported(flavor2));
            flavor2 = new DataFlavor("application/x-java-jvm-local-objectref; class=java.lang.String");
            createTransferable.assertTrue(transferable.isDataFlavorSupported(flavor2));
        }
        catch (ClassNotFoundException ex) {
            createTransferable.fail(ex.getMessage());
        }
    }

    public void testTransferableTransferData() {
        Object data;
        DataFlavor flavor22;
        Transferable transferable = this.transferHandler.createTransferable(this.component);
        try {
            flavor22 = new DataFlavor("xyz/x-java-jvm-local-objectref; class=java.lang.String");
            data = transferable.getTransferData(flavor22);
            createTransferable.fail("UnsupportedOperationException must be thrown");
        }
        catch (UnsupportedFlavorException flavor22) {
        }
        catch (IOException ex) {
            createTransferable.fail("UnsupportedFlavorException must be thrown, no IOException");
        }
        catch (ClassNotFoundException ex) {
            createTransferable.fail(ex.getMessage());
        }
        try {
            flavor22 = new DataFlavor("application/x-java-jvm-local-objectref; class=java.lang.String");
            data = transferable.getTransferData(flavor22);
            createTransferable.assertEquals(data, (Object)"HelloWorld");
        }
        catch (UnsupportedFlavorException ex) {
            createTransferable.fail("UnsupportedFlavorException must not be thrown");
        }
        catch (IOException ex) {
            System.err.println(ex.getMessage());
            createTransferable.fail("IOException must not be thrown");
        }
        catch (ClassNotFoundException ex) {
            createTransferable.fail(ex.getMessage());
        }
        this.component = new JComponent(){

            public String getTestProperty() {
                return "Hello World";
            }
        };
        transferable = this.transferHandler.createTransferable(this.component);
        try {
            flavor22 = new DataFlavor("application/x-java-jvm-local-objectref; class=java.lang.String");
            data = transferable.getTransferData(flavor22);
            createTransferable.fail("IOException must be thrown");
        }
        catch (UnsupportedFlavorException ex) {
            createTransferable.fail("UnsupportedFlavorException must not be thrown");
        }
        catch (IOException ex) {
        }
        catch (ClassNotFoundException ex) {
            createTransferable.fail(ex.getMessage());
        }
    }

    public class TestComponent
    extends JComponent {
        private String value;

        public void setTestProperty(String val) {
            this.value = val;
        }

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
        public Transferable createTransferable(JComponent comp) {
            return super.createTransferable(comp);
        }
    }
}

