package us.yxlotl.utils.tree;

public class TreeNodeTest {
    public static void main(String[] args) {
        TreeNode<String> head = new TreeNode<>(null);
        head.addChild("1").addChild("2").addChildren("3", "a", "b");
        System.out.println("DONE");
    }
}
