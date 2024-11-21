/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.beans.XMLDecoder;

import gnu.testlet.ResourceNotFoundException;
import gnu.testlet.TestHarness;
import gnu.testlet.java.beans.XMLDecoder.EqualityChecker;
import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DecoderTestHelper {
    private List expectedObjects = new ArrayList();
    private Map checkers = new HashMap();
    private String xmlFile;
    private String name;

    DecoderTestHelper(String name2, String xmlResourceFilename) {
        if (name2 == null || name2.length() == 0) {
            throw new IllegalArgumentException("Please provide a name for this test.");
        }
        this.name = name2;
        if (xmlResourceFilename == null) {
            throw new IllegalArgumentException("No filename to a XML resource file provided.");
        }
        this.xmlFile = xmlResourceFilename;
    }

    protected final void addObject(Object obj) {
        this.expectedObjects.add(obj);
    }

    protected final void addObject(Object obj, EqualityChecker eqChecker) {
        if (this.checkers.containsKey(obj)) {
            throw new IllegalStateException("Already provided an EqualityChecker instance for object '" + obj + "'.");
        }
        this.checkers.put(obj, eqChecker);
        this.addObject(obj);
    }

    final void doComparison(final TestHarness harness) {
        ExceptionListener exListener = new ExceptionListener(){

            @Override
            public void exceptionThrown(Exception e) {
                harness.fail(DecoderTestHelper.this.name + " - decode.readObject(): unexpected exception occured during decoding: " + e);
            }
        };
        XMLDecoder decoder = null;
        try {
            decoder = new XMLDecoder(harness.getResourceStream(this.xmlFile), null, exListener);
        }
        catch (ResourceNotFoundException e) {
            harness.fail(this.name + " - create XMLDecoder: unable to load resource from classpath: " + this.xmlFile);
            return;
        }
        for (Object expectedObject : this.expectedObjects) {
            try {
                Object decodedObject = decoder.readObject();
                if (this.checkers.containsKey(expectedObject)) {
                    EqualityChecker eq = (EqualityChecker)this.checkers.get(expectedObject);
                    harness.check(eq.areEqual(decodedObject, expectedObject), this.name + " - decoder.readObject()-loop");
                    continue;
                }
                harness.check(decodedObject, expectedObject, this.name + " - decoder.readObject()-loop");
            }
            catch (ArrayIndexOutOfBoundsException aioobe) {
                decoder.close();
                harness.fail(this.name + " - decoder.close()");
                harness.verbose(this.name + "decoder.close(): no more objects provided by XMLDecoder although at least one more was expected");
                return;
            }
        }
        try {
            decoder.readObject();
        }
        catch (ArrayIndexOutOfBoundsException aioobe) {
            decoder.close();
            return;
        }
        harness.fail(this.name + " - readObject()-final: at least one unexpected object was left in the decoder");
        decoder.close();
    }
}

