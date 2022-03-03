public class Node {

    private quintupla Value;
    private Node left;
    private Node right;

    public Node(quintupla Value) {
        this.Value = Value;
        this.left = null;
        this.right = null;
    }
    public Node(quintupla Value, Node left, Node right) {
        this.Value = Value;
        this.left = left;
        this.right = right;
    }

    public quintupla getValue() {
        return Value;
    }

    public void setValue(quintupla Value) {
        this.Value = Value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

}
