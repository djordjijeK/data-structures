public class BinarySearchTree<T extends Comparable<T>>
{
    // BST root node.
    private Node root;

    // tracks the number of nodes in this BST.
    private int nodeCount;

    /**
     * Internal class that represents one node in a BST.
     */
    private class Node
    {
        T key;
        Node leftChild;
        Node rightChild;

        /**
         * Node constructor.
         * 
         * @param key - node's data.
         */
        public Node(T key)
        {
            this.key        = key;
            this.leftChild  = null;
            this.rightChild = null;
        }

        /**
         * Node constructor.
         * 
         * @param key        - node's data.
         * @param leftChild  - node's left child.
         * @param rightChild - node's right child.
         */
        public Node(T key, Node leftChild, Node rightChild)
        {
            this.key        = key;
            this.leftChild  = leftChild;
            this.rightChild = rightChild;
        }

        @Override
        public String toString() 
        {
            return this.key.toString();
        }
    }

    /**
     * BinarySearchTree constructor.
     */
    public BinarySearchTree()
    {
        this.root      = null;
        this.nodeCount = 0;
    }

    /**
     * Adds a new item to the BST.
     * Time  Complexity: worst-case O(n), other O(log n)
     * Space Complexity: worst-case O(n), other O(log n)
     * 
     * @param item     - a new item to insert into a BST.
     * @return boolean - true if it is inserted, false if it already exists. 
     */
    public boolean add(T item)
    {
        return this.insert(item);
    }

    /**
     * Inserts a new item to the BST.
     * Time  Complexity: worst-case O(n), other O(log n)
     * Space Complexity: worst-case O(n), other O(log n)
     * 
     * @param item     - a new item to insert into a BST.
     * @return boolean - true if it is inserted, false if it already exists. 
     */
    public boolean insert(T item)
    {
        if (this.contains(item))
            return false;
        else
        {
            this.root      = this.insert(this.root, item);
            this.nodeCount = this.nodeCount + 1;

            return true;
        }
    }

    /**
     * Checks if BST contains the given element/item.
     * Time  Complexity: worst-case O(n), other O(log n)
     * Space Complexity: worst-case O(n), other O(log n)
     * 
     * @param item     - item to look for.
     * @return boolean - true if the item exists, false otherwise.
     */
    public boolean contains(T item)
    {
        return this.contains(this.root, item);
    }

    /**
     * Returns the minimum element in BST.
     * Time  Complexity: worst-case O(n), other O(log n)
     * Space Complexity: worst-case O(n), other O(log n) 
     * 
     * @return T - minimum element in BST.
     */
    public T findMin()
    {
        return this.findMin(this.root);
    }

    /**
     * Returns the maximum element in BST.
     * Time  Complexity: worst-case O(n), other O(log n)
     * Space Complexity: worst-case O(n), other O(log n) 
     * 
     * @return T - maximum element in BST.
     */
    public T findMax()
    {
        return this.findMax(this.root);
    }

    /**
     * Returns the height of a BST. 
     * 
     * @return int - height of BST.
     */
    public int height()
    {
        return this.height(this.root);
    }

    /**
     * Checks if BST is empty.
     */
    public boolean isEmpty()
    {
        return this.size() == 0;
    }

    /**
     * BST size (number of nodes).
     */
    public int size()
    {
        return this.nodeCount;
    }

    /********************** PRIVATE INTERFACE **********************/

    /**
     * Inserts a new item to the BST.
     * Time  Complexity: worst-case O(n), other O(log n)
     * Space Complexity: worst-case O(n), other O(log n)
     * 
     * @param item     - a new item to insert into a BST.
     * @param root     - current subtree root.
     * @return boolean - true if it is inserted, false if it already exists. 
     */
    private Node insert(Node root, T item)
    {
        if (root == null)
            return new Node(item);

        int cmp = item.compareTo(root.key);

        if (cmp < 0)
            root.leftChild = this.insert(root.leftChild, item);

        if (cmp > 0)
            root.rightChild = this.insert(root.rightChild, item);

        return root;
    }

    /**
     * Checks if BST contains the given element/item.
     * Time  Complexity: worst-case O(n), other O(log n)
     * Space Complexity: worst-case O(n), other O(log n)
     * 
     * @param item     - item to look for.
     * @param root     - current subtree root.
     * @return boolean - true if the item exists, false otherwise.
     */
    private boolean contains(Node root, T item)
    {
        if (root == null)
            return false;

        int cmp = item.compareTo(root.key);

        if (cmp < 0) 
            return this.contains(root.leftChild, item);

        if (cmp > 0) 
            return this.contains(root.rightChild, item);

        return true;
    }

    /**
     * Returns the minimum element in BST.
     * Time  Complexity: worst-case O(n), other O(log n)
     * Space Complexity: worst-case O(n), other O(log n) 
     * 
     * @return T - minimum element in BST.
     */
    private T findMin(Node root)
    {
        if (root.leftChild == null)
            return root.key;

        return this.findMin(root.leftChild);
    }

    /**
     * Returns the maximum element in BST.
     * Time  Complexity: worst-case O(n), other O(log n)
     * Space Complexity: worst-case O(n), other O(log n) 
     * 
     * @return T - maximum element in BST.
     */
    private T findMax(Node root)
    {
        if (root.rightChild == null)
            return root.key;

        return this.findMax(root.rightChild);
    }

    /**
     * Returns the height of a BST. 
     * 
     * @return int - height of BST.
     */
    private int height(Node root)
    {
        if (root == null)
            return 0;
            
        int leftHeight  = this.height(root.leftChild) + 1;
        int rightHeight = this.height(root.rightChild) + 1;
        
        return Math.max(leftHeight, rightHeight);
    }
}