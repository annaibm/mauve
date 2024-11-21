/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseInvalidTest;

public class InvalidCAnotBeforeDateTest1
extends BaseInvalidTest {
    public InvalidCAnotBeforeDateTest1() {
        super(new String[]{"data/certs/InvalidCAnotBeforeDateTest1EE.crt", "data/certs/BadnotBeforeDateCACert.crt"}, new String[]{"data/crls/BadnotBeforeDateCACRL.crl"});
    }
}

