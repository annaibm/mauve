/*
 * Decompiled with CFR 0.152.
 */
package net.sourceforge.nanoxml;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import net.sourceforge.nanoxml.XMLParseException;

public class XMLElement {
    private Hashtable attributes;
    private Vector children;
    private String name;
    private String contents;
    private Hashtable entities;
    private int lineNr;
    private boolean ignoreCase;
    private boolean ignoreWhitespace;
    private char charReadTooMuch;
    private char sanitizeCharReadTooMuch;
    private Reader reader;
    private int parserLineNr;

    public XMLElement() {
        this(new Hashtable(), false, true, true);
    }

    protected XMLElement(Hashtable entities, boolean skipLeadingWhitespace, boolean fillBasicConversionTable, boolean ignoreCase) {
        this.ignoreWhitespace = skipLeadingWhitespace;
        this.ignoreCase = ignoreCase;
        this.name = null;
        this.contents = "";
        this.attributes = new Hashtable();
        this.children = new Vector();
        this.entities = entities;
        this.lineNr = 0;
        Enumeration e = this.entities.keys();
        while (e.hasMoreElements()) {
            Object key = e.nextElement();
            Object value2 = this.entities.get(key);
            if (!(value2 instanceof String)) continue;
            value2 = ((String)value2).toCharArray();
            this.entities.put(key, value2);
        }
        if (fillBasicConversionTable) {
            this.entities.put("amp", new char[]{'&'});
            this.entities.put("quot", new char[]{'\"'});
            this.entities.put("apos", new char[]{'\''});
            this.entities.put("lt", new char[]{'<'});
            this.entities.put("gt", new char[]{'>'});
        }
    }

    public void addChild(XMLElement child) {
        this.children.addElement(child);
    }

    public void setAttribute(String name2, Object value2) {
        if (this.ignoreCase) {
            name2 = name2.toUpperCase();
        }
        this.attributes.put(name2, value2.toString());
    }

    public int countChildren() {
        return this.children.size();
    }

    public Enumeration enumerateAttributeNames() {
        return this.attributes.keys();
    }

    public Enumeration enumerateChildren() {
        return this.children.elements();
    }

    public String getContent() {
        return this.contents;
    }

    public int getLineNr() {
        return this.lineNr;
    }

    public Object getAttribute(String name2) {
        if (this.ignoreCase) {
            name2 = name2.toUpperCase();
        }
        Object value2 = this.attributes.get(name2);
        return value2;
    }

    public String getName() {
        return this.name;
    }

    public void parseFromReader(Reader reader) throws IOException, XMLParseException {
        this.parseFromReader(reader, 1);
    }

    public void parseFromReader(Reader reader, int startingLineNr) throws IOException, XMLParseException {
        char ch;
        this.charReadTooMuch = '\u0000';
        this.reader = reader;
        this.parserLineNr = startingLineNr;
        while (true) {
            if ((ch = this.scanWhitespace()) != '<') {
                throw this.expectedInput("<", ch);
            }
            ch = this.readChar();
            if (ch != '!' && ch != '?') break;
            this.skipSpecialTag(0);
        }
        this.unreadChar(ch);
        this.scanElement(this);
    }

    protected XMLElement createAnotherElement() {
        return new XMLElement(this.entities, this.ignoreWhitespace, false, this.ignoreCase);
    }

    public void setContent(String content) {
        this.contents = content;
    }

    public void setName(String name2) {
        this.name = name2;
    }

