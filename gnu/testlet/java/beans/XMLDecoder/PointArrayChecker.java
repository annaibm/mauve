/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.beans.XMLDecoder;

import gnu.testlet.java.beans.XMLDecoder.EqualityChecker;
import java.awt.Point;

class PointArrayChecker
implements EqualityChecker {
    PointArrayChecker() {
    }

    @Override
    public boolean areEqual(Object firstObject, Object secondObject) {
        try {
            if (!Class.forName("[Ljava.awt.Point;").isInstance(firstObject)) {
                return false;
            }
        }
        catch (ClassNotFoundException cnfe) {
            throw new InternalError("VM was unable to return the class representing an java.awt.Point array.");
        }
        Point[] decodedArray = (Point[])firstObject;
        Point[] expectedArray = (Point[])secondObject;
        if (decodedArray.length != expectedArray.length) {
            return false;
        }
        int size2 = decodedArray.length;
        for (int i = 0; i < size2; ++i) {
            if (decodedArray[i].equals(expectedArray[i])) continue;
            return false;
        }
        return true;
    }
}

