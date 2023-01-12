public class BSTNode <T extends Comparable<T>> {
    private T data;
    private BSTNode<T> left;
    private BSTNode<T> right;

    public BSTNode(T data) {
        this.data = data;
    }

    public BSTNode(T data, BSTNode<T> left, BSTNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }



    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BSTNode<T> getLeft() {
        return left;
    }

    public void setLeft(BSTNode<T> left) {
        this.left = left;
    }

    public BSTNode<T> getRight() {
        return right;
    }

    public void setRight(BSTNode<T> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
