/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseInvalidTest;

public class InvalidNameChainingOrderTest2
extends BaseInvalidTest {
    public InvalidNameChainingOrderTest2() {
        super(new String[]{"data/certs/InvalidNameChainingOrderTest2EE.crt", "data/certs/NameOrderingCACert.crt"}, new String[]{"data/crls/NameOrderCACRL.crl"});
    }
}

