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

public class importData
extends TestCase {
    private JComponent component;
    private TransferHandler transferHandler;
    private Transferable transferable;

    @Override
    public void setUp() {
        this.component = new TestComponent();
        this.transferHandler = new TransferHandler("testProperty");
        this.transferable = new TestTransferable();
    }

    @Override
    public void tearDown() {
        this.component = null;
        this.transferHandler = null;
        this.transferable = null;
    }

    public void testOK() {
        boolean ok = this.transferHandler.importData(this.component, this.transferable);
        importData.assertTrue(ok);
        importData.assertEquals(((TestComponent)this.component).getTestProperty(), "Hello World");
    }

    public void testWrongFlavor() {
        this.transferable = new TestTransferable(){

            @Override
            public DataFlavor[] getTransferDataFlavors() {
                return new DataFlavor[0];
            }
        };
        boolean ok = this.transferHandler.importData(this.component, this.transferable);
        importData.assertFalse(ok);
        importData.assertNull(((TestComponent)this.component).getTestProperty());
    }

    public void testInvalidWriter() {
        this.component = new JComponent(){

            public void setTestProperty(String prop, int i) {
            }

            public String getTestProperty() {
                return "test";
            }
        };
        boolean ok = this.transferHandler.importData(this.component, this.transferable);
        importData.assertFalse(ok);
    }

    public void testMissingPropertyWriter() {
        this.component = new JComponent(){

            public String getTestProperty() {
                return "test";
            }
        };
        boolean ok = this.transferHandler.importData(this.component, this.transferable);
        importData.assertFalse(ok);
    }

    public void testMissingPropertyReader() {
        this.component = new JComponent(){

            public void setTestProperty(String prop) {
            }
        };
        boolean ok = this.transferHandler.importData(this.component, this.transferable);
        importData.assertFalse(ok);
    }

    public void testNullProperty() {
        this.transferHandler = new TransferHandler(null);
        boolean ok = this.transferHandler.importData(this.component, this.transferable);
        importData.assertFalse(ok);
    }

    static class TestTransferable
    implements Transferable {
        TestTransferable() {
        }

        @Override
        public Object getTransferData(DataFlavor flavor2) throws UnsupportedFlavorException, IOException {
            return "Hello World";
        }

        @Override
        public DataFlavor[] getTransferDataFlavors() {
            try {
                DataFlavor flavor2 = new DataFlavor("application/x-java-jvm-local-objectref; class=java.lang.String");
                return new DataFlavor[]{flavor2};
            }
            catch (ClassNotFoundException ex) {
                throw new InternalError();
            }
        }

        @Override
        public boolean isDataFlavorSupported(DataFlavor flavor2) {
            return flavor2.getPrimaryType().equals("application") && flavor2.getSubType().equals("x-java-jvm-local-objectref") && flavor2.getRepresentationClass().equals("java.lang.String");
        }
    }

    public static class TestComponent
    extends JComponent {
        String property = null;

        public void setTestProperty(String prop) {
            this.property = prop;
        }

        public String getTestProperty() {
            return this.property;
        }
    }
}

