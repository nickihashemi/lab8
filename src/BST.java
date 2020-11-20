/*
 * Binary search tree data structure
 * @author :
 */

import java.util.ArrayList;

public class BST<T extends Comparable<T>> {
    /*
     * The root of the BST
     */
    Node<T> root;

    /*
     * Node class for a BST
     */
    private class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;
        int instance;

        Node(T item)
        {
            data = item;
            instance = 1;
        }

        @Override
        public String toString() {
            return "" + data;
        }
    }

    /*
     * public BST function returns root as null
     */
    public BST()
    {
        root = null;
    }

    /*
     * Find function that finds an item in the BST
     * @param item to be found
     * @return boolean if the item was found
     */
    public boolean find(T item)
    {
        return find(item, root);
    }

    /*
     * Function override of the find function
     * @param item to be found
     * @param node the current node you are at
     * @return boolean if the item was found
     */
    private boolean find(T item, Node<T> node) {

        if (node == null) {
            return false;
        } else if (item.compareTo(node.data) == 0) {
            return true;
        }

        if (item.compareTo(node.data) < 0) {        // item is less than node.data
            find(item, node.left);
        } else {                                    // item is greater than node.data
            find(item, node.right);
        }

        return false;
    }

    /*
     * Insert an item to the tree
     * @param item to insert
     */
    public void insert(T item)
    {
        root = insert(item, root);
    }

    /*
     * Helper function for insert
     * @param item to add
     * @param node you are at
     * @return node you traverse to
     */
    private Node<T> insert(T item, Node<T> node)
    {
        if (node == null) {
            return new Node(item);
        } else if (item.compareTo(node.data) < 0) {
            node.left = insert(item, node.left);
        } else {
            node.right = insert(item, node.right);
        }

        return node;
    }

    /*
     * Function for deletion of a node
     * @param item to delete
     */
    public void delete(T item)
    {
        root = delete(item, root);
    }

    /*
     * Helper function for deletion of a node
     * @param item to delete
     * @param node you are at
     * @return node you traverse to
     */
    private Node<T> delete(T item, Node<T> node) {
        if (node == null) {
            return null;
        }
        if (item.compareTo(node.data) < 0) {
            node.left = delete(item, node.left);
            return node;
        } else if (item.compareTo(node.data) > 0) {
            node.right = delete(item, node.right);
            return node;
        } else {
            //One child
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            //Two children
            else {
                if (node.right.left == null) {
                    node.data = node.right.data;
                    node.right = node.right.right;
                }
                else {
                    node.data = removeSmallest(node.right.left);
                }
                return node;
            }
        }
    }

    /*
     * removes the smallest node
     * @param node
     * @return
     */
    T removeSmallest(Node node) {
        if (node.left.left == null) {
            T smallest = (T) node.left.data;
            node.left = node.left.right;
            return smallest;
        }
        else {
            return (T) removeSmallest(node.left);
        }
    }

    /*
     * Function to find the range sum of the binary tree
     * @param L the left bound
     * @param R the right bound
     * @return The sum of the range in the binary tree
     */

    public int rangeSum(int L, int R)
    {
        int result = 0;
        ArrayList<Integer> inRange = new ArrayList<>();
        rangeSum(root, L, R, inRange);
        for (int val : inRange) {
            result += val;
        }
        return result;
    }


    private void rangeSum(Node<T> node, int L, int R, ArrayList<Integer> list) {

        if (node != null) {
            if (node.data instanceof Integer) {
                if (node.data.compareTo((T)(Object)L) >= 0 && node.data.compareTo((T)(Object)R) <= 0){
                    int value = Integer.parseInt((node.data.toString()));
                    list.add(value);
                }
                if (node.data.compareTo((T)(Object)L) > 0) {
                    rangeSum(node.left, L, R, list);
                }
                if (node.data.compareTo((T)(Object)R) < 0) {
                    rangeSum(node.right, L, R, list);
                }
            }
        }
    }


    @Override
    public String toString() {
        if(this.root == null) {
            return "Empty Tree";
        }

        return toString(this.root);
    }

    private String toString(Node root) {
        String result = "";

        result += root.data;

        if (root.left != null) {
            result += "(" + toString(root.left);
            result += ")";
        }

        if (root.right != null) {
            result += "[" + toString(root.right);
            result += "]";
        }

        return result;
    }

    /*
     * Function to print the Binary tree
     */
    public void print()
    {
        print(root);
    }

    /*
     * Helper Function to print the Binary tree
     * @param root the root of the tree
     */
    private void print(Node<T> root)
    {
        if (root != null) {
            print(root.left);
            System.out.println(root.data + " ");
            print(root.right);

        }
    }
}