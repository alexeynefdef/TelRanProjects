package org.anefdef.backend;

import java.time.Duration;

/**
 * The data structure stores the information about all backends
 * appealed to the balancer and keeps their actual load parameter
 */
public interface IBackendServerStorage {

    /**
     * @return the amount of active backends
     */
    int size();

    /**
     * updates server's load or adds a new backend server
     * if not present
     * @param backend server to add or update
     */
    void update(BackendServerEntity backend);

    /**
     * @return the optimal backend according to the load parameters
     * or null if there are no backends at all
     */
    BackendServerEntity getOptimal();

    /**
     * Clears the data structure from inactive backends
     * @param duration time
     */
    void clearOlderThan(Duration duration);
}
