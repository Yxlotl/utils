package us.yxlotl.playground.tree;

import java.util.ArrayList;
import java.util.HashMap;

class Registry {
    private ArrayList<Node> uniqueNodes;

    Registry() {
        uniqueNodes = new ArrayList<>();
    }

    void add(Object o) {
        Node n = new Node(o);
        boolean alreadyHas = false;
        for(Node i : uniqueNodes) {
            if (i.equals(n)) {
                alreadyHas = true;
                break;
            }
        }
        if(!alreadyHas) {
            uniqueNodes.add(n);
        }
    }

    void print() {
        for(Node n : uniqueNodes) {
            n.print();
        }
    }

    void link(Object superNode, Object subNode) {
        if((getNode(superNode) != null) && (getNode(subNode) != null)) {
            assert getNode(superNode) != null;
            getNode(superNode).addSubnode(getNode(subNode));
        }
    }

    private Node getNode(Object o) {
        for(Node n : uniqueNodes) {
            if(n.equals(o)) {
                return n;
            }
        }
        return null;
    }
    Object[] getSubobjects(Object o) {
        Node n = getNode(o);
        Node[] subnodes = n.getSubnodes();
        Object[] subobjects = new Object[subnodes.length];
        for(int i = 0; i < subnodes.length; i++) {
            subobjects[i] = subnodes[i].getData();
        }
        return subobjects;
    }
    boolean contains(Object o) {
        boolean contains = false;
        for(Node n : uniqueNodes) {
            if(n.equals(o)) {
                contains = true;
                break;
            }
        }
        return contains;
    }
}