    protected void scanIdentifier(StringBuffer result) throws IOException {
        while (true) {
            char ch;
            if (!((ch = this.readChar()) >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9' || ch == '_' || ch == '.' || ch == ':' || ch == '-' || ch > '~')) {
                this.unreadChar(ch);
                return;
            }
            result.append(ch);
        }
    }

    protected char scanWhitespace() throws IOException {
        char ch;
        block3: while (true) {
            ch = this.readChar();
            switch (ch) {
                case '\t': 
                case '\n': 
                case '\r': 
                case ' ': {
                    continue block3;
                }
            }
            break;
        }
        return ch;
    }

    protected char scanWhitespace(StringBuffer result) throws IOException {
        char ch;
        block4: while (true) {
            ch = this.readChar();
            switch (ch) {
                case '\t': 
                case '\n': 
                case ' ': {
                    result.append(ch);
                }
                case '\r': {
                    continue block4;
                }
            }
            break;
        }
        return ch;
    }

    protected void scanString(StringBuffer string) throws IOException {
        char delimiter = this.readChar();
        if (delimiter != '\'' && delimiter != '\"') {
            throw this.expectedInput("' or \"");
        }
        char ch;
        while ((ch = this.readChar()) != delimiter) {
            if (ch == '&') {
                this.resolveEntity(string);
                continue;
            }
            string.append(ch);
        }
        return;
    }

    protected void scanPCData(StringBuffer data) throws IOException {
        while (true) {
            char ch;
            if ((ch = this.readChar()) == '<') {
                ch = this.readChar();
                if (ch == '!') {
                    this.checkCDATA(data);
                    continue;
                }
                this.unreadChar(ch);
                return;
            }
            if (ch == '&') {
                this.resolveEntity(data);
                continue;
            }
            data.append(ch);
        }
    }

    protected boolean checkCDATA(StringBuffer buf) throws IOException {
        char ch = this.readChar();
        if (ch != '[') {
            this.unreadChar(ch);
            this.skipSpecialTag(0);
            return false;
        }
        if (!this.checkLiteral("CDATA[")) {
            this.skipSpecialTag(1);
            return false;
        }
        int delimiterCharsSkipped = 0;
        block4: while (delimiterCharsSkipped < 3) {
            int i;
            ch = this.readChar();
            switch (ch) {
                case ']': {
                    if (delimiterCharsSkipped < 2) {
                        ++delimiterCharsSkipped;
                        continue block4;
                    }
                    buf.append(']');
                    buf.append(']');
                    delimiterCharsSkipped = 0;
                    continue block4;
                }
                case '>': {
                    if (delimiterCharsSkipped < 2) {
                        for (i = 0; i < delimiterCharsSkipped; ++i) {
                            buf.append(']');
                        }
                        delimiterCharsSkipped = 0;
                        buf.append('>');
                        continue block4;
                    }
                    delimiterCharsSkipped = 3;
                    continue block4;
                }
            }
            for (i = 0; i < delimiterCharsSkipped; ++i) {
                buf.append(']');
            }
            buf.append(ch);
            delimiterCharsSkipped = 0;
        }
        return true;
    }

    protected void skipComment() throws IOException {
        int dashesToRead = 2;
        while (dashesToRead > 0) {
            char ch = this.readChar();
            dashesToRead = ch == '-' ? --dashesToRead : 2;
            if (dashesToRead != 0) continue;
            ch = this.readChar();
            if (ch == '>') {
                return;
            }
            dashesToRead = 2;
            this.unreadChar(ch);
        }
    }

    protected void skipSpecialTag(int bracketLevel) throws IOException {
        char ch;
        int tagLevel = 1;
        char stringDelimiter = '\u0000';
        if (bracketLevel == 0) {
            ch = this.readChar();
            if (ch == '[') {
                ++bracketLevel;
            } else if (ch == '-') {
                ch = this.readChar();
                if (ch == '[') {
                    ++bracketLevel;
                } else if (ch == ']') {
                    --bracketLevel;
                } else if (ch == '-') {
                    this.skipComment();
                    return;
                }
            }
        }
        while (tagLevel > 0) {
            ch = this.readChar();
            if (stringDelimiter == '\u0000') {
                if (ch == '\"' || ch == '\'') {
                    stringDelimiter = ch;
                } else if (bracketLevel <= 0) {
                    if (ch == '<') {
                        ++tagLevel;
                    } else if (ch == '>') {
                        --tagLevel;
                    }
                }
                if (ch == '[') {
                    ++bracketLevel;
                    continue;
                }
                if (ch != ']') continue;
                --bracketLevel;
                continue;
            }
            if (ch != stringDelimiter) continue;
            stringDelimiter = '\u0000';
        }
    }

    protected boolean checkLiteral(String literal) throws IOException {
        int length2 = literal.length();
        for (int i = 0; i < length2; ++i) {
            if (this.readChar() == literal.charAt(i)) continue;
            return false;
        }
        return true;
    }

    protected char readChar() throws IOException {
        if (this.charReadTooMuch != '\u0000') {
            char ch = this.charReadTooMuch;
            this.charReadTooMuch = '\u0000';
            return ch;
        }
        int i = this.reader.read();
        if (i < 0) {
            throw this.unexpectedEndOfData();
        }
        if (i == 10) {
            ++this.parserLineNr;
            return '\n';
        }
        return (char)i;
    }

    protected void scanElement(XMLElement elt) throws IOException {
        char ch;
        String name2;
        StringBuffer buf;
        block22: {
            buf = new StringBuffer();
            this.scanIdentifier(buf);
            name2 = buf.toString();
            elt.setName(name2);
            ch = this.scanWhitespace();
            while (ch != '>' && ch != '/') {
                buf.setLength(0);
                this.unreadChar(ch);
                this.scanIdentifier(buf);
                String key = buf.toString();
                ch = this.scanWhitespace();
                if (ch != '=') {
                    throw this.expectedInput("=");
                }
                this.unreadChar(this.scanWhitespace());
                buf.setLength(0);
                this.scanString(buf);
                elt.setAttribute(key, buf);
                ch = this.scanWhitespace();
            }
            if (ch == '/') {
                ch = this.readChar();
                if (ch != '>') {
                    throw this.expectedInput(">");
                }
                return;
            }
            buf.setLength(0);
            ch = this.scanWhitespace(buf);
            if (ch != '<') {
                this.unreadChar(ch);
                this.scanPCData(buf);
            } else {
                while ((ch = this.readChar()) == '!') {
                    if (this.checkCDATA(buf)) {
                        this.scanPCData(buf);
                    } else {
                        ch = this.scanWhitespace(buf);
                        if (ch == '<') continue;
                        this.unreadChar(ch);
                        this.scanPCData(buf);
                    }
                    break block22;
                }
                buf.setLength(0);
            }
        }
        if (buf.length() == 0) {
            while (ch != '/') {
                if (ch == '!') {
                    ch = this.readChar();
                    if (ch != '-') {
                        throw this.expectedInput("Comment or Element");
                    }
                    ch = this.readChar();
                    if (ch != '-') {
                        throw this.expectedInput("Comment or Element");
                    }
                    this.skipComment();
                } else {
                    this.unreadChar(ch);
                    XMLElement child = this.createAnotherElement();
                    this.scanElement(child);
                    elt.addChild(child);
                }
                ch = this.scanWhitespace();
                if (ch != '<') {
                    throw this.expectedInput("<");
                }
                ch = this.readChar();
            }
            this.unreadChar(ch);
        } else if (this.ignoreWhitespace) {
            elt.setContent(buf.toString().trim());
        } else {
            elt.setContent(buf.toString());
        }
        ch = this.readChar();
        if (ch != '/') {
            throw this.expectedInput("/");
        }
        this.unreadChar(this.scanWhitespace());
        if (!this.checkLiteral(name2)) {
            throw this.expectedInput(name2);
        }
        if (this.scanWhitespace() != '>') {
            throw this.expectedInput(">");
        }
    }

    protected void resolveEntity(StringBuffer buf) throws IOException {
        char ch = '\u0000';
        StringBuffer keyBuf = new StringBuffer();
        while ((ch = this.readChar()) != ';') {
            keyBuf.append(ch);
        }
        String key = keyBuf.toString();
        if (key.charAt(0) == '#') {
            try {
                ch = key.charAt(1) == 'x' ? (char)Integer.parseInt(key.substring(2), 16) : (char)Integer.parseInt(key.substring(1), 10);
            }
            catch (NumberFormatException e) {
                throw this.unknownEntity(key);
            }
            buf.append(ch);
        } else {
            char[] value2 = (char[])this.entities.get(key);
            if (value2 == null) {
                throw this.unknownEntity(key);
            }
            buf.append(value2);
        }
    }

    protected void unreadChar(char ch) {
        this.charReadTooMuch = ch;
    }

    protected XMLParseException invalidValueSet(String name2) {
        String msg = "Invalid value set (entity name = \"" + name2 + "\")";
        return new XMLParseException(this.getName(), this.parserLineNr, msg);
    }

    protected XMLParseException invalidValue(String name2, String value2) {
        String msg = "Attribute \"" + name2 + "\" does not contain a valid value (\"" + value2 + "\")";
        return new XMLParseException(this.getName(), this.parserLineNr, msg);
    }

    protected XMLParseException unexpectedEndOfData() {
        String msg = "Unexpected end of data reached";
        return new XMLParseException(this.getName(), this.parserLineNr, msg);
    }

    protected XMLParseException syntaxError(String context) {
        String msg = "Syntax error while parsing " + context;
        return new XMLParseException(this.getName(), this.parserLineNr, msg);
    }

    protected XMLParseException expectedInput(String charSet) {
        String msg = "Expected: " + charSet;
        return new XMLParseException(this.getName(), this.parserLineNr, msg);
    }

    protected XMLParseException expectedInput(String charSet, char ch) {
        String msg = "Expected: '" + charSet + "' but got: '" + ch + "'";
        return new XMLParseException(this.getName(), this.parserLineNr, msg);
    }

    protected XMLParseException unknownEntity(String name2) {
        String msg = "Unknown or invalid entity: &" + name2 + ";";
        return new XMLParseException(this.getName(), this.parserLineNr, msg);
    }

    public void sanitizeInput(InputStreamReader isr, PipedOutputStream pout) {
        try {
            PrintStream out = new PrintStream(pout);
            this.sanitizeCharReadTooMuch = '\u0000';
            this.reader = isr;
            this.parserLineNr = 0;
            int newline = 2;
            int prev = 32;
            while (true) {
                char ch;
                if (this.sanitizeCharReadTooMuch != '\u0000') {
                    ch = this.sanitizeCharReadTooMuch;
                    this.sanitizeCharReadTooMuch = '\u0000';
                } else {
                    int i = this.reader.read();
                    if (i == -1) {
                        out.flush();
                        break;
                    }
                    ch = i == 10 ? (char)'\n' : (char)((char)i);
                }
                int i = this.reader.read();
                if (i == -1) {
                    out.print(ch);
                    out.flush();
                    break;
                }
                int next2 = i == 10 ? 10 : (int)((char)i);
                this.sanitizeCharReadTooMuch = (char)next2;
                if (prev == 60 && (next2 == 33 || next2 == 63)) {
                    this.skipSpecialTag(0);
                    this.sanitizeCharReadTooMuch = '\u0000';
                } else {
                    out.print(ch);
                }
                prev = next2;
            }
            out.close();
            isr.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

