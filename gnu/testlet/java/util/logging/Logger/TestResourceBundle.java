/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.logging.Logger;

import java.util.ListResourceBundle;

public class TestResourceBundle
extends ListResourceBundle {
    private final Object[][] contents = new Object[][]{{"test", "foo-bar-baz"}, {"ENTRY {0}", "BETRETEN {0}"}};

    @Override
    protected Object[][] getContents() {
        return this.contents;
    }
}

