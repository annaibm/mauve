/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.beans.PropertyEditorSupport;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyEditorSupport;

public class getSource
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        PropertyEditorSupport pes = new PropertyEditorSupport();
        harness.check(pes.getSource(), pes, "pes-non argument");
        Object eventSource = new Object();
        pes = new PropertyEditorSupport(eventSource);
        harness.check(pes.getSource(), eventSource, "pes-single argument");
    }
}

