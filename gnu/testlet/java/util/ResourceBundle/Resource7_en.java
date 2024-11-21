/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.ResourceBundle;

import java.util.Enumeration;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Resource7_en
extends ResourceBundle {
    @Override
    protected Object handleGetObject(String key) throws MissingResourceException {
        if (key.compareTo("class") == 0) {
            return this.getClass().getName();
        }
        throw new MissingResourceException("s", "className", "key");
    }

    public Enumeration getKeys() {
        return null;
    }
}

