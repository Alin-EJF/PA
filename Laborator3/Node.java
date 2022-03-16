package com.company;

import java.util.HashMap;
import java.util.Map;

public abstract class Node implements Comparable<Node> {
    protected String name;
    protected String location;

    private Map<Node, Integer> cost = new HashMap<>();

    public Node(String name, String location) {
        this.name = name;
        this.location = location;

    }

    public Node(String name) {
        this.name = name;
        this.location = "notDef";
    }

    public void setCost(Node node, int value) {
        cost.put(node, value);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                "}\n";
    }

    @Override
    public int compareTo(Node other) {
        return this.name.compareTo(other.name);
    }

}
