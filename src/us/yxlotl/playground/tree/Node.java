package us.yxlotl.playground.tree;

import java.util.ArrayList;

class Node {
    private Object data;
    ArrayList<Node> subnodes;

    Node(Object data) {
        this.data = data;
        subnodes = new ArrayList<>();
    }

    Object getData() {
        return data;
    }

    void setData(Object o) {
        data = o;
    }
    void addSubnode(Node n) {
        if(!subnodes.contains(n)) {
            subnodes.add(n);
        }
    }

    Node[] getSubnodes() {
        return subnodes.toArray(new Node[0]);
    }

    private boolean hasSubnodes() {
        return this.getSubnodes().length != 0;
    }

    ArrayList<Node> getTerminalNodes() {
        ArrayList<Node> accumulator = new ArrayList<>();
        if(!this.hasSubnodes()) {
            accumulator.add(this);
        } else {
            for(Node n : this.getSubnodes()) {
                accumulator.addAll(n.getTerminalNodes());
            }
        }
        return accumulator;
    }

    void print() {
        //print this node's info
        System.out.print("Node ");
        System.out.println(data.toString());

        //prints this nodes direct subnodes
        System.out.print("Direct Subnodes: ");
        StringBuilder sub = new StringBuilder();
        for(Node n : subnodes) {
            sub.append(n.getData().toString()).append(" ");
        }
        System.out.println(sub);

        //prints this nodes complete terminal nodes
        System.out.print("Terminal Subnodes: ");
        StringBuilder term = new StringBuilder();
        Node[] terminals = getTerminalNodes().toArray(new Node[0]);
        for(Node n : terminals) {
            term.append(n.getData().toString()).append(" ");
        }
        System.out.println(term);
        System.out.println();
    }
    @Override
    public boolean equals(Object other) {
        if(other instanceof Node) {
            return ((Node) other).data.equals(data);
        } else {
            return data.equals(other);
        }
    }
}
