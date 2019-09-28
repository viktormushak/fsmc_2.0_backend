package com.fsmc.backend.data.model;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Company {

    private String name;
    private long lastUpdate;

    public Company(String name, long lastUpdate) {
        this.name = name;
        this.lastUpdate = lastUpdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(long lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
