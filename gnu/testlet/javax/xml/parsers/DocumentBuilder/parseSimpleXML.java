/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.xml.parsers.DocumentBuilder;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.xml.parsers.DocumentBuilder.Verifyer;

public class parseSimpleXML
extends Verifyer
implements Testlet {
    @Override
    public void test(TestHarness a_harness) {
        this.harness = a_harness;
        String head = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        this.verify(head + "<xa ap1=\"apv1\" ap2=\"apv2\"><b/><c><a ap1=\"n\"></a></c></xa>", "#document xa ap1='apv1'ap2='apv2' b c a ap1='n'", "simple xml");
        this.verify(head + "<xa ap1=\"apv1\" ap2=\"apv2\">t0<b/>t1<c><a ap1=\"n\"></a></c>te</xa>", "#document xa ap1='apv1'ap2='apv2' #text  = 't0' b #text  = 't1' c a ap1='n' #text  = 'te'", "simple xml with text nodes");
        this.verify(head + "<a><!--explain--></a>", "#document a #comment  = 'explain'", "comment");
        this.verify(head + "<a><!--e1--><!--e2--></a>", "#document a #comment  = 'e1' #comment  = 'e2'", "subsequent comments");
        this.verify(head + "<a xmlns:ans=\"www.lithuania.lt\"><ans:b></ans:b></a>", "#document a xmlns:ans='www.lithuania.lt' www.lithuania.lt:ans:b", "explicit namespace");
        this.verify(head + "<a xmlns=\"www.lithuania.lt\"><b></b></a>", "#document www.lithuania.lt:a xmlns='www.lithuania.lt' www.lithuania.lt:b", "default namespace");
        this.verify(head + "<a xmlns=\"www.lithuania.lt\" xmlns:ans=\"www.gnu.org\"><b><ans:c></ans:c></b></a>", "#document www.lithuania.lt:a xmlns='www.lithuania.lt'xmlns:ans='www.gnu.org' www.lithuania.lt:b www.gnu.org:ans:c", "mixed namespaces");
        this.verify("<xa ap1=\"apv1\" ap2=\"apv2\"><b/><c><a ap1=\"n\"></a></c></xa>", "#document xa ap1='apv1'ap2='apv2' b c a ap1='n'", "missing xml header");
    }
}

