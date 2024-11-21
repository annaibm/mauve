/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseInvalidTest;

public class InvalidWrongCRLTest6
extends BaseInvalidTest {
    public InvalidWrongCRLTest6() {
        super(new String[]{"data/certs/InvalidWrongCRLTest6EE.crt", "data/certs/WrongCRLCACert.crt"}, new String[]{"data/crls/WrongCRLCACRL.crl"});
    }
}

