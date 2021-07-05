package us.yxlotl.utils.tree;

import java.util.LinkedList;
import java.util.List;

// TODO: 6/25/21 implement iterator? (may not be important(?))

/**
 * <h1> Tree Node Class </h1>
 * Generalized Tree-Node object for data structure construction.
 *
 * @author Yxlotl
 * @version 1.0
 * @since 2021-7-05
 */

public class TreeNode<T>  {

    // Data is the object contained as data within this tree node.
    T data;
    // Parent contains the node that is a direct parent of this node.
    TreeNode<T> parent;
    //Children is the list of current children of this node.
    List<TreeNode<T>> children;

    public TreeNode(T data) {
        //On construction, provide the data to be contained and create a new list of children.
        this.data = data;
        this.children = new LinkedList<>();
    }

    /**
     * This method adds a child-node to a given node
     * @param childData the data the child should contain
     * @return TreeNode\<T\> this returns the new node created as the child of the given node
     */
    public TreeNode<T> addChild(T childData) {
        //Create a new child node, childNode, containing the provided data.
        TreeNode<T> childNode = new TreeNode<>(childData);
        //this node is added as the parent, the parent node gets this new node added as a child
        childNode.parent = this;
        this.children.add(childNode);
        //return the child node
        return childNode;
    }

    /**
     * This method adds multiple child-nodes to a given node
     * @param childrenData the data to be given to nodes, then added as child nodes to the given parent
     */
    public void addChildren(T... childrenData) {
        for(T childData : childrenData) {
            this.children.add(new TreeNode<>(childData));
        }
    }

    /**
     * This method returns the data contained within a node.
     * @return T data
     */
    public T getData() {
        return this.data;
    }
    //...add more?

    // TODO: 6/30/21 add fetchChild() based on data
}
