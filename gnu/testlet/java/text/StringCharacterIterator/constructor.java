/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.StringCharacterIterator;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.StringCharacterIterator;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        StringCharacterIterator sci = null;
        harness.checkPoint("failing constructors");
        try {
            sci = new StringCharacterIterator(null);
        }
        catch (NullPointerException nullPointerException2) {
            // empty catch block
        }
        harness.check(sci, null);
        sci = null;
        try {
            sci = new StringCharacterIterator(null, 0);
        }
        catch (NullPointerException nullPointerException3) {
            // empty catch block
        }
        harness.check(sci, null);
        sci = null;
        try {
            sci = new StringCharacterIterator(null, 0, 0, 0);
        }
        catch (NullPointerException nullPointerException4) {
            // empty catch block
        }
        harness.check(sci, null);
        sci = null;
        try {
            sci = new StringCharacterIterator(null, 0);
        }
        catch (NullPointerException nullPointerException5) {
            // empty catch block
        }
        harness.check(sci, null);
        sci = null;
        try {
            sci = new StringCharacterIterator(null, 0);
        }
        catch (NullPointerException nullPointerException6) {
            // empty catch block
        }
        harness.check(sci, null);
        sci = null;
        try {
            sci = new StringCharacterIterator("ontology", -1);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            // empty catch block
        }
        harness.check(sci, null);
        sci = null;
        try {
            sci = new StringCharacterIterator("ontology", 9);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            // empty catch block
        }
        harness.check(sci, null);
        sci = null;
        try {
            sci = new StringCharacterIterator("ontology", -9, 0, 1);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            // empty catch block
        }
        harness.check(sci, null);
        sci = null;
        try {
            sci = new StringCharacterIterator("ontology", 0, -5, 1);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            // empty catch block
        }
        harness.check(sci, null);
        sci = null;
        try {
            sci = new StringCharacterIterator("ontology", 0, 1, -1);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            // empty catch block
        }
        harness.check(sci, null);
        sci = null;
        try {
            sci = new StringCharacterIterator("ontology", 5, 2, 3);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            // empty catch block
        }
        harness.check(sci, null);
        sci = null;
        try {
            sci = new StringCharacterIterator("ontology", 2, 5, 7);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            // empty catch block
        }
        harness.check(sci, null);
        harness.checkPoint("successful constructors");
        sci = new StringCharacterIterator("ontology");
        harness.check(sci.getBeginIndex(), 0);
        harness.check(sci.getEndIndex(), 8);
        harness.check(sci.getIndex(), 0);
        sci = new StringCharacterIterator("ontology", 5);
        harness.check(sci.getBeginIndex(), 0);
        harness.check(sci.getEndIndex(), 8);
        harness.check(sci.getIndex(), 5);
        sci = new StringCharacterIterator("ontology", 0, 7, 3);
        harness.check(sci.getBeginIndex(), 0);
        harness.check(sci.getEndIndex(), 7);
        harness.check(sci.getIndex(), 3);
        harness.checkPoint("clone");
        StringCharacterIterator s2 = (StringCharacterIterator)sci.clone();
        harness.check(s2.getBeginIndex(), 0);
        harness.check(s2.getEndIndex(), 7);
        harness.check(s2.getIndex(), 3);
        harness.check(sci.equals(s2));
    }
}

