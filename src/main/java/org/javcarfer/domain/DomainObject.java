package org.javcarfer.domain;

public class DomainObject {
    private int id;
    private int version;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVersion() { return version; }

    public void setVersion(int version) { this.version = version; }
}
