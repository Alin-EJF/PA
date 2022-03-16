package com.company;

public class Main {

    public static void main(String[] args) {

        Node computerA= new Computer("Computer A","v1","00:00:6e:00:13:be");
        Node computerB= new Computer("Computer B","v2","00:00:1e:00:17:bF");

        Node routerA= new Router("Router A","00:00:5e:00:53:af","v3","127.0.0.1");
        Node routerB= new Router("Router B","00:00:5e:00:53:af","v4","127.0.0.1");

        Node switchA= new Switch("Switch A","v5");
        Node switchB= new Switch("Switch B","v6");

        Network net= new Network();


        net.addNode(computerA);
        net.addNode(computerB);
        net.addNode(routerA);
        net.addNode(routerB);
        net.addNode(switchA);
        net.addNode(switchB);

        computerA.setCost(routerA,10);
        computerA.setCost(switchA,50);

        routerA.setCost(switchA,20);
        routerA.setCost(switchB,20);
        routerA.setCost(routerB,20);

        switchA.setCost(switchB,10);
        switchB.setCost(routerB,30);
        switchB.setCost(computerB,10);
        routerB.setCost(computerB,20);




        //net.printList();
       // net.printCosts();

        Computer computerC= new Computer("Computer C");
        computerC.setStorageCapacity(100);
        computerC.getStorageCapacityMbKbB();


        net.displayIdentifiables();
        System.out.println();
        net.PrintShortestTimes(net);

    }
}
