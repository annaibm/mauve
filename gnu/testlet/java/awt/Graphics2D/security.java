/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Graphics2D;

import gnu.testlet.TestHarness;
import gnu.testlet.TestSecurityManager;
import gnu.testlet.Testlet;
import java.awt.AWTPermission;
import java.awt.Composite;
import java.awt.CompositeContext;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.ColorModel;
import java.security.Permission;

public class security
implements Testlet {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness harness) {
        try {
            Frame window = new Frame();
            window.setVisible(true);
            Graphics2D graphics2d = (Graphics2D)window.getGraphics();
            TestComposite composite = new TestComposite();
            Permission[] readDisplayPixels = new Permission[]{new AWTPermission("readDisplayPixels")};
            TestSecurityManager sm = new TestSecurityManager(harness);
            try {
                sm.install();
                harness.checkPoint("setComposite");
                try {
                    sm.prepareChecks(readDisplayPixels);
                    try {
                        graphics2d.setComposite(composite);
                    }
                    catch (UnsupportedOperationException unsupportedOperationException) {
                        // empty catch block
                    }
                    sm.checkAllChecked();
                }
                catch (SecurityException ex) {
                    harness.debug(ex);
                    harness.check(false, "unexpected check");
                }
            }
            finally {
                sm.uninstall();
            }
            window.setVisible(false);
            window.dispose();
        }
        catch (Exception ex) {
            harness.debug(ex);
            harness.check(false, "Unexpected exception");
        }
    }

    private static class TestComposite
    implements Composite {
        private TestComposite() {
        }

        @Override
        public CompositeContext createContext(ColorModel srcColorModel, ColorModel dstColorModel, RenderingHints hints) {
            return null;
        }
    }
}

