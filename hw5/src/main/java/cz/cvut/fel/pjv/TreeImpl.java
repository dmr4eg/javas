package cz.cvut.fel.pjv;

public class TreeImpl implements Tree {
    private Node root;

    public void setTree(int[] values) {
        root = new NodeImpl(values, 0, values.length - 1);
        if (root.getValue() == 0) {
            root = null;
        }
    }


    public Node getRoot() {
        return root;
    }

    @Override
    public String toString() {
        return toStringRecur(root, 0);
    }

    private String toStringRecur(Node node, int level) {
        if (node == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(deep(level)).append("- ").append(node.getValue()).append("\n");
        sb.append(toStringRecur(node.getLeft(), level + 1));
        sb.append(toStringRecur(node.getRight(), level + 1));
        return sb.toString();
    }

    private String deep(int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
