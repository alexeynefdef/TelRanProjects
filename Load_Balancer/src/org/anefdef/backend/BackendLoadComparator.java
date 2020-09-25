package org.anefdef.backend;

import java.util.Comparator;

public class BackendLoadComparator implements Comparator<BackendServerEntity> {
    @Override
    public int compare(BackendServerEntity b1, BackendServerEntity b2) {
        return Integer.compare(b1.getLoad(),b2.getLoad());
    }
}
