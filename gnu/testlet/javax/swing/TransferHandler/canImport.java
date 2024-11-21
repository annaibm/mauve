/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.TransferHandler;

import java.awt.datatransfer.DataFlavor;
import javax.swing.JComponent;
import javax.swing.TransferHandler;
import junit.framework.TestCase;

public class canImport
extends TestCase {
    private JComponent component;
    private DataFlavor[] flavors;
    private TransferHandler transferHandler;

    @Override
    public void setUp() {
        this.component = new JComponent(){
            String value;

            public void setTestProperty(String val) {
                this.value = val;
            }

            public String getTestProperty() {
                return this.value;
            }
        };
        this.transferHandler = new TransferHandler("testProperty");
        try {
            DataFlavor flavor2 = new DataFlavor("application/x-java-jvm-local-objectref;class=java.lang.String");
            this.flavors = new DataFlavor[]{flavor2};
        }
        catch (ClassNotFoundException x) {
            canImport.fail(x.getMessage());
        }
    }

    @Override
    public void tearDown() {
        this.component = null;
        this.transferHandler = null;
        this.flavors = null;
    }

    public void testComponentWithoutReader() {
        this.component = new JComponent(){
            String value;

            public void setTestProperty(String val) {
                this.value = val;
            }
        };
        boolean result = this.transferHandler.canImport(this.component, this.flavors);
        canImport.assertFalse(result);
    }

    public void testComponentWithoutWriter() {
        this.component = new JComponent(){
            String value;

            public String getTestProperty() {
                return this.value;
            }
        };
        boolean result = this.transferHandler.canImport(this.component, this.flavors);
        canImport.assertFalse(result);
    }

    public void testWrongMimeType() {
        DataFlavor flavor2 = DataFlavor.stringFlavor;
        this.flavors = new DataFlavor[]{flavor2};
        boolean result = this.transferHandler.canImport(this.component, this.flavors);
        canImport.assertFalse(result);
    }

    public void testWrongRepresentationClass() {
        try {
            DataFlavor flavor2 = new DataFlavor("application/x-java-jvm-local-objectref;class=java.awt.Component");
            this.flavors = new DataFlavor[]{flavor2};
        }
        catch (ClassNotFoundException ex) {
            canImport.fail(ex.getMessage());
        }
        boolean result = this.transferHandler.canImport(this.component, this.flavors);
        canImport.assertFalse(result);
    }

    public void testAllOK() {
        boolean result = this.transferHandler.canImport(this.component, this.flavors);
        canImport.assertTrue(result);
    }
}

