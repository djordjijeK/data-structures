public class BinarySearchTree<T extends Comparable<T>>
{
    // BST root node.
    private Node root;

    // tracks the number of nodes in this BST.
    private int nodeCount;

    /**
     * Internal class that represents one node in a BST.
     */
    public class Node
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
     * Adds a new element to the BST.
     * Time  Complexity: worst-case O(n), other O(log n)
     * Space Complexity: worst-case O(n), other O(log n)
     * 
     * @param element  - a new element to insert into a BST.
     * @return boolean - true if it is inserted, false if it already exists. 
     */
    public boolean add(T element)
    {
        return this.insert(element);
    }

    /**
     * Inserts a new element to the BST.
     * Time  Complexity: worst-case O(n), other O(log n)
     * Space Complexity: worst-case O(n), other O(log n)
     * 
     * @param element  - a new element to insert into a BST.
     * @return boolean - true if it is inserted, false if it already exists. 
     */
    public boolean insert(T element)
    {
        if (this.contains(element))
            return false;
        else
        {
            this.root      = this.insert(this.root, element);
            this.nodeCount = this.nodeCount + 1;

            return true;
        }
    }

    /**
     * Removes an element from a BST.
     * Time  Complexity: worst-case O(n), other O(log n)
     * Space Complexity: worst-case O(n), other O(log n)
     * 
     * @param element  - an element to delete from a BST.
     * @return boolean - true if it is deleted, false if it did not exist. 
     */
    public boolean remove(T element)
    {
        return this.delete(element);
    }

    /**
     * Deletes an element from a BST.
     * Time  Complexity: worst-case O(n), other O(log n)
     * Space Complexity: worst-case O(n), other O(log n)
     * 
     * @param element  - an element to delete from a BST.
     * @return boolean - true if it is deleted, false if it did not exist. 
     */
    public boolean delete(T element)
    {
        if (this.contains(element))
        {
            this.root      = this.delete(this.root, element);
            this.nodeCount = this.nodeCount - 1;

            return true;
        }

        return false;
    }

    /**
     * Checks if BST contains the given element/element.
     * Time  Complexity: worst-case O(n), other O(log n)
     * Space Complexity: worst-case O(n), other O(log n)
     * 
     * @param element  - element to look for.
     * @return boolean - true if the element exists, false otherwise.
     */
    public boolean contains(T element)
    {
        return this.contains(this.root, element);
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
        return this.findMin(this.root).key;
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
        return this.findMax(this.root).key;
    }

    /**
     * BST root getter.
     */
    public Node getRoot()
    {
        return this.root;
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
     * Inserts a new element to the BST.
     * Time  Complexity: worst-case O(n), other O(log n)
     * Space Complexity: worst-case O(n), other O(log n)
     * 
     * @param element  - a new element to insert into a BST.
     * @param root     - current subtree root.
     * @return boolean - true if it is inserted, false if it already exists. 
     */
    private Node insert(Node root, T element)
    {
        if (root == null)
            return new Node(element);

        int cmp = element.compareTo(root.key);

        if (cmp < 0)
            root.leftChild = this.insert(root.leftChild, element);

        if (cmp > 0)
            root.rightChild = this.insert(root.rightChild, element);

        return root;
    }

    /**
     * Deletes an element from a BST.
     * Time  Complexity: worst-case O(n), other O(log n)
     * Space Complexity: worst-case O(n), other O(log n)
     * 
     * @param element  - an element to delete from a BST.
     * @return boolean - true if it is deleted, false if it did not exist. 
     */
    private Node delete(Node root, T element)
    {
        if (root == null)
            return null;

        int cmp = element.compareTo(root.key);

        if (cmp < 0)
        {
            root.leftChild  = this.delete(root.leftChild, element);
        }
        else if (cmp > 0)
        {
            root.rightChild = this.delete(root.rightChild, element);
        }
        else
        {
            if (root.leftChild == null)
            {
                return root.rightChild;
            }
            else if (root.rightChild == null)
            {
                return root.leftChild;
            }   
            else
            {
                Node temp = this.findMin(root.rightChild);

                root.key = temp.key;
                root.rightChild = this.delete(root.rightChild, temp.key);
            }
        }

        return root;
    }

    /**
     * Checks if BST contains the given element/element.
     * Time  Complexity: worst-case O(n), other O(log n)
     * Space Complexity: worst-case O(n), other O(log n)
     * 
     * @param element  - element to look for.
     * @param root     - current subtree root.
     * @return boolean - true if the element exists, false otherwise.
     */
    private boolean contains(Node root, T element)
    {
        if (root == null)
            return false;

        int cmp = element.compareTo(root.key);

        if (cmp < 0) 
            return this.contains(root.leftChild, element);

        if (cmp > 0) 
            return this.contains(root.rightChild, element);

        return true;
    }

    /**
     * Returns the minimum element in BST.
     * Time  Complexity: worst-case O(n), other O(log n)
     * Space Complexity: worst-case O(n), other O(log n) 
     * 
     * @return T - minimum element in BST.
     */
    private Node findMin(Node root)
    {
        if (root.leftChild == null)
            return root;

        return this.findMin(root.leftChild);
    }

    /**
     * Returns the maximum element in BST.
     * Time  Complexity: worst-case O(n), other O(log n)
     * Space Complexity: worst-case O(n), other O(log n) 
     * 
     * @return T - maximum element in BST.
     */
    private Node findMax(Node root)
    {
        if (root.rightChild == null)
            return root;

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
