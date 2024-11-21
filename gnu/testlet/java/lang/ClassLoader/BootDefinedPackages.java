/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.ClassLoader;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.Serializable;

public class BootDefinedPackages
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TestLoader loader = new TestLoader(this.getClass().getClassLoader());
        loader.test(harness);
    }

    private static class TestLoader
    extends ClassLoader
    implements Serializable {
        private static final long serialVersionUID = 1L;
        static String[] standardPackagesClasses = new String[]{"java.applet.Applet", "java.awt.color.CMMException", "java.awt.datatransfer.Clipboard", "java.awt.dnd.peer.DragSourceContextPeer", "java.awt.dnd.Autoscroll", "java.awt.event.ActionEvent", "java.awt.font.FontRenderContext", "java.awt.geom.AffineTransform", "java.awt.im.spi.InputMethod", "java.awt.im.InputContext", "java.awt.image.renderable.ContextualRenderedImageFactory", "java.awt.image.AffineTransformOp", "java.awt.peer.ButtonPeer", "java.awt.print.Book", "java.awt.ActiveEvent", "java.beans.beancontext.BeanContext", "java.beans.AppletInitializer", "java.io.BufferedInputStream", "java.lang.annotation.AnnotationFormatError", "java.lang.ref.PhantomReference", "java.lang.reflect.AccessibleObject", "java.lang.AbstractMethodError", "java.math.BigDecimal", "java.net.Authenticator", "java.nio.channels.spi.AbstractInterruptibleChannel", "java.nio.channels.AlreadyConnectedException", "java.nio.charset.spi.CharsetProvider", "java.nio.charset.CharacterCodingException", "java.nio.Buffer", "java.rmi.activation.Activatable", "java.rmi.dgc.DGC", "java.rmi.registry.LocateRegistry", "java.rmi.server.ExportException", "java.rmi.AccessException", "java.security.acl.Acl", "java.security.cert.Certificate", "java.security.interfaces.DSAKey", "java.security.spec.AlgorithmParameterSpec", "java.security.AccessControlContext", "java.sql.Array", "java.text.Annotation", "java.util.jar.Attributes", "java.util.logging.ConsoleHandler", "java.util.prefs.AbstractPreferences", "java.util.regex.Matcher", "java.util.zip.Adler32", "java.util.AbstractCollection"};

        public TestLoader(ClassLoader parent) {
            super(parent);
        }

        public void test(TestHarness harness) {
            harness.checkPoint("Checking basic packages");
            harness.check(this.getPackage("gnu.testlet.java.lang.ClassLoader") != null);
            harness.check(this.getPackage("java.lang") != null);
            harness.check(this.getPackage("java.io") != null);
            for (int i = 0; i < standardPackagesClasses.length; ++i) {
                int lastDot = standardPackagesClasses[i].lastIndexOf(46);
                String packageName = standardPackagesClasses[i].substring(0, lastDot);
                if (this.getPackage(packageName) != null) continue;
                try {
                    Class.forName(standardPackagesClasses[i]);
                    harness.check(this.getPackage(packageName) != null, "Checking definition of " + packageName);
                    continue;
                }
                catch (ClassNotFoundException e) {
                    harness.debug("Unsuitable class to test on this vm");
                    harness.debug(e);
                }
            }
        }
    }
}

