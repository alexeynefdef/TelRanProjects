package org.anefdef.backend;

import java.time.Duration;
import java.util.HashSet;

public class BackendStorageSet implements IBackendServerStorage {

    HashSet<BackendServerEntity> storage;
    BackendLoadComparator comparator;

    public BackendStorageSet() {
        this.storage = new HashSet<>();
        this.comparator = new BackendLoadComparator();
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public synchronized void update(BackendServerEntity backend) {
        storage.remove(backend);
        storage.add(backend);
    }

    @Override
    public synchronized BackendServerEntity getOptimal() {
        return storage.stream().min(comparator).orElse(null);
    }

    //TODO: make it!
    @Override
    public void clearOlderThan(Duration duration) {
    }
}
