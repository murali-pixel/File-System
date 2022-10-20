package main.os;

import java.time.LocalDateTime;
import java.util.*;

public abstract class SystemNode implements Comparable<SystemNode> {
    private SystemDirectory root;
    private String name;
    private LocalDateTime created;
    private LocalDateTime lastUpdated;
    private LocalDateTime lastAccessed;



    public SystemNode(String name) {
        this.name = name;
        this.created = LocalDateTime.now();
        this.lastUpdated = LocalDateTime.now();
        this.lastAccessed = LocalDateTime.now();
    }

    public boolean isDirectory() {

        return this instanceof SystemDirectory;
    }

    public String getPath() {

        return root != null ? root.getPath() + "/" + name : name;
    }

    public SystemNode getParent() {
        return root;
    }

    public abstract long getLength();

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(SystemNode o) {

        return this.getName().compareTo(o.getName());
    }

    public void setRoot(SystemDirectory root) {
        this.root = root;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public LocalDateTime getLastAccessed() {
        return lastAccessed;
    }

    @Override
    public String toString() {
        return "root=" + root +
                ", \nname='" + name + '\'' +
                ", \ncreated=" + created +
                ", \nlastUpdated=" + lastUpdated +
                ", \nlastAccessed=" + lastAccessed;

    }
}
