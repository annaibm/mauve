/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseValidTest;

public class ValidLongSerialNumberTest16
extends BaseValidTest {
    public ValidLongSerialNumberTest16() {
        super(new String[]{"data/certs/ValidLongSerialNumberTest16EE.crt", "data/certs/LongSerialNumberCACert.crt"}, new String[]{"data/crls/LongSerialNumberCACRL.crl"});
    }
}

