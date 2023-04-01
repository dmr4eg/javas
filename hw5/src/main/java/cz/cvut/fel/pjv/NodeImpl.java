package cz.cvut.fel.pjv;

public class NodeImpl implements Node{
    private int value;
    private Node left;
    private Node right;
    private int middle;
    private int len;

    public NodeImpl(int[] values, int start, int end) {
        if (values == null || values.length == 0) {
            return;
        }
        len = end - start + 1;
        if (len == 1) {
            value = values[start];
            right = null;
            return;
        } else if (len == 2) {
            value = values[start + 1];
            left = new NodeImpl(values, start, start);
            right = null;
            return;
        }
        if (len % 2 == 0) {
            middle = (start + end) / 2 + 1;
            value = values[start + middle ];
            if (middle > 0) {
                left = new NodeImpl(values, start, start + middle - 1);
            } else {
                left = null;
            }
            if (middle < len) {
                right = new NodeImpl(values, start + middle + 1, end);
            } else {
                right = null;
            }

        } else {
            middle = len / 2 + 1;
            value = values[start + middle - 1];
            if (middle > 0) {
                left = new NodeImpl(values, start, start + middle - 2);
            } else {
                left = null;
            }
            if (middle < len) {
                right = new NodeImpl(values, start + middle, end);
            } else {
                right = null;
            }
        }

//        if (middle > 0) {
//            if (middle == 2) {
//                left = new NodeImpl(values, start, middle - 2);
//            }
//            else {
//                left = new NodeImpl(values, start, start + middle - 1);
//            }
//        } else {
//            left = null;
//        }
//        if (middle < len) {
//            right = new NodeImpl(values, start + middle, end);
//        } else {
//            right = null;
//        }

    }


    public Node getLeft() {
        return left;
    }

    public Node getRight() {

            return right;

    }

    public int getValue() {
        return value;
    }
}
