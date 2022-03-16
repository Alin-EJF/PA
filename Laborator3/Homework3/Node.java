package com.company;

import java.util.HashMap;
import java.util.Map;

public abstract class Node implements Comparable<Node> {
    protected String name;
    protected String location;
    private Integer time = Integer.MAX_VALUE;

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

    @Override
    public int compareTo(Node other) {
        if(other.equals(null)){
            System.out.println("error, other equals null");
            return -1;
        }

        return this.name.compareTo(other.name);
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

    public void printCost() {
        for (Map.Entry<Node, Integer> entry : cost.entrySet()) {
            System.out.println(this.location + "--" + entry.getKey() + " :" + entry.getValue());
        }
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return location;
    }

    public Map<Node, Integer> getCost() {
        return cost;
    }
}
