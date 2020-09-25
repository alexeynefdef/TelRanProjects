package org.anefdef;

import org.anefdef.backend.BackendStorageSet;
import org.anefdef.backend.IBackendServerStorage;
import org.anefdef.task.BackendUDPListener;
import org.anefdef.task.GatewayUDPSupplier;

public class LoadBalancer {

    private static final int BACKEND_PORT = 5001;

    private static final int GATEWAY_PORT = 6002;
    private static final String GATEWAY_HOST = "localhost";
    private static final int SENDING_PERIOD_MILLIS = 100;

    public static void main(String[] args) {

        IBackendServerStorage storage = new BackendStorageSet();

        // L I S T E N I N G   B A C K E N D
        BackendUDPListener backendUDPListener = new BackendUDPListener(storage,BACKEND_PORT);
        Thread backendListenerProcess = new Thread(backendUDPListener);
        backendListenerProcess.start();

        // S U P P L I E R   G A T E W A Y
        GatewayUDPSupplier sender = new GatewayUDPSupplier(GATEWAY_HOST,GATEWAY_PORT,storage,SENDING_PERIOD_MILLIS);
        Thread gatewaySenderProcess = new Thread(sender);
        gatewaySenderProcess.start();
    }
}
