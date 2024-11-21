/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.jar.JarInputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;

public class getNextEntry
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            JarOutputStream jos = new JarOutputStream(baos);
            JarEntry entry = new JarEntry("test-entry");
            jos.putNextEntry(entry);
            jos.write(1);
            jos.write(2);
            jos.write(3);
            jos.close();
            baos.close();
            byte[] bs = baos.toByteArray();
            ByteArrayInputStream bais = new ByteArrayInputStream(bs);
            JarInputStream jis = new JarInputStream(bais);
            entry = jis.getNextJarEntry();
            harness.check(entry.getName(), (Object)"test-entry");
            harness.check(jis.read(), 1);
            harness.check(jis.read(), 2);
            harness.check(jis.read(), 3);
            harness.check(jis.read(), -1);
            jis.close();
            bais.close();
        }
        catch (Throwable t) {
            harness.debug(t);
            harness.check(false, "Unexpected IOException");
        }
    }
}

