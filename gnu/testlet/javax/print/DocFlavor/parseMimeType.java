/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.print.DocFlavor;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.print.DocFlavor;

public class parseMimeType
implements Testlet {
    @Override
    public void test(TestHarness h) {
        DocFlavor syntax;
        DocFlavor simple2 = new DocFlavor("text/plain; charset=us-ascii", "java.io.InputStream");
        h.checkPoint("Simple mimetype");
        h.check(simple2.getMediaType().equals("text"));
        h.check(simple2.getMediaSubtype().equals("plain"));
        h.check(simple2.getParameter("charset").equals("us-ascii"));
        h.check(simple2.getRepresentationClassName().equals("java.io.InputStream"));
        h.check(simple2.getMimeType().equals("text/plain; charset=\"us-ascii\""));
        h.check(simple2.toString().equals("text/plain; charset=\"us-ascii\"; class=\"java.io.InputStream\""));
        DocFlavor quoted = new DocFlavor("text/plain; charset=\"us-ascii\"", "java.io.InputStream");
        h.checkPoint("Mimetype with quoted param values");
        h.check(quoted.getParameter("charset").equals("us-ascii"));
        h.check(quoted.getMimeType().equals("text/plain; charset=\"us-ascii\""));
        h.check(simple2.toString().equals("text/plain; charset=\"us-ascii\"; class=\"java.io.InputStream\""));
        DocFlavor multipleParam = new DocFlavor("text/plain; charset=\"us-ascii\"; param=paramValue", "java.io.InputStream");
        h.checkPoint("Mimetype with multiple parameters");
        h.check(multipleParam.getParameter("charset").equals("us-ascii"));
        h.check(multipleParam.getParameter("param").equals("paramValue"));
        h.check(multipleParam.getMimeType().equals("text/plain; charset=\"us-ascii\"; param=\"paramValue\""));
        h.check(multipleParam.toString().equals("text/plain; charset=\"us-ascii\"; param=\"paramValue\"; class=\"java.io.InputStream\""));
        DocFlavor paramOrder = new DocFlavor("text/plain; charset=\"us-ascii\"; another=paramValue; charset3=something", "java.io.InputStream");
        h.checkPoint("Multiple parameters output order");
        h.check(paramOrder.getMimeType().equals("text/plain; another=\"paramValue\"; charset=\"us-ascii\"; charset3=\"something\""));
        DocFlavor charset = new DocFlavor("text/plain; charset=US-ascii; nocharset=UoUo", "java.io.InputStream");
        h.checkPoint("Test charset treatment");
        h.check(charset.getParameter("charset").equals("us-ascii"));
        h.check(charset.getParameter("nocharset").equals("UoUo"));
        DocFlavor comments = new DocFlavor("text/plain(Comment); charset=\"us-ascii\" (Comment2)(Comment1)", "java.io.InputStream");
        h.checkPoint("Mimetype with comments");
        h.check(comments.getMediaSubtype().equals("plain"));
        h.check(comments.getParameter("charset").equals("us-ascii"));
        h.checkPoint("Syntax checks");
        DocFlavor lowercase = new DocFlavor("teXt/Plain; charset=US-ascii; nocharset=UoUo", "java.io.InputStream");
        h.check(lowercase.getMediaType().equals("text"));
        h.check(lowercase.getMediaSubtype().equals("plain"));
        try {
            new DocFlavor("text/plain; charset=us-ascii\"", "java.io.InputStream");
            h.check(false);
        }
        catch (IllegalArgumentException e) {
            h.check(true);
        }
        try {
            new DocFlavor(" te,xt/plain; charset=us-ascii", "java.io.InputStream");
            h.check(false);
        }
        catch (IllegalArgumentException e) {
            h.check(true);
        }
        try {
            new DocFlavor("text/plain; \"charset\"=us-ascii", "java.io.InputStream");
            h.check(false);
        }
        catch (IllegalArgumentException e) {
            h.check(true);
        }
        try {
            new DocFlavor(" text/plain; charset=us-asc'ii", "java.io.InputStream");
            h.check(true);
        }
        catch (IllegalArgumentException e) {
            h.check(false);
        }
        try {
            new DocFlavor("text/plain; charset=?us-ascii", "java.io.InputStream");
            h.check(false);
        }
        catch (IllegalArgumentException e) {
            h.check(true);
        }
        try {
            syntax = new DocFlavor("text/plain; param=\"?value.\"", "java.io.InputStream");
            h.check(syntax.getParameter("param").equals("?value."));
        }
        catch (IllegalArgumentException e) {
            h.check(false);
        }
        try {
            new DocFlavor("text/plain; param=\"?v\u00f6al ue.\"", "java.io.InputStream");
            h.check(true);
        }
        catch (IllegalArgumentException e) {
            h.check(false);
        }
        try {
            syntax = new DocFlavor("application/vnd.cups-command", "java.io.InputStream");
            h.check(syntax.getMediaSubtype().equals("vnd.cups-command"));
        }
        catch (IllegalArgumentException e) {
            h.check(false);
        }
    }
}

