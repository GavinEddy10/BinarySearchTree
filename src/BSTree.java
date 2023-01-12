public class BSTree <T extends Comparable<T>> {
    private BSTNode<T> root;//root is top of tree, currently null

    public BSTree () {
        root = null;
    }


    public boolean exists(T data) {
        BSTNode<T> node = root;
        while(node != null) {
           if (node.getData() == data)
               return true;
           node = (data.compareTo(node.getData()) < 0) ? node.getLeft() : node.getRight();
        }
        return false;
    }

    public void delete(T data) {
        if (!exists(data))//doesn't exist
            return;


        BSTNode<T> node = root;
        BSTNode<T> nodeAbove = null;//above node

        if (data == node.getData()) {//deletes root, go one to left, then all the way down to right. Swap this and root pointers
            int count = 0;
            while (node != null) {
                if (count == 0)
                    node = node.getLeft();

                if (count > 0)
                    node = node.getRight();
                count++;
            }
        }

        while(node != null) {//finds node with data
            if (node.getData() == data)//found node wanted removal
                break;
            if (node.getRight().getData() == data) {
                nodeAbove = node;
            }
            else if (node.getLeft().getData() == data) {
                nodeAbove = node;
            }
            node = (data.compareTo(node.getData()) < 0) ? node.getLeft() : node.getRight();
        }


        if (hasZeroConnections(node)) {//node has no pointers left and right WORKS
            if (nodeAbove.getLeft().getData() == data)
                nodeAbove.setLeft(null);
            else if (nodeAbove.getRight().getData() == data)
                nodeAbove.setRight(null);
        }

        else if (hasTwoConnections(node)) {
            if (nodeAbove.getLeft() == node) {
                nodeAbove.setLeft(node.getLeft());
            }
            else if (nodeAbove.getRight() == node) {
                nodeAbove.setRight(node.getLeft());
            }
        }

        else if (hasOnlyLeftConnection(node)) {//works
            if (nodeAbove.getRight() == node) {
                nodeAbove.setRight(node.getLeft());
            }
            else if (nodeAbove.getLeft() == node) {
                nodeAbove.setLeft(node.getLeft());
            }
        }

        else if (hasOnlyRightConnection(node)) {//works
            if (nodeAbove.getRight() == node) {
                nodeAbove.setRight(node.getRight());
            }
            else if (nodeAbove.getLeft() == node) {
                nodeAbove.setLeft(node.getRight());
            }
        }


    }

    private boolean hasOnlyLeftConnection(BSTNode<T> node) {
        return node.getLeft() != null && node.getRight() == null;
    }
    private boolean hasOnlyRightConnection(BSTNode<T> node) {
        return node.getRight() != null && node.getLeft() == null;
    }
    private boolean hasZeroConnections(BSTNode<T> node) {
        return node.getRight() == null && node.getLeft() == null;
    }
    private boolean hasTwoConnections(BSTNode<T> node) {
        return node.getRight() != null && node.getLeft() != null;
    }



    public void printInOrder() {
        printInOrderRecur(root);
    }

    private void printInOrderRecur(BSTNode<T> node) {//hidden them
        if (node == null)
            return;

        printInOrderRecur(node.getLeft());
        System.out.print(node + ", ");
        printInOrderRecur(node.getRight());
    }

    public void add(T data) {
        if (root == null)//tree not made yet, data is first node now root
            root = new BSTNode<>(data);
        else
            addRecur(root, data);
    }

    private void addRecur(BSTNode<T> root, T data) {//don't want main to have access to recursive method and know knowledge

        if (data.compareTo(root.getData()) < 0) {//if data is less than root
            if (root.getLeft() == null) {//if left does not exist
                root.setLeft(new BSTNode<>(data));
            }
            else {//left exists, recursively call myself on left subtree
                addRecur(root.getLeft(), data);
            }
        }

        else {//the data is greater than root
            if (root.getRight() == null) {//if right does not exist
                root.setRight(new BSTNode<>(data));
            }
            else {//right exists, recursively call myself on right subtree
                addRecur(root.getRight(), data);
            }
        }
    }
}
