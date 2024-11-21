/*
 * Decompiled with CFR 0.152.
 */
package net.sourceforge.nanoxml;

public class XMLParseException
extends RuntimeException {
    public static final int NO_LINE = -1;
    private int lineNr;

    public XMLParseException(String name2, String message) {
        super("XML Parse Exception during parsing of " + (name2 == null ? "the XML definition" : "a " + name2 + " element") + ": " + message);
        this.lineNr = -1;
    }

    public XMLParseException(String name2, int lineNr, String message) {
        super("XML Parse Exception during parsing of " + (name2 == null ? "the XML definition" : "a " + name2 + " element") + " at line " + lineNr + ": " + message);
        this.lineNr = lineNr;
    }

    public int getLineNr() {
        return this.lineNr;
    }
}

