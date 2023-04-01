package cz.cvut.fel.pjv;

public class Start {
    public static void main(String[] args) {
        Tree tree = new TreeImpl();
        tree.setTree(new int[]{44, 5, 8, 7, 9, 1});
        System.out.println(tree);
    }
}
