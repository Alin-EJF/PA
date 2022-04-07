package com.company;

import java.util.ArrayList;
import java.util.List;

public class Node {
    boolean visited = false;
    int row;
    int col;
    List<Node> neighbours = new ArrayList<>();

    public Node( int row, int col){
        this.row = row;
        this.col = col;
    }

    public void addNeigbour( Node i){
        neighbours.add(i);
    }

    public Node findNeighbour( int row, int col){
        for( Node i : neighbours)
            if( i.getRow() == row && i.getCol() == col)
                return i;
        return null;
    }

    public int findIndex( int row, int col){
        for (int i = 0; i < neighbours.size(); i++)
            if (neighbours.get(i).getCol() == col && neighbours.get(i).getRow() == row)
                return i;
        return -1;
    }

    public void removeNeighbour( int row, int col){
        if(findNeighbour(row, col) != null) {
            neighbours.remove(findNeighbour(row, col));
        }
    }
    public void printNeighbours(){
        for( Node i : neighbours)
            System.out.println(i);
    }

    public boolean noNeighbours(){ //returneaza true daca lista nu are nici un element sau are elemente dar sunt vizitate
        return neighbours.isEmpty();

    }
    @Override
    public String toString() {
        return "Node{" +
                "visited=" + visited +
                ", row=" + row +
                ", col=" + col +
                ", neighbours" + neighbours +
                '}';
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(){
        this.visited = true;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
