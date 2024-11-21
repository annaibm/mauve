/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseValidTest;

public class ValidNegativeSerialNumberTest14
extends BaseValidTest {
    public ValidNegativeSerialNumberTest14() {
        super(new String[]{"data/certs/ValidNegativeSerialNumberTest14EE.crt", "data/certs/NegativeSerialNumberCACert.crt"}, new String[]{"data/crls/NegativeSerialNumberCACRL.crl"});
    }
}

