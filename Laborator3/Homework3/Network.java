package com.company;

import java.util.*;

public class Network {
    private List<Node> nodes = new ArrayList<>();

    public Network() {
    }


    public void addNode(Node node) {
        nodes.add(node);
    }

    @Override
    public String toString() {
        return "Network{" +
                "nodes=" + nodes +
                '}';
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    //metode pentru printarea listei si a costurilor, dupa modelul din curs
    public void printList() {
        for (Node node : nodes) {
            System.out.print(node.toString() + " (" + node.getName() + ") ");
        }
        System.out.println();
    }


    public void printCosts() {
        System.out.println("costs:");
        for (Node node : nodes) {
            node.printCost();
        }
    }

    //functie ce printeaza nodurile identificabile ordonate dupa adresa
    public void displayIdentifiables() {
        Network identif = new Network();
        for (Node node : nodes)
            if (node instanceof Identifiable)
                identif.addNode(node);


        Collections.sort(identif.nodes, new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                StringBuilder str1 = new StringBuilder();
                StringBuilder str2 = new StringBuilder();
                str1.append(((Identifiable) n1).getAddress());
                str2.append(((Identifiable) n2).getAddress());
                return str1.toString().compareTo(str2.toString());

            }
        });

        System.out.println("Identifiable nodes: ");
        identif.printList();
    }

    //dijkstra - calculeaza timpul minim de la nodul sursa la restul nodurilor
    private static Network ShortestPathFromSource(Network graph, Node source) {
        source.setTime(0);

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            Node currentNode = getLowestTimeNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Map.Entry<Node, Integer> adjacencyPair : currentNode.getCost().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    CalculateMinTime(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }

    //returneaza nodul adiacent(neparcurs) cu timpul cel mai scurt
    private static Node getLowestTimeNode(Set<Node> unsettledNodes) {
        Node lowestTimeNode = null;
        int lowestTime = Integer.MAX_VALUE;
        for (Node node : unsettledNodes) {
            int nodeTime = node.getTime();
            if (nodeTime < lowestTime) {
                lowestTime = nodeTime;
                lowestTimeNode = node;
            }
        }
        return lowestTimeNode;
    }

    private static void CalculateMinTime(Node evaluationNode, Integer edgeWeigh, Node sourceNode) {
        Integer sourceTime = sourceNode.getTime();
        if (sourceTime + edgeWeigh < evaluationNode.getTime()) {
            evaluationNode.setTime(sourceTime + edgeWeigh);
        }
    }

    //afiseaza cel mai scurt timp de transmitere a datelor de la un nod identificabil la altul
    public void PrintShortestTimes(Network graph) {
        for (Node node : nodes)
            if (node instanceof Identifiable) {
                Network completedGraph = ShortestPathFromSource(graph, node); //graful completat cu distantele de la nodul sursa la restul nodurilor

                for (Node iterator : completedGraph.getNodes()) {
                    if (iterator instanceof Identifiable && iterator != node) {
                        if (((Node) iterator).getTime() != 0) {
                            System.out.println("Shortest time from " + node.getName() + " to " + ((Node) iterator).getName()
                                    + ": " + ((Node) iterator).getTime());
                        } else {
                            System.out.println("Shortest time from " + node.getName() + " to " + ((Node) iterator).getName()
                                    + ": UNREACHABLE");
                        }
                    }
                }
            }
    }
}


