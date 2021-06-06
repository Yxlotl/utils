package us.yxlotl.playground.tree;

public class Shell {
    public static void main(String[] args) {
        //init registry object
        Registry r = new Registry();

        //test addition of nodes, nodes must be unique
        r.add("A");
        r.add("B");
        r.add("C");
        r.add("D");
        //redundant, does nothing
        r.add("A");

        //test linking of nodes, links must be unique!
        r.link("A", "B");
        r.link("A", "C");
        r.link("C", "D");
        //redundant, does nothing
        r.link("A", "C");

        //display all nodes in registry
        r.print();
    }
}
