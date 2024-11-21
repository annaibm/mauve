/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.beans.XMLDecoder;

import gnu.testlet.java.beans.XMLDecoder.EqualityChecker;

class DoubleArrayChecker
implements EqualityChecker {
    DoubleArrayChecker() {
    }

    @Override
    public boolean areEqual(Object firstObject, Object secondObject) {
        try {
            if (!Class.forName("[D").isInstance(firstObject)) {
                return false;
            }
        }
        catch (ClassNotFoundException cnfe) {
            throw new InternalError("VM was unable to return the class representing an double array.");
        }
        double[] decodedArray = (double[])firstObject;
        double[] expectedArray = (double[])secondObject;
        if (decodedArray.length != expectedArray.length) {
            return false;
        }
        int size2 = decodedArray.length;
        for (int i = 0; i < size2; ++i) {
            if (decodedArray[i] == expectedArray[i]) continue;
            return false;
        }
        return true;
    }
}

