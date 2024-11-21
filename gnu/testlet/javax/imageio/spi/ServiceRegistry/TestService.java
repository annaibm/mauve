/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.imageio.spi.ServiceRegistry;

import javax.imageio.spi.RegisterableService;
import javax.imageio.spi.ServiceRegistry;

public class TestService
implements RegisterableService {
    public int numRegistrations;
    public Class lastRegisteredCategory;
    public ServiceRegistry lastRegisteredRegistry;
    public Class lastDeregisteredCategory;
    public ServiceRegistry lastDeregisteredRegistry;

    public void onRegistration(ServiceRegistry r, Class cat) {
        ++this.numRegistrations;
        this.lastRegisteredRegistry = r;
        this.lastRegisteredCategory = cat;
    }

    public void onDeregistration(ServiceRegistry r, Class cat) {
        --this.numRegistrations;
        this.lastDeregisteredRegistry = r;
        this.lastDeregisteredCategory = cat;
    }
}

