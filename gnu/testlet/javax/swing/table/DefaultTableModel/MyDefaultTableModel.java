/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.DefaultTableModel;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class MyDefaultTableModel
extends DefaultTableModel {
    public static Vector convertToVector(Object[] anArray) {
        return DefaultTableModel.convertToVector(anArray);
    }

    public static Vector convertToVector(Object[][] anArray) {
        return DefaultTableModel.convertToVector(anArray);
    }
}

