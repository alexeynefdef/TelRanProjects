package org.anefdef.backend;

import java.time.ZonedDateTime;
import java.util.Objects;

public class BackendServerEntity {

    int port;
    String host;
    int load;
    ZonedDateTime updateTime;

    public BackendServerEntity(int port, String host) {
        this.port = port;
        this.host = host;
        this.updateTime = ZonedDateTime.now();
    }

    public ZonedDateTime getUpdateTime() {
        return updateTime;
    }

    public int getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }

    public void setUpdateTime(ZonedDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return host + ":" + port;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BackendServerEntity)) return false;
        BackendServerEntity that = (BackendServerEntity) o;
        return getPort() == that.getPort() &&
                Objects.equals(getHost(), that.getHost());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPort(), getHost(), getLoad(), getUpdateTime());
    }
}
